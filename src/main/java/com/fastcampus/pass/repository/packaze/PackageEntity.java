package com.fastcampus.pass.repository.packaze;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Package")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packageSeq;

    private String packageName;
    private Integer count;
    private Integer period;
}
