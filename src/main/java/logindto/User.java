package logindto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tjc on 9/2/17.
 */

public class User {
    private int userId;
    private String username;
    private String initials;
    private String cpr;
    private String password;
    private List<String> roles;

    public User(int userId, String username, String initials, String cpr, String password, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.initials = initials;
        this.cpr = cpr;
        this.password = password;
        this.roles = roles;
    }

    public User(int userId, String username, String initials, String cpr, String password, String roles) {
        this.userId = userId;
        this.username = username;
        this.initials = initials;
        this.cpr = cpr;
        this.password = password;
        this.roles = Arrays.asList(roles.split(","));
    }

    public User(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.initials = user.getInitials();
        this.cpr = user.getCpr();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public void setUsername(String username) { this.username = username; }
    public void setInitials(String initials) { this.initials = initials; }
    public void setCpr(String cpr) { this.cpr = cpr; }
    public void setPassword(String password) { this.password = password; }
    public boolean addRole(String role) { return this.roles.add(role); }
    public boolean removeRole(String role) { return this.roles.remove(role); }

    public int getUserId() { return this.userId; }
    public String getUsername() { return this.username; }
    public String getInitials() { return this.initials; }
    public String getCpr() { return this.cpr; }
    public String getPassword() { return this.password; }
    public List<String> getRoles() { return this.roles; }
}
