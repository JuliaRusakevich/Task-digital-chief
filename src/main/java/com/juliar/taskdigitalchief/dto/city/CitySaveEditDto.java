package com.juliar.taskdigitalchief.dto.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CitySaveEditDto {

    private String name;
    private String country;
    private Integer age;
    private Double population;
    private String description;

}
