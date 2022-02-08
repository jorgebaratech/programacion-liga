
public class Calendario {
	private Liga liga;
	private Jornada[] jornadas;
	private String fechaInicio;
	private EquipoClasificacion[] listaClasificacion;
	
	
	
	

	public EquipoClasificacion[] getListaClasificacion() {
		return listaClasificacion;
	}
	public void setListaClasificacion(EquipoClasificacion[] listaClasificacion) {
		this.listaClasificacion = listaClasificacion;
	}
	public Liga getLiga() {
		return liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	public Jornada[] getJornadas() {
		return jornadas;
	}
	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
}
