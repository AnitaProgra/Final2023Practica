package ar.unlam.edu.ar;

public class TransporteCarga extends MedioTransporte implements iCargable {

	protected Double cargaMaxima; 
	
	public TransporteCarga(String patente, Double cargaMaxima) {
		super(patente);
		this.cargaMaxima= cargaMaxima; 
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}
	
	
	@Override
	public Double obtenerCargaMaxima() {
		return cargaMaxima;
	}

	
	
}
