
public class Equipo {
	private String nombre;
	private String club;
	private Entrenador entrenador;
	private String equipacionCasa;
	private String equipacionFuera;
	private Jugador[] jugadores;
	private int puntuacion;
	
	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	public String getEquipacionCasa() {
		return equipacionCasa;
	}
	public void setEquipacionCasa(String equipacionCasa) {
		this.equipacionCasa = equipacionCasa;
	}
	public String getEquipacionFuera() {
		return equipacionFuera;
	}
	public void setEquipacionFuera(String equipacionFuera) {
		this.equipacionFuera = equipacionFuera;
	}
	public Jugador[] getJugadores() {
		return jugadores;
	}
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	
	@Override
	public String toString() {
		return super.toString()+", "+ club +"\n"+
				"Equipo: "+ nombre +"\n"+
				" Entrenador: "+ entrenador +"\n";
	}
}