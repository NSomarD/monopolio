package vistaText;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Casilla;
import clases.MonopolioJuego;
import clases.Diario;
import clases.OperacionJuego;
import controlador.Respuesta;
import clases.OperacionInmobiliaria;
import clases.Jugador;

public class VistaTextual implements Vista {
    // ATRIBUTO DE CLASE
    private static String separador = "===========================";
    // PROPIEDADES
    private Scanner in;
    MonopolioJuego juegoModel;
    private int iPropiedad;
    private int iGestion;
    // CONSTRUCTOR
    public VistaTextual (MonopolioJuego juegoModel){
        in = new Scanner (System.in); // El objeto Scanner es el que nos facilitará la implementación de inputs
        this.juegoModel = juegoModel;
    }
    // OTROS MÉTODOS
    // Enseña por pantalla la frase "Pulsa una tecla" y hasta que no le introduzcas un input y lo lea no acaba el método
    public void pausa(){
        System.out.println(separador);
        System.out.println("Pulsa una tecla");
        in.nextLine(); // Lee el input y acaba el método
        System.out.println(separador);
    }
    public void actualiza(){
        System.out.println(separador);
        System.out.println(juegoModel.getJugadorActual().toString()); // Enseña la cadena que devuelve el método del Jugador actual toString()
        System.out.println(juegoModel.getTablero().getCasilla(juegoModel.getJugadorActual().getCasillaActual()).toString()); // Enseña la cadena que devuelve el método toString de la Casilla actual
        System.out.println(separador);
    }
    // Pediremos un número como cadena y lo pasaremos a entero. Si no es posible la conversión, vuelve a pedirlo
    int leeEntero(int max, String msg1, String msg2){
        Boolean ok;
        String cadena;
        int numero = -1;
        do {
            System.out.print(msg1); // Enseñamos mensaje que pedirá un número
            cadena = in.nextLine(); // Le pediremos un número que se guardará como cadena
            try{
                numero = Integer.parseInt(cadena); // Hacemos el cambio a integer (si es imposible devuelve 'NumberFormatException')
                ok = true; // Damos el visto bueno
            } catch(NumberFormatException e) { // Si el cambio es imposible
                System.out.print(msg2); // Devolvemos mensaje de error
                ok = false; // Le quitamos el visto bueno
            }
            if (ok && (numero < 0 || numero >= max)){ // Si la conversion era posible pero no está entre 0 y el número máximo pasado como parámetro
                System.out.print(msg2); // Enseñamos mensaje de error
                ok = false; // Quitamos el visto bueno
            }
        } while (!ok); // Siempre que no tenga el visto bueno no saldrá del bucle
        return numero; // Si tiene el visto bueno, devuelve el número ya convertido
    }
    // Se enseñará una lista de opciones posibles, se introducirá el índice de la opción deseada y se devolverá dicho índice
    int menu(String titulo, ArrayList<String> lista){
        String tab = "  ";
        int opcion;
        System.out.println(titulo);
        for (int i = 0; i < lista.size(); i++){ // Por cada opción de la lista
            System.out.println(tab + i + "-" + lista.get(i)); // Enseña la opción de forma indexada
        }
        opcion = leeEntero(lista.size(), "\n" + tab + "Elige una opción: ", tab + "Valor erróneo"); // Método para introducir el valor y pasarlo a entero
        return opcion; // Devuelve el índice de la opción deseada
    }
    // Da a elegir entre comprar o no una casilla
    public Respuesta comprar(){
        System.out.println(separador);
        String titulo = "¿Desea comprar la calle actual?";
        ArrayList<String> opciones = new ArrayList<>(); // lista de opciones
        opciones.add("No");
        opciones.add("Si");
        int iRespuesta = menu(titulo, opciones); // Pedimos el indice de la respuesta que el jugador desea
        if (iRespuesta == 0){
            return Respuesta.NO;
        }
        else {
            return Respuesta.SI;
        }
    }
    // Da a elegir si construir casa, hotel o nada
    public OperacionInmobiliaria elegirOperacion(){
        System.out.println(separador);
        String titulo = "¿Quieres contruir alguna casa u hotel?";
        ArrayList<String> opciones = new ArrayList<>(); // lista de opciones
        opciones.add("Construir casa");
        opciones.add("Construir hotel");
        opciones.add("Terminar");
        int iRespuesta = menu(titulo, opciones); // Pedimos el indice de la respuesta que el jugador desea
        if (iRespuesta == 0)
                return OperacionInmobiliaria.CONSTRUIR_CASA;
        else if (iRespuesta == 1)
                return OperacionInmobiliaria.CONSTRUIR_HOTEL;
        else
                return OperacionInmobiliaria.TERMINAR;
    }
    // Devuelve el índice de la propiedad que hayamos elegido
    public int elegirPropiedad(){
        System.out.println(separador);
        String titulo = "¿Sobre que propiedad vas a realizar la gestión?";
        ArrayList<String> opciones = new ArrayList<>();
        for (Casilla casilla : juegoModel.getJugadorActual().getPropiedades()){
            opciones.add(casilla.getNombre());
        }
        return menu(titulo, opciones);
    }
    // Enseña por pantalla la operación introducida como parámetro
    public void mostrarSiguienteOperacion(OperacionJuego operacion){
        System.out.println(separador);        
        System.out.print(operacion);
        System.out.println(separador);
    }
    // Muestra todos los eventos pendientes por pantalla
    public void mostrarEventos(){
        System.out.println(separador);
        while (Diario.getInstance().eventosPendientes()) {
            System.out.println(Diario.getInstance().leerEvento());
        }
    }
}
