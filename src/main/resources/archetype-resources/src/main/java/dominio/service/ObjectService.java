package ${package}.dominio.service;

import ${package}.dominio.IRepositories.ObjectRepository;
import ${package}.dominio.dto.PersonDto;
import ${package}.persistencia.entities.PersonEntity;
import ${package}.persistencia.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private PersonMapper personMapper;

    public List<PersonDto> getAll() {
        List<PersonEntity> personEntity = objectRepository.getAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (PersonEntity person: personEntity){
            personDtoList.add(personMapper.personEntityToDto(person));
        }
        return personDtoList;
    }

    public PersonDto getById(Long id) {
        return personMapper.personEntityToDto(objectRepository.getById(id));
    }

    public PersonDto save(PersonDto personDto) throws Exception {
        PersonEntity personEntity = objectRepository.save(personDto);
        return personMapper.personEntityToDto(personEntity);
    }

    public void delete(Long id) {
        objectRepository.delete(id);
    }
}