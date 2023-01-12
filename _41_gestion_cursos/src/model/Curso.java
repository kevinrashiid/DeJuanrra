package model;

public class Curso {
	private String nombre;
	private int duracion;
	private double precio;
	private String tematica;
	
	public Curso(String nombre, int duracion, double precio, String tematica) {
		
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.tematica = tematica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	} 
	
	

}
