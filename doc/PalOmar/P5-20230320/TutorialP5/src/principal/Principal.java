package principal;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;
import vista.VistaPrincipal;


public class Principal {
    
    public static void main(String[] args) {
        Vista v=new VistaPrincipal();
        Modelo m=new Modelo();
        Controlador c=new Controlador(m,v);
    }
}
