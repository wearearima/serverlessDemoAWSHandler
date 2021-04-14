# serverlessDemoAWSHandler
Spring Boot demo using AWS Lambda functions with the AWS SDK Handler.

**WARNING: This demo is just an example and doesn't have proper business logic, it just answers with the values that it receives**

## Publish on AWS

To generate the necessary files for S3:
```bash
./mvnw clean package
```
After that finishes, we'll create the function as follows:
1. We upload to a S3 bucket the file in the `target` directory ending in `-aws.jar`.

2. We create a Lambda function and choose `Java8` as its runtime and the url of the S3 bucket file that we just uploaded.

3. We change the functions handler to `eu.arima.serverlessDemo.handlers.HandlerReservationMock::handleRequest`

AWS Lambda offers more customization options where you can choose from, as setting environment variables or memory allocation. These configurations are not needed to run this basic demo though, so they won't be covered.
