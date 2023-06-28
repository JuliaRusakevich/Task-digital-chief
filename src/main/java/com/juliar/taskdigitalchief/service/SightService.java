package com.juliar.taskdigitalchief.service;

import com.juliar.taskdigitalchief.dto.sight.*;
import com.juliar.taskdigitalchief.entity.Sight;
import com.juliar.taskdigitalchief.mapper.SightMapper;
import com.juliar.taskdigitalchief.repository.SightRepository;
import com.juliar.taskdigitalchief.service.api.IService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SightService implements IService<Sight, SightSaveEditDto, SightReadDto> {

    private final SightRepository repository;
    private final SightMapper mapper;

    public SightService(SightRepository repository, SightMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void add(SightSaveEditDto dto) {
        var entity = this.mapper.mapDtoToEntity(dto);
        this.repository.save(entity);

    }

    @Override
    public Optional<SightReadDto> updateInfo(SightSaveEditDto dto, Long id) {
        var toEntity = this.mapper.mapDtoToEntity(dto); //из дто в сущность
        var fromEntity = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var entity = mapper.map(fromEntity, toEntity);
        this.repository.saveAndFlush(fromEntity);
        var cityDto = this.mapper.mapEntityToDto(entity);
        return Optional.ofNullable(cityDto);
    }

    @Override
    public Optional<SightReadDto> findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::mapEntityToDto);
    }

    @Override
    public List<SightReadDto> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<SightReadDto> findAllSightsByCityId(Long cityId) {
        return this.repository.findAllByCityId(cityId)
                .stream().map(mapper::mapEntityToDto).toList();

    }
}
