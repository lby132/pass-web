package com.fastcampus.pass.repository.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "uesr")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String userName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
