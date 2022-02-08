
public class Clasificacion {
	Liga liga;
	EquipoClasificacion[] listaEquipo;
	private Equipo equipo;
	private int victorias, derrotas, empates, golesFavor,golesContra, diferenciaEquipo;
	private Jornada jornada;
	private Partido partido;
	
	
	
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	
	
	
	
	
	}
