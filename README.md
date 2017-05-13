# DiceInSpring
Pequeña aplicación que expone el servicio de un lanzamiento de dados. Desarrollada en SpringBoot 

Requisitos ejecución:
- Requere java 8

Requisitos de instalación:
- Maven https://maven.apache.org/install.html

Uso sin Docker:
- Descargar el contenido del repositorio.
- Descomprimir el archivo DiceInSpring-master.zip
- En una terminal ingresar a la ruta DiceInSpring-master\dice donde se encuentra el archivo pom.xml
- Ejecutar el comando <code>mvn clean install package</code>
- Ejecutar el siguiente comando:
<code> java -jar -Dserver.port=[PUERTO] target/dice-1.0.jar</code>
  donde [PUERTO] puede ser cualquier puerto disponible para que el servidor Tomcat embebido levante la aplicación.
- Ingresar a la ruta http://localhost:[PUERTO] en un navegador. Debe generarse una página con el mensaje Dice!
- Para ver la firma de los servicios expuestos ingresar a http://localhost:[PUERTO]/swagger-ui.html
  
Uso con Docker!!!:
  Si se tiene instalado Docker y Maven:
  - Descargar el repositorio.
  - Descomprimir el contenido.
  - Ingresar al directorio DiceInSpring-master\dice
  - Ejecutar el archivo Ejecutar.bat
  
Peticiones:
Mediante una herramienta para el consumo de servicios REST se puede probar la aplicación.

Endpoint: http://[HOST]:[PUERTO]/app/dice

Método: POST

Content-Type: application/json

Body: A continuación un ejemplo para la petición.

<code>
{
  "modifier":0,
  "repetitions":1,
  "faces":6,
  "name":"German"
}
</code>



Respuesta: A continuación un ejemplo para la respuesta.

<code>
{
  "text":"",
  "value":0
}
</code>
