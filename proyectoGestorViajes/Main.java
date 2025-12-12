/*
 * Los únicos métodos con control de errores try-catch són los que tienen manejo de archivos.
 * Java con File genera exceptciones obligatorias, si no se manejan se sale del programa.
 * Evitar manejar un exit forzado con throws, utilizando un try-catch simple.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase principal del programa Gestor de Viajes.
 * Esta aplicación permite planificar, mostrar, generar informes y eliminar viajes,
 * guardando los datos en archivos de texto para obtener persistencia.
 */
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
    String carpetaViajes = "proyectoGestorViajes/viajes/";
    String carpetaInformes = "proyectoGestorViajes/informes/";

    /**
     * Punto de entrada principal del programa.
     * Crea una instancia de la clase Main y ejecuta el método init()
     * para iniciar la aplicación (como se ha explicado en clase y ya).
     */
    public static void main(String[] args) {
        Main programa = new Main();
        programa.init();
    }

    /**
     * Inicializa la aplicación.
     * Crea las carpetas necesarias, carga los viajes existentes desde archivos
     * y muestra el menú principal en un bucle hasta que el usuario elija salir.
     */
    void init() {
        crearCarpetas();
        cargarViajes();

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Planificar un viaje");
            System.out.println("2. Mostrar viajes");
            System.out.println("3. Generar informe");
            System.out.println("4. Eliminar viaje");
            System.out.println("5. Salir");

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
                case 5:
                    System.out.println("Saliendo... ¡Adiós!");
            }

        } while (opcion != 5);
    }

    /**
     * Crea las carpetas necesarias para almacenar los datos del programa.
     * viajes/ - Para almacenar los archivos de viajes
     * informes/ - Para almacenar los informes generados
     */
    void crearCarpetas() {
        // Crear una referencia, para el programa, de la carpeta en la ruta
        // previamente definida
        File carpeta = new File(carpetaViajes);
        if (!carpeta.exists()) {
            // Crear carpeta
            carpeta.mkdir();
        }

        // Crear una referencia, para el programa, de la carpeta en la ruta
        // previamente definida
        File carpetaInfo = new File(carpetaInformes);
        if (!carpetaInfo.exists()) {
            // Crear carpeta
            carpetaInfo.mkdir();
        }
    }

    /**
     * Carga los viajes existentes desde archivos de texto.
     * Lee todos los archivos .txt de la carpeta de viajes y carga sus datos
     * en los ArrayLists correspondientes para su uso en memoria.
     */
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

    /**
     * Lee los datos de un archivo de viaje y los carga en los ArrayLists.
     * Lee línea por línea el archivo de texto, extrae los valores eliminando
     * las cabezeras y los almacena en los ArrayLists correspondientes.
     *
     * @param archivoActual Archivo de texto que contiene los datos del viaje
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

    /**
     * Permite al usuario planificar un nuevo viaje.
     * Solicita al usuario todos los datos necesarios para un viaje:
     * ciudad, país, moneda, fechas, transporte, número de personas, actividad principal y presupuesto.
     * Muestra un resumen y pregunta si desea guardar el viaje.
     */
    void planificarViaje() {
        System.out.println("\n--- Planificar un nuevo viaje ---");

        // Ciudad
        System.out.print("Ingrese ciudad: ");
        String ciudad = scanner.nextLine();

        // País
        System.out.print("Ingrese país: ");
        String pais = scanner.nextLine();

        // Moneda
        System.out.print("Ingrese moneda en plural: ");
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
        System.out.print("\nIngrese número de personas: ");
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
        System.out.print("\nIngrese el presupuesto estimado (cantidad sin unidades): ");
        // Solo números positivos
        int presupuesto = leerNumero(0, Integer.MAX_VALUE);
        // Reconventir a String después del método de validación de decimales
        String presupuestoStr = String.valueOf(presupuesto);

        // Generar ID automático al final
        String id = "VIAJE_" + (ids.size() + 1);

        // Mostrar resumen temporal
        System.out.println("\n--- RESUMEN RAPIDO ---");
        System.out.println("   ID: " + id);
        System.out.println("   Destino: " + ciudad + ", " + pais);
        System.out.println("   Estancia: " + fechaInicio + " --> " + fechaFin);
        System.out.println("   Número de personas: " + numPersonas);
        System.out.println("   Transportes: " + transporte);
        System.out.println("   Actividades: " + actividad);
        System.out.println("   Presupuesto: " + presupuesto + " " + moneda);

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

    /**
     * Guarda los datos de un viaje en un archivo de texto.
     * Crea un archivo con formato .txt que contiene todos los datos del viaje,
     * usando el ID como nombre del archivo.
     *
     * @param id Identificador único del viaje
     * @param ciudad Ciudad de destino del viaje
     * @param pais País de destino del viaje
     * @param moneda Moneda utilizada para el presupuesto
     * @param fechaInicio Fecha de inicio del viaje (formato DD/MM/AAAA)
     * @param fechaFin Fecha de fin del viaje (formato DD/MM/AAAA)
     * @param transporte Medio de transporte seleccionado
     * @param numPersonas Número de personas que viajarán
     * @param actividad Actividad principal del viaje
     * @param presupuestoStr Presupuesto estimado como cadena de texto
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
        
        // Capturar error de tipo general --> Exception e
        } catch (Exception e) {
            System.out.println("Error guardando archivo " + nombreArchivo);
        }
    }

    /**
     * Muestra una lista numerada de todos los viajes almacenados.
     * Presenta cada viaje con su número, ID, ciudad y país.
     */
    void mostrarViajes() {
        if (ids.isEmpty()) {
            System.out.println("No hay viajes registrados.");
        } else {
            System.out.println("\n--- Lista de viajes ---");
            for (int i = 0; i < ids.size(); i++) {
                System.out
                        .println((i + 1) + ". ID: " + ids.get(i) + " ( " + ciudades.get(i) + ", " + paises.get(i) + " )");
            }
        }
    }

    /**
     * Muestra todos los detalles de un viaje específico.
     * Presenta información completa del viaje seleccionado por índice,
     * incluyendo todos los campos almacenados.
     *
     * @param indice Índice real del viaje en las listas (1a posición tiene indice real 0)
     */
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

    /**
     * Genera un informe detallado de un viaje seleccionado.
     * Permite seleccionar un viaje de la lista y crea un archivo de informe almacenado en una carpeta concreta.
     * Los datos se leen directamente del archivo original del viaje, no de los ArrayLists.
     */
    void generarInforme() {
        PrintWriter writer = null;
        Scanner lector = null;

        if (ids.isEmpty()) {
            System.out.println("\nNo hay viajes para generar ningún informe");
            return;
        }

        System.out.println("\n--- Generar informe ---");
        System.out.print("Selecciona el ID del viaje: ");

        int num = leerNumero(1, ids.size());
        int indice = num - 1;
        String idViaje = ids.get(indice);
    
        // Ruta del archivo
        String archivoViaje = carpetaViajes + idViaje + ".txt";
        File archivo = new File(archivoViaje);

        if (!archivo.exists()) {
            System.out.println("Error: No se encuentra el archivo del viaje: " + archivoViaje);
            return;
        }

        // Ruta para el informe
        String nombreArchivo = carpetaInformes + "informe_" + idViaje + ".txt";

        try {
            writer = new PrintWriter(new FileWriter(nombreArchivo));
            lector = new Scanner(archivo);

            // Leer datos DEL ARCHIVO .txt
            String id = lector.nextLine().replace("ID: ", "");
            String ciudad = lector.nextLine().replace("Ciudad: ", "");
            String pais = lector.nextLine().replace("País: ", "");
            String moneda = lector.nextLine().replace("Moneda: ", "");
            String fechaInicio = lector.nextLine().replace("Fecha inicio: ", "");
            String fechaFin = lector.nextLine().replace("Fecha fin: ", "");
            String transporte = lector.nextLine().replace("Transportes: ", "");
            String personas = lector.nextLine().replace("Personas: ", "");
            String actividades = lector.nextLine().replace("Actividades: ", "");
            String presupuesto = lector.nextLine().replace("Presupuesto: ", "");
            
            // Escribir informe con datos DEL ARCHIVO
            writer.println("--- Informe viaje ---");
            writer.println("ID: " + id);
            writer.println("DESTINO:");
            writer.println("  Ciudad: " + ciudad);
            writer.println("  País: " + pais);
            writer.println();
            writer.println("FECHAS:");
            writer.println("  Fecha inicio: " + fechaInicio);
            writer.println("  Fecha fin: " + fechaFin);
            writer.println();
            writer.println("Personas: " + personas);
            writer.println("Transporte: " + transporte);
            writer.println("Actividades: " + actividades);
            writer.println("Presupuesto: " + presupuesto + " " + moneda);
            
            System.out.println("Informe guardado como: informe_" + idViaje + ".txt");
        
        // Capturar error de tipo general --> Exception e    
        } catch (Exception e) {
            System.out.println("Error guardando archivo " + nombreArchivo);
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (lector != null) {
                lector.close();
            }
        }
    }

    /**
     * Elimina un viaje seleccionado.
     * Permite seleccionar un viaje de la lista, lo elimina de todas las listas en memoria
     * y borra su archivo correspondiente del sistema de archivos.
     */
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

    /**
     * Lee un número entero del usuario con validación de rango.
     * Solicita al usuario una entrada y valida que sea un número entero válido dentro
     * del rango especificado. Continúa pidiendo entrada hasta que se proporcione un valor válido.
     *
     * @param min Valor mínimo aceptable (inclusive)
     * @param max Valor máximo aceptable (inclusive)
     * @return Número entero válido dentro del rango especificado
     */
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