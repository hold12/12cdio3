package rest;

import logindto.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by AndersWOlsen on 10-05-2017.
 */
@Path("user")
public class UpdateUser {
    @Path("update/{userId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user, @PathParam("userId") int userId) {
        User oldUser = null;
        for (User curUser : ShowUsersTest.getUsersList())
            if (curUser.getUserId() == userId)
                oldUser = curUser;

        if (oldUser == null)
            return;

        oldUser.setUsername(user.getUsername());
        oldUser.setInitials(user.getInitials());
        oldUser.setCpr(user.getCpr());
        oldUser.setPassword(user.getPassword());
        oldUser.setRoles(user.getRoles());
    }
}
