# 📝 Mi Block de Notas (Java Spring Boot Edition)

Una aplicación web robusta y completa para la gestión de notas, construida utilizando el ecosistema de **Java** y **Spring Boot**.
Combina la potencia de un backend empresarial con una interfaz ligera y dinámica.

## 🚀 Características

- **Gestión Integral:** Crear, Leer, Actualizar y Borrar notas (CRUD).
- **Persistencia SQLite:** Base de datos ligera embebida. La carpeta `/db` y el archivo de base de datos se autogeneran al iniciar.
- **Drag & Drop:** Reordenamiento visual de las notas con guardado automático de la posición.
- **Filtrado por Etiquetas:** Sistema dinámico para filtrar notas por categorías sin recargar la página.
- **UI Responsiva:** Interfaz limpia construida con Bootstrap 5 y Thymeleaf.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 8 (o superior).
- **Framework:** Spring Boot 2.7.18 (Spring Web y Spring Daa JPA).
- **Motor de Plantillas:** Thymeleaf.
- **Base de Datos:** SQLite (con dialecto sqlite-dialect).
- **Build Tool:** Maven.
- **Frontend:** HTML5, Bootstrap 5, JavaScript (Fetch API + SortableJS).

## 📋 Requisitos Previos

Para ejecutar este proyecto desde el código necesitas tener instalado:
- **Java JDK 1.8** o superior.
- **Maven** (Asegúrate de que el comando `mvn -v` funciona en tu terminal).

## 🔧 Instalación y Ejecución

Sigue estos pasos para levantar el servidor localmente:

### 1. Preparar el proyecto
Abre una terminal en la carpeta raíz del proyecto (donde está el archivo `pom.xml`).

### 2. Descargar dependencias y compilar
Ejecuta el siguiente comando para que Maven descargue Spring Boot y las librerías necesarias:

```bash
mvn clean install
```

El resultado compilado estará en la ruta `target/notas-java-8-1.0.0.jar`

### 3\. Iniciar la aplicación

**Opción A: En el mismo sistema con el plugin de Spring Boot:**

```bash
mvn spring-boot:run
```

**Opción B: En cualquier sistma que tenga JRE ejecuta directamente el archivo compilado desde el directorio en el que esté**

```bash
java -jar notas-java-8-1.0.0.jar
```

Verás los logs de Spring arrancando. Espera a ver un mensaje similar a:
`Started NotasApplication in X.XXX seconds`

### 4\. Acceder al navegador

Abre tu navegador web y visita:
[http://localhost:8080](http://localhost:8080) o http://direcciónIP:8080

> **Nota:** En la primera ejecución la aplicación creará automáticamente una carpeta `db` en el mismo directorio conteniendo el archivo `notas.db` que es la base de datos sqlite.

## 📂 Estructura del Proyecto

```text
/
 ├── db/                        # Se genera automáticamente (directorio)
 │   └── notas.db               # Se genera automáticamente (base de datos)
 ├── pom.xml                    # Gestión de dependencias Maven
 └── src
     └── main
         ├── java/com/ejemplo/notas
         │   ├── NotasApplication.java  # Clase Main
         │   ├── Note.java              # Entidad JPA (Modelo)
         │   ├── NoteRepository.java    # Interface de acceso a datos
         │   └── NoteController.java    # Controlador Web y API
         └── resources
             ├── application.properties # Configuración (conexión SQLite)
             └── templates
                 └── index.html         # Vista principal (Thymeleaf)
```

## 📝 Guía de Uso

1.  **Añadir Nota:** Rellena el texto, selecciona la fecha y añade etiquetas separadas por comas. Al pulsar "Añadir", el formulario se limpia automáticamente.
2.  **Organizar:** Arrastra y suelta las tarjetas para priorizar tus notas. El orden se guarda en tiempo real.
3.  **Filtrar:** Haz clic en los botones de etiquetas (ej: `trabajo`, `ideas`) para filtrar la lista.
4.  **Editar:** Pulsa el botón de lápiz (✏️) para editar el contenido en línea.

-----

Desarrollado con ❤️ y Java Spring Boot.
