package Examen2doParcial;
import java.util.ArrayList;
import java.util.List;

public class Contactos {
    private String nombre;
    private List<String> telefonos;

    public Contactos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefonos = new ArrayList<>();
        agregarTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void agregarTelefono(String telefono) {
        if (telefono.length() == 10) {
            telefonos.add(telefono);
        } else {
            System.out.println("El teléfono debe tener 10 dígitos.");
        }
    }

    boolean equals(Contactos otro) {
        return this.nombre.equalsIgnoreCase(otro.nombre);
    }
}
