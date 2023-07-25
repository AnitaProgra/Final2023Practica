package ar.unlam.edu.ar;

public class CapacidadExcedidaException extends Exception {


	protected String mensaje;

	public CapacidadExcedidaException (String mensaje) {
		super(mensaje);
		
	} 
}
