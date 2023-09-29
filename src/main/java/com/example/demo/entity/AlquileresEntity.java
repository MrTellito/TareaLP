package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALQUILERES")
public class AlquileresEntity implements Serializable{
	public AlquileresEntity(Long idalquileres2, Object lector2, Object libro2, String fecha_salida2,
			String fecha_entrada2) {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_ALQUILERES")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlquileres")
    @SequenceGenerator(sequenceName = "SEQ_ALQUILERES", allocationSize = 1, name = "seqAlquileres")
	private Long idalquileres;
	
	@ManyToOne
  	@JoinColumn(name="DNILector", nullable = false)
  	private LectoresEntity lector;
  	
  	@ManyToOne
  	@JoinColumn(name="ASIN", nullable = false)
  	private LibroEntity libro;
  
  	@Column(name = "FECHA SALIDA")
  	private Date fecha_salida;
  	
  	@Column(name = "FECHA ENTRADA")
  	private Date fecha_entrada;
  	
}