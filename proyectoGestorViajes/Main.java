import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    // Listas globales para guardar datos de viajes
    static ArrayList<String> ids = new ArrayList<>();
    static ArrayList<String> ciudades = new ArrayList<>();
    static ArrayList<String> paises = new ArrayList<>();
    static ArrayList<String> monedas = new ArrayList<>();
    static ArrayList<String> fechasInicio = new ArrayList<>();
    static ArrayList<String> fechasFin = new ArrayList<>();
    static ArrayList<String> transportes = new ArrayList<>();
    static ArrayList<String> adultos = new ArrayList<>();
    static ArrayList<String> ninos = new ArrayList<>();
    static ArrayList<String> actividades = new ArrayList<>();
    static ArrayList<String> presupuestos = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    static String carpetaViajes = "viajes_simple/";

    public static void main(String[] args) {
        init(); // Empieza el menú principal
    }

    public static void init() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Planificar un viaje");
            System.out.println("2. Mostrar viajes");
            System.out.println("3. Generar informe");
            System.out.println("4. Eliminar viaje");
            System.out.println("Otro número para salir");

            opcion = leerNumero(1, 4);

            switch (opcion) {
                case 1:
                    planificarViaje();
                    break;
                case 2:
                    mostrarViajes();
                    break;
                case 3:
                    generarInforme();
                    break;
                case 4:
                    eliminarViaje();
                    break;
                default:
                    System.out.println("Saliendo... ¡Adiós!");
            }

        } while (opcion >= 1 && opcion <= 4);
    }

}

static void crearCarpeta() {

}

static void cargarViajes() {

}

static void leerViajeArchivo(File archivo) {

}

static void planificarViaje() {

}

static void guardarEnArchivo(String id, String ciudad, String pais, String moneda,
        String fechaInicio, String fechaFin, String transporte,
        int numPers, String actividad, double presupuesto) {

}

static void mostrarViajes() {

}

static void mostrarDetallesViaje(int indice) {

}

static void generarInforme() {

}

static void eliminarViaje() {

}

static int leerNumero(int min, int max) {

}

static double leerDecimal() {

}
