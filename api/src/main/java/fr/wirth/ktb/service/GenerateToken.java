package fr.wirth.ktb.service;

import java.util.Arrays;
import java.util.HashSet;
import fr.wirth.ktb.domain.User;
import org.eclipse.microprofile.jwt.Claims;
import io.smallrye.jwt.build.Jwt;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenerateToken {

    public String getToken(String username, String password) {
        User user = User.find("username = ?1 and password = ?2", username, password).firstResult();
        return buildToken(user);
    }

    private String buildToken(User user) {
        return Jwt.issuer("https://example.com/issuer")
                .upn(user.username)
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
    }
}