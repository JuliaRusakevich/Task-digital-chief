package com.juliar.taskdigitalchief.dto.city;

import com.juliar.taskdigitalchief.dto.sight.SightReadDto;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityWithSights {

    private String cityName;
    private List<SightReadDto> sights;

}
