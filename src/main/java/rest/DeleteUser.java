package rest;

import logindto.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by freya on 09-05-2017.
 */
@Path("delete-user")
public class DeleteUser {
    @POST
    public void deleteUser(User user) {
        ShowUsersTest.removeUser(user);
    }
}
