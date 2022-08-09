package com.example.Electricitybill.controller;

import com.example.Electricitybill.bean.ChangePasswordBean;

import com.example.Electricitybill.bean.Userbean;
import com.example.Electricitybill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Userbean user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Userbean user){
    	Userbean user1=userService.loginUser(user);
        HashMap<String,String> response=new HashMap<>();
        response.put("message","login successful");
        response.put("username",user.getUserName());
        response.put("uid", String.valueOf(user1.getUserId()));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    	
    }

    @PutMapping("/fp")
    public ResponseEntity<?> forgetPassword(@RequestParam String username){
        System.out.println(username);
        return ResponseEntity.status(HttpStatus.OK).body(userService.forgetPassword(username));
    }

    @PutMapping("/cp")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordBean changePassword){
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(changePassword.getUser(),changePassword.getNewPassword()));
    }

    @GetMapping("/id/{uid}")
    public ResponseEntity<?> getById(@PathVariable int uid){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(uid));
    }
    @GetMapping("/un/{uname}")
    public ResponseEntity<?> getByUserName(@PathVariable String uname){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserName(uname));
    }
    @GetMapping("/getallusers")
    public List<Userbean> getallUsers(){
    	return userService.getallUsers();
    }
}
