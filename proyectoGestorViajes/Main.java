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
        System.out.println("\n--- Planificar un nuevo viaje ---");

        // Ciudad
        System.out.print("Ingrese ciudad: ");
        String ciudad = scanner.nextLine();
        ciudades.add(ciudad);

        // País
        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();
        paises.add(pais);

        // Moneda
        System.out.print("Ingrese moneda: ");
        String moneda = scanner.nextLine();
        monedas.add(moneda);

        // Fechas
        System.out.print("Ingrese fecha de inicio: ");
        String fechaInicio = scanner.nextLine();
        fechasInicio.add(fechaInicio);

        System.out.print("Ingrese fecha de fin: ");
        String fechaFin = scanner.nextLine();
        fechasFin.add(fechaFin);

        // Submenú Transporte
        System.out.println("Seleccione transporte:");
        System.out.println("1. Avión");
        System.out.println("2. Tren");
        System.out.println("3. Autobús");
        System.out.println("4. Coche");
        int opcionTransporte = leerNumero();
        String transporte;
        switch (opcionTransporte) {
            case 1:
                transporte = "Avión";
                break;
            case 2:
                transporte = "Tren";
                break;
            case 3:
                transporte = "Autobús";
                break;
            case 4:
                transporte = "Coche";
                break;
            default:
                transporte = "Otro";
                break;
        }
        transportes.add(transporte);

        // Número de adultos
        System.out.print("Ingrese número de adultos: ");
        String numAdultos = scanner.nextLine();
        adultos.add(numAdultos);

        // Número de niños
        System.out.print("Ingrese número de niños: ");
        String numNinos = scanner.nextLine();
        ninos.add(numNinos);

        // Submenú Actividad
        System.out.println("Seleccione actividad principal:");
        System.out.println("1. Parque Natural");
        System.out.println("2. Cultural");
        System.out.println("3. Ludica");
        System.out.println("4. Gastronomica");
        int opcionActividad = leerNumero();
        String actividad;
        switch (opcionActividad) {
            case 1:
                actividad = "Parque Natural";
                break;
            case 2:
                actividad = "Cultural";
                break;
            case 3:
                actividad = "Ludica";
                break;
            case 4:
                actividad = "Gastronomica";
                break;
            default:
                actividad = "Otra";
                break;
        }
        actividades.add(actividad);

        // Presupuesto
        System.out.print("Ingrese el presupuesto estimado: ");
        double presupuesto = leerDecimal();
        presupuestos.add(String.valueOf(presupuesto));

        // Generar ID automático al final
        String id = "V" + (ids.size() + 1);
        ids.add(id);

        System.out.println("Viaje registrado con ID: " + id);

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
        if (indice < 0 || indice >= ids.size()) {
            System.out.println("❌ Índice inválido. No existe ese viaje.");
            return;
        }

        System.out.println("\n--- Detalles del viaje ---");
        System.out.println("ID: " + ids.get(indice));
        System.out.println("Ciudad: " + ciudades.get(indice));
        System.out.println("País: " + paises.get(indice));
        System.out.println("Moneda: " + monedas.get(indice));
        System.out.println("Fecha inicio: " + fechasInicio.get(indice));
        System.out.println("Fecha fin: " + fechasFin.get(indice));
        System.out.println("Transporte: " + transportes.get(indice));
        System.out.println("Adultos: " + adultos.get(indice));
        System.out.println("Niños: " + ninos.get(indice));
        System.out.println("Actividad: " + actividades.get(indice));
        System.out.println("Presupuesto: " + presupuestos.get(indice));

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
        String entrada = scanner.nextLine(); // leer como texto
        return Double.parseDouble(entrada); // convertir a decimal

    }

}
