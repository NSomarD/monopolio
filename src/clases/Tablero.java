package clases;

import java.util.ArrayList;

public class Tablero {
    // PROPIEDADES
    private ArrayList<Casilla> tablero;
    private boolean porSalida;
    // CONSTRUCTOR
    public Tablero(){
        this.tablero = new ArrayList<>();
        this.tablero.add(new Casilla("Salida"));
        this.porSalida = false;
    }
    // CONSULTORES
    // Devuelve la casilla solo si su índice existe
    public Casilla getCasilla(int numCasilla){
        if (correcto(numCasilla) == true)
            return this.tablero.get(numCasilla);
        else 
            return null;
    }
    public ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    // MÉTODOS DE INSTANCIA
    // Comprueba si el índice de la casilla existe
    private boolean correcto(int numCasilla){
        return numCasilla < tablero.size();
    }
    // Comprueba si se ha pasado por la casilla de Salida es decir 'porSalida=true', y cambia el mismo a 'porSalida=false' una vez hecha la comprobación.
    boolean computarPasoPorSalida(){
        boolean auxiliar = this.porSalida;
        this.porSalida = false;
        return auxiliar;
    }
    // Añades una casilla al tablero
    void añadeCasilla(Casilla casilla){
        this.tablero.add(casilla);
    }
    // Establece la posición de un jugador tras una tirada
    int nuevaPosicion(int actual, int tirada){
        if ((actual + tirada) <= this.tablero.size())
            this.porSalida = true;
        return (actual + tirada) % this.tablero.size();
    }
}
