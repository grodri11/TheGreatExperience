package thegreatexperience.api.user.preferences;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferencesDAO extends CrudRepository<Preferences, Long>, PreferencesRepositoryCustom {

//    @Query("select  p.pref_id, apiname \n" +
//            "from  Preferences p \n" +
//            "join  preferences_name pn on p.apiname_id = pn.apiname_id where p.usr_id = :usrId")
//    List<Preferences> getPreferencesListNow(@Param("usrId") int usrId);
}
