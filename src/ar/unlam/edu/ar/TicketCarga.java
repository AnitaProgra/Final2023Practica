package ar.unlam.edu.ar;

public class TicketCarga extends Ticket implements GetTipo {

	protected Carga carga; 
	
	public TicketCarga(Integer id, Integer nroViaje,  Carga carga) {
		super(id, nroViaje);
		 
		this.carga= carga; 
		
	}

	
	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}


	@Override
	public String getTipo() {
		return "Carga";
	}


	
	
	
	
}
