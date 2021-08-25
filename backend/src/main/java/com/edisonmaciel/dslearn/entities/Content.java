package com.edisonmaciel.dslearn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
        private static final long serialVersionUID = 1L;

        private String textContent;

        private String videoUri;

}
