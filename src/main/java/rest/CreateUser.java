package rest;

import logindto.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by AndersWOlsen on 09-05-2017.
 */
@Path("user")
public class CreateUser {
    @Path("create/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        ShowUsersTest.addUser(user);
    }
}
