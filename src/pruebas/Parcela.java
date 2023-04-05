
package pruebas;

/**
 *
 * @author Omar
 */
public class Parcela {
    // ATRIBUTOS
    private String nombre;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    // CONSTANTES
    private float FACTORIALALQUILERCALLE = 1f;
    private float FACTORIALALQUILERCASA = 1f;
    private float FACTORIALALQUILERHOTEL = 4f;
    // CONSTRUCTOR
    public Parcela(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    // CONSULTORES
    public String getNombre() {
        return this.nombre;
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
        precioAlquiler = this.precioBaseAlquiler * (FACTORIALALQUILERCALLE + this.numCasas * FACTORIALALQUILERCASA + this.numHoteles * FACTORIALALQUILERHOTEL);
        return precioAlquiler;
    }
    // MÉTODOS MODIFICADORES
    public boolean construirCasa() {
        this.numCasas++;
        return true;
    }
    public boolean construirHotel(){
        this.numHoteles++;
        return true;
    }
    public boolean igualdadIdentidad(Parcela otraParcela){
        return this == otraParcela;
    }
    public boolean igualdadEstado(Parcela otraParcela){
        boolean estado;
        estado = ((this.nombre == otraParcela.getNombre()) 
            // && (this.precioCompra == otraParcela.getPrecioCompra()) 
            // && (this.precioEdificar == otraParcela.getPrecioEdificar())
            // && (this.getPrecioAlquilerCompleto() == otraParcela.getPrecioAlquilerCompleto())
            // && (this.numCasas == otraParcela.getNumCasas())
            // && (this.numHoteles == otraParcela.getNumHoteles())
        );
        return estado;
    }
}
