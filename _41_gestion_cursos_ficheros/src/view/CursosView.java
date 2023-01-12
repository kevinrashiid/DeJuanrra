package view;
/*
1.- Añadir curso
2.- Buscar curso
3.- Duración media de cursos
4.- Cursos por temática
5.- Eliminar cursos por precio
6.- Salir*/

import java.util.ArrayList;
import java.util.Scanner;

import model.Curso;
import service.CursosService;

public class CursosView {


	static CursosService service = new CursosService(); 
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			opcion=Integer.parseInt(sc.nextLine());  // lee opcion elegida
			switch(opcion) {      // evaluamos
			case 1:
				añadirCurso();
				break;
			case 2:
				buscarCurso();
				break;   
			case 3:
				duracionMedia();
				break;
			case 4:
				cursosTematica();
				break;
			case 5:
				eliminarCurso();
				break;
			case 6:
				mostrarTodos();
				break;
			case 7: System.out.println("--- Adios ---");
			}
		}while(opcion!=7);
		

	}
	
	
	
	static void mostrarMenu() {
		System.out.println();
		System.out.println("1.- Añadir curso ");
		System.out.println("2.- Buscar curso ");
		System.out.println("3.- Duración media de cursos");
		System.out.println("4.- Cursos por temática");
		System.out.println("5.- Eliminar cursos por precio");
		System.out.println("6.- Mostrar todos");
		System.out.println("7.- Salir");
	}
	
	
	static void añadirCurso() {
		String nom;
		int duracion;
		int precio;
		Boolean existe = false;
		String tematica;
		
		
		System.out.println("Nombre del curso: ");
		nom= sc.nextLine();
	    while (service.buscarCurso(nom)!=null) {
	    	System.out.println("Ya existe un curso con ese nombre, por favor, introduce otro nombre: ");
	    	nom= sc.nextLine();
	    }
		System.out.println("Duración del curso: ");
		duracion=Integer.parseInt(sc.nextLine());
		System.out.println("Precio del curso: ");
		precio=Integer.parseInt(sc.nextLine());
		System.out.println("Tematica del curso: ");
		tematica= sc.nextLine();		
		
		service.añadirCurso(nom, duracion, precio, tematica);
	}
	
	static void buscarCurso() {
		String nombrecurso;
		System.out.println("Qué curso buscas: ");
		nombrecurso=sc.nextLine();
		Curso curso=service.buscarCurso(nombrecurso);
		
		if (curso==null) {
			System.out.println("El curso "+nombrecurso+ " que estás buscando no existe");
		}else {
		
		System.out.println("El curso "+curso.getNombre()+" de "+curso.getDuracion()+" horas de duración, y con precio de "+
							curso.getPrecio()+ "€ , es de la tematica "+curso.getTematica());
		}
							
		
	}
	
	static void duracionMedia () {
		System.out.println("La duración media de los cursos es: " +service.duracionMedia()+" horas");
	}

	static void cursosTematica () {
		System.out.println("Introduce temática: ");
		String tematica = sc.nextLine();
		ArrayList<String> cur=service.cursosTematica(tematica);
		
		if (cur.size()>0) {
			System.out.println("Existen los siguientes cursos con temática "+tematica);
			for (String c: cur) {
				System.out.println(c);
			}
		}else {
			System.out.println("No Existe ningún curso con temática "+tematica);
			
		}
		
	}
	
	static void eliminarCurso () {
		System.out.println("Introduce el precio máximo y eliminamos los cursos mas caros que ese precio: ");

		System.out.println("Se han eliminado "+service.eliminarCurso(Integer.parseInt(sc.nextLine()))+" cursos");
	}
	static void mostrarTodos() {
		
		ArrayList<Curso> cur = service.mostrarTodos();
		
		if (cur.isEmpty()) {
			System.out.println("Aún no hay cursos dados de alta");
		}
		else {
			for(Curso c:cur){		
			System.out.println(c.getNombre()+"-->"+c.getDuracion()+" horas "+ c.getPrecio()+" € "+ "("+c.getTematica()+")");
			}
		}
	}
}
