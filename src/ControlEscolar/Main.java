package ControlEscolar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Carrera> carreras = new ArrayList<>();

		List<Materia> materias = new ArrayList<>();

		List<Profesor> profesores = new ArrayList<>();

		List<Alumno> alumnos = new ArrayList<>();

		int opcion;
		do {
			System.out.println("ESCUELA DE JOSHER");
			System.out.println("1. Dar de alta carreras");
			System.out.println("2. Dar de alta materias");
			System.out.println("3. Dar de alta profesores");
			System.out.println("4. Dar de alta alumnos");
			System.out.println("5. Asignar materias a los profesores");
			System.out.println("6. Asignar carrera a los alumnos");
			System.out.println("7. Agregar calificaciones a los alumnos por materia");
			System.out.println("8. Obtener datos del alumno");
			System.out.println("0. Salir");
			System.out.print("Ingrese su opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); 

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre de la carrera: ");
				String nombreCarrera = scanner.nextLine();
				Carrera carrera = new Carrera(nombreCarrera);
				carreras.add(carrera);
				break;
			case 2:
				System.out.print("Ingrese el nombre de la materia: ");
				String nombreMateria = scanner.nextLine();
				System.out.print("Ingrese el nombre de la carrera a la que pertenece: ");
				String nombreCarreraMateria = scanner.nextLine();
				Materia nuevaMateria = new Materia(nombreMateria, nombreCarreraMateria);
				materias.add(nuevaMateria);
				for (Carrera c : carreras) {
					if (c.getNombre().equals(nombreCarreraMateria)) {
						c.agregarMateria(nombreMateria);
					}
				}
				break;
			case 3:
				System.out.print("Ingrese el nombre del profesor: ");
				String nombreProfesor = scanner.nextLine();
				Profesor nuevoProfesor = new Profesor(nombreProfesor);
				profesores.add(nuevoProfesor);
				break;
			case 4:
				System.out.print("Ingrese el nombre del alumno: ");
				String nombreAlumno = scanner.nextLine();
				System.out.print("Ingrese el nombre de la carrera del alumno: ");
				String nombreCarreraAlumno = scanner.nextLine();
				Alumno nuevoAlumno = new Alumno(nombreAlumno, nombreCarreraAlumno);
				alumnos.add(nuevoAlumno);
				break;
			case 5:
				if (profesores.isEmpty() || materias.isEmpty()) {
					System.out.println("No hay profesores o materias para asignar.");
					break;
				}
				System.out.println("Lista de profesores:");
				for (int i = 0; i < profesores.size(); i++) {
					System.out.println((i + 1) + ". " + profesores.get(i).getNombre());
				}
				System.out.println("Lista de materias:");
				for (int i = 0; i < materias.size(); i++) {
					System.out.println((i + 1) + ". " + materias.get(i).getNombre());
				}
				System.out.print("Seleccione el número del profesor: ");
				int indexProfesor = scanner.nextInt() - 1;
				System.out.print("Seleccione el número de la materia: ");
				int indexMateria = scanner.nextInt() - 1;
				if (indexProfesor >= 0 && indexProfesor < profesores.size() && indexMateria >= 0 && indexMateria < materias.size()) {
					Profesor profesorSeleccionado = profesores.get(indexProfesor);
					Materia materiaSeleccionada = materias.get(indexMateria);
					System.out.println("Asignando materia " + materiaSeleccionada.getNombre() + " al profesor " + profesorSeleccionado.getNombre());
					profesorSeleccionado.asignarMateria(materiaSeleccionada);
				} else {
					System.out.println("Selección inválida.");
				}
				break;
			case 6:
				if (alumnos.isEmpty() || carreras.isEmpty()) {
					System.out.println("No hay alumnos o carreras para asignar.");
					break;
				}
				System.out.println("Lista de alumnos:");
				for (int i = 0; i < alumnos.size(); i++) {
					System.out.println((i + 1) + ". " + alumnos.get(i).getNombre());
				}
				System.out.println("Lista de carreras:");
				for (int i = 0; i < carreras.size(); i++) {
					System.out.println((i + 1) + ". " + carreras.get(i).getNombre());
				}
				System.out.print("Seleccione el número del alumno: ");
				int indexAlumnoCarrera = scanner.nextInt() - 1;
				System.out.print("Seleccione el número de la carrera: ");
				int indexCarreraAlumno = scanner.nextInt() - 1;
				if (indexAlumnoCarrera >= 0 && indexAlumnoCarrera < alumnos.size() && indexCarreraAlumno >= 0 && indexCarreraAlumno < carreras.size()) {
					Alumno alumnoSeleccionado = alumnos.get(indexAlumnoCarrera);
					Carrera carreraSeleccionada = carreras.get(indexCarreraAlumno);
					System.out.println("Asignando carrera " + carreraSeleccionada.getNombre() + " al alumno " + alumnoSeleccionado.getNombre());
					alumnoSeleccionado.asignarCarrera(carreraSeleccionada);
				} else {
					System.out.println("Selección inválida.");
				}
				break;
			case 7:
				if (alumnos.isEmpty() || materias.isEmpty()) {
					System.out.println("No hay alumnos o materias para agregar calificaciones.");
					break;
				}
				System.out.println("Lista de alumnos:");
				for (int i = 0; i < alumnos.size(); i++) {
					System.out.println((i + 1) + ". " + alumnos.get(i).getNombre());
				}
				System.out.print("Seleccione el número del alumno: ");
				int indexAlumnoCalif = scanner.nextInt() - 1;
				scanner.nextLine();
				if (indexAlumnoCalif >= 0 && indexAlumnoCalif < alumnos.size()) {
					Alumno alumnoSeleccionado = alumnos.get(indexAlumnoCalif);
					System.out.println("Alumno seleccionado: " + alumnoSeleccionado.getNombre());

					System.out.println("Lista de materias del alumno:");
					Map<String, Double> calificaciones = alumnoSeleccionado.getCalificacionesPorMateria();
					for (String materia : calificaciones.keySet()) {
						System.out.println("- " + materia);
					}

					System.out.print("Ingrese el nombre de la materia: ");
					String materia = scanner.nextLine();

					System.out.print("Ingrese la calificación: ");
					double calificacion = scanner.nextDouble();

					alumnoSeleccionado.agregarCalificacion(materia, calificacion);
					System.out.println("Calificación agregada correctamente.");
				} else {
					System.out.println("Selección inválida.");
				}
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida. Inténtelo de nuevo.");
			}
		} while (opcion != 0);

		scanner.close();
	}
}