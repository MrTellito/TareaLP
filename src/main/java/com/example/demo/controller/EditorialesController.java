package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_EDITARIALES;

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

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.service.EditorialesService;

@RestController
@RequestMapping(API_EDITARIALES)
public class EditorialesController {
	
	@Autowired
	private EditorialesService editorialesService;
	
	@GetMapping("/all")
	public List<EditorialesEntity> listar() {
		return editorialesService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EditorialesEntity> listar2(@PathVariable("id") long ideditoriales) {
		EditorialesEntity prod = editorialesService.read(ideditoriales);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<EditorialesEntity> createTutorial(@RequestBody EditorialesEntity p) {
	    try {
	    	EditorialesEntity prod = editorialesService.create(new EditorialesEntity(p.getIdeditoriales(), p.getEditorial(), p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<EditorialesEntity> updateTutorial(@PathVariable("id") long ideditoriales, @RequestBody EditorialesEntity p) {
		EditorialesEntity post = editorialesService.read(ideditoriales);

	    if (post!=null) {
	    	post.setIdeditoriales(p.getIdeditoriales());
	    	post.setEditorial(p.getEditorial());
	    	post.setLibrosEntity(p.getLibrosEntity());
	      return new ResponseEntity<>(editorialesService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long ideditoriales) {
	    try {
	    	editorialesService.delete(ideditoriales);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}