# 🧳 Gestor de Viajes - Aplicación Java
**Gestor de Viajes** es una aplicación de consola desarrollada en Java que permite planificar, gestionar y organizar viajes personales de manera sencilla y eficiente. Diseñada para usuarios que buscan una herramienta gratuita, intuitiva y sin complicaciones para controlar sus presupuestos de viaje.

## ✨ Características Principales

- **Planificación Completa**: Captura todos los datos esenciales de un viaje  
- **Generación de Informes**: Reportes detallados en formato estructurado  
- **Persistencia de Datos**: Almacenamiento en archivos .txt para recuperación  
- **Interfaz Intuitiva**: Menú interactivo con validaciones robustas  
- **Sistema de Archivos**: Organización automática en carpetas específicas  

## 🏗️ Arquitectura del Proyecto

```
proyectoGestorViajes/
├── documentacion/
│   ├── ExplicaciónMetodos.md
│   └── primeraEntrega_gestorViajes.md
├── viajes/                             # Archivos de datos de viajes
│   ├── VIAJE_1.txt
│   └── VIAJE_2.txt
├── informes/                           # Informes generados
│   ├── informe_VIAJE_1.txt
│   └── informe_VIAJE_2.txt
├── Main.java                           # Código fuente principal
└── README.md
```

## 🎯 Guía de Uso

### 1. Menú Principal
```
--- Menú Principal ---
1. Planificar un viaje
2. Mostrar viajes
3. Generar informe
4. Eliminar viaje
5. Salir
```

### 2. Planificar un Nuevo Viaje
- **Ciudad y País**: Destino del viaje
- **Moneda**: Tipo de moneda para el presupuesto
- **Fechas**: Inicio y fin (formato DD/MM/AAAA)
- **Transporte**: Opciones predefinidas (Avión, Tren, Autobús, Coche)
- **Personas**: Número de personas que acuden al viaje
- **Actividad**: Tipo principal (Parque Natural, Cultural, Lúdica, Gastronómica)
- **Presupuesto**: Cantidad numérica positiva
- **Confirmación**: Resumen antes de guardar con opción de descartar el viaje sin guardarlo

### 3. Funcionalidades Adicionales
- **Mostrar viajes**: Lista numerada con ID, ciudad y país
- **Generar informe**: Crea reporte detallado en carpeta `informes/`
- **Eliminar viaje**: Borra viaje de lista y archivo correspondiente

## 💾 Gestión de Datos

### Estructuras Utilizadas
- **ArrayLists**: Para almacenamiento en memoria
- **Archivos .txt**: Para persistencia de datos
- **Scanner**: Para entrada de usuario
- **FileWriter/PrintWriter**: Para escritura de archivos

### Formato de Archivo
```
ID: VIAJE_1
Ciudad: París
País: Francia
Moneda: euros
Fecha inicio: 01/06/2026
Fecha fin: 10/06/2026
Transportes: Avión
Personas: 2
Actividades: Cultural
Presupuesto: 1500
```

## 🔧 Estructuras de Control Implementadas

### Condicionales
- `if-else` para validaciones y decisiones
- `switch-case` para menús de opciones

### Bucles
- `do-while` para menú principal
- `while` para validación de entrada
- `for` para iteración sobre listas

### Manejo de Excepciones
- `try-catch` para operaciones de archivo
- Validación de entrada numérica
- Verificación de existencia de archivos

## 📊 Ejemplo de Uso

### Caso 1: Planificar Viaje a París
```
Ciudad: París
País: Francia
Moneda: euros
Fechas: 01/06/2024 - 10/06/2024
Transporte: Avión (opción 1)
Personas: 2
Actividad: Cultural (opción 2)
Presupuesto: 1500
```

### Caso 2: Generar Informe
```
1. Seleccionar "Generar informe"
2. Elegir viaje de la lista
3. Informe creado en: informes/informe_VIAJE_1.txt
```

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java
- **Manejo de Archivos**: java.io (File, FileWriter, PrintWriter)
- **Control de Versiones**: Git + GitHub
- **Documentación**: JavaDoc

## 👥 Autores

**Lucía Martínez** - Coordinación del proyecto, arquitectura del sistema y documentación
**Julio Arango** - Investigación de requerimientos, diseño de interfaz de usuario y documantación

## 🔮 Mejoras Futuras

- Interfaz gráfica con JavaFX
- Exportación a PDF/Excel
- Sistema multiusuario
- Conexión a APIs (clima, cambio moneda)
- Búsqueda y filtrado avanzado
- Estadísticas y gráficos

---

**Proyecto con finalidades académicas - La Salle Gràcia**

