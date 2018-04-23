package thegreatexperience.api.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thegreatexperience.config.ApplicationProps;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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
            System.out.println(e.getStackTrace());
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
          System.out.println(e.getStackTrace());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
      }

        return ResponseEntity.ok(response);
    }


}