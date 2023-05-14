package clases;

import java.util.Random;

public class Dado {
    // PROPIEDADES
    Random random;
    int ultimoResultado;
    boolean debug;
    // ATRIBUTO DE CLASE (SINGLETON)
    private static final Dado instance = new Dado();
    // CONSTANTES
    private static int VALORDEBUG = 1;
    private static int VALORESDADO = 6;
    // CONSTRUCTOR
    private Dado(){
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }
    // CONSULTORES
    // devuelve la única instancia del dado, lo usaremos en otras clases para acceder a los métodos de esta
    public static Dado getInstance(){
        return instance;
    }
    public int getUltimoResultado(){
        return this.ultimoResultado;
    }
    // OTROS MÉTODOS
    // Clásica tirada, pero controlando si el dado está o no en el modo debug
    int tirar(){
        if (!this.debug) {
            // Usamos el método nextInt() de la clase Random para sacar un entero aleatorio desde 0 en un rango pasado como parámetro. Le sumamos 1 para que en vez de sacar uno del 0 al 5, lo saque del 1 al 6
            this.ultimoResultado = random.nextInt(Dado.VALORESDADO) + 1;    
            return ultimoResultado;
        }
        else {
            // En el modo debug siempre sacará 1 la tirada
            this.ultimoResultado = Dado.VALORDEBUG;
            return ultimoResultado;
        }
    }
    // De nuevo usamos el nextIn() de la clase Random, aquí para devolver un entero aleatorio entre 0 y la cantidad de Jugadores, que funcionaría más tarde como índice en un Array de Jugadores
    int quienEmpieza(int cantidadJugadores){
        int empieza = random.nextInt(cantidadJugadores);
        return empieza;
    }
    // Cambia el estado del dado al pasado por parámetro, y creando un evento en Diario informando de ello
    void setDebug(boolean estadoDebug){
        this.debug = estadoDebug;
        if (debug == true)
            Diario.getInstance().ocurreEvento("El modo debug del dado está activado");
        else 
            Diario.getInstance().ocurreEvento("El modo debug del dado está desactivado");
    }
}
