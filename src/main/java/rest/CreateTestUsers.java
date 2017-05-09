package rest;

import logindto.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndersWOlsen on 09-05-2017.
 */
@Path("create-test-users")
public class CreateTestUsers {
    @GET
    public String createTestUsers() {
        List<String> jdRoles = new ArrayList<String>();
        List<String> joRoles = new ArrayList<String>();

        jdRoles.add("Admin");
        jdRoles.add("Pharmacist");
        joRoles.add("Pharmacist");

        User jd = new User(1, "John Doe", "JD", "010190-1233", "p455w0rd!", jdRoles);
        User jo = new User(2, "Jane Doe", "JO", "010190-1234", "!dr0w554p", joRoles);

        ShowUsersTest.addUser(jd);
        ShowUsersTest.addUser(jo);

        return "Users created...";
    }
}
