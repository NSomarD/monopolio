package GUI;

import clases.OperacionInmobiliaria;
import clases.OperacionJuego;
import controlador.Respuesta;

public interface Vista {
    // MÉTODOS DE LA INTERFAZ
    public void actualiza();
    public void pausa();
    public Respuesta comprar();
    public OperacionInmobiliaria elegirOperacion();
    public int elegirPropiedad();
    public void mostrarSiguienteOperacion(OperacionJuego operacion);
    public void mostrarEventos();
}