# Report Generator

## Overview

The Report Generator is a Java Spring Boot service that ingests feed files in CSV format, applies configurable transformation rules using reference data, and generates transformed reports. The service can handle large files (up to 1GB) and can be scheduled to run at specific times. Additionally, report generation can be triggered via a REST API.

## Features

- Ingest CSV feed files and reference data
- Configurable transformation rules
- Generate reports in CSV format
- Handle large files efficiently
- Schedule report generation
- Trigger report generation via REST API
- Extensible to support other formats (e.g., Excel, JSON)

## Requirements

- Java 17
- Maven 3.6+
- Spring Boot 3.3.2

## Dependencies

- Spring Boot Starter Batch
- Spring Boot Starter Data JPA
- Spring Boot Starter Quartz
- Spring Boot Starter Web
- Spring Cloud Starter Zookeeper Config
- Spring Boot DevTools
- H2 Database
- Lombok
- Spring Boot Starter Test
- Spring Batch Test
- Apache Commons CSV 1.10

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/DeepaliVerma011/report-generator.git
   cd report-generator
Build the project using Maven:

bash

mvn clean install
Run the application:

bash

mvn spring-boot:run
Configuration
Configure the transformation rules and schedules in the application.yml file.
Usage
REST API
Trigger Report Generation:

http

POST /api/reports/generate
Request Parameters:

inputFile (MultipartFile): The input CSV file.
referenceFile (MultipartFile): The reference CSV file.
Example Request:

bash

curl -X POST http://localhost:8080/api/reports/generate \
-F "inputFile=@path/to/input.csv" \
-F "referenceFile=@path/to/reference.csv"
Code Structure
src/main/java/com/example/reportgenerator:
controller: Contains REST controllers.
model: Contains data models for input and reference data.
service: Contains services for file processing and report generation.
utils: Contains utility classes.
ReportGeneratorApplication.java: The main application class.
Example Transformation Rules
outfield1 = field1 + field2
outfield2 = refdata1
outfield3 = refdata2 + refdata3
outfield4 = field3 * max(field5, refdata4)
outfield5 = max(field5, refdata4)
Logging
The application uses SLF4J for logging. Logs can be configured in the application.yml file.
Testing
Unit tests are provided in the src/test directory.

To run tests:

bash

mvn test
License
This project is licensed under the MIT License.

Contributing
Fork the repository.
Create a new branch.
Make your changes.
Commit and push your changes.
Create a pull request.
Contact
For issues and inquiries, please open an issue on GitHub.



Feel free to customize the `README.md` file according to your project's specifics and requirements.