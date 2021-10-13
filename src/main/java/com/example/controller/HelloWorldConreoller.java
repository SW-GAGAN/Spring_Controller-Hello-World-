package com.example.controller;

import com.example.model.Userr;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldConreoller {

    // curl localhost:8070/hello -w "\n"
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello From BridgeLabz";
    }
    //curl localhost:8070/hello/query?name=Gagan -w "\n"
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }
    //curl -X POST -H "Connectet-type: application/json"
    @PostMapping("/post")
    public String sayHello(@RequestBody Userr user){
        return "Hello "+ user.getFName() + " " + user.getLName() + "!";
    }
    //curl localhost:8070/hello/param/Gagan -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello" + name + "!";
    }
    // curl -X PUT localHost:8070/hello/put/Lisa/?lName =Reddy -w "\n"
    @PutMapping("/put/{fName}")
    public String sayHello(@PathVariable String fName,
                           @RequestParam(value = "lName") String lName) {
        return "Hello" + fName + " " + lName + "!";
    }
}