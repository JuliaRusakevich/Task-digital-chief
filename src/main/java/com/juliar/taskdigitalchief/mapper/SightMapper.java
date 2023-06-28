package com.juliar.taskdigitalchief.mapper;

import com.juliar.taskdigitalchief.dto.sight.SightReadDto;
import com.juliar.taskdigitalchief.dto.sight.SightSaveEditDto;
import com.juliar.taskdigitalchief.entity.Sight;
import com.juliar.taskdigitalchief.mapper.api.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SightMapper implements Mapper<Sight, SightSaveEditDto, SightReadDto> {

    @Override
    public SightReadDto mapEntityToDto(Sight entity) {
        return SightReadDto.builder()
                .name(entity.getName())
                .architect(entity.getArchitect())
                .address(entity.getAddress())
                .build();
    }

    @Override
    public Sight mapDtoToEntity(SightSaveEditDto dto) {
        return Sight.builder()
                .name(dto.getName())
                .architect(dto.getArchitect())
                .style(dto.getStyle())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public Sight map(Sight fromObject, Sight toObject) {
        fromObject.setName(toObject.getName());
        fromObject.setArchitect(toObject.getArchitect());
        fromObject.setStyle(toObject.getStyle());
        fromObject.setAddress(toObject.getAddress());
        fromObject.setDescription(toObject.getDescription());
        return toObject;
    }
}
