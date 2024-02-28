package ControlEscolar;
import java.util.ArrayList;
import java.util.List;

public class Carrera {

	private String nombre;
	private List<String> materias;

	public Carrera(String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getMaterias() {
		return materias;
	}

	public void agregarMateria(String materia) {
		materias.add(materia);
	}
}
