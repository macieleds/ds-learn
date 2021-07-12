package com.edisonmaciel.dslearn.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_task")
public class Task extends Lesson {
    private static final long serialVersionUID = 1L;

    private String description;

    private Integer questionCount;

    private Integer approvalcount;

    private double weight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;


    public Task(Long id, String title, Integer position, Section section, String description, Integer questionCount, Integer approvalcount, double weight, Instant dueDate) {
        super(id, title, position, section);
        this.description = description;
        this.questionCount = questionCount;
        this.approvalcount = approvalcount;
        this.weight = weight;
        this.dueDate = dueDate;
    }
}