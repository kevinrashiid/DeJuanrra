package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
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

//	HashSet <Curso> curso = new HashSet <>();
	
	String dir ="C:\\ficheroseclipse\\cursos.txt";
	
	public void añadirCurso(String nombre, int duracion, double precio, String tematica) {
	//	curso.add(new Curso(nombre, duracion, precio, tematica));	
		String datos=nombre+"|"+duracion+"|"+precio+"|"+tematica;
		try (FileOutputStream fos = new FileOutputStream (dir, true);
			 PrintStream out= new PrintStream (fos);) {
			out.println(datos);
				
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
	} 
	
	
	
	
	public Curso buscarCurso(String cursobuscado ) {
		Curso res = null;
		
		
		try (FileReader    fr =new FileReader(dir);
				BufferedReader bf= new BufferedReader(fr);){
					
			String fila;  
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  
				Curso c =new Curso(linea[0],Integer.parseInt(linea[1]),Double.parseDouble(linea[2]),linea[3]);
				if (c.getNombre().equalsIgnoreCase(cursobuscado)) {
					res = c;
					break;
				}
			}
		}
		catch (FileNotFoundException ex)                  {
			try (FileOutputStream fos = new FileOutputStream (dir, true);
				PrintStream out= new PrintStream (fos);) {}
			
			catch (FileNotFoundException exi) {
				exi.printStackTrace();
			}
			
			catch (IOException exi) {
				exi.printStackTrace();
			}
			
			
			}
		
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public double duracionMedia() {
		double media=0;
		int contador=0;
		
		try (FileReader    fr =new FileReader(dir);
			BufferedReader bf= new BufferedReader(fr);){
					
			String fila;  
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  
				Curso c =new Curso(linea[0],Integer.parseInt(linea[1]),Double.parseDouble(linea[2]),linea[3]);
				media=media+c.getDuracion();
				contador++;
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return media/contador ;
		
		
	}
	
	public ArrayList<String> cursosTematica(String tematica) {
		
		ArrayList<String> res = new ArrayList<>();
		
		try (FileReader    fr =new FileReader(dir);
				BufferedReader bf= new BufferedReader(fr);){
					
			String fila;  
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  
				Curso c =new Curso(linea[0],Integer.parseInt(linea[1]),Double.parseDouble(linea[2]),linea[3]);
				if (c.getTematica().equalsIgnoreCase(tematica)) {
					res.add(c.getNombre());
				}
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return res;
		
	}
	
	public int  eliminarCurso(int precio) {
		int eliminados = 0;



		// Me llevo a un arraylist de cursos los que son menores que el precio dado
		ArrayList<Curso> res = new ArrayList<>();

		try (FileReader    fr =new FileReader(dir);
				BufferedReader bf= new BufferedReader(fr);){

			String fila;  
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  
				Curso c =new Curso(linea[0],Integer.parseInt(linea[1]),Double.parseDouble(linea[2]),linea[3]);

				if (c.getPrecio() < precio) {
					res.add(c);
				}
				else {
					eliminados++;
				}
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		//  Creo de nuevo el fichero con los cursos del arraylist 
		//  en los que ya se han eliminado los de precio superior al limite



		try {    // empiezo a escribir sobreescribiendo  , es una forma de crear de cero el fichero
			FileOutputStream fosi = new FileOutputStream (dir, false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



		for (Curso c: res) { 

			String datos=c.getNombre()+"|"+c.getDuracion()+"|"+c.getPrecio()+"|"+c.getTematica();
			try (FileOutputStream fos = new FileOutputStream (dir, true);  //pero cuando escribo de verdad, añado datos
					PrintStream out= new PrintStream (fos);) {
				out.println(datos);

			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}

		return eliminados;
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

		try (FileReader    fr =new FileReader(dir);
				BufferedReader bf= new BufferedReader(fr);){

			String fila;  
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  
				Curso c =new Curso(linea[0],Integer.parseInt(linea[1]),Double.parseDouble(linea[2]),linea[3]);
				res.add(c);

			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return res;


	}
}
