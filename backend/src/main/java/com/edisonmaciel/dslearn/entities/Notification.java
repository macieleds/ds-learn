package com.edisonmaciel.dslearn.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_notification")
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private boolean read;
    private String route;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}