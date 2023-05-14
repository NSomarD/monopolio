package elmonopolio;

import java.util.ArrayList;
import clases.*;
import controlador.Controlador;
import vistaText.VistaTextual;

/**
 *
 * @author Omar
 */
public class ElMonopolio {

    public static void main(String[] args) {
        ArrayList<String> jugadores = new ArrayList<>();
        jugadores.add("Ramona");
        jugadores.add("Hakimi");
        jugadores.add("Juan");
        jugadores.add("null");
        MonopolioJuego juego = new MonopolioJuego(jugadores, false);
        VistaTextual partida = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego, partida);
        controlador.juega();
    }
    
}
