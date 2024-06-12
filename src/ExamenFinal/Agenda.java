package ExamenFinal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {
	private Paciente Paciente;
	private Medico Medico;
	private LocalDate fechaCita;
	private LocalTime horaCita;
	
	public Agenda (Paciente paciente, Medico medico, LocalDate fechaCita, LocalTime horaCita) {
		this.Paciente=paciente;
		this.Medico=medico;
		this.fechaCita=fechaCita;
		this.horaCita=horaCita;
	}

	public Paciente getPaciente() {
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.Paciente = paciente;
	}
	public Medico getMedico() {
		return Medico;
	}
	public void setMedico(Medico medico) {
		this.Medico = medico;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}
	public LocalTime getHoraCita() {
		return horaCita;
	}
	public void setHoraCita(LocalTime horaCita) {
		this.horaCita = horaCita;
	}
	@Override
	public String toString(){
		return "Cita con "+ Medico+"para "+Paciente+"el "+fechaCita+"a la hora "+horaCita;
		}
}