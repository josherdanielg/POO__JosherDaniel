package Modelos;
import Modelos.Cuenta;
import Procesos.IngresoRetiro;

public class Cajero {

	public static void main (String[] args) {
		IngresoRetiro inRet = new IngresoRetiro();

		Cuenta c1 = new Cuenta();
		c1.setTitular("Josher Daniel Guzman Gomez");

		c1 = inRet.ingresar(c1, 10D);
	}
}