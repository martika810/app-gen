package controllers;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.madcoding.controllers.ApiController;
import com.madcoding.controllers.PersonController;
import com.madcoding.domain.Person;
import com.madcoding.store.PersonStore;
import com.madcoding.store.Store;

public class ApiControllerTest {
	
	@Test
	public void add(){
		Store<Person,String> store = new PersonStore();
		ApiController<Person,String> controller = new PersonController(store);
		Person p1= Person.of(UUID.randomUUID().toString(), "Marta", 32);
		controller.add(p1);
		
		assertEquals(1,controller.registered());
		assertEquals(p1,controller.searchById(p1.id()));
	}

}
