
package clases;

public class Casilla {
   // PROPIEDADES
   private tipoCasilla tipo;
   private String nombre;
   private float precioCompra;
   private float precioEdificar;
   private float precioBaseAlquiler;
   private int numCasas;
   private int numHoteles;
   // CONSTANTES
   private float ALQUILERCALLE = 1f;
   private float ALQUILERCASA = 1f;
   private float ALQUILERHOTEL = 4f;
   // CONSTRUCTOR
   public Casilla(tipoCasilla tipo, String nombre, float precioCompra, float precioEdificar, float precioAlquilerBase){
      this.tipo = tipo;
      this.nombre = nombre;
      this.precioCompra = precioCompra;
      this.precioEdificar = precioEdificar;
      this.precioBaseAlquiler = precioAlquilerBase;
      this.numCasas = 0;
      this.numHoteles = 0;
   }
   // CONSULTORES
   public String getNombre() {
      return this.nombre;
   }
   public tipoCasilla getTipo(){
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
   public float getPrecioAlquilerCompleto() {
      float precioAlquiler;
      precioAlquiler = this.precioBaseAlquiler * (ALQUILERCALLE + this.numCasas * ALQUILERCASA + this.numHoteles * ALQUILERHOTEL);
      return precioAlquiler;
   }
   // MÉTODOS MODIFICADORES
   public boolean construirCasa() {
      this.numCasas++;
      return true;
   } 
   public boolean construirHotel() {
      this.numHoteles++;
      return true;
   }
   // OTROS MÉTODOS
   public String toString(){
      String infoObjeto = "Nombre = " + this.getNombre() + "\nTipo = " + this.getTipo() + "\nPrecio de Compra = " + this.getPrecioCompra()
      + "\nPrecio de Edificar = " + this.getPrecioEdificar() + "\nPrecio del Alquiler = " + getPrecioAlquilerCompleto();
      return infoObjeto;
   }
}