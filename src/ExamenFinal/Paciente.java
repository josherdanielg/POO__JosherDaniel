package ExamenFinal;
import java.time.LocalDate;

public class Paciente {
    private String RFC;
    private String Nombre;
    private String Padecimiento;
    private LocalDate fechaNacimiento;
    private double Peso;
    private double Estatura;

    public Paciente(String rfc, String nombre, String padecimiento, LocalDate fechaNacimiento, double peso, double estatura) {
        this.RFC = rfc;
        this.Nombre = nombre;
        this.Padecimiento = padecimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.Peso = peso;
        this.Estatura = estatura;
    }
    public String getRfc() {
        return RFC;
    }
    public void setRfc(String rfc) {
        this.RFC=rfc;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre=nombre;
    }
    public String getPadecimiento() {
        return Padecimiento;
    }
    public void setPadecimiento(String padecimiento) {
        this.Padecimiento=padecimiento;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento=fechaNacimiento;
    }
    public double getPeso() {
        return Peso;
    }
    public void setPeso(double peso) {
        this.Peso=peso;
    }
    public double getEstatura() {
        return Estatura;
    }
    public void setEstatura(double estatura) {
        this.Estatura=estatura;
    }
    @Override
    public String toString() {
        return Nombre+" (" +RFC+" )";
    }
}
