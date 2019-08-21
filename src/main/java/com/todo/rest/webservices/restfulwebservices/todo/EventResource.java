package com.todo.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController 
public class EventResource {
	
	@Autowired
	private EventHardcodedService eventService;
	
	@GetMapping("/users/{username}/events")
	public List<Event> getAllEvents(@PathVariable String username) {
		return eventService.findAll();
	}
	
	@GetMapping("/users/{username}/events/{id}")
	public Event getEvent(@PathVariable String username, @PathVariable long id) {
		return eventService.findById(id);
	}
	
	
	@DeleteMapping("/users/{username}/events/{id}")
	public ResponseEntity<Void> deleteEvent(
			@PathVariable String username, @PathVariable long id) {
		Event event = eventService.deleteById(id);
		if (event!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/events/{id}")
	public ResponseEntity<Event> updateEvent(
			@PathVariable String username, @PathVariable long id, @RequestBody Event event){
		Event eventUpdated = eventService.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/events")
	public ResponseEntity<Void> updateEvent(
			@PathVariable String username, @RequestBody Event event){
		Event createdEvent = eventService.save(event);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(createdEvent.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
