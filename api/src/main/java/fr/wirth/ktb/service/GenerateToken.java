package fr.wirth.ktb.service;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenerateToken {


    public String getToken(String username) {
       return
                Jwt.issuer("https://example.com/issuer")
                        .upn(username)
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .sign();
    }

    public static void main(String[] args) {
        System.out.println(new GenerateToken().getToken("toto@toto.fr"));
    }
}