package com.simfle.boottoy.user;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Table(name = "mt_user")
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "urid", length = 50)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 70)
    private String password;
}
