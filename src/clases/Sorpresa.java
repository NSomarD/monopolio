package clases;

import java.util.ArrayList;

public class Sorpresa {
    // PROPIEDADES
    String texto;
    int valor;
    TipoSorpresa tipo;
    MazoSorpresas mazo;
    // CONSTRUCTOR
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    // OTROS MÉTODOS
    // Según el tipo de sorpresa llama a un método o a otro
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (this.tipo == TipoSorpresa.PAGARCOBRAR)
            aplicarAJugador_pagarCobrar(actual, todos);
        else 
            aplicarAJugador_porCasaHotel(actual, todos);
    }
    // Le aplica los efectos de la carta sorpresa al jugador introducido como parámetro (tipo PAGARCOBRAR)
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        todos.get(actual).modificaSaldo(this.valor);
        informe(actual, todos);
    }
    // Le aplica los efectos de la carta sorpresa al jugador introducido como parámetro (tipo PORCASAHOTEL), lo multiplicas por la cantidad de casas y hoteles que posea el jugador
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        todos.get(actual).modificaSaldo(this.valor * todos.get(actual).cantidadCasasHoteles());
    }
    // crea un evento informando del efecto de una Sorpresa sobre un Jugador en concreto
    private void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Al jugador " + todos.get(actual).getNombre() + " se le aplicará una sorpresa.");
    }
    // Devuelve la descripción de la carta
    public String toString(){
        return this.texto;
    }
}
