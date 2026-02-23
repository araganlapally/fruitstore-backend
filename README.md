# Fruit Store Backend

## Tech Stack
- Java
- Spring Boot
- MySQL
- Docker

## Features
- RESTful APIs
- Product CRUD operations
- Database integration
- Exception handling
- CORS configuration

## How to Run Locally
1. Clone the repository
2. Configure application.properties
3. Run using:
   mvn spring-boot:run

## Run Using Docker
1. Build Image:
   docker build -t fruitstore-backend .
2. Run Container:
   docker run -p 8080:8080 fruitstore-backend
