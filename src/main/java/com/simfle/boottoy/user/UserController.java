package com.simfle.boottoy.user;


import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Resources<UserResource>> getUsers() {
        List<UserResource> collection = userRepository.findAll().stream()
                .map(UserResource::new).collect(Collectors.toList());

        final Resources<UserResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUser(@PathVariable final String id) {
        return userRepository.findById(id)
                .map(u -> ResponseEntity.ok(new UserResource(u)))
                .orElseThrow(UserNotFoundException::new);
    }

    @PostMapping
    public ResponseEntity<UserResource> saveUser(@RequestBody final User userFromRequest) {
        final User user = new User(userFromRequest);
        userRepository.save(user);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new UserResource(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable final String id,
                                                   @RequestBody final User userFromRequest) {

        final User user = new User(userFromRequest, id);
        userRepository.save(user);
        final UserResource resource = new UserResource(user);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable final String id) {
        return userRepository.findById(id).map(u -> {
                            userRepository.deleteById(id);
                            return ResponseEntity.noContent().build();
                        }).orElseThrow(UserNotFoundException::new);
    }
}
