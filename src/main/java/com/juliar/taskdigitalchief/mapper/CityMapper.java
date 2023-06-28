package com.juliar.taskdigitalchief.mapper;

import com.juliar.taskdigitalchief.dto.city.CitySaveEditDto;
import com.juliar.taskdigitalchief.dto.city.CityReadDto;
import com.juliar.taskdigitalchief.entity.City;
import com.juliar.taskdigitalchief.mapper.api.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CityMapper implements Mapper<City, CitySaveEditDto, CityReadDto> {


    @Override
    public CityReadDto mapEntityToDto(City entity) {

        return CityReadDto.builder()
                .name(entity.getName())
                .country(entity.getCountry())
                .age(entity.getAge())
                .population(entity.getPopulation())
                .description(entity.getDescription())
                .build();

    }

    @Override
    public City mapDtoToEntity(CitySaveEditDto dto) {
        return City.builder()
                .name(dto.getName())
                .country(dto.getCountry())
                .age(dto.getAge())
                .population(dto.getPopulation())
                .description(dto.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public City map(City fromObject, City toObject) {

        fromObject.setName(toObject.getName());
        fromObject.setCountry(toObject.getCountry());
        fromObject.setAge(toObject.getAge());
        fromObject.setPopulation(toObject.getPopulation());
        fromObject.setDescription(toObject.getDescription());

        return toObject;
    }
}
