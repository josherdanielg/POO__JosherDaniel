package Tareas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Persona {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el nombre: ");
		String nombre = scanner.nextLine();

		System.out.print("Introduce la fecha de nacimiento (formato yyyy-MM-dd): ");
		String fechaNacimiento = scanner.nextLine();

		System.out.print("Introduce el sexo (H/M): ");
		String sexo = scanner.nextLine();

		Persona persona = new Persona(nombre, fechaNacimiento, sexo);

		System.out.println("\nInformación de la persona:\n" + persona.toString());
		System.out.println("Edad: " + persona.calcularEdad() + " años");
		System.out.println("¿Es mayor de edad?: " + persona.esMayorDeEdad());
		System.out.println("IMC: " + persona.calcularIMC());
	}

	private String nombre;
	private String fechaNacimiento;
	private String ID;
	private String sexo;
	private double peso;
	private double altura;

	public Persona() {
	}

	public Persona(String nombre, String fechaNacimiento, String sexo) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ID = generaID();
		this.sexo = sexo;
	}

	public Persona(String nombre, String fechaNacimiento, String ID, String sexo, double peso, double altura) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ID = ID;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public int calcularIMC() {
		if (peso > 0 && altura > 0) {
			double imc = peso / Math.pow(altura, 2);
			if (imc < 20) {
				return -1;
			} else if (imc >= 20 && imc <= 25) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return -1; 
		}
	}

	public int calcularEdad() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNac = sdf.parse(fechaNacimiento);
			Date fechaActual = new Date();
			long diferencia = fechaActual.getTime() - fechaNac.getTime();
			int edad = (int) (diferencia / (1000 * 60 * 60 * 24) / 365.25);
			return edad;
		} catch (Exception e) {
			e.printStackTrace();
			return -1; 
		}
	}

	public boolean esMayorDeEdad() {
		int edad = calcularEdad();
		return edad >= 18;
	}

	public String toString() {
		return "Nombre: " + nombre + "\nFecha de Nacimiento: " + fechaNacimiento + "\nID: " + ID + "\nSexo: " + sexo
				+ "\nPeso: " + peso + "\nAltura: " + altura;
	}

	private String generaID() {
		Random random = new Random();
		int numAleatorio = 10000000 + random.nextInt(90000000);
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		char letra = letras.charAt(numAleatorio % 23);
		return String.valueOf(numAleatorio) + letra;
	}
}