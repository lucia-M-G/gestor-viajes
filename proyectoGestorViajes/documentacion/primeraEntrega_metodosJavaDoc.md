# Explicación de métodos del proyecto

```java
/**
 * Clase principal del programa Gestor de Viajes.
 * Esta aplicación permite planificar, mostrar, generar informes y eliminar viajes,
 * guardando los datos en archivos de texto para obtener persistencia.
 */
public class Main {}

/**
 * Punto de entrada principal del programa.
 * Crea una instancia de la clase Main y ejecuta el método init()
 * para iniciar la aplicación (como se ha explicado en clase y ya).
 */
public static void main(String[] args) {}

/**
 * Inicializa la aplicación.
 * Crea las carpetas necesarias, carga los viajes existentes desde archivos
 * y muestra el menú principal en un bucle hasta que el usuario elija salir.
 */
void init() {}

/**
 * Crea las carpetas necesarias para almacenar los datos del programa.
 * viajes/ - Para almacenar los archivos de viajes
 * informes/ - Para almacenar los informes generados
 */
void crearCarpetas() {}

/**
 * Carga los viajes existentes desde archivos de texto.
 * Lee todos los archivos .txt de la carpeta de viajes y carga sus datos
 * en los ArrayLists correspondientes para su uso en memoria.
 */
void cargarViajes() {}

/**
 * Lee los datos de un archivo de viaje y los carga en los ArrayLists.
 * Lee línea por línea el archivo de texto, extrae los valores eliminando
 * las cabezeras y los almacena en los ArrayLists correspondientes.
 *
 * @param archivoActual Archivo de texto que contiene los datos del viaje
 */
void leerViajeArchivo(File archivoActual) {}

/**
 * Permite al usuario planificar un nuevo viaje.
 * Solicita al usuario todos los datos necesarios para un viaje:
 * ciudad, país, moneda, fechas, transporte, número de personas, actividad principal y presupuesto.
 * Muestra un resumen y pregunta si desea guardar el viaje.
 */
void planificarViaje() {}

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
     String fechaFin, String transporte, String numPersonas, String actividad, String presupuestoStr) {}

/**
 * Muestra una lista numerada de todos los viajes almacenados.
 * Presenta cada viaje con su número, ID, ciudad y país.
 */
void mostrarViajes() {}

/**
 * Muestra todos los detalles de un viaje específico.
 * Presenta información completa del viaje seleccionado por índice,
 * incluyendo todos los campos almacenados.
 *
 * @param indice Índice real del viaje en las listas (1a posición tiene indice real 0)
 */
void mostrarDetallesViaje(int indice) {}

/**
 * Genera un informe detallado de un viaje seleccionado.
 * Permite seleccionar un viaje de la lista y crea un archivo de informe almacenado en una carpeta concreta.
 * Los datos se leen directamente del archivo original del viaje, no de los ArrayLists.
 */
void generarInforme() {}

/**
 * Elimina un viaje seleccionado.
 * Permite seleccionar un viaje de la lista, lo elimina de todas las listas en memoria
 * y borra su archivo correspondiente del sistema de archivos.
 */
void eliminarViaje() {}

/**
 * Lee un número entero del usuario con validación de rango.
 * Solicita al usuario una entrada y valida que sea un número entero válido dentro
 * del rango especificado. Continúa pidiendo entrada hasta que se proporcione un valor válido.
 *
 * @param min Valor mínimo aceptable (inclusive)
 * @param max Valor máximo aceptable (inclusive)
 * @return Número entero válido dentro del rango especificado
 */
int leerNumero(int min, int max) {}
```
