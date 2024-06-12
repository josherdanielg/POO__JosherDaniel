package ExamenFinal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class main {

	private static List<Medico> medicos = new ArrayList<>();
	private static List<Paciente> pacientes = new ArrayList<>();
	private static List<Agenda> agenda = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean salir=false;

		while (!salir) {
			System.out.println("Hospital VitalTech by Josher Daniel G");
			System.out.println("1-. Alta/Edicion del medico");
			System.out.println("2-. Alta/edicion del paciente");
			System.out.println("3-. Agenda tu cita");
			System.out.println("4-. Ver agenda del medico");
			System.out.println("5.- Salir del sistema");

			int opcion=scanner.nextInt();
			switch (opcion){
			case 1:
				altaEdicionMedico(scanner);
				break;
			case 2:
				altaEdicionPaciente(scanner);
				break;
			case 3:
				agendarCita(scanner);
				break;
			case 4:
				verAgendaMedico(scanner);
				break;
			case 5:
				salir=true;
				break;
			default:
				System.out.println("Opcion no valida, seleccione otra");
			}
		}
		scanner.close();
	}
	private static void altaEdicionMedico(Scanner scanner) {
		System.out.println("Alta/Edición de Médico");
		System.out.print("Ingrese la cédula del médico: ");
		String cedula=scanner.nextLine();
		Medico medico=buscarMedicoPorCedula(cedula);

		if (medico==null) {
			System.out.print("Ingrese el nombre del médico: ");
			String nombre=scanner.nextLine();
			List<Especialidad> especialidades = new ArrayList<>();
			System.out.print("Ingrese las especialidades del médico (separadas por comas): ");
			String[] especialidadesStr=scanner.nextLine().split(",");
			for (String especialidadStr:especialidadesStr) {
				especialidades.add(new Especialidad(especialidadStr.trim()));
			}

			System.out.print("Ingrese el horario de inicio (HH:MM): ");
			LocalTime horarioInicio=LocalTime.parse(scanner.nextLine());
			System.out.print("Ingrese el horario de fin (HH:MM): ");
			LocalTime horarioFin=LocalTime.parse(scanner.nextLine());
			medico=new Medico(cedula, nombre, especialidades, horarioInicio, horarioFin);
			medicos.add(medico);
			System.out.println("Médico registrado exitosamente.");
		} else {
			System.out.println("Editando médico existente: "+medico);
		}
	}

	private static Medico buscarMedicoPorCedula(String cedula) {
		for (Medico medico:medicos) {
			if (medico.getCedula().equals(cedula)) {
				return medico;
			}
		}
		return null;
	}

	private static void altaEdicionPaciente(Scanner scanner) {
		System.out.println("Alta/Edición de Paciente");
		System.out.print("Ingrese el RFC del paciente: ");
		String rfc=scanner.nextLine();
		Paciente paciente=buscarPacientePorRFC(rfc);

		if (paciente==null) {
			System.out.print("Ingrese el nombre del paciente: ");
			String nombre=scanner.nextLine();
			System.out.print("Ingrese el padecimiento del paciente: ");
			String padecimiento=scanner.nextLine();
			System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
			LocalDate fechaNacimiento=LocalDate.parse(scanner.nextLine());
			System.out.print("Ingrese el peso del paciente: ");
			double peso=scanner.nextDouble();
			System.out.print("Ingrese la estatura del paciente: ");
			double estatura=scanner.nextDouble();
			scanner.nextLine();  

			paciente=new Paciente(rfc, nombre, padecimiento, fechaNacimiento, peso, estatura);
			pacientes.add(paciente);
			System.out.println("Paciente registrado exitosamente.");
		} else {
			System.out.println("Editando paciente existente: " + paciente);
		}
	}

	private static Paciente buscarPacientePorRFC(String rfc) {
		for (Paciente paciente:pacientes) {
			if (paciente.getRfc().equals(rfc)) {
				return paciente;
			}
		}
		return null;
	}

	private static void agendarCita(Scanner scanner) {
		System.out.println("Agendar Cita");
		System.out.print("Ingrese el RFC del paciente: ");
		String rfc=scanner.nextLine();
		Paciente paciente = buscarPacientePorRFC(rfc);

		if (paciente==null) {
			System.out.println("Paciente no encontrado.");
			return;
		}

		System.out.print("Ingrese la especialidad: ");
		String especialidadStr=scanner.nextLine();
		List<Medico> medicosEspecialidad=new ArrayList<>();
		for (Medico medico:medicos) {
			for (Especialidad especialidad:medico.getEspecialidades()) {
				if (especialidad.getNombre().equalsIgnoreCase(especialidadStr)) {
					medicosEspecialidad.add(medico);
				}
			}
		}

		if (medicosEspecialidad.isEmpty()) {
			System.out.println("No hay médicos con esa especialidad.");
			return;
		}

		System.out.println("Médicos disponibles:");
		for (Medico medico:medicosEspecialidad) {
			System.out.println(medico);
		}

		System.out.print("Ingrese la cédula del médico: ");
		String cedulaMedico=scanner.nextLine();
		Medico medicoSeleccionado=buscarMedicoPorCedula(cedulaMedico);

		if (medicoSeleccionado==null||!medicosEspecialidad.contains(medicoSeleccionado)) {
			System.out.println("Médico no encontrado o no corresponde a la especialidad.");
			return;
		}

		System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
		LocalDate fechaCita=LocalDate.parse(scanner.nextLine());
		System.out.print("Ingrese la hora de la cita (HH:MM): ");
		LocalTime horaCita=LocalTime.parse(scanner.nextLine());

		if (!esHorarioValido(medicoSeleccionado, fechaCita, horaCita)) {
			System.out.println("El médico no está disponible en ese horario.");
			return;
		}

		Agenda cita=new Agenda(paciente, medicoSeleccionado, fechaCita, horaCita);
		agenda.add(cita);
		System.out.println("Cita agendada exitosamente.");
	}

	private static boolean esHorarioValido(Medico medico, LocalDate fecha, LocalTime hora) {
		for (Agenda agenda:agenda) {
			if (agenda.getMedico().equals(medico)&&agenda.getFechaCita().equals(fecha) && agenda.getHoraCita().equals(hora)) {
				return false;
			}
			if (agenda.getPaciente().equals(agenda.getPaciente())&&agenda.getFechaCita().equals(fecha) && agenda.getHoraCita().equals(hora)) {
				return false;
			}
		}
		return hora.isAfter(medico.getHorarioInicio().minusMinutes(1))&&hora.isBefore(medico.getHorarioFin().plusMinutes(1));
	}

	private static void verAgendaMedico(Scanner scanner) {
		System.out.println("Ver Agenda del Médico");
		System.out.print("Ingrese la cédula del médico: ");
		String cedula=scanner.nextLine();

		Medico medico=buscarMedicoPorCedula(cedula);
		if (medico==null) {
			System.out.println("Médico no encontrado.");
			return;
		}

		System.out.println("Agenda del médico "+medico.getNombre()+": ");
		for (Agenda agenda:agenda) {
			if (agenda.getMedico().equals(medico)) {
				System.out.println(agenda);
			}
		}
	}
}
