# Users Authentication API

## Overview

The Users Authentication API is designed to allow the registration, login, and management of user accounts. It provides a set of endpoints to create a new user, log in, update user details, and delete user accounts, as well as to secure the application with JWT tokens.

## Technologies Used

- **Spring Boot**: A Java framework used for building the backend of the API.
- **Spring Security**: For authentication and authorization.
- **JWT (JSON Web Token)**: For securing the API and handling user sessions.
- **JPA (Java Persistence API)**: For database access.
- **PostgreSQL**: The object-relational database used to store user information.

## Features

- **User Registration**: Allows new users to create an account.
- **User Login**: Authenticates users and returns a JWT token.
- **User Information Update**: Allows users to update their email, name, and password.
- **User Deletion**: Enables users to delete their accounts.
- **Secure Endpoints**: All sensitive endpoints are protected by JWT authentication.

## API Endpoints

### Authentication

- **POST /v1/auth/register**: Registers a new user.
    - Request Body: 
    ```json
    {
      "name": "string",
      "email": "string",
      "password": "string"
    }
    ```
    - Response: Returns a JWT token.

- **POST /v1/auth/login**: Logs in a user and returns a JWT token.
    - Request Body: 
    ```json
    {
      "email": "string",
      "password": "string"
    }
    ```
    - Response: Returns a JWT token.

### User Management

- **GET /v1/user/getUser/{userId}**: Retrieves a user's information.
    - Headers: `X-User-Id: {userId}`
    - Response: Returns user details.

- **PUT /v1/user/updateUser/{userId}**: Updates the user's information.
    - Headers: `X-User-Id: {userId}`
    - Request Body: 
    ```json
    {
      "email": "string",
      "name": "string",
      "password": "string"
    }
    ```
    - Response: Returns a status code indicating success.

- **DELETE /v1/user/delete/{userId}**: Deletes the user account.
    - Headers: `X-User-Id: {userId}`
    - Response: Status code indicating successful deletion.

## Security

- **JWT Authentication**: Every sensitive endpoint requires a valid JWT token to access. This token is passed in the `Authorization` header as `Bearer <token>`.
- **User Roles**: The default role for new users is `USER`. This can be extended for more granular access control if necessary.

## Database Schema

The API uses a MySQL database with the following schema:

- **User Table**: Stores user information, including email, password, name, and role.
    - Columns:
      - `userId`: Primary key (Long)
      - `email`: Unique user email (String)
      - `password`: Encrypted password (String)
      - `name`: User's name (String)
      - `role`: User's role (String)

## Configuration

### Application Properties

- **JWT Secret**: The secret used for signing JWT tokens. Can be configured in the `application.properties` file.
- **Database Configuration**: Database connection details (URL, username, password) should be set in the `application.properties` file.

## JWT Token Expiry
Tokens have an expiration time set to the longest possible duration (Long.MAX_VALUE). You can modify the expiration time by editing the JwtServiceImpl class according to your needs.

## How to Clone and Run

### Prerequisites

- **JDK 17 or higher**.
- **MySQL (or any other relational database)**.
- **Maven** for dependency management.

### Steps to Clone and Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/users-auth-api.git
    ```

2. **Configure the database connection**:
   - Open the `src/main/resources/application.properties` file.
   - Set your MySQL database connection parameters (`url`, `username`, `password`) and JWT secret key.
   - Example for MySQL database:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
   spring.datasource.username=root
   spring.datasource.password=root
   jwt.secret=your_jwt_secret_key
