package thegreatexperience.api.user.preferences;

import javax.persistence.*;

@Entity
@Table(name="preferences_name")
public class PreferencesLookup
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pref_id;
    String apiname;

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
}
