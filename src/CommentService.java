import java.util.ArrayList;
import java.util.List;

public class CommentService {

    private static List<Comment> db = new ArrayList<Comment>();
    private static int currentId = 1;

    public List<Comment> getAll() {
        return db;
    }

    // CRUD
    public void create(Comment c) {
        c.setId(++currentId);
        c.updateDate();
        db.add(c);
    }

    public Comment read(int id) {
        for (Comment c : db) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void update(Comment c) {
        Comment old_c = read(c.getId());
        old_c.setContent(c.getContent());
        old_c.updateDate();

    }

    public void delete(int id) {
        int idx = 0;
        for (Comment c : db) {
            if (c.getId() == id) {
                db.remove(idx);
            }
            idx++;
        }
    }


}
