package com.simfle.boottoy.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "rt_room", uniqueConstraints = @UniqueConstraint(name = "access_code", columnNames = {"access_code"}))
@Entity
public class Room {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "room_id", length = 50)
    private String id;

    @Column(name = "access_code", length = 6)
    private String accessCode;

    @JsonIgnore
    @Column(name = "support_type")
    private String supportType;
}
