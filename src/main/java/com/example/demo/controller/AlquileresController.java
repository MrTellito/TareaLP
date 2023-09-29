package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_ALQUILERES;

import java.util.List;

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

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.service.AlquileresService;

@RestController
@RequestMapping(API_ALQUILERES)
public class AlquileresController {
	
	@Autowired
	private AlquileresService alquilerestService;
	
	@GetMapping("/all")
	public List<AlquileresEntity> listar() {
		return alquilerestService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlquileresEntity> listar2(@PathVariable("id") long idalquileres) {
		AlquileresEntity prod = alquilerestService.read(idalquileres);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<AlquileresEntity> createTutorial(@RequestBody AlquileresEntity a) {
	    try {
	    	AlquileresEntity prod = alquilerestService.create(new AlquileresEntity(a.getIdalquileres(), a.getLectorEntity(), a.getLibroEntity(), a.getFecha_entrada(), a.getFecha_salida()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<AlquileresEntity> updateTutorial(@PathVariable("id") long idalquileres, @RequestBody AlquileresEntity a) {
		AlquileresEntity post = alquilerestService.read(idalquileres);

	    if (post!=null) {
	    	post.setIdalquileres(a.getIdalquileres());
	    	post.setFecha_salida(a.getFecha_salida());
	    	post.setFecha_entrada(a.getFecha_entrada());
	    	post.setLectorEntity(a.getLectorEntity());
	    	post.setLibroEntity(a.getLibroEntity());
	    	
	      return new ResponseEntity<>(alquilerestService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long idalquileres) {
	    try {
	    	alquilerestService.delete(idalquileres);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}