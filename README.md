# serverlessDemoAWSHandler
Demo para utilizar una aplicación Spring Boot con AWS Lambda functions

**Atención: Esta demo es un ejemplo y no tiene una lógica de negocio, solo responde con los valores de la petición que recibe**

## Publicar en AWS

Para generar los archivos necesarios para S3:
```bash
./mvnw clean package
```
Como cada función Lambda solo puede ejecutar una función, habrá que crear una para cada una que contenga nuestra aplicación:
1. Subimos a un bucket de S3 el fichero acabado en `-aws.jar`.

2. Creamos una Lambda function utilizando el runtime Java 8 y la dirección del bucket S3 con el fichero `-aws.jar` que hemos subido.

3. Configurar el handler para que sea `eu.arima.serverlessDemo.handlers.HandlerReservationMock::handleRequest`

## API Gateway
