package ar.unlam.edu.ar;

public class TransportePasajero extends MedioTransporte implements ITransportable{
	
	
	protected Integer cantidadMaximaPasajeros; 
	public TransportePasajero(String patente, Integer cantidadMaximaPasajeros ) {
		super(patente);
		this.cantidadMaximaPasajeros= cantidadMaximaPasajeros; 
	}
	
	public void setCantidadMaximaPasajeros(Integer cantidadMaximaPasajeros) {
		this.cantidadMaximaPasajeros = cantidadMaximaPasajeros;
	}

	
	@Override
	public Integer obtenerCantidadMaximaPasajero() {
	return cantidadMaximaPasajeros;
	}

	

}
