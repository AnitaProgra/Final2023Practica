package ar.unlam.edu.ar;

public class TipoTicketInvalidoExcption extends Exception {

	protected String mensaje;

	public TipoTicketInvalidoExcption(String mensaje) {
		super(mensaje);
		
	} 
	
	
}
