package com.juliar.taskdigitalchief.dto.sight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SightReadDto {

    private String name;
    private String architect;
    private String address;

}
