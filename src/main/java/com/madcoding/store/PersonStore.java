package com.madcoding.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.madcoding.domain.Person;

@Component
public class PersonStore implements Store<Person,String> {
	
	private Map<String,Person> store;

	public PersonStore(){
		store = new HashMap<String,Person>();
	}
	public CompletableFuture<Person> add(Person obj) {
		return CompletableFuture.runAsync(() ->{
			store.put(obj.id(), obj);
		}).completedFuture(store.get(obj.id()));
		
	}

	public CompletableFuture<Void> remove(String id) {
		store.remove(id);
		return CompletableFuture.completedFuture(null);
		
	}

	public CompletableFuture<Person> searchById(String id) {
		
		return CompletableFuture.completedFuture(store.get(id));
	}

	public CompletableFuture<List<Person>> search(Predicate<Person> condition) {
		List<Person>filtered = store.values().stream().filter(condition).collect(Collectors.toList());
		return CompletableFuture.completedFuture(filtered);
		
	}

	public int registered() {
		
		return store.size();
	}

}
