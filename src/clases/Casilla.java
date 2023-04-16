package clases;

import java.util.ArrayList;

public class Casilla {
   // PROPIEDADES
   private String nombre;
   private float precioCompra;
   private float precioEdificar;
   private float precioBaseAlquiler;
   private int numCasas;
   private int numHoteles;
   private TipoCasilla tipo;
   private Jugador propietario;
   private MazoSorpresas mazo;
   private Sorpresa sorpresa;
   // CONSTANTES
   private float ALQUILERCALLE = 1f;
   private float ALQUILERCASA = 1f;
   private float ALQUILERHOTEL = 4f;
   // CONSTRUCTORES
   public void init(){
      this.numCasas = 0;
      this.numHoteles = 0;
   }
   Casilla(String nombre){
      this.nombre = nombre;
      this.tipo = TipoCasilla.DESCANSO;
      this.init();
   }
   Casilla(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
      this.tipo = TipoCasilla.CALLE;
      this.nombre = titulo;
      this.precioCompra = precioCompra;
      this.precioEdificar = precioEdificar;
      this.precioBaseAlquiler = precioBaseAlquiler;
      this.init();
   }
   Casilla(String nombre, MazoSorpresas mazo){
      this.tipo = TipoCasilla.SORPRESA;
      this.nombre = nombre;
      this.mazo = mazo;
      this.init();
   }
   // CONSULTORES
   public String getNombre() {
      return this.nombre;
   }
   public TipoCasilla getTipo(){
      return this.tipo;
   }
   public float getPrecioCompra() {
      return this.precioCompra;
   }
   public float getPrecioEdificar() {
      return this.precioEdificar;
   }
   public int getNumCasas() {
      return this.numCasas;
   }
   public int getNumHoteles() {
      return this.numHoteles;
   }
   public Jugador getPropietario(){
      return this.propietario;
   }
   // Aquí calculamos el alquiler teniendo en cuenta cuantas casas/hoteles hay en la casilla en cuestión
   public float getPrecioAlquilerCompleto() {
      float precioAlquiler;
      precioAlquiler = this.precioBaseAlquiler * (ALQUILERCALLE + this.numCasas * ALQUILERCASA + this.numHoteles * ALQUILERHOTEL);
      return precioAlquiler;
   }
   public int cantidadCasasHoteles(){
      return this.numCasas + this.numHoteles;
   }
   // MÉTODOS MODIFICADORES
   public boolean construirCasa(Jugador jugador) {
      propietario.paga(precioEdificar);
      this.numCasas++;
      return true;
   } 
   public boolean construirHotel(Jugador jugador) {
      propietario.paga(precioEdificar);
      this.numHoteles++;
      return true;
   }
   // Si la casilla tiene propietario y el jugador pasado no lo es, este paga alquiler correspondiente y el propietario lo recibe
   public void tramitarAlquiler(Jugador jugador){
      if ((tienePropietario()) && (!esEsteElPropietario(jugador))){
         jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
         this.propietario.recibe(this.getPrecioAlquilerCompleto());
      }
   }
   // Si el jugador pasado es el propietario y el número de casas a derruir es menor que el número de casas que hay, se quitan las casas
   boolean derruirCasas(int n, Jugador jugador){
      if ((esEsteElPropietario(jugador)) && (this.getNumCasas() <= n)){
         this.numCasas = this.getNumCasas() - n;
         return true;
      }
      else
         return false;
   }
   boolean comprar(Jugador jugador){
      this.propietario = jugador;
      jugador.paga(getPrecioCompra());
      return true;
   }
   void recibeJugador(int actual, ArrayList<Jugador> todos){
      if (this.tipo == TipoCasilla.CALLE)
         recibeJugador_calle(actual, todos);
      else if (this.tipo == TipoCasilla.SORPRESA)
         recibeJugador_sorpresa(actual, todos);
      else 
         informe(actual, todos);
   }
   private void recibeJugador_calle(int actual, ArrayList<Jugador> todos){
      informe(actual, todos);
      Jugador jugador = todos.get(actual);
      if (!tienePropietario())
         jugador.puedeComprarCasilla();
      else 
         tramitarAlquiler(jugador);
   }
   private void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos){
      Sorpresa sorpresa = mazo.siguiente();
      informe(actual, todos);
      sorpresa.aplicarAJugador(actual, todos);
   }

   // OTROS MÉTODOS
   // Crea un evento que informa del movimiento del jugador a esta casilla
   void informe(int actual, ArrayList<Jugador> todos){
      Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual).getNombre() + " ha pasado por la casilla " + this.getNombre());
   }
   public String toString(){
      String infoObjeto = "Nombre = " + this.getNombre() + "\nTipo = " + this.getTipo() + "\nPrecio de Compra = " + this.getPrecioCompra()
      + "\nPrecio de Edificar = " + this.getPrecioEdificar() + "\nPrecio del Alquiler = " + getPrecioAlquilerCompleto() + "\nPropietario = " + this.getPropietario();
      return infoObjeto;
   }
   // Devuelve si el jugador pasado es o no el propietario
   public boolean esEsteElPropietario(Jugador jugador){
      return this.propietario == jugador;
   }
   // Devuelve si la casilla tiene o no propietario
   public boolean tienePropietario(){
      return this.propietario != null;
   }
}