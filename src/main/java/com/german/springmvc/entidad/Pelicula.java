package com.german.springmvc.entidad;

import java.util.Date;

import lombok.Data;

@Data
public class Pelicula {

	private long id;
	private String titulo;
	private int duracion;
	private char clasificacion;
	private String genero;
	private Date fechaEstreno;
	private String imagen;
	private char estatus;

}
