import java.util.ArrayList;
import java.util.List;

public class ActorService {

    private static List<Actor> db = new ArrayList<Actor>();
    private static int currentId = 1;

    public List<Actor> getAll() {
        return db;
    }

    // CRUD
    public void create(Actor a) {
        a.setId(++currentId);
        db.add(a);
    }

    public Actor read(int id) {
        for (Actor a : db) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void update(Actor a) {
        Actor old_a = read(a.getId());
        old_a.setName(a.getName());
        old_a.setSurname(a.getSurname());
        old_a.setMovies(a.getMovies());

    }

    public void delete(int id) {
        int idx = 0;
        for (Actor a : db) {
            if (a.getId() == id) {
                db.remove(idx);
                break;
            }
            idx++;
        }
    }


}
