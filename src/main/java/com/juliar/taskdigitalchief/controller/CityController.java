package com.juliar.taskdigitalchief.controller;

import com.juliar.taskdigitalchief.dto.city.*;
import com.juliar.taskdigitalchief.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {

    private final CityService service;
    private final SightService sightService;

    public CityController(CityService service, SightService sightService) {
        this.service = service;
        this.sightService = sightService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/city")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CitySaveEditDto dto) {
        this.service.add(dto);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/city/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CityReadDto> update(@RequestBody CitySaveEditDto dto, @PathVariable Long id) {
        return this.service.updateInfo(dto, id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities")
    @ResponseStatus(HttpStatus.OK)
    public List<CityReadDto> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityReadDto findById(@PathVariable Long id) {
        return this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));

    }

    /**
     * Получаем модель, состоящую из имени города и достопримечательностейб которые к нему относятся
     */
    @RequestMapping(method = RequestMethod.GET, value = "/city/sights/{id}")
    public CityWithSights findCitySights(@PathVariable Long id) {

        var listSights = this.sightService.findAllSightsByCityId(id);

        return CityWithSights.builder()
                .cityName(findById(id).getName())
                .sights(listSights.stream().toList())
                .build();

    }

}
