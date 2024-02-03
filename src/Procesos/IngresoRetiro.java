package Procesos;

import Modelos.Cuenta;

public class IngresoRetiro {

	public Cuenta retirar(Cuenta cuenta, Double monto) throws Exception {
		if(null == monto) {
			throw new Exception("El monto no puede ser nulo");
		}
		
		Double cantidad = cuenta.getCantidad() - monto;
		if(cantidad < 0) {
			cuenta.setCantidad(0D);
		}
		
		return cuenta;
	}
	
	public Cuenta ingresar (Cuenta cuenta, Double monto) throws Exception {

		if(null == monto || monto<0) {
			throw new Exception ("El monto n puede ser nulo / negativo");
		}

		Double cantidad = cuenta.getCantidad() + monto;
		cuenta.setCantidad(cantidad);

		return cuenta;
	   }
	}
