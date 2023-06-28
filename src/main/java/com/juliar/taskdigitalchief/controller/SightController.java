package com.juliar.taskdigitalchief.controller;

import com.juliar.taskdigitalchief.dto.sight.*;
import com.juliar.taskdigitalchief.service.SightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sight")
public class SightController {

    private final SightService service;

    public SightController(SightService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody SightSaveEditDto dto) {
        this.service.add(dto);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<SightReadDto> update(@RequestBody SightSaveEditDto dto, @PathVariable Long id) {
        return this.service.updateInfo(dto, id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SightReadDto> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SightReadDto findById(@PathVariable Long id) {
        return this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        findById(id);
        this.service.delete(id);
    }
}
