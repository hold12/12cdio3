package rest;

import logindto.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by AndersWOlsen on 09-05-2017.
 */
@Path("user")
public class DeleteUser {
    @Path("delete/{userId}")
    @GET
    public String deleteUser(@PathParam("userId") int userId) {
        User user = null;
        for(User curUser : ShowUsersTest.getUsersList())
            if (curUser.getUserId() == userId)
                user = curUser;

        if (user == null)
            return "User does not exist! (chosen id = " + userId + ")";

        ShowUsersTest.removeUser(user);

        return "Deleted user with id = " + user.getUserId() + " and name = " + user.getUsername();
    }
}
