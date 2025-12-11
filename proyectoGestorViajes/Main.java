import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
    // Listas globales para guardar datos de viajes
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> ciudades = new ArrayList<>();
    ArrayList<String> paises = new ArrayList<>();
    ArrayList<String> monedas = new ArrayList<>();
    ArrayList<String> fechasInicio = new ArrayList<>();
    ArrayList<String> fechasFin = new ArrayList<>();
    ArrayList<String> transportes = new ArrayList<>();
    ArrayList<String> adultos = new ArrayList<>();
    ArrayList<String> ninos = new ArrayList<>();
    ArrayList<String> actividades = new ArrayList<>();
    ArrayList<String> presupuestos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String carpetaViajes = "viajes_simple/";

    /* 
     * Crea el objeto de programa: constructor
     */
    public static void main(String[] args) {
        Main programa = new Main();
        programa.init();
    }

    void init() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Planificar un viaje");
            System.out.println("2. Mostrar viajes");
            System.out.println("3. Generar informe");
            System.out.println("4. Eliminar viaje");
            System.out.println("Otro número para salir");

            opcion = leerNumero();

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

    void crearCarpeta() {

    }

    void cargarViajes() {

    }

    void leerViajeArchivo(File archivo) {

    }

    void planificarViaje() {

    }

    void guardarEnArchivo(String id, String ciudad, String pais, String moneda,
            String fechaInicio, String fechaFin, String transporte,
            int numPers, String actividad, double presupuesto) {

    }

    void mostrarViajes() {
        if (ids.isEmpty()) {
            System.out.println("No hay viajes registrados.");
        } else {
            System.out.println("\n--- Lista de viajes ---");
            for (int i = 0; i < ids.size(); i++) {
                System.out.println((i + 1) + ". " + ciudades.get(i) + ", " + paises.get(i)
                        + " (ID: " + ids.get(i) + ")");
            }
        }
    }

    void mostrarDetallesViaje(int indice) {

    }

    void generarInforme() {

    }

    void eliminarViaje() {

    }

    int leerNumero() {
        System.out.print("Ingrese un número: ");
        String entrada = scanner.nextLine(); // leer como texto
        int numero = Integer.parseInt(entrada); // convertir a entero
        return numero;

    }

    // Método sencillo para leer un número decimal
    double leerDecimal() {
        System.out.print("Ingrese un número decimal: ");
        String entrada = scanner.nextLine(); // leer como texto
        double numero = Double.parseDouble(entrada); // convertir a decimal
        return numero;
    }

}
