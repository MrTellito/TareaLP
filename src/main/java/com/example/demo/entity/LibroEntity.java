package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
  	
  	@Column(name = "FECHA_LANZAMIENTO")
  	private Date fecha_lanzamiento;

  	@ManyToOne
  	@JoinColumn(name="ID_AUTOR", nullable = false)
  	private AutoresEntity autorEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_CATEGORIA", nullable = false)
  	private CategoriaEntity categoriaEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_EDITORIAL", nullable = false)
  	private EditorialesEntity editorialEntity;
  	
  	@Column(name = "IDIOMA")
  	private String idioma;
  	
  	@Column(name = "PAGINAS")
  	private int paginas;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;
  	
  	@Column(name = "PORTADA")
  	private String portada;
  	
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "libroEntity")
	@JsonIgnore
	Set<AlquileresEntity> alquileresEntity;
}
