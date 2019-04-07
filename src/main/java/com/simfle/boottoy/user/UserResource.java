package com.simfle.boottoy.user;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Getter
public class UserResource extends ResourceSupport {

    private final User user;

    public UserResource(final User user) {
        this.user = user;
        final String id = user.getId();
        add(linkTo(UserController.class).withRel("user"));
        add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
    }
}
