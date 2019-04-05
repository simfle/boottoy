package com.simfle.boottoy.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(User user) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
