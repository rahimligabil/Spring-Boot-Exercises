package testproject1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Controller {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Rustem oglan deyil";
    }
}

