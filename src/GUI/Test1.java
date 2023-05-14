
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;
import java.util.ArrayList;
import clases.MonopolioJuego;
import controlador.Controlador;


/**
 *
 * @author Omar
 */
public class Test1 {

    //private ElMonopolioVista vista = new ElMonopolioVista();
    //private CapturaNombres capNombres = new CapturaNombres(vista, true);
    //private ArrayList<String> nombres = new ArrayList<>(capNombres.getNombres());
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ElMonopolioVista vista = new ElMonopolioVista();
        
        CapturaNombres captura = new CapturaNombres(vista, true);
        
        ArrayList<String> nombres = new ArrayList<>();
        
        // Asignamos a este array el array que ya existe en la clase CapturaNombres
        nombres = captura.getNombres();
        
        Dado.createInstance(vista);

        MonopolioJuego juego = new MonopolioJuego(nombres, false);

        Controlador controlador = new Controlador(juego, vista);

        vista.setMonopolioJuego(juego);

        controlador.juega();

    }
    
}
