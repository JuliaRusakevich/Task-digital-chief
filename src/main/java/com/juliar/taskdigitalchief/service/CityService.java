package com.juliar.taskdigitalchief.service;

import com.juliar.taskdigitalchief.dto.city.*;
import com.juliar.taskdigitalchief.entity.City;
import com.juliar.taskdigitalchief.mapper.CityMapper;
import com.juliar.taskdigitalchief.repository.CityRepository;
import com.juliar.taskdigitalchief.service.api.IService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements IService<City, CitySaveEditDto, CityReadDto> {

    private final CityRepository repository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void add(CitySaveEditDto dto) {
        var entity = this.mapper.mapDtoToEntity(dto);
        repository.save(entity);
    }

    @Override
    public Optional<CityReadDto> updateInfo(CitySaveEditDto dto, Long id) {

        var toEntity = this.mapper.mapDtoToEntity(dto); //из дто в сущность
        var fromEntity = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var entity = mapper.map(fromEntity, toEntity);
        this.repository.saveAndFlush(fromEntity);
        var cityDto = this.mapper.mapEntityToDto(entity);
        return Optional.ofNullable(cityDto);
    }

    @Override
    public Optional<CityReadDto> findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::mapEntityToDto);
    }


    @Override
    public List<CityReadDto> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();
    }

    @Override
    public void delete(Long id) {

    }


}
