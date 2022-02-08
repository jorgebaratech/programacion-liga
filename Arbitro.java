
public class Arbitro extends Persona {
	int licencia;
	int partido;
	
	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}
	
	public int getPartido()
	{
		return partido;
	}
	
	public void setPartido(int partido)
	{
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "licencia" + licencia + ", Nombre" + getNombre() + ", Apellidos()=" + getApellidos()
				+ ", Edad" + getEdad() + ", getPartido()=" + getPartido() + "]";
	
	}
}
