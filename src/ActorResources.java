import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// The Java class will be hosted at the URI path "/actors"
@Path("/actors")
public class ActorResources {

    private ActorService db = new ActorService();

    // Get all actors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getAll() {
        return db.getAll();
    }

    // Get specific actor
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Actor result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    // Update specific actor
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Actor a) {
        Actor result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        a.setId(id);
        db.update(a);
        return Response.ok(a.getId()).build();
    }

    // Add actor to actors
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Actor a) {
        db.create(a);
        return Response.ok(a.getId()).build();
    }

    // Delete specific actor
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Actor result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        db.delete(id);
        return Response.ok().build();
    }

    // Actor's movies
    @GET
    @Path("/{id}/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies(@PathParam("id") int id) {
        Actor result = db.read(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result.getMovies()).build();
    }


}
