package ${package}.dominio.IRepositories;

import ${package}.dominio.dto.PersonDto;
import ${package}.persistencia.entities.PersonEntity;

import java.util.List;

public interface ObjectRepository {
    List<PersonEntity> getAll();

    PersonEntity getById(Long id);

    PersonEntity save(PersonDto personDto) throws Exception;

    void delete(Long id);
}