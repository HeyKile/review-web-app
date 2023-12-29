package com.heykile.reviewgame;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloWordController {
    
    @GetMapping(path = "/hello")
    public String helloWord() {
        return "hello world";
    }

}
