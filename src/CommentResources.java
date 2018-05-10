import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/comments"
@Path("/comments")
public class CommentResources {

    private CommentService db = new CommentService();
    private MovieService movie_db = new MovieService();

    // Get specific comment
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Comment result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    // Update specific comment
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Comment c) {
        Comment result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        c.setId(id);
        db.update(c);
        return Response.ok(c.getURI()).build();
    }

    // Delete specific Comment
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Comment result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }

        String movie_uri = result.getMovie();
        String movie_id = movie_uri.replaceAll("\\D+", "");
        Movie movie_result = movie_db.read(Integer.parseInt(movie_id));
        if (movie_result == null) {
            return Response.status(404).build();
        }
        movie_result.removeComment(result);
        movie_db.update(movie_result);
        db.delete(id);
        return Response.ok().build();
    }

}
