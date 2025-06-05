# actuator-demo
This application demonstrates how to create a custom Spring Boot Actuator endpoint.

Available APIs
List all actuator endpoints
GET - http://localhost:8081/actuator-demo/actuator

Get custom status
GET - http://localhost:8081/actuator-demo/actuator/custom-status

Get application status
GET - http://localhost:8081/actuator-demo/actuator/custom-status/application

Delete application status
DELETE - http://localhost:8081/actuator-demo/actuator/custom-status/application

Set application status
POST - http://localhost:8081/actuator-demo/actuator/custom-status/application
Request Body (JSON):
{
  "statusHolder": false
}
