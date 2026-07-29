# Skyline — Flight Booking Authentication Module

A group project from the Advanced Programming course at An-Najah National University. Skyline is a JavaFX desktop application for flight booking management. This repository contains the contributor's portion: the **user-authentication module** (login, registration, and password-reset screens plus their supporting service and DAO layers).

> The full Skyline system was a team effort. The code in this repo covers only the authentication slice described below.

## What's Implemented

| Component | File(s) | Description |
|---|---|---|
| Application entry point | `application/SkylineApplication.java` | JavaFX `Application` subclass; loads the initial FXML scene |
| Login controller | `controller/LoginController.java` | Handles credential input, calls BCrypt verification, navigates on success |
| Login view | `resources/view/login_page.fxml` | FXML layout wired to `LoginController` |
| Hello/landing controller | `controller/HelloController.java` | Post-login landing screen controller |
| `Users` model | `model/Users.java` | Hibernate entity with BCrypt password hashing; `save()`, `isEmailInDatabase()`, `updatePassword()` |
| DAO interface + impl | `database/interfaces/`, `database/repositories/UsersDAOImpl.java` | Repository pattern wrapping JDBC queries for user lookup and update |
| Flights booking model | `database/FlightsBookingModel.java` | Hibernate entity for the `flights_booking` table |
| Permission entity | `database/Permission.java` | Hibernate entity for the `permissions` table |
| Hibernate config | `resources/hibernate.cfg.xml` | MySQL connection and entity mappings |

## Tech Stack

| Component | Detail |
|---|---|
| Language | Java 20 |
| UI framework | JavaFX 20.0.1 with FXML |
| Build tool | Maven (Maven Wrapper included: `./mvnw`) |
| ORM | Hibernate 5.6.15 |
| Database | MySQL 8.0.28 |
| Password hashing | jBCrypt |
| UI styling | BootstrapFX 0.4.0, FormsFX 11.6.0 |
| Test dependency declared | JUnit Jupiter 5.10.2 |

## Project Structure

```
Advanced-Programming-Project/
├── pom.xml
├── mvnw / mvnw.cmd           # Maven Wrapper
└── src/
    └── main/
        ├── java/
        │   ├── application/  # JavaFX Application class
        │   ├── controller/   # FXML controllers (Login, Hello)
        │   ├── database/     # Hibernate entities, DAO interfaces, UsersDAOImpl
        │   │   ├── interfaces/
        │   │   └── repositories/
        │   ├── model/        # Users entity (BCrypt + JDBC helpers)
        │   └── util/         # Utility classes
        └── resources/
            ├── hibernate.cfg.xml
            ├── images/
            └── view/         # FXML layouts (login_page.fxml, hello-view.fxml)
```

## Build & Run

### Prerequisites

- Java 20+
- MySQL 8.0 running locally
- Maven 3.6+ (or use the included wrapper)

### Database setup

```sql
CREATE DATABASE UserRegistration;
-- Run your project's schema scripts to create the users, flights_booking,
-- and permissions tables.
```

Update the connection URL and credentials in `src/main/resources/hibernate.cfg.xml` before running.

### Run the application

```bash
./mvnw clean javafx:run
```

### Run tests

```bash
./mvnw test
```

## Security Note

`src/main/java/model/Users.java` currently contains a **hardcoded database password** in the source. Before sharing or deploying this code, move credentials to environment variables or an external configuration file and rotate the committed password.

---

*Software Engineering degree, An-Najah National University*
