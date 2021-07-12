package com.edisonmaciel.dslearn.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
        private static final long serialVersionUID = 1L;

        private String textContent;

        private String videoUri;


    public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
        super(id, title, position, section);
        this.textContent = textContent;
        this.videoUri = videoUri;
    }
}
