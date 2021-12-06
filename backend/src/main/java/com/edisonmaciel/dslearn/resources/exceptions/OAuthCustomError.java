package com.edisonmaciel.dslearn.resources.exceptions;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OAuthCustomError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;


}
