# Example Performance Testing Project

This is a simple Spring Boot project that provides a REST API used for comparing performance between a java implementation and N-CAPIE implementation. Below you will find instructions for running the project and accessing the API documentation through Swagger, as well as using the provided Postman collection.

## Prerequisites

- Java 17 or higher
- Maven 3.8.0 or higher

## Building the Project

To build the project use:

```sh
mvn clean install
```

## Running the Project

To run the project use:

```bash
mvn spring-boot:run
```

This will start the server on `http://localhost:8080`.

## Accessing Swagger UI

Once the application is running, you can view the API documentation through Swagger by visiting the following URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

You can access the json version of the API documentation by visiting the following URL:

[http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Using Postman Collection

A Postman collection is included in the root directory of the project. You can import this collection into Postman to easily test the available APIs.

To import the collection:

1. Open Postman.
2. Click on "Import".
3. Select the file named `Postman_Collection.json` located in the base folder of this project.

This will import all the necessary requests for interacting with the API endpoints. This collection Include requests for this implementation as well as for the N-CAPIE implementation.