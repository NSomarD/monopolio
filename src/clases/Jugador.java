package clases;

import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {
    // PROPIEDADES
    private int casillaActual; // Índice de la casilla en la que se encuentra el Jugador
    private String nombre;
    private boolean puedeComprar; // Puede o no comprar la Casilla en la que se encuentra el Jugador
    private float saldo;
    private ArrayList<Casilla> propiedades; // Calles que posee el Jugador
    // ATRIBUTOS DE CLASE
    protected int CasasMax = 4;
    protected int CasasPorHotel = 4; // Cuantas casas valen un hotel
    protected int HotelesMax = 4;
    protected float PasoPorSalida = 1000f;
    private float SaldoInicial = 7500f;
    // CONSTRUCTORES
    // Constructor normal
    Jugador(String nombre){
        this.nombre = nombre;
        this.casillaActual = 0;
        this.puedeComprar = false;
        this.saldo = this.SaldoInicial;
        this.propiedades = new ArrayList<Casilla>();        
    }
    // Constructor copia
    protected Jugador(Jugador otro){
        this.nombre = otro.nombre;
        this.casillaActual = 0;
        this.puedeComprar = false;
        this.saldo = this.SaldoInicial;
        this.propiedades = new ArrayList<Casilla>(); 
    }
    // CONSULTORES
    protected String getNombre(){
        return this.nombre;
    }
    public ArrayList<Casilla> getPropiedades(){
        return propiedades;
    }
    public int getCasillaActual(){
        return casillaActual;
    }
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    protected float getSaldo(){
        return saldo;
    }
    public int getCasasMax(){
        return CasasMax;
    }
    public int getHotelesMax(){
        return HotelesMax;
    }
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    public float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    // Cuantas casas u hoteles tiene este Jugador en propiedad
    int cantidadCasasHoteles(){
        int cantidad = 0;
        for(Casilla propiedad : propiedades){
            cantidad = cantidad + propiedad.cantidadCasasHoteles();
        }
        return cantidad;
    }
    // Cadena con info del Jugador
    public String toString(){
        String infoObjeto = "El jugador " + this.getNombre() + " con saldo: " + Float.toString(this.getSaldo());
        return infoObjeto;
    }
    // OTROS MÉTODOS
    // Se mueve a la casilla pasada como parámetro y resetea el atributo puedeComprar (para comprobarlo más tarde), y crea un evento informando para el Diario
    boolean moverACasilla(int numCasilla){
        this.casillaActual = numCasilla;
        this.puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha llegado a la casilla " + numCasilla);
        return true;
    }
    // Modifica el atributo saldo del Jugador en la cantidad dada como parámetro y crea un evento informando de ello para el Diario. Devuelve true si no hay ningún problema.
    boolean modificaSaldo(float cantidad){
        this.saldo = this.saldo + cantidad;
        Diario.getInstance().ocurreEvento("Al jugador " + this.nombre + " se le ha modificado el saldo en: " + cantidad);
        return true;
    }
    // Llama a modificaSaldo() y le pasa como parámetro el valor pasado a paga() pero convertido a negativo. Devuelve true si no hay ningún problema.
    boolean paga(float cantidad){
        return modificaSaldo(cantidad * (-1));
    }
    // Simplemente llama a modificaSaldo(). Devuelve true si no hay ningún problema.
    boolean recibe(float cantidad){
        return modificaSaldo(cantidad);
    }
    // Hace que el jugador pague la cantidad pasado como parámetro
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad);
    }
    // El jugador recibe la aportación por pasar por la salida, informa al Diario y devuelve true si no haya ningún problema
    boolean pasaPorSalida(){
        recibe(this.PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha pasado por la casilla de salida y recibe " + this.PasoPorSalida);
        return true;
    }
    // Habilita la capacidad de comprar la Casilla
    boolean puedeComprarCasilla(){
        this.puedeComprar = true;
        return this.puedeComprar;
    }
    // Devuelve si se puede comprar una casa comprobando si tiene saldo y si tiene hueco para una
    private boolean puedoEdificarCasa(Casilla propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumCasas() < this.CasasMax;
    }
    // Devuelve si se puede comprar un hotel comprobando su saldo, cuanto hueco para hoteles hay, y si tiene las suficientes casas como para comprar uno.
    private boolean puedoEdificarHotel(Casilla propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedad.getNumHoteles() < this.HotelesMax && propiedad.getNumCasas() == this.CasasMax;
    }
    // Devuelve si se tiene el suficiente saldo para pagar el precio pasado como parámetro
    private boolean puedoGastar(float precio){
        return this.saldo >= precio;
    }
    // Comprueba si el Jugador tiene propiedades
    boolean tieneAlgoQueGestionar(){
        return !propiedades.isEmpty();
    }
    // Aquí utilizaremos el método 'compareTo()' que está definido en la interfaz 'Comparable'
    @Override
    public int compareTo(Jugador otro){
        // Compara el saldo de este Jugador con el saldo del Jugador pasado como parámetro
        return Float.compare(otro.saldo, this.saldo);
    }
    // Comprueba si el Jugador ha perdido todo su dinero y ha entrado en bancarrota
    boolean enBancarrota(){
        return saldo < 0f;
    }
    // Comprueba el índice de la propiedad existe en el array de propiedades
    private boolean existeLaPropiedad(int ip){
        return ip <= propiedades.size();
    }
    boolean comprar(Casilla titulo){
        boolean result = false;
        if (this.puedeComprar){
            float precio = titulo.getPrecioCompra();
            if (puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " compra la propiedad " + titulo.getNombre());
                this.puedeComprar = false;
            }
            else
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " no tiene suiciente saldo para comprar la propiedad " + titulo.getNombre());
        }
        return result;
    }
    boolean construirCasa(int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            Casilla propiedad = propiedades.get(ip);
            if (puedoEdificarCasa(propiedad)){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye casa en la propiedad "  + propiedad.getNombre());
            }
        }
        return result;
    }
    boolean construirHotel(int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            Casilla propiedad = propiedades.get(ip);
            if (puedoEdificarHotel(propiedad)){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye un hotel en la propiedad " + propiedad.getNombre());
            }
        }
        return result;
    }
}
