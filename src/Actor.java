import java.util.ArrayList;
import java.util.List;

public class Actor {

    private int id;
    private String name;
    private String surname;
    private List<String> movies = new ArrayList<String>();

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getURI() {
        return String.format("/actors/%d", this.getId());
    }

    public void addMovie(Movie m) {
        this.movies.add(m.getURI());
    }

    public void removeMovie(Movie m) {
        int idx = 0;
        for (String m_uri : this.movies) {
            if (m_uri.equals(m.getURI())) {
                this.movies.remove(idx);
                break;
            }
            idx++;
        }
    }
}
