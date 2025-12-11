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
        // Creo una referencia para el programa de la carpeta en ruta previamente definida
        File carpeta = new File(carpetaViajes);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
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