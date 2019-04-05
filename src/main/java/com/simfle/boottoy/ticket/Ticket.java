package com.simfle.boottoy.ticket;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "rt_ticket")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ticket_id", length = 50)
    private String id;
}
