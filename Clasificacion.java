public class Clasificacion {
	Liga liga;
	EquipoClasificacion[] listaEquipo;

	public void GenerarClasificacion() {
		for(EquipoClasificacion ec:listaEquipo) {
			Equipo equipo=ec.getEquipo();
			Jornada[] jornadas=liga.getCalendario().getJornadas();
			for(Jornada j:jornadas) {
				Partido[] partidos=j.getPartidos();
				for(Partido p:partidos) {
					//si es el local 

					if (equipo==p.getEquipoLocal()) 
					{
						if(p.getGolesLocal()>p.getGolesVisitante()) 
						{
							ec.getSumargoles();
							ec.getVictorias();
						}
						else if(p.getGolesLocal()<p.getGolesVisitante())
						{
							ec.getRestargoles();
							ec.getDerrotas();
						}
						else
						{
							ec.getEmpates();
						}

					}
					else
					{
						if(equipo==p.getEquipoVisitante()) 
						{
							if(p.getGolesLocal()>p.getGolesVisitante()) 
							{
								ec.getRestargoles();
								ec.getDerrotas();
							}
							else if(p.getGolesLocal()<p.getGolesVisitante())
							{
								ec.getSumargoles();
								ec.getVictorias();
							}
							else
							{
								ec.getEmpates();
							}
						}
					}

				}

			}


		}
	}

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









}
