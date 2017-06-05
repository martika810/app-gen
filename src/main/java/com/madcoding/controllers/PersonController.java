package com.madcoding.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoding.domain.Person;
import com.madcoding.store.Store;

@RestController
@RequestMapping("/person")
public class PersonController implements ApiController<Person,String> {

	private Store<Person,String> repository;
	
	@Autowired
	public PersonController(Store<Person,String> repo){
		this.repository = repo;
	}
	
	public ResponseEntity<Person> add(Person obj) {
		ResponseEntity<Person> response = null;
		try {
			response = repository.add(obj).thenApply(this::convert).exceptionally(this::unsuccessfull).get();
			
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		return response;
	}

	public ResponseEntity<Void> remove(String id) {
		ResponseEntity<Void> response = null;
		try {
			response = repository.remove(id).thenAccept( result -> this.convert()).exceptionally(err -> this.unsuccessfull(err));
		}catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		return response;
		
	}

	public Person searchById(String id) {
		return repository.searchById(id);
	}

	public List<Person> search(Predicate<Person> condition) {
		return repository.search(condition);
		
	}

	public int registered() {
		return repository.registered();
	
	}
	
	private ResponseEntity<Person> convert(Person person){
		return ResponseEntity.status(HttpStatus.OK).body(person);
		
	}
	
	private ResponseEntity<Person> convert(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	private ResponseEntity<Person> unsuccessfull(Throwable err){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error", err.getLocalizedMessage()).body(null);
	}
	
	private ResponseEntity<Person> unsuccessfull(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error", "error").body(null);
	}
	
	

}
