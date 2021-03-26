# serverlessDemoAWS
Demo para utilizar una aplicación Spring Boot con AWS Lambda functions y RDS

## Configuración
Modificar el fichero [application.properties](./src/main/resources/application.properties) y añadir el hostname y credenciales de la BD que se quiera utilizar (por ejemplo, la de una instancia RDS).

## Ejecutar
Lanzar la aplicación con:
````bash
./mvnw spring-boot:run
````
 Desde otra sesión de la terminal, se puede probar con comandos como:
 ```bash
 curl localhost:8080/saveItem -H "Content-Type: application/json" -d '{"itemName": "book", "number": 100}' 
 ```
 o
 ````bash
 curl localhost:8080/reserve -H "Content-Type: application/json" -d '{"itemName": "book", "number": 1}'
 ````

## Publicar en AWS

Es necesario configurar antes de nada la instancia de RDS y modificar el fichero [application.properties](./src/main/resources/application.properties) con el hostname y credenciales.

Para generar los archivos necesarios para S3:
```bash
./mvnw clean package
```
Como cada función Lambda solo puede ejecutar una función, habrá que crear una para cada una que contenga nuestra aplicación:
1. Subimos a un bucket de S3 el fichero acabado en `-aws.jar`.

2. Creamos una Lambda function utilizando el runtime Java 8 y la dirección del bucket S3 con el fichero `-aws.jar` que hemos subido.

3. Configurar el handler para que sea `org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest``

4. Modificar la memoria y el timeout a `1024MB` y `45s` respectivamente.

5. Añadir una variable de entorno llamada `spring_cloud_function_definition` con el nombre de la función que queramos ejecutar (por ejemplo, `reserve`).

Repetir pasos 2-5 por cada función que queramos.

Si en algún momento necesitamos modificar algún parámetro de conexión a la BD, podremos sobreescribirlos añadiendo variables de entorno a la función con el mismo nombre que la propiedad (sustituyendo los `.` por `_`). Por ejemplo:
```
spring.datasource.url
```
se sobreescribe con la variable de entorno
```
spring_datasource_url
```

## API Gateway
