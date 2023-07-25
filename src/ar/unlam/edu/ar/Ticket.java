package ar.unlam.edu.ar;

public class Ticket implements Comparable<Ticket> , GetTipo {
	
	private Integer id;
    protected Integer nroViaje;  


	public Ticket(Integer id, Integer nroViaje  ) {
		this.id = id;
		this.nroViaje= nroViaje; 
		 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public Integer getNroViaje() {
		return nroViaje;
	}

	public void setNroViaje(Integer nroViaje) {
		this.nroViaje = nroViaje;
	}

	
	public int compareTo(TicketPasajero o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int compareTo(Ticket o) {
		return this.id.compareTo(o.getId());
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
