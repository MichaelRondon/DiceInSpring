# DiceInSpring
Pequeña aplicación que expone el servicio de un lanzamiento de dados. Desarrollada en SpringBoot 

Requisitos:
- Requere java 8

Uso:
- Descargar el proyecto.
- En una terminal ir a la ruta del archivo dice-1.0.war
- Ejecutar el siguiente comando:
<code> java -jar -Dserver.port=[PUERTO] dice-1.0.war</code>
  donde [PUERTO] puede ser cualquier puerto disponible para que el servidor Tomcat embebido levante la aplicación.
  
Peticiones:
Mediante una herramienta para el consumo de servicios REST se puede probar la aplicación.

Endpoint: http://[HOST]:[PUERTO]/app/dice

Metodo: POST

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



Respuesta:

<code>
{
  "text":"",
  "value":0
}
</code>
