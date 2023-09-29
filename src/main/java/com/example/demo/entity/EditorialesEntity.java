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
@Table(name="EDITORIALES")
public class EditorialesEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_EDITORIALES")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEditoriales")
    @SequenceGenerator(sequenceName = "SEQ_EDITORIALES", allocationSize = 1, name = "seqEditoriales")
	private Long ideditoriales;
  
  	@Column(name = "EDITORIAL")
  	private String editorial;
}
