package com.example.springplayground.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPointController {

/* @GetMapping("/") */
    public String helloWorld() {
        return "Hello from Spring!";
    }
    @GetMapping("/math/pi")
    public String getPi(){
        return "3.141592653589793";
    }
}