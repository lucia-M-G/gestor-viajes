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
    ArrayList<String> personas = new ArrayList<>();
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

        // País
        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();

        // Moneda
        System.out.print("Ingrese moneda: ");
        String moneda = scanner.nextLine();

        // Fechas
        System.out.print("Ingrese fecha de inicio (DD/MM/AAAA): ");
        String fechaInicio = scanner.nextLine();

        System.out.print("Ingrese fecha de fin (DD/MM/AAAA): ");
        String fechaFin = scanner.nextLine();

        // Submenú Transporte
        System.out.println("Seleccione transporte:");
        System.out.println("1. Avión");
        System.out.println("2. Tren");
        System.out.println("3. Autobús");
        System.out.println("4. Coche");
        int opcionTransporte = leerNumero(1, 4);
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

        // Número de personas
        System.out.print("Ingrese número de personas: ");
        String numPersonas = scanner.nextLine();

        // Submenú Actividad
        System.out.println("Seleccione actividad principal:");
        System.out.println("1. Parque Natural");
        System.out.println("2. Cultural");
        System.out.println("3. Ludica");
        System.out.println("4. Gastronomica");
        int opcionActividad = leerNumero(1, 4);
        String actividad;

        switch (opcionActividad) {
            case 1:
                actividad = "Parque Natural";
                break;
            case 2:
                actividad = "Cultural";
                break;
            case 3:
                actividad = "Lúdica";
                break;
            case 4:
                actividad = "Gastronomica";
                break;
            default:
                actividad = "Otra";
                break;
        }

        // Presupuesto
        System.out.print("Ingrese el presupuesto estimado: ");
        double presupuesto = leerDecimal();
        // Reconventir a String después del método de validación de decimales
        String presupuestoStr = String.valueOf(presupuesto);

        // Generar ID automático al final
        String id = "VIAJE_" + (ids.size() + 1);

        // Mostrar resumen temporal
        System.out.println("--- RESUMEN RÁPIDO ---");
        System.out.println("ID: " + id);
        System.out.println("Destino: " + ciudad + ", " + pais);
        System.out.println("Estancia: " + fechaInicio + " → " + fechaFin);
        System.out.println("Número de personas: " + numPersonas);
        System.out.println("Transportes: " + transporte);
        System.out.println("Actividades: " + actividad);
        System.out.println("Presupuesto: " + presupuesto + " " + moneda);

        // Preguntar si guardar
        System.out.print("\n¿Guardar este viaje? (S/N): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            // Guardar en ArrayLists
            ids.add(id);
            ciudades.add(ciudad);
            paises.add(pais);
            monedas.add(moneda);
            fechasInicio.add(fechaInicio);
            fechasFin.add(fechaFin);
            transportes.add(transporte);
            personas.add(numPersonas);
            actividades.add(actividad);
            presupuestos.add(presupuestoStr);

            // Guardar en archivo pasando parámetros a el método guardarEnArchivo()
            guardarEnArchivo(id, ciudad, pais, moneda, fechaInicio, fechaFin,
                    transporte, numPersonas, actividad, presupuestoStr);

            System.out.println("Viaje guardado");
        } else {
            System.out.println("Viaje descartado");
        }
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
            System.out.println("Índice inválido. No existe ese viaje.");
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
        System.out.println("Personas: " + personas.get(indice));
        System.out.println("Actividad: " + actividades.get(indice));
        System.out.println("Presupuesto: " + presupuestos.get(indice));

    }

    void generarInforme() {

    }

    void eliminarViaje() {
        if (ids.isEmpty()) {
            System.out.println("No hay viajes registrados para eliminar.");
            return;
        }

        mostrarViajes();
        System.out.print("Ingrese el número del viaje a eliminar: ");
        int seleccion = leerNumero();
        int indice = seleccion - 1;

        if (indice < 0 || indice >= ids.size()) {
            System.out.println("Número inválido. No existe ese viaje.");
            return;
        }

        // Guardar ID para borrar archivo
        String id = ids.get(indice);

        // Eliminar de todas las listas
        ids.remove(indice);
        ciudades.remove(indice);
        paises.remove(indice);
        monedas.remove(indice);
        fechasInicio.remove(indice);
        fechasFin.remove(indice);
        transportes.remove(indice);
        personas.remove(indice);
        actividades.remove(indice);
        presupuestos.remove(indice);

        // Intentar borrar archivo asociado (sin alternativas)
        File archivo = new File(carpetaViajes + id + ".txt");
        archivo.delete();

        System.out.println("Viaje eliminado.");

    }

    int leerNumero(int min, int max) {
        while (true) {
            String entrada = scanner.nextLine();

            // Verificar si todos son dígitos
            boolean esNumero = true;
            for (int i = 0; i < entrada.length(); i++) {
                char numChar = entrada.charAt(i);
                if (numChar < '0' || numChar > '9') {
                    esNumero = false;
                    break;
                }
            }

            // Si no es número, pedir otra vez
            if (!esNumero || entrada.isEmpty()) {
                System.out.print("Ingresa un número válido: ");
                continue;
            }

            // Convertir a número
            int num = Integer.parseInt(entrada);

            // Verificar rango
            if (num >= min && num <= max) {
                return num;
            } else {
                System.out.print("Número inválido. Ingresa entre " + min + " y " + max + ": ");
            }
        }
    }

    // Método sencillo para leer un número decimal
    double leerDecimal() {
        String entrada = scanner.nextLine(); // leer como texto
        return Double.parseDouble(entrada); // convertir a decimal

    }

}
