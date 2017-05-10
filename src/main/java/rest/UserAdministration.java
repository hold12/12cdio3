package rest;

import logindto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndersWOlsen on 08-05-2017.
 */

@Path("user")
public class UserAdministration {
    private static List<User> users = new ArrayList<User>();

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
        for (User curUser : users)
            if (curUser.getUserId() == userId)
                return curUser;
        return null;
    }

    @Path("create/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        users.add(user);
    }

    @Path("update/{userId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user, @PathParam("userId") int userId) {
        User oldUser = null;
        for (User curUser : users)
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

    @Path("create/test")
    @GET
    public Response createTestUsers() {
        List<String> r1 = new ArrayList<>();
        List<String> r2 = new ArrayList<>();
        List<String> r3 = new ArrayList<>();
        List<String> r4 = new ArrayList<>();

        r1.add("Admin");
        r1.add("Pharmacist");
        r2.add("Pharmacist");
        r3.add("Labtech");
        r3.add("Operator");
        r4.add("Admin");
        r4.add("Pharmacist");
        r4.add("Labtech");
        r4.add("Operator");


        User u1 = new User(1, "John Doe", "JD", "010190-1233", "p455w0rd!", r1);
        User u2 = new User(2, "Jane Doe", "JO", "010190-1234", "!dr0w554p", r2);
        User u3 = new User(3, "Bum", "BM", "123456-9999", "über_password", r3);
        User u4 = new User(4, "Hanne", "HN", "121212-1234", "afja8wefa8", r4);
        User u5 = new User(5, "Karsten", "KS", "538372-1233", "g9¤A34M4g9", r3);
        User u6 = new User(6, "Lotte", "LT", "111150-1834", "4Jg9sregEJR", r1);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        URI uri = URI.create("/");
        return Response.temporaryRedirect(uri).build();
    }

    @Path("delete/{userId}")
    @GET
    public String deleteUser(@PathParam("userId") int userId) {
        User user = null;
        for(User curUser : users)
            if (curUser.getUserId() == userId)
                user = curUser;

        if (user == null)
            return "User does not exist! (chosen id = " + userId + ")";

        users.remove(user);

        return "Deleted user with id = " + user.getUserId() + " and name = " + user.getUsername();
    }
}
