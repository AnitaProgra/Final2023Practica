package ar.unlam.edu.ar;

public class TicketPasajero extends Ticket implements GetTipo{

	protected Pasajero pasajero; 
	
	public TicketPasajero(Integer id,Integer nroViaje,  Pasajero pasajero) {
		super(id, nroViaje);
		// TODO Auto-generated constructor stub
		this.pasajero= pasajero; 
	}

	
	
	public Pasajero getPasajero() {
		return pasajero;
	}



	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	@Override
	public int compareTo(TicketPasajero o) {
		return o.getPasajero().getDni().compareTo(this.pasajero.getDni());
	}



	@Override
	public String getTipo() {
		return "Pasajero"; 
	}

}
