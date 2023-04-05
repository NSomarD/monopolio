package pruebas;

public class Main {

    public static void main(String[] args) {
        Parcela parcela1 = new Parcela("parcela1", 2f, 2f, 1f);
        System.out.println(parcela1.getNombre());
        System.out.println(parcela1.getPrecioCompra());
        System.out.println(parcela1.getPrecioAlquilerCompleto());
        System.out.println(parcela1.getPrecioEdificar());
    }
    
}
