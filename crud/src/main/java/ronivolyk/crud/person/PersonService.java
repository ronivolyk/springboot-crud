package ronivolyk.crud.person;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Iterable<Person> list(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			return repository.findAll();
		}

		return repository.findByFirstName(firstName);
	}
	
	public Person save(Person person) {
		if (person == null) {
			return null;
		}
		
		return repository.save(person);
	}
	
	public Person update(Long id, Person person) {
		if (id == null || person == null) {
			return null;
		}
		
		Optional<Person> personFound = repository.findById(id);
		
		if (!personFound.isPresent()) {
			throw new IllegalArgumentException("Person with id " + id + " not found");
		}

		person.setId(id);
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		if (id == null) {
			return;
		}

		Optional<Person> personFound = repository.findById(id);
		
		if (!personFound.isPresent()) {
			throw new IllegalArgumentException("Person with id " + id + " not found");
		}

		repository.deleteById(id);
	}

}
