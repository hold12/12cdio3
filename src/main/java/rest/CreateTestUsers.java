package rest;

import logindto.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndersWOlsen on 09-05-2017.
 */
@Path("user")
public class CreateTestUsers {
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
        r4.add(r1.get(0));
        r4.add(r1.get(1));
        r4.add(r1.get(2));
        r4.add(r1.get(3));


        User u1 = new User(1, "John Doe", "JD", "010190-1233", "p455w0rd!", r1);
        User u2 = new User(2, "Jane Doe", "JO", "010190-1234", "!dr0w554p", r2);
        User u3 = new User(3, "Bum", "BM", "123456-9999", "über_password", r3);
        User u4 = new User(4, "Hanne", "HN", "121212-1234", "afja8wefa8", r4);
        User u5 = new User(5, "Karsten", "KS", "538372-1233", "g9¤A34M4g9", r3);
        User u6 = new User(6, "Lotte", "LT", "111150-1834", "4Jg9sregEJR", r1);

        ShowUsersTest.addUser(u1);
        ShowUsersTest.addUser(u2);
        URI uri = URI.create("/");
        return Response.temporaryRedirect(uri).build();
    }
}
