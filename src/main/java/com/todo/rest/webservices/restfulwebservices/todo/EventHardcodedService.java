package com.todo.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventHardcodedService {
	private static List<Event> todos = new ArrayList<Event>();
	private static int idCounter = 0;

	static {
		todos.add(new Event(++idCounter, "Chang", "2019 Feast of San Gennaro", new Date()));
		todos.add(new Event(++idCounter, "Chang", "NYC Haunted Booze Cruise", new Date()));
		todos.add(new Event(++idCounter, "Chang", "The Empire Beneath the Streets Tour", new Date()));
		todos.add(new Event(++idCounter, "Chang", "Jersey City Seafood Fest", new Date()));
		todos.add(new Event(++idCounter, "Chang", "Animal Rights March", new Date()));
		todos.add(new Event(++idCounter, "Chang", "October Midnight Yacht Cruise", new Date()));
		
	}
	
	public List<Event> findAll() {
		return todos;
	}
	
	public Event deleteById(long id) {
		Event todo = findById(id);
		if (todo == null) return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Event findById(long id) {
		for(Event todo:todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Event save(Event todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
