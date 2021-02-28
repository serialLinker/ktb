package fr.wirth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/pets")
public class GreetingResource {

    private static final List<Pet> PETS = new ArrayList<>();
    private static Integer i = 0;

    @GET
    @RolesAllowed({"api-fighter", "api-admin"})
    public Response get() {
        return Response.ok(PETS).build();
    }

    @POST
    @RolesAllowed({"api-admin"})
    public Response post() throws URISyntaxException {
        var pet = new Pet();
        pet.setPetId(i++);
        PETS.add(pet);
        return Response.created(new URI("https://www.google.fr")).build();
    }
}