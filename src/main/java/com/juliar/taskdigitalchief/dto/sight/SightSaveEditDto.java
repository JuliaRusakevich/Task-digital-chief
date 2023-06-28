package com.juliar.taskdigitalchief.dto.sight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SightSaveEditDto {

    private String name;
    private String architect;
    private String style;
    private String address;
    private String description;
    @JsonProperty("city_id")
    private Long cityId;

}
