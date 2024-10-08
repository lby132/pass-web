package com.fastcampus.pass.repository.statistics;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "statistics")
public class StatisticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statisticsSeq;
    private LocalDateTime statisticsAt; // 일 단위

    private int allCount;
    private int attendedCount;
    private int cancelledCount;

}
