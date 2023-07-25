package ar.unlam.edu.ar;


public class MedioTransporte implements Comparable<MedioTransporte>{

	
	private String patente;

	public MedioTransporte (String patente) {
		this.patente=patente;
	}
	
	
	

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}




	@Override
	public int compareTo(MedioTransporte o) {
	return this.patente.compareTo(o.getPatente());
	}



	
}
