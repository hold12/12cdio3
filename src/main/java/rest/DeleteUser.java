package rest;

import logindto.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by freya on 09-05-2017.
 */
@Path("delete-user")
public class DeleteUser {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User user) {
        ShowUsersTest.removeUser(user);
    }
}
