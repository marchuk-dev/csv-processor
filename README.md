Simple CSV file processor.
<details lang="java">
<summary>How to start:</summary>

<summary>In Intellij Idea:</summary>

1. Clone the project.
```
gh repo clone marchuk-engineer/csv-processor
```
2. Run the server
```
mvn spring-boot:run
```
</details>

<details lang="java">
<summary>Enpoints:</summary>
  
**CSV Controller** - CSV Operations
| HTTP method |         Endpoint         |      Description          |
|:-----------:|:------------------------:|:-------------------------:|
|     POST     | `localhost:8080/api/csv/upload` |Uploads a CSV file to the server|
|     GET     | `localhost:8080/api/csv/search?query=john` |   Disable notifications   |


**Metrics and HealthCheck Controller**
| HTTP method |         Endpoint         |      Description          |
|:-----------:|:------------------------:|:-------------------------:|
|     GET     | `localhost:8080/actuator/metrics` |Get metrics|
|     GET     | `localhost:8080/actuato/health` |  Get health   |

</details>

REST Service:

✅ Develop a RESTful API.
📄 Provide API documentation.
🩺 Implement a health check endpoint.
📊 Implement metrics to monitor the service.
CSV File Upload Endpoint:

✅ Create an HTTP endpoint to upload CSV files.
✅ Upon upload, parse the CSV file and store the data in a database.
🔄 Optional: Support for different CSV formats (e.g., delimiter variations).
Search Endpoint:

✅ Create an HTTP endpoint to search within the parsed CSV data.
📝 Optional: Implement full-text search capabilities.
Next Steps
Implement API documentation using Swagger to describe the endpoints and their functionalities.
Add health check endpoint and integrate metrics monitoring for the service using Spring Boot Actuator and Micrometer.
Enhance CSV file handling to support different formats if needed, ensuring robust parsing and data storage capabilities.
Consider implementing full-text search using Hibernate Search or a suitable library to enable advanced searching within the CSV data.
