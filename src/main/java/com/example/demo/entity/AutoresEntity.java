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
@Table(name="AUTORES")
public class AutoresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_AUTOR")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutor")
    @SequenceGenerator(sequenceName = "seqAutor", allocationSize = 1, name = "seqAutor")
	private Long idautor;
  
  	@Column(name = "AUTOR")
  	private String autor;
}
