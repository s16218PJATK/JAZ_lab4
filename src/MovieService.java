import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private static List<Movie> db = new ArrayList<Movie>();
    private static int currentId = 1;

    public List<Movie> getAll() {
        return db;
    }

    // CRUD
    public void create(Movie m) {
        m.setId(++currentId);
        db.add(m);
    }

    public Movie read(int id) {
        for (Movie m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void update(Movie m) {
        for (Movie m_old : db) {
            if (m.getId() == m_old.getId()) {
                m_old.setTitle(m.getTitle());
                m_old.setInfo(m.getInfo());
                m_old.setActors(m.getActors());
                m_old.setComments(m.getComments());
            }
        }
    }

    public void delete(int id) {
        int idx = 0;
        for (Movie m : db) {
            if (m.getId() == id) {
                db.remove(idx);
                break;
            }
            idx++;
        }
    }


}
