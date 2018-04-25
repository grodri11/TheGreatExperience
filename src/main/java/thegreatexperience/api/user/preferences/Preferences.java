package thegreatexperience.api.user.preferences;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="preferences")
public class Preferences {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pref_id;
    String apiname;
    Long usr_id;

    @OneToMany
    List<PreferencesLookup> preferencesLookupList;


    public List<PreferencesLookup> getPreferencesLookupList() {
        return preferencesLookupList;
    }

    public void setPreferencesLookupList(List<PreferencesLookup> preferencesLookupList) {
        this.preferencesLookupList = preferencesLookupList;
    }

    public Long getPref_id() {
        return pref_id;
    }

    public void setPref_id(Long pref_id) {
        this.pref_id = pref_id;
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public Long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Long usr_id) {
        this.usr_id = usr_id;
    }
}
