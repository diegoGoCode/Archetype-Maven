package ${package}.persistencia.mappers;

import ${package}.dominio.dto.PersonDto;
import ${package}.persistencia.entities.PersonEntity;

public interface PersonMapper {
    PersonDto personEntityToDto(PersonEntity personEntity);
    PersonEntity personDtoToEntity(PersonDto personDto);
}