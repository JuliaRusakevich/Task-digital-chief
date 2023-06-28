package com.juliar.taskdigitalchief.mapper.api;


public interface Mapper<E, C, R> {

    R mapEntityToDto(E entity);

    E mapDtoToEntity(C dto);

    E map(E fromObject, E toObject);
}
