/*
package com.jks.springbootrest1.controller;

import com.jks.springbootrest1.request.UserRequest;
import com.jks.springbootrest1.response.UserResponse;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(){//http://localhost:8080/user
        return "Hello hardcoded User";
    }

    //RequestParam
    //@RequiredParam(required="false", defaultValue="")
    //@Nullable

    @GetMapping("/greet")
    public String getByName(@RequestParam(required = false, defaultValue="dummy")  String name){//http://localhost:8080/user/getByName?name=username
        return "Hello "+name;
    }

    //@PathVariable
    @GetMapping("/greet/{name}")
    public String getByNamePath(@PathVariable String name){
        return "Hello "+name;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        System.out.println("User Request:: "+userRequest);
        //Business Logic to create user

        */
/*UserResponse userResponse=new UserResponse();
        userResponse.setId(UUID.randomUUID().toString());
        userResponse.setCreatedAt(LocalDateTime.now());
       // return ResponseEntity.ok(userResponse);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();*//*
//This has nothing returned back to client as response

        //Exception handling in API-customized Error response
        createUserException();


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    private void createUserException() {
        throw new NullPointerException("NPE");
    }
}
*/
