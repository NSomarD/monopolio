package clases;

import java.util.Collections;
import java.util.ArrayList;

public class MazoSorpresas {
    // PROPIEDADES
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    // INICIALIZADOR
    // Inicializador de algunas propiedades
    private void init(){
        this.sorpresas = new ArrayList<Sorpresa>();
        this.barajada = false;
        this.usadas = 0;
    }
    // CONSTRUCTORES
    // Constructor para activar el modo debug del dado
    MazoSorpresas(boolean estadoDebug){
        this.debug = estadoDebug;
        this.init();
        if (debug){
            Diario.getInstance().ocurreEvento("El modo debug del dado está activado");
        }
    }
    // Constructor que no activa el modo debug
    MazoSorpresas(){
        this.init();
        debug = false;
    }
    // RESTO DE MÉTODOS
    // Añade una carta Sorpresa al mazo siempre y cuando este no esté barajado.
    void alMazo(Sorpresa carta){
        if (!barajada){
            sorpresas.add(carta);
        }
    }
    // Devuelve la siguiente carta de la baraja e introduce la anterior al final del mazo, si tiene que barajar lo hace con el método shuffle de la clase Collections de java.util
    Sorpresa siguiente(){
        if ((!barajada) || (sorpresas.size() == usadas)){
            if (!debug){
                Collections.shuffle(sorpresas);
                usadas = 0;
                barajada = true;
            }
        }
        usadas++;
        Sorpresa carta = sorpresas.remove(0);
        sorpresas.add(carta);
        return carta;
    }
}
