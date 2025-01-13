# ZonaFit-GYM
Repositorio de la aplicación ZonaFit en Java. Esta aplicación fue desarrollada dentro del curso de Udemy [Universidad Java][curso_udemy], el cual recomiendo ampliamente si deseas aprender a programar en este lenguaje de programación.

## Herramientas empleadas en el proyecto
* Java 17
* Spring Boot
* JPA/Hibernate
* MySQL
* Java Swing
* Postman

## Clonar el repositorio
Si deseas contribuir con la aplicación, puedes clonar el repositorio en tu PC con el SSH.
~~~
git clone git@github.com:BraulioIAC/ZonaFit-GYM-backend.git
~~~
También puede realizar una copia del repositorio en tu cuenta de GitHub con la acción _fork_, y escalar el proyecto por tu cuenta.

## Notas
### logback
El archivo **src/main/resources/logback-spring.xml** sirve para poder realizar _logs_ en la aplicación con la clase _slf4j_. La aplicación de escritorio no tiene el *salto de línea* por defecto, pero si deseas ocupar la aplciación con Swing, o quieres colocarlo como parte de otra capa de presentación, deberás añadir el salto de línea de la siguiente forma:
~~~
<pattern>%msg%n</pattern>
~~~

### Lombok
El proyecto incluye la **dependencia** de **Lombok**, por lo que puedes incluir las siguientes etiquetas en el modelo de _cliente_:
* @NoArgsConstructor // crea de forma automática el constructor con todos los miembros de la clase
* @AllArgsConstructor // crea de forma automática el constructors sin argumentos
* @Data // coloca los getters y setters de forma automática
* @ToString // crea de forma automática el método toString
* @EqualsAndHashCode

Y dejar únicamente los miembros de la clase `src/main/java/model/Cliente`. Yo no lo realicé para poder practicar la creación de los métodos necesarios para la clase.

### Seleccionar la aplicaión de presentación
Deberás comentar la anotación @SpringBootApplication de las clases que ejecutan una capa de presentación, exceptuando la que es de tu interés. Las que se encuentran disponibles para esta aplicación son:
+ src/main/java/ZonaFitApplication
+ src/main/java/ZonaFitSwing

[curso_udemy]:https://www.udemy.com/share/101Wlw3@5JDgz9ZDK0nw81HNBIyr_W7grBUFlmBnt6rT-zuEcedToPXJy-hv7CuxRVGnw6WvrQ==/
