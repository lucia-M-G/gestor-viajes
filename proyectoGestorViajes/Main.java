import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
        crearCarpeta();
        cargarViajes();

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Planificar un viaje");
            System.out.println("2. Mostrar viajes");
            System.out.println("3. Generar informe");
            System.out.println("4. Eliminar viaje");
            System.out.println("Otro número para salir");

            opcion = leerNumero(Integer.MIN_VALUE, Integer.MAX_VALUE);

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
        // Crear una referencia, para el programa, de la carpeta en la ruta previamente
        // definida
        File carpeta = new File(carpetaViajes);
        if (!carpeta.exists()) {
            // Crear carpeta
            carpeta.mkdir();
        }
    }

    void cargarViajes() {
        // Solo es una referencia para este método, no creamos otra carpeta duplicada
        File carpeta = new File(carpetaViajes);
        // Crear array de objetos File y llenarlo con archivos dentro carpeta
        // viajes_simple/
        // Si carpeta no existe el método .listFiles() devuelve un null
        File[] archivos = carpeta.listFiles();

        // Manejar el null (null = vacío) de .listFiles()
        // ¿Carpeta existe y contiene datos?
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];

                // Comprobar el formato de archivos de BB. DD.
                String nombreArchivo = archivo.getName();
                boolean esTxt = nombreArchivo.endsWith(".txt");

                if (esTxt) {
                    leerViajeArchivo(archivo);
                }
            }
        } else {
            System.out.println("No hay datos de viajes previos");
        }
    }

    /*
     * Los únicos métodos con control de errores try-catch són los que tienen manejo
     * de archivos
     * Java con File genera exceptciones obligatorias, si no se manejan se sale del
     * programa
     * Evitar manejar un exit forzado con throws, utilizando un try-catch simple
     */
    void leerViajeArchivo(File archivoActual) {
        try {
            // Crear un scanner específico para los archivos
            Scanner lector = new Scanner(archivoActual);

            // Leer cada línea de los .txt + guardar en los ArrayList
            // .replace() --> para quitar cabezeras del archivo al guardar los valores en
            // los ArrayList
            ids.add(lector.nextLine().replace("ID: ", ""));
            ciudades.add(lector.nextLine().replace("Ciudad: ", ""));
            paises.add(lector.nextLine().replace("País: ", ""));
            monedas.add(lector.nextLine().replace("Moneda: ", ""));
            fechasInicio.add(lector.nextLine().replace("Fecha inicio: ", ""));
            fechasFin.add(lector.nextLine().replace("Fecha fin: ", ""));
            transportes.add(lector.nextLine().replace("Transportes: ", ""));
            personas.add(lector.nextLine().replace("Personas: ", ""));
            actividades.add(lector.nextLine().replace("Actividades: ", ""));
            presupuestos.add(lector.nextLine().replace("Presupuesto: ", ""));

            // Cerrar el scanner lector para evitar errores
            lector.close();

            // Capturar error de tipo general --> Exception e
        } catch (Exception e) {
            System.out.println("Error leyendo archivo " + archivoActual.getName());
        }
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
        System.out.println("3. Lúdica");
        System.out.println("4. Gastronómica");
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
                actividad = "Gastronómica";
                break;
            default:
                actividad = "Otra";
                break;
        }

        // Presupuesto
        System.out.print("Ingrese el presupuesto estimado: ");
        // Solo números positivos
        int presupuesto = leerNumero(0, Integer.MAX_VALUE);
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

        // Omitir si es minúscula o mayuscula
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

    /*
     * Los únicos métodos con control de errores try-catch són los que tienen manejo
     * de archivos
     * Java con File genera exceptciones obligatorias, si no se manejan se sale del
     * programa
     * Evitar manejar un exit forzado con throws, utilizando un try-catch simple
     */
    void guardarEnArchivo(String id, String ciudad, String pais, String moneda, String fechaInicio,
            String fechaFin, String transporte, String numPersonas, String actividad, String presupuestoStr) {
        // Ejemplo: viajes/VIAJE_1.txt
        String nombreArchivo = carpetaViajes + id + ".txt";

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo));

            // Escribir en formato del archivo
            writer.println("ID: " + id);
            writer.println("Ciudad: " + ciudad);
            writer.println("País: " + pais);
            writer.println("Moneda: " + moneda);
            writer.println("Fecha inicio: " + fechaInicio);
            writer.println("Fecha fin: " + fechaFin);
            writer.println("Transportes: " + transporte);
            writer.println("Personas: " + numPersonas);
            writer.println("Actividades: " + actividad);
            writer.println("Presupuesto: " + presupuestoStr);

            // Cerrar el writer para evitar errores
            writer.close();
            System.out.println("Archivo " + nombreArchivo + " guardado");

            // Capturar error de tipo general --> Exception e
        } catch (Exception e) {
            System.out.println("Error guardando archivo " + nombreArchivo);
        }
    }

    void mostrarViajes() {
        if (ids.isEmpty()) {
            System.out.println("No hay viajes registrados.");
        } else {
            System.out.println("\n--- Lista de viajes ---");
            for (int i = 0; i < ids.size(); i++) {
                System.out
                        .println((i + 1) + ". " + ciudades.get(i) + ", " + paises.get(i) + " (ID: " + ids.get(i) + ")");
            }
        }
    }

    void mostrarDetallesViaje(int indice) {
        if (indice < 0 || indice >= ids.size()) {
            System.out.println("Índice inválido. No existe ese viaje");
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

    /*
     * Los únicos métodos con control de errores try-catch són los que tienen manejo
     * de archivos
     * Java con File genera exceptciones obligatorias, si no se manejan se sale del
     * programa
     * Evitar manejar un exit forzado con throws, utilizando un try-catch simple
     */
    void generarInforme() {
        if (ids.isEmpty()) {
            System.out.println("\nNo hay viajes para generar ningún informe");
            return;
        }

        System.out.println("--- Generar informe ---");
        mostrarViajes();

        System.out.print("\nSelecciona el ID del viaje: ");

        int num = leerNumero(1, ids.size());
        int indice = num - 1;

        // Crear archivo para el informe que usaremos como BB.DD.
        String nombreArchivo = "informe_" + ids.get(indice) + ".txt";
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(nombreArchivo));
        } catch (Exception e) {
            System.out.println("Error: No se pudo crear el informe");
            return;
        }

        // Escribir informe
        writer.println("--- Informe viaje ---");
        writer.println("ID: " + ids.get(indice));
        writer.println("DESTINO:");
        writer.println("  Ciudad: " + ciudades.get(indice));
        writer.println("  País: " + paises.get(indice));
        writer.println();
        writer.println("FECHAS:");
        writer.println("  Fecha inicio: " + fechasInicio.get(indice));
        writer.println("  Fecha fin: " + fechasFin.get(indice));
        writer.println();
        writer.println("Personas: " + personas.get(indice));
        writer.println("Transporte: " + transportes.get(indice));
        writer.println("Actividades: " + actividades.get(indice));
        writer.println("Presupuesto: " + presupuestos.get(indice) + " " + monedas.get(indice));

        writer.close();
        System.out.println("Informe guardado como: " + nombreArchivo);
    }

    void eliminarViaje() {
        if (ids.isEmpty()) {
            System.out.println("No hay viajes registrados para eliminar");
            return;
        }

        mostrarViajes();
        System.out.print("Ingrese el número del viaje a eliminar: ");
        int seleccion = leerNumero(1, ids.size());
        int indice = seleccion - 1;

        if (indice < 0 || indice >= ids.size()) {
            System.out.println("Número inválido. No existe ese viaje");
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
        if (archivo.exists()) {
            archivo.delete();
        }

        System.out.println("Viaje eliminado");

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
            // Sin rango
            } else if (min == Integer.MIN_VALUE && max == Integer.MAX_VALUE) {
                System.out.print("Ingresa un número válido: ");
            } else {
                System.out.print("Número inválido. Ingresa entre " + min + " y " + max + ": ");
            }
        }
    }

}
