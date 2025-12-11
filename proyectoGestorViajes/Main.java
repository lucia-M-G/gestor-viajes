import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        crearCarpeta();
        cargarViajes();
    }
   
    void init() {

    }

    void crearCarpeta() {
        // Crear una referencia, para el programa, de la carpeta en la ruta previamente definida
        File carpeta = new File(carpetaViajes);
        if (!carpeta.exists()) {
            // Crear carpeta
            carpeta.mkdir();
        }
    }

    void cargarViajes() {
        // Solo es una referencia para este método, no creamos otra carpeta duplicada
        File carpeta = new File(carpetaViajes);
        // Crear array de objetos File y llenarlo con archivos dentro carpeta viajes_simple/
        // Si carpeta no existe el método .listFiles() devuelve un null
        File[] archivos = carpeta.listFiles();
        
        // Manejar el null (null = vacío) de .listFiles()
        // ¿Carpeta existe y contiene datos?
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];

                // Comprobar el formato de archivos de BB. DD.
                String nombreArchivo = archivoActual.getName();
                boolean esTxt = nombreArchivo.endsWith(".txt");
                
                if (esTxt) {
                    leerViajeDesdeArchivo(archivoActual);
                }
            }
        } else {
            System.out.println("No hay datos de viajes previos");
        }
    }
   
    /*
     * Los únicos métodos con control de errores try-catch són los que tienen manejo de archivos
     * Java con File genera exceptciones obligatorias, si no se manejan se sale del programa
     * Evitar manejar un exit forzado con throws, utilizando un try-catch simple
     */
    void leerViajeArchivo(File archivo) {
        try {
            // Crear un scanner específico para los archivos
            Scanner lector = new Scanner(archivo);
            
            // Leer cada línea de los .txt + guardar en los ArrayList
            // .replace() --> para quitar cabezeras del archivo al guardar los valores en los ArrayList
            ids.add(lector.nextLine().replace("ID: ", ""));
            ciudades.add(lector.nextLine().replace("Ciudad: ", ""));
            paises.add(lector.nextLine().replace("País: ", ""));
            monedas.add(lector.nextLine().replace("Moneda: ", ""));
            fechasInicio.add(lector.nextLine().replace("Fecha inicio: ", ""));
            fechasFin.add(lector.nextLine().replace("Fecha fin: ", ""));
            
            // Varios transportes, manejo distinto
            // Saltar cabezera
            lector.nextLine();
            String transporteLinea = lector.nextLine();
            transportes.add(transporteLinea);
            
            // Leer los .txt + guardar en el ArrayList
            // .replace() --> para quitar cabezeras del archivo al guardar los valores en el ArrayList
            personas.add(lector.nextLine().replace("Personas: ", ""));

            // Varias actividades, manejo distinto
            // Saltar cabezera
            lector.nextLine();
            String actividadLinea = lector.nextLine();
            actividades.add(actividadLinea);
            
            // Leer los .txt + guardar en el ArrayList
            // .replace() --> para quitar cabezeras del archivo al guardar los valores en el ArrayList
            // Guardar iniccialmente presupuestos como String, manejar formato después
            presupuestos.add(lector.nextLine().replace("Presupuesto: ", ""));
            
            // Cerrar el scanner lector para evitar errores
            lector.close();
        // Capturar error de tipo general --> Exception e
        } catch (Exception e) {
            System.out.println("Error leyendo archivo " + archivo.getName());
        }
    }
   
    void planificarViaje() {
       
    }
   
    void guardarEnArchivo(String id, String ciudad, String pais, String moneda,
                                String fechaInicio, String fechaFin, String transporte,
                                int numPers, String actividad, double presupuesto) {
    
    }
   
    void mostrarViajes() {
        
    }
   
    void mostrarDetallesViaje(int indice) {
    
    }

    /*
    * Los únicos métodos con control de errores try-catch són los que tienen manejo de archivos
    * Java con File genera exceptciones obligatorias, si no se manejan se sale del programa
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
        writer.println("Transporte: " + transporte.get(indice));
        writer.println("Actividades: " + actividades.get(indice));
        writer.println("Presupuesto: " + presupuestos.get(indice) + " " + monedas.get(indice));

        writer.close();
        System.out.println("Informe guardado como: " + nombreArchivo);
    }
   
    void eliminarViaje() {
       
    }
   
    int leerNumero(int min, int max) {
       
    }
   
    double leerDecimal() {
        
    }
}