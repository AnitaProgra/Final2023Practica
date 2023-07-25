package ar.unlam.edu.ar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private Map<Integer, Viaje> viajes;
    protected Integer nroViaje;
    protected Integer idTicket; 
	// Se registran todas las ventas de pasajes de los pasajeros
	private Set<Ticket> tickets;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.nroViaje= 0;
		this.idTicket= 0; 
		this.viajes= new HashMap<>();
		this.tickets= new TreeSet<>(); 
		
	}

	
	
	
	public Set<Ticket> getTickets() {
		return tickets;
	}

	public Integer nroTickets() {
		return tickets.size();
	}


	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Map<Integer, Viaje> viajes) {
		this.viajes = viajes;
	}

	/*
	 * Registra Un Nuevo viaje se debe guardar en un mapa donde la Key es un entero
	 * y es autoincremental arrancando de 0
	 */
	
	
	public void registrarViaje(Viaje viaje) {
     this.viajes.put(nroViaje, viaje); 
     nroViaje++; 
	}

	/*
	 * Registra Un ticket para carga TicketCarga.class 
	 * Si el viaje no admite Carga lanza TipoTicketInvalidoExcption
	 *  si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketcarga(Integer id, Integer numeroViaje, Carga carga) throws TipoTicketInvalidoExcption, CapacidadExcedidaException {
	    try {
	
	    	if(!viajes.containsKey(numeroViaje)) {
	    		throw new TipoTicketInvalidoExcption("este viaje no existe");
	    	}
	    	
	    	MedioTransporte transporte = viajes.get(numeroViaje).getMedioTransporte();
	    	
	    	if(!(transporte instanceof TransporteCarga)) {
	    		throw new TipoTicketInvalidoExcption("este viaje no acepta cargas");
	    	}
	    
	     Double cargaPaquete = carga.getPeso(); 
	    Double cargaPermitida = ((TransporteCarga)transporte).obtenerCargaMaxima(); 
	    	
	    if(cargaPaquete > cargaPermitida) {
	    		throw new CapacidadExcedidaException("Excede el peso permitido");
	    	}
	    
	    else {tickets.add(new TicketCarga(id, numeroViaje, carga));}
	    
	    } 
	        
	catch (TipoTicketInvalidoExcption e) {
	        System.out.println(e.getMessage());
	    } 
	catch (CapacidadExcedidaException e) {
	        System.out.println("La carga con id "+ carga.getId() +" " + e.getMessage() + ". Peso : "+carga.getPeso());
	    }
	}

	
	
	/*
	 * Se registra un TicketPasajero TicketPasajero 
	 * Si el viaje no admite pasajeros lanza TipoTicketInvalidoExcption 
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 */

	public void registrarTicketPasajero(Integer id, Integer numeroViaje, Pasajero pasajero) throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

	    try {
	        
            if (!viajes.containsKey(numeroViaje)) {
            	throw new TipoTicketInvalidoExcption("no existe este viaje"); 
            }
	        
	        MedioTransporte transporte = viajes.get(numeroViaje).getMedioTransporte(); 

	        if (!(transporte instanceof TransportePasajero)) {
	            throw new TipoTicketInvalidoExcption("Tipo de transporte no acepta tickets de pasajero.");
	        }

	        
	        Integer cantidadMaxPasajeros = ((TransportePasajero) transporte).obtenerCantidadMaximaPasajero();
	        Integer cantidadTickets = 0;

	        for (Ticket t : tickets) {
	            if (t instanceof TicketPasajero) {
	                cantidadTickets++;
	            }
	        }
	        

            
	        if (cantidadTickets < cantidadMaxPasajeros) {
	        	tickets.add(new TicketPasajero(id, numeroViaje, pasajero));   
	        }
	        
	        
        else {
        	throw new CapacidadExcedidaException("Capacidad Excedida Exception");       
	        }

	        
	    } catch (TipoTicketInvalidoExcption e) {
	        System.out.println(e.getMessage());
	    } catch (CapacidadExcedidaException e) {
	        System.out.println(e.getMessage());
	    }
	}

	
	
	
	
	/*
	 * Se registra un TicketMixto TicketMixto.class  
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 * si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketMixto(Integer id, Integer numeroViaje, Pasajero pasajero,Carga carga)throws TipoTicketInvalidoExcption, CapacidadExcedidaException {

	    try {
	        
            if (!viajes.containsKey(numeroViaje)) {
            	throw new TipoTicketInvalidoExcption("no existe este viaje"); 
            }
	        
	        MedioTransporte transporte = viajes.get(numeroViaje).getMedioTransporte(); 

	        if (!(transporte instanceof TransporteMixto)) {
	            throw new TipoTicketInvalidoExcption("Tipo de transporte no acepta tickets de pasajero.");
	        }

	        
	        Integer cantidadMaxPasajeros = ((TransporteMixto) transporte).obtenerCantidadMaximaPasajero();
	        Double pesoMaximo = ((TransporteMixto) transporte).obtenerCargaMaxima();  
	        Integer cantidadTickets=0;
	        Double cargaActual= carga.getPeso(); 

	        for (Ticket t : tickets) {
	            if (t instanceof TicketMixto) {
	                cantidadTickets++;
	            }
	        }
	        

            
	        if (cantidadTickets < cantidadMaxPasajeros && cargaActual < pesoMaximo) {
	        	tickets.add(new TicketMixto(id, numeroViaje, pasajero, carga));   
	        }
	        
	        
        else {
        	throw new CapacidadExcedidaException("Capacidad Excedida Exception");       
	        }

	        
	    } catch (TipoTicketInvalidoExcption e) {
	        System.out.println(e.getMessage());
	    } catch (CapacidadExcedidaException e) {
	        System.out.println(e.getMessage());
	    }
	}


	
	
	
	
	
	
	/*
	 * retorna la lista de pasajero enforma Descendiente Lanza una exception si el
	 * viaje no existe o si el tipo de viaje No es compatible para trnssporte de
	 * pasajero lanza una exception si el viaje no existe
	 */

	public boolean obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer numeroViaje) {

		
		if (!viajes.containsKey(numeroViaje)) {
			return false; 
		}
		
		
		TreeSet<Pasajero> pasajerosOrdenados = new TreeSet<>();

		 if(viajes.containsKey(numeroViaje)) {
		 
	        for (Ticket ticket : tickets) {
	            pasajerosOrdenados.add(((TicketPasajero)ticket).getPasajero());
	                 
	        }
		 }      

		 for (Pasajero pasajero : pasajerosOrdenados) {
	            System.out.println("Nombre: " + pasajero.getApellido() + ", DNI: " + pasajero.getDni());
	             
	        }
	     	        
	        return true; 
		 
	    }
		


	public Double obtenerELTotalDeCargaTransportadaEnTodosLosViajes(Integer numeroViaje) {

		if (!viajes.containsKey(numeroViaje)) {
			return 0.0; 
		}
				
		Double kilosCargas = 0.0;

		 if(viajes.containsKey(numeroViaje)) {
		 
	        for (Ticket ticket : tickets) {
	         kilosCargas+= ((TicketCarga)ticket).getCarga().getPeso();
	                 
	        }
		 }      
     	        
	        return kilosCargas; 
		
	}

}
