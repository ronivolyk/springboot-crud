package ronivolyk.crud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public Iterable<Person> list(@RequestParam(name = "firstName", required = false) String firstName) {
		return service.list(firstName);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return service.save(person);
	}
	
	@PutMapping("/{id}")
	public Person update(@PathVariable Long id, @RequestBody Person person) {
		return service.update(id, person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
