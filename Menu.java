import java.util.Scanner;
public class Menu 
{

	//MENU PRINCIPAL

	public static void main(String[] args) 
	{
		String nombreLiga = nombreLiga();
		int numeroEquipos = (int) Math.floor(Math.random()*6)+4;
		int edad = (int) Math.floor(Math.random()*14)+6;
		int numeroJugadores = (int) Math.floor(Math.random())+11;
		Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);
		Equipo[] locales = listaEquipos.clone();
		Equipo[] visitantes = locales.clone();
		int puntuacion = 0;

		Scanner sc = new Scanner(System.in);
		int opcion = 1;
		while(opcion != 10)
		{
			
			LimpiaPantalla();
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+ "[" + nombreLiga + "]" + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			imprimirMenu();
			opcion = leerEntrada();

			switch (opcion)
			{
			case 1: 
				//clasificacion();
				break;
			case 2:
				jornadas(numeroEquipos, locales, visitantes, listaEquipos, puntuacion);
				break;
			case 3:
				menuEquipos(edad, numeroEquipos, numeroJugadores, listaEquipos);
				break;
			default:
				System.out.println("Numero no valido");
			}
			if (opcion != 16)
			{	
				System.out.println();
				System.out.println("Pulse una tecla para continuar.");
				EsperaPulsacion();
			}
		}
	}

	private static void LimpiaPantalla()
	{
		for (int i = 0 ; i < 5 ; i++)
		{
			System.out.println();
		}
	}

	private static void EsperaPulsacion() 
	{
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	public static int leerEntrada()
	{
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		return numero;
	}

	public static void imprimirMenu()
	{

		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Menu Principal: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("Press 1 Clasificaciones.");
		System.out.println("Press 2 Calendarios.");
		System.out.println("Press 3 Jugadores y Equipos.");
		System.out.println("Press 4 Atras!");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("Introduzca una opcion: ");
	}


	//EQUIPOS

	public static void menuEquipos(int edad, int numeroEquipos, int numeroJugadores, Equipo[] listaEquipos)
	{

		System.out.println("*************************************************************************************************************");
		System.out.println("********************************** Lista de Jugadores y Equipos:*********************************************");
		System.out.println("*************************************************************************************************************");
		impresionEquipos(edad, numeroEquipos, numeroJugadores, listaEquipos);
		System.out.println("*************************************************************************************************************");
	}

	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};

		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];

		for (int i=0; i < numeroJugadores; i++) {
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

			//Posición
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

		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pichón", "Rincón de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez Málaga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva Málaga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta"};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
				"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
				"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];

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
			if (barrio.startsWith("El ")) 
			{
				barrio = barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}
			else 
			{
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


			listaEquipos[i] = equipo;
			//System.out.println("*************************************************************************************************************");
		}
		return listaEquipos;

	}

	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
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

	private static void impresionEquipos(int edad, int numeroEquipos, int numeroJugadores, Equipo[] listaEquipos)
	{
		//Crear una Lista de Equipo
		
		//Imprimimos los equipos
		//System.out.println("Numero de equipos: " + numeroEquipos);
		for (Equipo e: listaEquipos) 
		{
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(e.getNombre());
			System.out.println("**********************************************************************************");
			System.out.print(e.getEntrenador());
			for (Jugador j: e.getJugadores()) 
			{
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println(j);
			}
		}
		
	}

	private static Arbitro crearArbitro()
	{
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};

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

	//LIGA

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

	//CALENDARIO

	public static Calendario calendario(Liga liga, Jornada[] jornada, EquipoClasificacion[] listaClasificaicon)
	{
		Calendario calendario = new Calendario();
		calendario.setLiga(liga);
		calendario.setJornadas(jornada);
		calendario.setListaClasificacion(listaClasificaicon);

		return calendario;
	}

	// JORNADAS 

	public static void jornadas(int numeroEquipos, Equipo[] locales, Equipo[] visitantes, Equipo[] listaEquipo, int puntuacion)
	{
		Jornada[] jornadas = new Jornada[numeroEquipos - 1];
		Calendario calendario = new Calendario();
		calendario.setJornadas(jornadas);

		for (int j = 0; j < numeroEquipos - 1; j++) 
		{

			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + "[" + "Jornada" + ":" + (j + 1) + "]" + "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
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
				System.out.println("*********************************** Partido" + ":" + (i + 1) + "************************************************");
				Arbitro arbitro =  crearArbitro();
				Partido partido = new Partido();
				partido.setEquipoLocal(locales[i]);
				partido.getEquipoLocal().setPuntuacion(puntuacion);
				partido.getEquipoLocal().getPuntuacion();
				
				partido.setEquipoVisitante(visitantes[i]);
				partido.getEquipoVisitante().setPuntuacion(puntuacion);
				partido.getEquipoVisitante().getPuntuacion();
				
				int golesLocal = (int) Math.floor(Math.random()*7);
				int golesVisitante = (int) Math.floor(Math.random()*7);
				partido.setGolesLocal(golesLocal);
				partido.setGolesVisitante(golesVisitante);
				partido.setArbitro(arbitro);
				
				System.out.println(partido);
				System.out.println("----------------------------------------------------------------------------------------------------");
				if(golesVisitante > golesLocal) 
				{
					System.out.println("Ha ganado el equipo visitante");
					puntuacion += 3;
					System.out.println(puntuacion);
					
				}
				else if(golesVisitante < golesLocal) 
				{
					System.out.println("Ha ganado el equipo Local");
					puntuacion += 3;
				}
				else if(golesVisitante == golesLocal) 
				{
					System.out.println("Empate");
					puntuacion +=1;
				} 
			}
			
		}
		
	}
	
	
	public static void clasificacion(Liga liga, EquipoClasificacion[] listaEquipo) {
		
		Clasificacion clasificacion= new Clasificacion(liga);
		
		
		
	}
	
}