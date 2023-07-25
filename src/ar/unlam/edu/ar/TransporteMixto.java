package ar.unlam.edu.ar;

public class TransporteMixto  extends MedioTransporte implements iCargable, ITransportable{
	/*
	 * No se pueden agregar mas Atributos
	 */
	
	private Integer cantidadPasajerosMaximos;
	private Double cargaMaxima;
 
	
	
	public TransporteMixto(String patente, Integer cantidadPasajerosMaximos,Double cargaMaxima) {
		super(patente);
		this.cantidadPasajerosMaximos= cantidadPasajerosMaximos; 
		this.cargaMaxima= cargaMaxima; 
	}

	


	public void setCantidadPasajerosMaximos(Integer cantidadPasajerosMaximos) {
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
	}

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}



	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		return cantidadPasajerosMaximos;
	}



	@Override
	public Double obtenerCargaMaxima() {
		return cargaMaxima;
	}


	
	

}
