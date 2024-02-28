package ControlEscolar;

public class Materia {

	private String nombre;
	private String carrera;

	public Materia(String nombre, String carrera) {
		this.nombre = nombre;
		this.carrera = carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCarrera() {
		return carrera;
	}
}
