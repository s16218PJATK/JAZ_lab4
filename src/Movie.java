import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Movie {

    private int id;
    private String title;
    private String info;
    private List<Integer> rates = new ArrayList<Integer>();
    private List<String> actors = new ArrayList<String>();
    private List<String> comments = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getRating() {
        Integer sum = 0;
        for (Integer r : rates) {
            sum += r;
        }
        if (rates.size() > 0) {
            return round(sum.doubleValue() / rates.size(), 2);
        } else {
            return 0;
        }

    }

    public void addRate(Integer rate) {
        rates.add(rate);
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor.getURI());
    }

    public void removeActor(Actor actor) {
        int idx = 0;
        for (String a_uri : actors) {
            if (a_uri.equals(actor.getURI())) {
                actors.remove(idx);
                break;
            }
            idx++;
        }
    }

    public String getURI() {
        return String.format("/movies/%d", this.getId());
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment.getURI());
    }

    public void removeComment(Comment comment) {
        int idx = 0;
        for (String a_uri : actors) {
            if (a_uri.equals(comment.getURI())) {
                comments.remove(idx);
            }
            idx++;
        }
    }

}
