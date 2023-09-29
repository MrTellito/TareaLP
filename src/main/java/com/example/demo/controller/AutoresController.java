package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_AUTORES;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.service.AutoresService;

@RestController
@RequestMapping(API_AUTORES)
public class AutoresController {
	
	@Autowired
	private AutoresService autoresService;
	
	@GetMapping("/all")
	public List<AutoresEntity> listar() {
		return autoresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutoresEntity> listar2(@PathVariable("id") long idautores) {
		AutoresEntity prod = autoresService.read(idautores);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<AutoresEntity> createTutorial(@RequestBody AutoresEntity p) {
	    try {
	    	AutoresEntity prod = autoresService.create(new AutoresEntity(p.getIdautor(), p.getAutor(),p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<AutoresEntity> updateTutorial(@PathVariable("id") long idautores, @RequestBody AutoresEntity p) {
		AutoresEntity post = autoresService.read(idautores);

	    if (post!=null) {
	    	post.setIdautor(p.getIdautor());
	    	post.setAutor(p.getAutor());
	    	post.setLibrosEntity(p.getLibrosEntity());
	      return new ResponseEntity<>(autoresService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long idautores) {
	    try {
	    	autoresService.delete(idautores);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}