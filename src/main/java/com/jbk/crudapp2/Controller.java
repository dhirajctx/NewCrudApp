package com.jbk.crudapp2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired EmpRepo repo;
	@Autowired CacheManager cacheM;

	@PostMapping(value = "/createEmployee")
	public String createStudent(@RequestBody Employee emp) {
		return repo.save(emp).toString();
	}

	
	
	@GetMapping (value ="/getAllEmployee")
	public List<Employee> getAllStudent()
	{
		return repo.findAll();
	}
	
	
	
	@DeleteMapping(value = "/deleteEmployee/{id}")
	public String deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
		return "Deleted";
	}
}
