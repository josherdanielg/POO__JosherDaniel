package Examen2doParcial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Procesos {
    private List<Contactos> agenda;

    public Procesos() {
        this.agenda = new ArrayList<>();
    }

    public void añadirActualizarContacto(Contactos contacto) {
        if (!agenda.contains(contacto)) {
            agenda.add(contacto);
            Collections.sort(agenda, (c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
            System.out.println("Contacto añadido.");
        } else {
            System.out.println("El contacto ya existe en la agenda.");
        }
    }

    public boolean existeContacto(String nombre) {
        return agenda.stream().anyMatch(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }

    public void listarContactos() {
        System.out.println("Lista de contactos:");
        for (Contactos contacto : agenda) {
            System.out.println(contacto.getNombre() + ": " + contacto.getTelefonos());
        }
    }

    public void buscarContacto(String nombre) {
        for (Contactos contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Teléfonos de " + nombre + ": " + contacto.getTelefonos());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean eliminarContacto(String nombre) {
        for (Contactos contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                agenda.remove(contacto);
                System.out.println("Contacto eliminado.");
                return true;
            }
        }
        System.out.println("Contacto no encontrado.");
        return false;
    }

    public boolean eliminarTelefono(String nombre, String telefono) {
        for (Contactos contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                if (contacto.getTelefonos().remove(telefono)) {
                    System.out.println("Teléfono eliminado.");
                    return true;
                } else {
                    System.out.println("Teléfono no encontrado.");
                    return false;
                }
            }
        }
        System.out.println("Contacto no encontrado.");
        return false;
    }
}
