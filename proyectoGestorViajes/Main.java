import java.util.Scanner;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        crearCarpeta();
        cargarViajes();
    }
   
    void init() {

    }

    void crearCarpeta() {
        // Crear una referencia para el programa de la carpeta en ruta previamente definida
        File carpeta = new File(carpetaViajes);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    void cargarViajes() {
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
            System.out.println("No hay datos de viajes previos.");
        }
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
        
    }
   
    void mostrarDetallesViaje(int indice) {
    
    }

    void generarInforme() {

    }
   
    void eliminarViaje() {
       
    }
   
    int leerNumero(int min, int max) {
       
    }
   
    double leerDecimal() {
        
    }
}