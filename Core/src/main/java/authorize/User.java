package authorize;

import contacts.Contact;

import javax.persistence.*;

/**
 * Created by orbot on 20.06.15.
 */
@Entity
@Table(name="users")
public class User {
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Id
    @Column(name="user_id", nullable = false)
    @GeneratedValue
    private long id;

    public User() {}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
