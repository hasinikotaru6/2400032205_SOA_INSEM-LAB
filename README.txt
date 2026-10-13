ROUND-ROBIN LOAD BALANCING - STS PROJECT
Compatibility: Java 17, Spring Boot 3.3.5, Spring Cloud 2023.0.3.

IMPORT
1. Extract this ZIP.
2. STS > File > Import > Maven > Existing Maven Projects.
3. Select the extracted root folder containing pom.xml. Finish.
4. Right-click the root project > Maven > Update Project. Select Force Update if dependencies are not resolved.

RUN
Start in this order:
1. eureka-server/src/main/java/.../EurekaServerApplication.java as Spring Boot App.
2. driver-service/.../DriverServiceApplication.java as Spring Boot App (first instance uses port 8081).
3. To start another instance: Run > Run Configurations > Spring Boot App > select DriverServiceApplication configuration > Arguments > Program arguments:
   --server.port=8082
   Click Apply, Run. Create another launch configuration with --server.port=8083.
   Important: do not try to start all three on the same port.
4. api-gateway/.../ApiGatewayApplication.java as Spring Boot App.

VERIFY
Wait for all three DRIVER-SERVICE instances to register at http://localhost:8761.
Send GET requests repeatedly to:
http://localhost:8080/drivers/instance
Responses should rotate among ports 8081, 8082, and 8083. Initial requests may repeat while Eureka and the load balancer update.
GET http://localhost:8080/drivers returns the sample driver list.

If Boot does not start:
- Check Window > Preferences > Java > Installed JREs: select JDK 17.
- Right-click root project > Maven > Update Project.
- Check Console for the first red ERROR line.
- Ensure ports 8761, 8080, 8081, 8082, 8083 are free.
