package ExamenFinal;
import java.time.LocalTime;
import java.util.List;

public class Medico {
	private String Cedula;
	private String Nombre;
	private List<Especialidad> Especialidades;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;

	public Medico(String cedula, String nombre, List<Especialidad> especialidades, LocalTime horarioInicio, LocalTime horarioFin) {
		this.Cedula=cedula;
		this.Nombre=nombre;
		this.Especialidades=especialidades;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
	}

	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		this.Cedula=cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre=nombre;
	}
	public List<Especialidad> getEspecialidades() {
		return Especialidades;
	}
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.Especialidades=especialidades;
	}
	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio=horarioInicio;
	}
	public LocalTime getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin=horarioFin;
	}
	@Override
	public String toString() {
		return Nombre+ " ("+Cedula+ ")";
	}
}
