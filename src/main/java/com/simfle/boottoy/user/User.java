package com.simfle.boottoy.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
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

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
    }

    public User(User user, String id) {
        this.id = id;
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
