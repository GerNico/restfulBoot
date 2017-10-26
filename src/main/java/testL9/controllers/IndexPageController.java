package testL9.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexPageController {

    @RequestMapping("/hello")
    public String sayHi(){
        return "hi";
    }
}
