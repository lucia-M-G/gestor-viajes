import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class GestorViajes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 3: Crear ArrayList para nombres de viajes
        ArrayList<String> nombresViajes = new ArrayList<>();

        // Paso 4: Carpeta base "viajes"
        File carpetaBase = new File("viajes");

        // Paso 5: ¿Existe la carpeta?
        if (!carpetaBase.exists()) {
            System.out.println("La carpeta 'viajes' no existe. Finalizando...");
            return; // se puede cambiar este return por mkdir() para que el programa avance y cree
                    // automaticamente la carpeta o se crea la carpeta manual.

        }

        // Paso 6: Crear carpeta nueva con nombre introducido
        System.out.print("Ingrese el nombre de la nueva carpeta: ");
        String nombreCarpeta = scanner.nextLine().trim();
        File nuevaCarpeta = new File(nombreCarpeta);

        if (!nuevaCarpeta.exists()) {
            nuevaCarpeta.mkdir();
            System.out.println("Carpeta creada: " + nuevaCarpeta.getName());
        }
        // Paso 7: Mostrar mensaje
        System.out.println("Carpeta a leer:");

        // Paso 8: Leer nombre de carpeta
        String carpetaALeer = scanner.nextLine().trim();
        File carpetaLectura = new File(carpetaALeer);

        if (!carpetaLectura.exists()) {
            carpetaLectura.mkdir();
            System.out.println("Carpeta creada: " + carpetaLectura.getName());
        }

        // Paso 10: Leer opción numérica
        System.out.println("Seleccione una opción:");
        System.out.println("1. Planificar un viaje");
        System.out.println("2. Planificaciones previas");
        System.out.println("Otro número para salir");

        int opcion = leerEntero(scanner);

        // Paso 11: Switch de opciones
        switch (opcion) {
            case 1:
                System.out.println("Opción 1: Planificar un viaje");
                // Aquí se llamaría a planificarUnViaje();
                break;
            case 2:
                System.out.println("Opción 2: Planificaciones previas");
                // Aquí se llamaría a mostrarMenuPlanificacionesPrevias();
                break;
            default:
                System.out.println("Saliendo... ¡Adiós!");
        }
    }

    // Validación básica de enteros
    public static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. Intente con un número: ");
            scanner.next();
        }

        return scanner.nextInt();
    }
}