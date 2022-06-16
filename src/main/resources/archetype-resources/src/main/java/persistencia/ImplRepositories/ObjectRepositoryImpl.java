package ${package}.persistencia.ImplRepositories;

import ${package}.dominio.IRepositories.ObjectRepository;
import ${package}.dominio.dto.PersonDto;
import ${package}.persistencia.entities.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ObjectRepositoryImpl implements ObjectRepository {

    @Override
    public List<PersonEntity> getAll() {
        List<PersonEntity> list = new ArrayList<>();
        list.add(new PersonEntity(1, "Diego", "Diaz", "24"));
        list.add(new PersonEntity(2, "Laura", "Nieves", "24"));
        return list;
    }

    @Override
    public PersonEntity getById(Long id) {
        return new PersonEntity(1,"Diego", "Diaz", "28");
    }

    @Override
    public PersonEntity save(PersonDto personDto) throws Exception {
        return new PersonEntity(personDto.getId() , personDto.getNombre(), personDto.getApellido(), personDto.getEdad());
    }

    @Override
    public void delete(Long id) {
    }
}