package fr.wirth.ktb.web;

import fr.wirth.ktb.service.GenerateToken;
import fr.wirth.ktb.dto.LoginDTO;
import fr.wirth.ktb.dto.TokenDTO;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authenticate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    @Inject
    GenerateToken generateToken;

    @POST
    @PermitAll
    public TokenDTO hello(LoginDTO loginDTO) {
        System.out.println(loginDTO.getEmail());
        if(loginDTO.getEmail().equals("admin@admin.fr")) {
            var res = new TokenDTO();
            res.setToken(generateToken.getToken(loginDTO.getEmail()));
            return res;
        }

        throw new RuntimeException();

    }
}
