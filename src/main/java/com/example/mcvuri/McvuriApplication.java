package com.example.mcvuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@SpringBootApplication
public class McvuriApplication {

	public static void main(String[] args) {
		SpringApplication.run(McvuriApplication.class, args);
	}

	@RestController
	@RequestMapping("/api1")
	static class Controller1 {

		@GetMapping("/{path}")
		ResponseEntity<String> get(@PathVariable(name = "path") String path){
			return ResponseEntity.ok("Hello "+path);
		}

		@PostMapping
		ResponseEntity<Void> post(){
			var uri = MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(Controller1.class).get("test")).build();
			return ResponseEntity.created(uri.toUri()).build();
		}
	}


}
