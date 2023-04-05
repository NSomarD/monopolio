package clases;

import java.util.ArrayList;

public class Tablero {
    // PROPIEDADES
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    // CONSTRUCTOR
    public Tablero(){
        this.casillas = new ArrayList<>();
        this.casillas.add(new Casilla(tipoCasilla.DESCANSO, "Salida", 0f, 0f, 0f));
        this.porSalida = false;
    }
    // MÉTODOS DE INSTANCIA
    private boolean correcto(int numCasilla){
        return numCasilla < casillas.size();
    }
    boolean computarPasoPorSalida(){
        boolean auxiliar = this.porSalida;
        this.porSalida = false;
        return auxiliar;
    }
    void añadeCasilla(Casilla casilla){
        this.casillas.add(casilla);
    }
    Casilla getCasilla(int numCasilla){
        if (correcto(numCasilla) == true)
            return this.casillas.get(numCasilla);
        else 
            return null;
    }
    int nuevaPosicion( int actual, int tirada){
        if ((actual + tirada) <= this.casillas.size())
            this.porSalida = true;
        return (actual + tirada) % this.casillas.size();
    }

}
