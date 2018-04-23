package thegreatexperience.api.user;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long usr_id;

    String username;
    String password;

    Long pref_id;

    public Long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Long usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPref_id() {
        return pref_id;
    }

    public void setPref_id(Long pref_id) {
        this.pref_id = pref_id;
    }
}
