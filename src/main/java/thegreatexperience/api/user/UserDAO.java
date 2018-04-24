package thegreatexperience.api.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thegreatexperience.api.user.User;



public interface UserDAO extends CrudRepository<User, Long>{
    User findByUsername(String username);

}
