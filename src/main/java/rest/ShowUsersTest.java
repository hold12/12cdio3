package rest;

import logindto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndersWOlsen on 08-05-2017.
 */

@Path("users")
public class ShowUsersTest {
    private List<User> users = new ArrayList<User>();

    private void createUsers() {
        List<String> jdRoles = new ArrayList<String>();
        List<String> joRoles = new ArrayList<String>();

        jdRoles.add("Admin");
        jdRoles.add("Pharmacist");
        joRoles.add("Pharmacist");

        User jd = new User(1, "John Doe", "JD", "010190-1233", "p455w0rd!", jdRoles);
        User jo = new User(2, "Jane Doe", "JO", "010190-1234", "!dr0w554p", joRoles);

        users.add(jd);
        users.add(jo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUsers() {
        createUsers();
        return users;
    }
}
