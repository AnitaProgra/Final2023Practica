package ar.unlam.edu.ar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMediosTransportes {

	@Test
	public void queSepuedaCrearMedioTransportePasajero() {
 
		Integer cantidadPasajerosMaximos=50;
		String patente = "AB123CD";
		MedioTransporte pasajero = new TransportePasajero (patente,cantidadPasajerosMaximos); 
        
		assertEquals( "AB123CD", pasajero.getPatente()); 
		
	}
	
	@Test
	public void queSepuedaCrearMedioTransporteCarga() {

		Double cargaMaxima = 1000.0;
		String patente = "987RT";
		MedioTransporte transporteCarga = new TransporteCarga (patente,cargaMaxima); 
		
		assertEquals("987RT", transporteCarga.getPatente()); 
		assertTrue(((TransporteCarga)transporteCarga).obtenerCargaMaxima().equals(cargaMaxima)); 

	}

	
	@Test
	public void queSepuedaCrearTransporteMixto() {


		Integer cantidadPasajerosMaximos=50;
		Double cargaMaxima = 1000.0;
		String patente = "987RT";
		MedioTransporte transporteMixto = new TransporteMixto (patente,cantidadPasajerosMaximos,cargaMaxima);
		
		assertTrue(transporteMixto.getPatente().contains("987RT")); 
		
	}


}