import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// The Java class will be hosted at the URI path "/movies"
@Path("/movies")
public class MovieResources {

    private MovieService db = new MovieService();
    private ActorService actor_db = new ActorService();
    private CommentService comment_db = new CommentService();

    // Get all movies
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {
        return db.getAll();
    }

    // Get specific movie
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }


    // Update specific movie
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Movie m) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        m.setId(id);
        db.update(m);
        return Response.ok(m.getURI()).build();
    }

    // Add movie to movies
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Movie m) {
        db.create(m);
        return Response.ok(m.getURI()).build();
    }

    // Delete specific movie
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        db.delete(id);
        return Response.ok().build();
    }

    // Get specific's movie average rate
    @GET
    @Path("/{id}/rating")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRating(@PathParam("id") int id) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result.getRating()).build();
    }

    // Rate specific movie
    @POST
    @Path("/{id}/rating/{rate}")
    public Response addRating(@PathParam("id") int id, @PathParam("rate") int rate) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        result.addRate(rate);
        db.update(result);
        return Response.ok().build();
    }

    // Get actors of specific movie
    @GET
    @Path("/{id}/actors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@PathParam("id") int id) {
        Movie result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result.getActors()).build();
    }

    // Add actor to a movie; add movie to actor's movie list
    @POST
    @Path("/{movie_id}/actors/{actor_id}")
    public Response addActor(@PathParam("movie_id") int movie_id, @PathParam("actor_id") int actor_id) {
        Movie result_movie = db.read(movie_id);
        if (result_movie == null) {
            return Response.status(404).build();
        }
        Actor result_actor = actor_db.read(actor_id);
        if (result_actor == null) {
            return Response.status(404).build();
        }
        result_movie.addActor(result_actor);
        result_actor.addMovie(result_movie);
        db.update(result_movie);
        actor_db.update(result_actor);
        return Response.ok(result_movie.getActors()).build();
    }

    // Delete actor from a movie; delete movie from actor's movie list
    @DELETE
    @Path("/{movie_id}/actors/{actor_id}")
    public Response removeActor(@PathParam("movie_id") int movie_id, @PathParam("actor_id") int actor_id) {
        Movie result_movie = db.read(movie_id);
        if (result_movie == null) {
            return Response.status(404).build();
        }
        Actor result_actor = actor_db.read(actor_id);
        if (result_actor == null) {
            return Response.status(404).build();
        }
        result_movie.removeActor(result_actor);
        result_actor.removeMovie(result_movie);
        db.update(result_movie);
        actor_db.update(result_actor);
        return Response.ok().build();
    }

    // Get comments of a movie
    @GET
    @Path("/{movie_id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments(@PathParam("movie_id") int movie_id) {
        Movie result_movie = db.read(movie_id);
        if (result_movie == null) {
            return Response.status(404).build();
        }
        return Response.ok(result_movie.getComments()).build();
    }

    // Add comment to movie
    @POST
    @Path("/{movie_id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(@PathParam("movie_id") int movie_id, Comment c) {
        Movie result_movie = db.read(movie_id);
        if (result_movie == null) {
            return Response.status(404).build();
        }
        c.setMovie(result_movie.getURI());
        comment_db.create(c);
        result_movie.addComment(c);
        db.update(result_movie);
        return Response.ok(c.getURI()).build();
    }


}
