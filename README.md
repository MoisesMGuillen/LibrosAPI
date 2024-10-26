# LibrosAPI
Proyecto de Spring Boot y Maven que consume datos de la API de Gutendex para obtener información de libros y autores.

# Descripción
Con esta aplicación, usando la línea de comandos, permite: 
Obtener y mostrar información básica sobre libros y autores de Gutendex.
Ver los libros más descargados.
Realizar una búsqueda específica de un libro por título.
Calcular estadísticas de descargas de los libros.

# Requisitos
- Java 17+
- Maven 3.6+
- Spring Boot 2.7+
- Instalación

**Clona este repositorio:**
git clone https://github.com/MoisesMGuillen/LibrosAPI.git

# Estructura del Proyecto
El proyecto está compuesto por las siguientes clases:

1. LibrosApiApplication.java
Clase principal que inicializa la aplicación y despliega el menú principal.

2. ConsumeAPI.java
Clase encargada de realizar la solicitud HTTP a la API de Gutendex y obtener los datos en formato JSON.

3. ConstructorDeDatos.java
Clase que convierte el JSON recibido en objetos Java específicos, utilizando Jackson.

4. DatosLibros.java
Modelo de datos que representa los detalles de un libro. Incluye el título, los autores y el número de descargas.

5. DatosAutor.java
Modelo de datos que representa la información de un autor, incluyendo el nombre y año de nacimiento.

6. Libros.java
Modelo que contiene una lista de objetos DatosLibros, representando el conjunto de libros recibidos.

7. Menu.java
Clase que despliega el menú y opciones de interacción, como:
  - Mostrar los primeros 5 libros
  - Listar los 10 libros más descargados
  - Realizar una búsqueda de libros
  - Calcular estadísticas básicas de descargas

# Uso
Al iniciar la aplicación, se despliega un menú en la consola con las opciones disponibles.
Los usuarios pueden ver los libros más populares, buscar títulos específicos y ver estadísticas de descarga.

# Dependencias
- Spring Boot Starter
- Jackson Databind (para el mapeo de JSON a POJOs)
- Java HttpClient (para consumir la API)
- API

# Autor
Desarrollado por Moises Morales Guillen.

**La aplicación consulta la API pública de Gutendex para obtener datos de libros.**
Puedes explorar la API en https://gutendex.com.
