package com.madcoding.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;

public interface ApiController<TYPE,IDTYPE> {
	
	ResponseEntity<TYPE> add(TYPE obj);
	ResponseEntity<Void> remove(IDTYPE id) ;
	ResponseEntity<TYPE> searchById(IDTYPE id);
	ResponseEntity<List<TYPE>> search(Predicate<TYPE> condition);
	
	
}
