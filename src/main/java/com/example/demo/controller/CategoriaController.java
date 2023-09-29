package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_CATEGORIAS;

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

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping(API_CATEGORIAS)
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/all")
	public List<CategoriaEntity> listar() {
		return categoriaService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaEntity> listar2(@PathVariable("id") long idcategoria) {
		CategoriaEntity prod = categoriaService.read(idcategoria);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Post")
	  public ResponseEntity<CategoriaEntity> createTutorial(@RequestBody CategoriaEntity p) {
	    try {
	    	CategoriaEntity prod = categoriaService.create(new CategoriaEntity(p.getIdcategoria(), p.getCategoria(), p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/post/{id}")
	  public ResponseEntity<CategoriaEntity> updateTutorial(@PathVariable("id") long idcategoria, @RequestBody CategoriaEntity p) {
		CategoriaEntity post = categoriaService.read(idcategoria);

	    if (post!=null) {
	    	post.setIdcategoria(p.getIdcategoria());
	    	post.setCategoria(p.getCategoria());
	    	post.setLibrosEntity(p.getLibrosEntity());
	    	return new ResponseEntity<>(categoriaService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/post/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long idcategoria) {
	    try {
	    	categoriaService.delete(idcategoria);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}