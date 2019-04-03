package com.simfle.boottoy.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @PostMapping("/user")
    public ResponseEntity<Void> saveUser(User user) {

        return ResponseEntity.ok().build();
    }


    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(User user) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return ResponseEntity.ok().build();
    }
}
