package controlador;

import clases.GestionInmobiliaria;
import clases.MonopolioJuego;
import clases.OperacionInmobiliaria;
import clases.OperacionJuego;
import vistaText.Vista;
import vistaText.VistaTextual;
import GUI.*;

public class Controlador {
    // PROPIEDADES
    private MonopolioJuego juegoModel;
    // private Vista vista;
    private ElMonopolioVista vista;
    // CONSTRUCTOR
    public Controlador(MonopolioJuego juego, ElMonopolioVista vista){
        this.juegoModel = juego;
        this.vista = vista;
    }
    // OTROS MÉTODOS
    public void juega(){
        while (!juegoModel.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            OperacionJuego operacion = juegoModel.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);
            
            if (operacion != OperacionJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }

            // if (juegoModel.siguientePaso() == OperacionJuego.COMPRAR){
            //     vista.actualiza();
            //     if (vista.comprar() == Respuesta.SI){
            //         juegoModel.comprar();
            //         vista.actualiza();
            //     }
            //     juegoModel.siguientePasoCompletado(juegoModel.siguientePaso());
            // }
            // else if (juegoModel.siguientePaso() == OperacionJuego.GESTIONAR){
            //     vista.actualiza();
            //     OperacionInmobiliaria operacion = vista.elegirOperacion();
            //     if (operacion == OperacionInmobiliaria.CONSTRUIR_CASA){
            //         int propiedad = vista.elegirPropiedad();
            //         juegoModel.construirCasa(propiedad);
            //         juegoModel.siguientePasoCompletado(juegoModel.siguientePaso());
            //         vista.actualiza();
            //     }
            //     else if (operacion == OperacionInmobiliaria.CONSTRUIR_HOTEL){
            //         int propiedad = vista.elegirPropiedad();
            //         juegoModel.construirHotel(propiedad);
            //         juegoModel.siguientePasoCompletado(juegoModel.siguientePaso());
            //         vista.actualiza();
            //     }
            //     else {
            //         juegoModel.siguientePasoCompletado(juegoModel.siguientePaso());
            //         vista.actualiza();
            //     }
            // }
            // else
            //     vista.actualiza();
        
            switch(operacion){
                case COMPRAR:
                    if(vista.comprar() == Respuesta.SI)
                        juegoModel.comprar();
                    juegoModel.siguientePasoCompletado(operacion);
                break;
                case GESTIONAR:
                    OperacionInmobiliaria oper = vista.elegirOperacion();
                    if(oper != OperacionInmobiliaria.TERMINAR){
                        int numero = vista.elegirPropiedad();
                        if(oper == OperacionInmobiliaria.CONSTRUIR_CASA)
                            juegoModel.construirCasa(numero);
                        else
                            juegoModel.construirHotel(numero);
                    }
                    else
                        juegoModel.siguientePasoCompletado(operacion);
                break;
            }
        }
        vista.actualiza();
    }
}
