package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_LECTORES;

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

import com.example.demo.entity.LectoresEntity;
import com.example.demo.service.LectoresService;

@RestController
@RequestMapping(API_LECTORES)
public class LectoresController {
	
	@Autowired
	private LectoresService lectoresService;
	
	@GetMapping("/all")
	public List<LectoresEntity> listar() {
		return lectoresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LectoresEntity> listar2(@PathVariable("id") long DNILector) {
		LectoresEntity prod = lectoresService.read(DNILector);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<LectoresEntity> createTutorial(@RequestBody LectoresEntity p) {
	    try {
	    	LectoresEntity prod = lectoresService.create(new LectoresEntity(p.getDNILector(), p.getNombre(), p.getTelefono(), p.getDireccion(), p.getCodigo_postal(), p.getObservaciones()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<LectoresEntity> updateTutorial(@PathVariable("id") long DNILector, @RequestBody LectoresEntity p) {
		LectoresEntity post = lectoresService.read(DNILector);

	    if (post!=null) {
	    	post.setDNILector(p.getDNILector());
	    	post.setNombre(p.getNombre());
	    	post.setTelefono(p.getTelefono());
	    	post.setDireccion(p.getDireccion());
	    	post.setCodigo_postal(p.getCodigo_postal());
	    	post.setObservaciones(p.getObservaciones());

	      return new ResponseEntity<>(lectoresService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long DNILector) {
	    try {
	    	lectoresService.delete(DNILector);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}
