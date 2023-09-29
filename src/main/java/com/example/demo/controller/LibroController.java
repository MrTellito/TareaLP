package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_LIBROS;

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

import com.example.demo.entity.LibroEntity;
import com.example.demo.service.LibroService;

@RestController
@RequestMapping(API_LIBROS)
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/all")
	public List<LibroEntity> listar() {
		return libroService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LibroEntity> listar2(@PathVariable("id") long ASIN) {
		LibroEntity prod = libroService.read(ASIN);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<LibroEntity> createTutorial(@RequestBody LibroEntity p) {
	    try {
	    	LibroEntity prod = libroService.create(new LibroEntity(p.getASIN(), p.getTitulo(), p.getFecha_lanzamiento(), p.getAutorEntity(), p.getCategoriaEntity(), p.getEditorialEntity(), p.getIdioma(), p.getPaginas(), p.getDescripcion(), p.getPortada(), p.getAlquileresEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<LibroEntity> updateTutorial(@PathVariable("id") long ASIN, @RequestBody LibroEntity p) {
		LibroEntity post = libroService.read(ASIN);

	    if (post!=null) {
	    	post.setASIN(p.getASIN());
	    	post.setTitulo(p.getTitulo());
	    	post.setFecha_lanzamiento(p.getFecha_lanzamiento());
	    	post.setAutorEntity(p.getAutorEntity());
	    	post.setCategoriaEntity(p.getCategoriaEntity());
	    	post.setEditorialEntity(p.getEditorialEntity());
	    	post.setIdioma(p.getIdioma());
	    	post.setPaginas(p.getPaginas());
	    	post.setDescripcion(p.getDescripcion());
	    	post.setPortada(p.getPortada());
	    	post.setAlquileresEntity(p.getAlquileresEntity());
	      return new ResponseEntity<>(libroService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long ASIN) {
	    try {
	    	libroService.delete(ASIN);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}