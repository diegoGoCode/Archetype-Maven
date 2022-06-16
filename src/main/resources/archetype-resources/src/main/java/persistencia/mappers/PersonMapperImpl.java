package ${package}.persistencia.mappers;

import ${package}.dominio.dto.PersonDto;
import ${package}.persistencia.entities.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper{
    @Override
    public PersonDto personEntityToDto(PersonEntity personEntity) {
        return PersonDto.builder()
                .id(personEntity.getId())
                .nombre(personEntity.getNombre())
                .apellido(personEntity.getApellido())
                .edad(personEntity.getEdad())
                .build();
    }

    @Override
    public PersonEntity personDtoToEntity(PersonDto personDto) {
        return PersonEntity.builder()
                .id(personDto.getId())
                .nombre(personDto.getNombre())
                .apellido(personDto.getApellido())
                .edad(personDto.getEdad())
                .build();
    }
}