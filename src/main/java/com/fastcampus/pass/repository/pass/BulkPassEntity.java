package com.fastcampus.pass.repository.pass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bulk_pass")
public class BulkPassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bulkPassSeq;
    private Integer packageSeq;
    private String userGroupId;

    @Enumerated(EnumType.STRING)
    private BulkPassStatus status;
    private Integer count;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public void setEndedAt(Integer period) {
        if (period == null) {
            return;
        }
        this.endedAt = this.startedAt.plusDays(period);
    }
}
