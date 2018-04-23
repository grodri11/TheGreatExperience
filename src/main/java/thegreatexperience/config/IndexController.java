package thegreatexperience.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/index")
public class IndexController
{

    @RequestMapping(method= RequestMethod.GET)
    public String index() {
        return "index";
    }

}
