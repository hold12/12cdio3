package rest;

import logindto.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by AndersWOlsen on 09-05-2017.
 */
@Path("create-user")
public class CreateUser {
    @POST
    @Consumes("application/json")
    public void createUser(User user) {
        ShowUsersTest.addUser(user);
    }
}
