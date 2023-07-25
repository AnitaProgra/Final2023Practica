package ar.unlam.edu.ar;

public class TicketMixto extends Ticket implements GetTipo{

	
	protected Pasajero pasajero; 
	protected Carga carga; 
	
	public TicketMixto(Integer id,Integer nroViaje, Pasajero pasajero, Carga carga ) {
		super(id, nroViaje);
		// TODO Auto-generated constructor stub
		this.pasajero= pasajero; 
		this.carga= carga; 
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	@Override
	public String getTipo() {
		return "Mixto";
	}

	
	
	
}
