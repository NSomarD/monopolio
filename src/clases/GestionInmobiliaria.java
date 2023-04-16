package clases;

public class GestionInmobiliaria {
    // PROPIEDADES
    private int propiedad; // Este será el índice de la propiedad con la que se va a operar
    private OperacionInmobiliaria operacion; // Esta es la operación que se va a realizar
    // CONSTRUCTOR
    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip){
        this.operacion = gest;
        this.propiedad = ip;
    }
    // CONSULTORES
    public OperacionInmobiliaria getOperacion(){
        return operacion;
    }
    public int getPropiedad(){
        return propiedad;
    }
}
