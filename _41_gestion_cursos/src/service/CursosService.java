package service;

import java.util.ArrayList;
import java.util.HashSet;

import model.Curso;
/*
1.- Añadir curso
2.- Buscar curso
3.- Duración media de cursos
4.- Cursos por temática
5.- Eliminar cursos por precio
6.- Mostrar todos los cursos
7.- Salir
*/
public class CursosService {

	HashSet <Curso> curso = new HashSet <>();
	
	public void añadirCurso(String nombre, int duracion, double precio, String tematica) {
		curso.add(new Curso(nombre, duracion, precio, tematica));	
	}
	
	
	public Curso buscarCurso(String cursobuscado ) {
		Curso res = null;
		
		for(Curso c : curso) {
			if (c.getNombre().equalsIgnoreCase(cursobuscado)) {
				res = c;
			}
		}
		
		return res;
	}
	
	public double duracionMedia() {
		double media=0;
		
		for (Curso c : curso) {
			media=media+c.getDuracion();			
		}
		
		return media/curso.size() ;
		
		
	}
	
	public ArrayList<String> cursosTematica(String tematica) {
		
		ArrayList<String> res = new ArrayList<>();
		// quiero devolver un arraylist  de nombres de cursos con esa tematica 
		for (Curso c : curso) {
			if (c.getTematica().equalsIgnoreCase(tematica)) {
				res.add(c.getNombre());
			}
		}
		return res;
		
	}
	
	public int  eliminarCurso(int precio) {
		int cuantos=0;
		for (Curso c: curso) {
			if (c.getPrecio() > precio) {
				curso.remove(c);
				cuantos++;
			}
		}
		return cuantos;
	}
	/*
	public void  eliminarCurso(double precio) {
		
		for (Curso c: curso) {
			if (c.getPrecio() > precio) {
				curso.remove(c);
				
			}
		}
	}
	*/
	
	public ArrayList<Curso>  mostrarTodos () {
		 ArrayList<Curso> res = new ArrayList<>();
		 for (Curso c: curso) {
			 res.add(c);
			
		}
	return res;	 
	}
}
