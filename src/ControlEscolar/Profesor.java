package ControlEscolar;
import java.util.ArrayList;
import java.util.List;

public class Profesor {

	private String nombre;
	private List<Materia> materiasImpartidas;

	public Profesor(String nombre) {
		this.nombre = nombre;
		this.materiasImpartidas = new ArrayList<>();
	}

	public void asignarMateria(Materia materia) {
		materiasImpartidas.add(materia);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Materia> getMateriasImpartidas() {
		return materiasImpartidas;
	}
}
