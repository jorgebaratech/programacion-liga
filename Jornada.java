
public class Jornada {
	Calendario calendario;
	Partido[] partidos;
	boolean completa=false;
	String fecha;

	public Calendario getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	public Partido[] getPartidos() {
		return partidos;
	}
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	public boolean isCompleta() {
		return completa;
	}
	public void setCompleta(boolean completa) {
		this.completa = completa;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
