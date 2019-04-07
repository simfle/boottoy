package com.simfle.boottoy.room;

import com.simfle.boottoy.ticket.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/room", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    private final RoomRepository roomRepository;

    @PostMapping()
    public ResponseEntity<Void> saveUser(@RequestBody Ticket ticket) {

        return ResponseEntity.ok().build();
    }
}
