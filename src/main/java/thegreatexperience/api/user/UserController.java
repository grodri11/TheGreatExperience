package thegreatexperience.api.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thegreatexperience.config.ApplicationProps;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ApplicationProps props;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("")
    public ResponseEntity getAllUserInfo(){

        List<User> users = Lists.newArrayList(userDAO.findAll());

        String response;

        try{
            response = objectMapper.writeValueAsString(users);
        }catch(Exception e){
           log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity inserUser(@RequestBody User user){
        userDAO.save(user);

        return ResponseEntity.ok("");
    }

    @RequestMapping("/{username}")
    public ResponseEntity getUserInfo(@PathVariable String username){
      User user =  userDAO.findByUsername(username);
      String response;

      try{
           response = objectMapper.writeValueAsString(user);
      }catch(Exception e){
          log.error(e.getMessage());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
      }

        return ResponseEntity.ok(response);
    }


}