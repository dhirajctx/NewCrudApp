package com.jbk.crudapp2;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheManager {
	@Autowired EmpRepo repo;
	
	public static HashMap<Integer, Employee> cache= new HashMap<>();
	
	@Scheduled (cron ="* * * * * *")
	public void loadcache(){
					System.out.println("Cache load started");
	List<Employee> emplist = repo.findAll();
	emplist.forEach(employee-> cache.put(employee.getId(), employee));
			System.out.println("Cache load ended");
	}
	

}
