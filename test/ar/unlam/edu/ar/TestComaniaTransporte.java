package ar.unlam.edu.ar;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class TestComaniaTransporte {

	@Test
	public void queSePuedaRegistrarUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);
		
		Boolean valorObtenido = empresa.getViajes().containsKey(0);
		Boolean valorObtenido2 = empresa.getViajes().containsValue(viaje);
		
		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaRegistrarUnTicketDePasajeroAUnViaje() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 2;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);		
		
		empresa.registrarViaje(viaje);
		
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Pasajero pasajero2 = new Pasajero(333, "lopez");
		
		empresa.registrarTicketPasajero(1, 0, pasajero);
		empresa.registrarTicketPasajero(2, 0, pasajero2);

		assertEquals((Integer)2, empresa.nroTickets());

	}

	@Test
	public void queAlRegistrarUnTicketDePasajeroAUnViajeConMedioDeTransporteDeCargaLanceUnaException() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

 
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		
		empresa.registrarTicketPasajero(1, 0, pasajero);

		assertTrue(empresa.getTickets().isEmpty());


	}

	@Test
	public void queSePuedaRegistrarUnTicketDeCargaAUnViaje() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";
        
		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);
		
		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		Viaje viaje2 = new Viaje(salida, llegada, "lanus", destino, medioTransporte);
		
		empresa.registrarViaje(viaje);
		empresa.registrarViaje(viaje2);
		
		empresa.registrarTicketcarga(1, 0, new Carga(12, 5.0));
		empresa.registrarTicketcarga(2, 0, new Carga(13, 10.0));
		//empresa.registrarTicketcarga(3, 0, new Carga(14, 60.0));
		
		assertEquals((Integer)2, empresa.nroTickets());
		
	}

	@Test
	public void queSePuedaRegistrarUnTicketMixtoAUnViaje() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 5.0;

		Integer cantidadPasajerosMaximos = 1;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos ,cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Pasajero pasajero2 = new Pasajero(333, apellido);
		
		empresa.registrarTicketMixto(1, 0, pasajero,new Carga(1, 3.0));
		//empresa.registrarTicketMixto(2, 0, pasajero2,new Carga(2, 4.0));
		
		assertEquals((Integer)1, empresa.nroTickets()); 

	}

	@Test
	public void queAlRegistrarUnticketYExcedalaCargaMaximaDelTransporteLanceUnaExceptionCapacidadExcedidaException() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {
		// No modificar este test.
			Empresa empresa = new Empresa("UnlamTravel");

			LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
			LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
			String origen = "Buenos Aires";
			String destino = "Mardel Plata";

			String Patente = "ac111jr";
	        
			Double cargaMaxima = 50.0;
			MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);
			
			Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
			
			empresa.registrarViaje(viaje);
			
			empresa.registrarTicketcarga(1, 0, new Carga(1, 55.0));
			
			assertTrue(empresa.getTickets().isEmpty());
	}

	@Test
	public void queSePuedaObtenerUnaListaPasajeroDeUnViajeOrdenadoPorDNIDescendiente() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";
        
		Integer cantidadPasajerosMaximos = 4;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);		
		
		empresa.registrarViaje(viaje);
		
		Integer dni = 2;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Pasajero pasajero2 = new Pasajero(3, "zaro");
		Pasajero pasajero3 = new Pasajero(4, "dolte");
		Pasajero pasajero4 = new Pasajero(5, "lopez");
		
		empresa.registrarTicketPasajero(1, 0, pasajero);
		empresa.registrarTicketPasajero(2, 0, pasajero2);
		empresa.registrarTicketPasajero(3, 0, pasajero3);
		empresa.registrarTicketPasajero(4, 0, pasajero4);

        assertTrue(empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(0));
	}

	
	
	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportada() throws TipoTicketInvalidoExcption, CapacidadExcedidaException {
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";
        
		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);
		
		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		
		empresa.registrarViaje(viaje);
		
		empresa.registrarTicketcarga(1, 0, new Carga(12, 5.0));
		empresa.registrarTicketcarga(2, 0, new Carga(13, 10.0));
		empresa.registrarTicketcarga(3, 0, new Carga(14, 20.0));
		
		assertEquals((Double)35.0, empresa.obtenerELTotalDeCargaTransportadaEnTodosLosViajes(0));

	}
}
