# Dream API — Endterm Project

## A. Project Overview

Dream API is a RESTful web application developed using Spring Boot.  
The project manages Dream entities and provides full CRUD functionality through a REST API.

The main goal of this project is to demonstrate understanding of:
- REST architecture
- layered application design
- object-oriented principles
- design patterns
- proper error handling

---

## B. Technologies Used

- Java 17
- Spring Boot
- Maven
- Postman

---

## C. Application Architecture

The project follows a layered architecture:

- Controller layer — handles HTTP requests and responses
- Service layer — contains business logic
- Repository layer — handles database access
- DTO layer — separates API models from entities
- Model layer — domain entities
- Exception layer — global error handling
- Patterns & Utils — design patterns implementation

This structure improves readability, testability, and maintainability.

---

## D. Component Principles

The application follows basic component design principles:

**REP (Reuse-Release Equivalence Principle)**  
Classes that change together (e.g. service and repository logic) are grouped in the same packages.

**CCP (Common Closure Principle)**  
Changes related to business logic usually affect only the service layer, without impacting controllers or repositories.

**CRP (Common Reuse Principle)**  
Independent components (DTOs, exceptions, patterns) are separated to avoid unnecessary coupling.

---

## E. Design Patterns Used

### Singleton
`AppLogger` is implemented as a Singleton to ensure only one logging instance is used across the application.

### Builder
The Builder pattern is implemented inside the `Dream` entity to simplify object creation and improve readability.

### Factory
`DreamFactory` encapsulates the logic of creating different dream types  
(`NormalDream`, `LucidDream`, `NightmareDream`) based on input data.

---

## F. REST API Endpoints

| Method | Endpoint | Description | Status |
|------|--------|------------|--------|
| POST | `/api/dreams` | Create a new dream | 201 |
| GET | `/api/dreams` | Get all dreams | 200 |
| GET | `/api/dreams/{id}` | Get dream by ID | 200 / 404 |
| PUT | `/api/dreams/{id}` | Update dream | 200 |
| DELETE | `/api/dreams/{id}` | Delete dream | 204 |

---

## G. Sample JSON Requests & Responses

### Create Dream (POST)

```json
{
  "title": "Flying",
  "description": "I was flying over the city",
  "type": "LUCID",
  "intensity": 8
}
```

### Response

```json
{
  "id": 1,
  "title": "Flying",
  "description": "I was flying over the city",
  "type": "LUCID",
  "intensity": 8
}
```
---

## H. Error Handling

Global exception handling is implemented using @RestControllerAdvice.
Handled errors:
- Resource not found (404 Not Found )
- Invalid input data

Errors are returned in a structured format using the **ApiError** class.

Example error response:
```json
{
  "message": "Dream not found",
  "status": 404
}
```
---

## I. Database Design
The application uses PostgreSQL with a single main table:

**dreams**
- id (Primary Key)
- title
- description
- type
- intensity

Hibernate is used for ORM mapping.

---

## J. UML Diagram

The UML diagram reflects:

- layered architecture
- entity relationships
- inheritance
- applied design patterns

Location:
```bash
docs/uml.png
```

---

## K. Postman Testing
All API endpoints were tested using Postman.


Screenshots are located in:
```bash
docs/screenshots/
```
Included tests:
- POST → 201 Created
- GET all → 200 OK
- GET by ID → 200 OK
- PUT → 200 OK
- DELETE → 204 No Content
- GET after delete → 404 Not Found
---

## L. How to Run the Project
1. Create a PostgreSQL database
2. Update **application.properties** with database credentials
3. Run the Spring Boot application
4. Test endpoints using Postman

---

## M. Reflection
This project helped me better understand how REST APIs are structured in Spring Boot.
I gained practical experience with layered architecture, design patterns, and global error handling.
The UML design helped visualize the system before implementation.

---



