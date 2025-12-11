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
            return;
        }

        // Paso 6: Crear carpeta nueva con nombre introducido
        System.out.print("Ingrese el nombre de la nueva carpeta: ");
        String nombreCarpeta = scanner.nextLine().trim();
        File nuevaCarpeta = new File(nombreCarpeta);

        if (!nuevaCarpeta.exists()) {
            nuevaCarpeta.mkdir();
            System.out.println("Carpeta creada: " + nuevaCarpeta.getName());
        }


    }return scanner.nextInt();
}