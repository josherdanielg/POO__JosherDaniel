package Examen2doParcial;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Procesos agenda = new Procesos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Añadir/Actualizar Contacto");
            System.out.println("2. Existe Contacto");
            System.out.println("3. Listar Contactos");
            System.out.println("4. Buscar Contacto");
            System.out.println("5. Eliminar Contacto");
            System.out.println("6. Eliminar Teléfono");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contactos nuevoContacto = new Contactos(nombre, telefono);
                    agenda.añadirActualizarContacto(nuevoContacto);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.println("El contacto existe: " + agenda.existeContacto(nombre));
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    agenda.buscarContacto(nombre);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    agenda.eliminarContacto(nombre);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono a eliminar: ");
                    telefono = scanner.nextLine();
                    agenda.eliminarTelefono(nombre, telefono);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
