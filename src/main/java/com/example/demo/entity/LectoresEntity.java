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
@Table(name="LECTORES")
public class LectoresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_LECTORES")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLectores")
    @SequenceGenerator(sequenceName = "SEQ_LECTORES", allocationSize = 1, name = "seqLectores")
	private Long DNILector;
  
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "TELEFONO")
  	private String telefono;

  	@Column(name = "DIRECCION")
  	private String direccion;
  	
  	@Column(name = "CODIGO_POSTAL")
  	private Integer codigo_postal;
  	
  	@Column(name = "OBSERVACIONES")
  	private String observaciones;
}