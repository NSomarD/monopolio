package clases;

import java.util.ArrayList;

public class MonopolioJuego {
    // PROPIEDADES
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
    private EstadoJuego estado;
    private GestorEstado gestor;
    private MazoSorpresas mazo;
    private Tablero tablero;
    // CONTRUCTOR
    MonopolioJuego(ArrayList<String> nombres, boolean debug){
        // Por cada nombre de la lista introducida se crea un jugador
        for(String nombre : nombres){
            this.jugadores.add(new Jugador(nombre));
        }
        // Se inicializa el gestor y el estado 
        this.gestor = new GestorEstado();
        this.estado = gestor.estadoInicial();
        // Se establece o no el modo debug según el parámetro
        Dado.getInstance().setDebug(debug);
        // Se establece que jugador va a empezar la partida
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(this.jugadores.size());
        // Se inicializa el mazo según si establecemos el modo debug o no
        if (debug)
            this.mazo = new MazoSorpresas(debug);
        else
            this.mazo = new MazoSorpresas();
        // Se inicializa el tablero y el mazo con las cartas
        this.tablero = new Tablero();
        this.inicializaTablero(mazo);
        this.inicializarMazoSorpresas();
    }
    // Inicialización de las cartas sorpresa
    private void inicializarMazoSorpresas(){
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Pagas 100", (-100)));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Pagas 200", (-200)));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Pagas 300", (-300)));z
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Cobras 100", 100));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Cobras 200", 200));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Cobras 300", 300));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagas 50 por cada casa u hotel", (-50)));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Pagas 70 por cada casa u hotel", (-70)));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Cobras 50 por cada casa u hotel", 50));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Cobras 70 por cada casa u hotel", 70));
    }
    // Inicialización de las casillas
    private void inicializaTablero(MazoSorpresas mazo){
        this.tablero.añadeCasilla(new Casilla("calle1", 60f, 20f, 40f));
        this.tablero.añadeCasilla(new Casilla("calle2", 70f, 25f, 45f));
        this.tablero.añadeCasilla(new Casilla("calle3", 80f, 30f, 45f));
        this.tablero.añadeCasilla(new Casilla("sorpresa4", mazo));
        this.tablero.añadeCasilla(new Casilla("calle5", 110f, 40f, 50f));
        this.tablero.añadeCasilla(new Casilla("calle6", 145f, 50f, 50f));
        this.tablero.añadeCasilla(new Casilla("calle7", 135f, 50f, 50f));
        this.tablero.añadeCasilla(new Casilla("descanso8"));
        this.tablero.añadeCasilla(new Casilla("calle9", 160f, 65f, 60f));
        this.tablero.añadeCasilla(new Casilla("calle10", 175f, 70f, 60f));
        this.tablero.añadeCasilla(new Casilla("calle11", 200f, 75f, 60f));
        this.tablero.añadeCasilla(new Casilla("sorpresa12", mazo));
        this.tablero.añadeCasilla(new Casilla("calle13", 210f, 90f, 70f));
        this.tablero.añadeCasilla(new Casilla("calle14", 225f, 95f, 70f));
        this.tablero.añadeCasilla(new Casilla("calle15", 240f, 100f,70f));
        this.tablero.añadeCasilla(new Casilla("sorpresa16", mazo));
        this.tablero.añadeCasilla(new Casilla("calle17", 260f, 110f, 80f));
        this.tablero.añadeCasilla(new Casilla("calle18", 275f, 115f, 80f));
        this.tablero.añadeCasilla(new Casilla("calle19", 300f, 120f, 80f));
    }
    // CONSULTORES
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;   
    }
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    public Tablero getTablero(){
        return this.tablero;
    }
    // OTROS MÉTODOS
    // Realiza todas las acciones necesarias cuando un jugador se mueve de casilla
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar(); // lanzamos el dado
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada); // Sacamos el índice de la casilla a la que irá el jugador tras la tirada del dado
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida(); // comprobamos que el jugador ha pasado por la salida, y si es así recibe la compensación correspondiente
        jugadorActual.moverACasilla(posicionNueva); // El jugador se mueve a la nueva casilla
        casilla.recibeJugador(this.indiceJugadorActual, jugadores); // La nueva casilla recibe al jugador
    }
    // Si pasa por la salida, el jugador recibe compensación
    private void contabilizarPasosPorSalida(){
        if (this.tablero.computarPasoPorSalida());
            this.getJugadorActual().pasaPorSalida();
    }
    // Pasa el turno al siguiente jugador. Si es el último pasa al primero.
    private void pasarTurno(){
        this.indiceJugadorActual = (this.indiceJugadorActual + 1) % this.jugadores.size();
    }
    // Pasa a la siguiente etapa del turno
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado); // Según el estado del turno sacamos la operación a realizar
        if (operacion == OperacionJuego.PASAR_TURNO){
            // Pasamos de turno y pasamos al primer estado del turno
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        else if (operacion == OperacionJuego.AVANZAR){
            // Hacemos que avance el jugador y pasamos al siguiente estado del turno
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    // Pasa al siguiente estado
    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    private ArrayList<Jugador> ranking(){
        // cosa
    }
    public boolean comprar(){
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        return jugadorActual.comprar(casilla);
    }
    // Delega las acciones de construir a los métodos de la clase Jugador
    public boolean construirCasa(int ip){
        return this.getJugadorActual().construirCasa(ip);
    }
    public boolean construirHotel(int ip){
        return this.getJugadorActual().construirHotel(ip);
        
    }
    // Si el jugador actual entra en bancarrota, se acaba el juego
    public boolean finalDelJuego(){
        return this.getJugadorActual().enBancarrota();
    }
}
