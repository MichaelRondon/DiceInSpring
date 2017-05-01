# DiceInSpring
Pequeña aplicación que expone el servicio de un lanzamiento de dados. Desarrollada en SpringBoot 

Requisitos:
- Requere java 8

Uso:
- Descargar el archivo dice-1.0.jar
- En una terminal ir a la ruta del archivo dice-1.0.jar
- Ejecutar el siguiente comando:
<code> java -jar -Dserver.port=[PUERTO] dice-1.0.jar</code>
  donde [PUERTO] puede ser cualquier puerto disponible para que el servidor Tomcat embebido levante la aplicación.
  
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
