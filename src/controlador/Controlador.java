package controlador;

import clases.GestionInmobiliaria;
import clases.MonopolioJuego;
import clases.OperacionInmobiliaria;
import clases.OperacionJuego;
import vistaText.Vista;
import vistaText.VistaTextual;

public class Controlador {
    // PROPIEDADES
    private MonopolioJuego juegoModel;
    private Vista vista;
    // CONSTRUCTOR
    Controlador(MonopolioJuego juego, VistaTextual vista){
        // cosa
    }
    // OTROS MÉTODOS
    public void juega(){
        while (!juegoModel.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            vista.mostrarSiguienteOperacion(juegoModel.siguientePaso());
            if (juegoModel.siguientePaso() != OperacionJuego.PASAR_TURNO)
                vista.mostrarEventos();
            else if (juegoModel.siguientePaso() == OperacionJuego.COMPRAR)
                vista.comprar();
            else if (juegoModel.siguientePaso() == OperacionJuego.GESTIONAR){
                OperacionInmobiliaria operacion = vista.elegirOperacion();
                if (operacion == OperacionInmobiliaria.CONSTRUIR_CASA)
                    int propiedad = vista.elegirPropiedad();
                    juegoModel.construirCasa(propiedad);
                else if (operacion == OperacionInmobiliaria.CONSTRUIR_HOTEL)
                    int propiedad = vista.elegirPropiedad();
                    juegoModel.construirHotel(propiedad);
                else 
                    juegoModel.siguientePasoCompletado(juegoModel.siguientePaso());
            }
        }
        vista.actualiza();
    }
}
