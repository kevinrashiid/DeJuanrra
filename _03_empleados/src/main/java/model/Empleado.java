package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
	private String nombre;
	private String departamento;
	private double salario;
	private LocalDate fecha;
	
}
