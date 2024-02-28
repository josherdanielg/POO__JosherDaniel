package ControlEscolar;
import java.util.HashMap;
import java.util.Map;

public class Alumno {

	private String nombre;
	private String nombreCarrera;
	private Map<String, Double> calificacionesPorMateria;

	public Alumno(String nombre, String nombreCarrera) {
		this.nombre = nombre;
		this.nombreCarrera = nombreCarrera;
		this.calificacionesPorMateria = new HashMap<>();
	}

	public void asignarCarrera(Carrera carrera) {
		this.nombreCarrera = carrera.getNombre();
	}

	public void agregarCalificacion(String materia, double calificacion) {
		calificacionesPorMateria.put(materia, calificacion);
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public Map<String, Double> getCalificacionesPorMateria() {
		return calificacionesPorMateria;
	}
}
