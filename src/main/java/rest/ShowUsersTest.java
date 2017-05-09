package rest;

import logindto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndersWOlsen on 08-05-2017.
 */

@Path("user")
public class ShowUsersTest {
    private static List<User> users = new ArrayList<User>();

    private void createUsers() {
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static List<User> getUsersList() { return users; }

    @Path("get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUsers() {
        //createUsers();
        return users;
    }

    @Path("get/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") int userId) {
        User user = null;
        for (User curUser : users)
            if (curUser.getUserId() == userId)
                return curUser;
        return null;
    }
}
