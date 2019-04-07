package com.simfle.boottoy.ticket;

import com.simfle.boottoy.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    private final TicketRepository ticketRepository;

    @PostMapping()
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
