package fr.wirth.ktb;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/seasons")
public class SeasonResource {

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @GET
    @Path("/secured")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2(@Context SecurityContext securityContext) {
        return "Hello " + securityContext.getUserPrincipal().getName();
    }
}