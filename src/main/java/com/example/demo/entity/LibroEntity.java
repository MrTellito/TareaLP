package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LIBRO")
public class LibroEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_LIBRO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLibro")
    @SequenceGenerator(sequenceName = "seqLibro", allocationSize = 1, name = "seqLibro")
	private Long ASIN;
  
  	@Column(name = "TITULO")
  	private String titulo;
  	
  	@Column(name = "Fecha de lanzamiento")
  	private String fecha_lanzamiento;

  	@Column(name = "AUTOR")
  	private String autor;
  	
  	@Column(name = "CATEGORIA")
  	private String categoria;
  	
  	@Column(name = "EDITORIAL")
  	private String editorial;
  	
  	@Column(name = "IDIOMA")
  	private String idioma;
  	
  	@Column(name = "PAGINAS")
  	private Integer paginas;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;
  	
  	@Column(name = "PORTADA")
  	private String portada;
}
