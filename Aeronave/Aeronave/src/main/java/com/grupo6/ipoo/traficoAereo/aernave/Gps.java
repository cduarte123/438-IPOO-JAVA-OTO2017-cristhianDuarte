package com.grupo6.ipoo.traficoAereo.aernave;

import java.util.List;

public class Gps {
	
	private int id;
	private List<Posicion> posicion;
	
	public Gps(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Posicion> getPosicion() {
		return posicion;
	}

	public void setPosicion(List<Posicion> posicion) {
		this.posicion = posicion;
	}

	public Gps(int id, List<Posicion> posicion) {
		super();
		this.id = id;
		this.posicion = posicion;
	}
	
	
	
	
}
