package clases;

import java.util.ArrayList;

public class Diario {
    // PROPIEDADES
    private ArrayList<String> eventos;
    // ATRIBUTO DE CLASE (SINGLETON)
    private static final Diario instance = new Diario();
    // CONSTRUCTOR
    private Diario(){
        eventos = new ArrayList<>();
    }
    // CONSULTOR
    public static Diario getInstance(){
        return instance;
    }
    public ArrayList<String> getEventos(){
        return this.eventos;
    }
    // OTROS MÉTODOS
    void ocurreEvento(String evento){
        eventos.add(evento);
    }
    public boolean eventosPendientes(){
        return !eventos.isEmpty();
    }
    public String leerEvento(){
        String cadena = "";
        if (!eventos.isEmpty())
            cadena = eventos.remove(0);
        return cadena;
    }
}