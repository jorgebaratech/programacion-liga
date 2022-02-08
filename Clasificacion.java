
public class Clasificacion {
	Liga liga;
	EquipoClasificacion[] listaEquipo;
	
	private int victorias, derrotas, empates, golesFavor,golesContra, diferenciaEquipo;
	
	public Clasificacion(Liga liga) 
	{
		this.liga=liga;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public EquipoClasificacion[] getListaEquipo() {
		return listaEquipo;
	}

	public void setListaEquipo(EquipoClasificacion[] listaEquipo) {
		this.listaEquipo = listaEquipo;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getGolesFavor() {
		return golesFavor;
	}

	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}

	public int getGolesContra() {
		return golesContra;
	}

	public void setGolesContra(int golesContra) {
		this.golesContra = golesContra;
	}

	public int getDiferenciaEquipo() {
		return diferenciaEquipo;
	}

	public void setDiferenciaEquipo(int diferenciaEquipo) {
		this.diferenciaEquipo = diferenciaEquipo;
	}

	
	
	
	
	
	}
