import java.util.Scanner;

public class Principal {
	public static void main(String[] args) 
	{
		String nombreLiga = nombreLiga();
		
		//Crear una Lista de Equipo
		int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = (int) Math.floor(Math.random())+4;
		Equipo[] locales = crearEquipos(numeroEquipos, edad);
		Equipo[] visitantes= locales.clone();
		Jornada[] jornadas = new Jornada[numeroEquipos -1];
		Calendario calendario = new Calendario();
		calendario.setJornadas(jornadas);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+ "[" + nombreLiga + "]" + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" );
		for (int j=0;j<numeroEquipos-1;j++) 
		{
			
			System.out.println("**********************************" + "[" + "Jornada" + ":" + (j + 1) + "]" + "**************************************");
			Equipo[] temporal = new Equipo[numeroEquipos];
			// Generamos una jornada
			for (int i=0; i<numeroEquipos;i++) {
				if (i==0) {
					temporal[i]=visitantes[numeroEquipos-1];
				}else {
					temporal[i]=visitantes[i-1];
				}
			}
			visitantes=temporal;

			
			for (int i=0;i<(numeroEquipos/2) +1;i++) {
				//Creamos un Partido
				System.out.println("------------------------------Partido" + ":" + (i + 1) + "---------------------------------------");
				Arbitro arbitro =  crearArbitro();
				Partido partido = new Partido();
				partido.setEquipoLocal(locales[i]);
				partido.setEquipoVisitante(visitantes[i]);
				int golesLocal = (int) Math.floor(Math.random()*7);
				int golesVisitante = (int) Math.floor(Math.random()*7);
				partido.setGolesLocal(golesLocal);
				partido.setGolesVisitante(golesVisitante);
				partido.setArbitro(arbitro);
				System.out.println(partido);
				
			}
		}


	}


	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqu�","Bale (lesionado)",
				"Amunike","N'kono","Butrague�o","Sanch�s","Neymar","Batistuta","Maradona",
				"Pel�","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};

		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];

		for (int i=0; i<numeroJugadores; i++) {
			//Crear un Jugador
			Jugador jug = new Jugador();
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//Posici�n
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			//Edad
			jug.setEdad(edad);

			//Dorsal
			jug.setDorsal(i+1);

			//Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

			//Imprime jugadores de los equipos creados anteriormente.

			//System.out.println(jug);
		}

		return jugadores;
	}

	private static Equipo[] crearEquipos(int numeroEquipos,int edad) {

		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pich�n", "Rinc�n de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez M�laga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva M�laga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta","Playamar","Los chipirones", ""};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
				"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
				"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos = new Equipo[numeroEquipos];

		for (int i=0; i<numeroEquipos; i++) {

			//Creamos Equipo
			Equipo equipo = new Equipo();

			//Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
			String barrio= nombreBarrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			//Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");

			//Las pegamos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}

			equipo.setNombre(nombre);
			//Continuamos con entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);

			//Meter los jugadores
			int numeroJugadores=(int) Math.floor(Math.random()*7)+15;
			Jugador[] jugadores = crearJugadores(numeroJugadores,edad,equipo);
			equipo.setJugadores(jugadores);

			//Meter el equipo en el array de equipos

			listaEquipos[i]=equipo;

		}
		return listaEquipos;

	}

	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqu�","Bale (lesionado)",
				"Amunike","N'kono","Butrague�o","Sanch�s","Neymar","Batistuta","Maradona",
				"Pel�","Beckenbauer"};
		Entrenador entrenador = new Entrenador();

		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);

		//Equipo
		entrenador.setEquipo(equipo);

		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);

		//System.out.println(entrenador);

		return entrenador;
	}

	private static Arbitro crearArbitro()
	{
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqu�","Bale (lesionado)",
				"Amunike","N'kono","Butrague�o","Sanch�s","Neymar","Batistuta","Maradona",
				"Pel�","Beckenbauer"};

		Arbitro arbitro = new Arbitro();

		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		arbitro.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		arbitro.setApellidos(apellido1+" "+apellido2);


		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		arbitro.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		arbitro.setLicencia(licencia);

		//System.out.println(arbitro);

		return arbitro;
	}

	private static String nombreLiga()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la liga");
		String nombreLiga = sc.nextLine();
		return nombreLiga;
	}

	public static Liga crearLiga(Equipo[] equipo, Arbitro[] arbitros, Calendario calendario, Clasificacion clasificacion )
	{
		Liga liga = new Liga();
		liga.setEquipos(equipo);
		liga.setCalendario(calendario);
		liga.setArbitros(arbitros);
		
		return liga;
	}
	
	public static Calendario calendario(Liga liga, Jornada[] jornada, EquipoClasificacion[] listaClasificaicon)
	{
		Calendario calendario = new Calendario();
		calendario.setLiga(liga);
		calendario.setJornadas(jornada);
		calendario.setListaClasificacion(listaClasificaicon);
		
		return calendario;
	}




}

