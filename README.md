# ✈️ Skyline - Flight Booking Management System

A comprehensive flight booking management system built with **JavaFX** frontend and **MySQL** database backend, featuring secure user authentication and role-based access control.

## � Technologies Used

- **Frontend**: JavaFX 20.0.1 with FXML
- **Backend**: Java 20 with Maven
- **Database**: MySQL 8.0.28
- **ORM**: Hibernate 5.6.15
- **Security**: BCrypt password hashing
- **UI Framework**: BootstrapFX 0.4.0, FormsFX 11.6.0
- **Build Tool**: Maven
- **Testing**: JUnit 5.10.2

## 📋 Key Features

- 🔐 **Secure User Authentication** with BCrypt password hashing
- 👥 **Role-Based Access Control** (Admin/Agent roles)
- 📝 **User Registration & Validation**
- 🔑 **Password Reset Functionality**
- 🎨 **Modern UI** with BootstrapFX styling
- 🗄️ **Database Integration** with Hibernate ORM

## �👤 Contributor: Ali Derar Ali Yaqoub

### My Role in the Project:
I was responsible for the **User Authentication** module. This included:

- 🔒 **Forget Password View & Logic** - Implemented secure password reset workflow
- 📝 **Register View & Logic** - Created user registration with form validation
- 🔐 **Login System** - Developed authentication with BCrypt password verification
- 🎨 **UI/UX Design** - Designed responsive user interfaces using JavaFX and BootstrapFX

### Technical Implementation:
- **Frontend**: JavaFX controllers with FXML views
- **Backend**: Java services with DAO pattern
- **Security**: BCrypt for password hashing and validation
- **Database**: MySQL with Hibernate ORM integration
- **Validation**: Client-side and server-side form validation
- **Error Handling**: Comprehensive exception handling and user feedback

## 🛠️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── application/          # Main application entry point
│   │   ├── controller/           # FXML controllers (Login, Register)
│   │   ├── model/               # Data models and entities
│   │   ├── database/            # Database layer and repositories
│   │   └── util/                # Utility classes
│   └── resources/
│       ├── view/                # FXML view files
│       └── hibernate.cfg.xml    # Database configuration
```

## 📊 Database Schema

The application uses a MySQL database with the following main tables:
- **users** - User authentication and profile data
- **flights_booking** - Flight booking management
- **permissions** - Role-based permissions

## 🔧 Setup & Installation

### Prerequisites
- Java 20 or higher
- MySQL 8.0+
- Maven 3.6+
- IDE with JavaFX support (IntelliJ IDEA recommended)

### Database Setup
1. Create MySQL database: `UserRegistration`
2. Update database credentials in `model/Users.java`
3. Run the provided SQL scripts to create tables

### Running the Application
1. Clone the repository
2. Navigate to project directory
3. Run: `mvn clean javafx:run`
4. Application will launch on the main login screen

## 🎯 Project Highlights

- **Security First**: Implemented industry-standard password hashing with BCrypt
- **Clean Architecture**: Followed MVC pattern with proper separation of concerns
- **Modern UI**: Responsive design with BootstrapFX and FormsFX
- **Database Integration**: Seamless MySQL connectivity with Hibernate ORM
- **Error Handling**: Comprehensive validation and user-friendly error messages
- **Scalable Design**: Modular architecture ready for future enhancements

## 📈 Learning Outcomes

This project demonstrates expertise in:
- Enterprise Java development with modern frameworks
- Database design and ORM implementation
- Security best practices in authentication systems
- UI/UX design with JavaFX
- Software architecture patterns (MVC, DAO)
- Build automation with Maven
- Version control and project management

