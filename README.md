Users Authentication API
Project Description
This project is a User Authentication API developed with Spring Boot, designed to manage user registration, login, update, and deletion. It uses JSON Web Tokens (JWT) to ensure secure authentication and authorization of requests, ensuring that only authenticated users can access protected resources.

The API provides the following key functionalities:
User Registration: Users can register by providing an email, password, and name.
User Login: Users can log in with their email and password, receiving a JWT token to access protected routes.
User Management: Users can view, update, and delete their personal information.
Secure Authentication: JWT is used to authenticate requests and ensure only authorized users can access protected routes.
Interactive Documentation: The API is fully documented with Swagger UI, which facilitates testing and visualizing all the API endpoints.

•	Technologies Used
Spring Boot: Framework for building Java-based microservices applications.
Spring Security: Framework for handling user authentication and authorization.
JWT (JSON Web Tokens): Standard for securely authenticating and authorizing requests.
JPA (Java Persistence API): API for interacting with the database.
Swagger: Tool for interactive API documentation.

•	Key Features
Authentication with JWT: The API uses JWT tokens to authenticate users and ensure that only those with a valid token can access protected resources.
User Registration and Login: Users can register on the platform with their name, email, and password, and can obtain a JWT token by logging in with their credentials.
User Management: Users can view, update, and delete their personal information.
Swagger Documentation: The API is documented with Swagger UI, allowing easy interaction with the API and testing endpoints.

•	Design Patterns Used
Filter Pattern: A JWT filter is used to authenticate incoming requests. This filter validates whether the JWT token is valid and sets the security context for each request.

Service Pattern: Business logic is encapsulated in the AuthServiceImpl and UserService services. Controllers delegate operations to these services to maintain a clean and scalable design.

Repository Pattern: The UserRepository interface abstracts the database access operations, allowing queries like finding a user by email or ID.

DTO Pattern: The DTO (Data Transfer Object) pattern is used to transfer data between system layers, as seen in the UserRequest, LoginRequest, UpdateInfoRequest, and TokenResponse classes.

•	API Endpoints
Authentication Routes (/auth)
POST /v1/auth/register
Registers a new user.
Request Body:
json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123"
}
Response:
json
{
  "accessToken": "jwt-token-here"
}
POST /v1/auth/login
Logs in with user credentials and returns a JWT token.
Request Body:
json
{
  "email": "john.doe@example.com",
  "password": "password123"
}
Response:
json
{
  "accessToken": "jwt-token-here"
}

User Routes (/users)
GET /v1/users/{userId}
Fetches user information.

Response:
json
{
  "userId": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
PUT /v1/users/{userId}
Updates user information.
Request Body:
json
{
  "name": "John Doe Updated",
  "email": "john.doe.updated@example.com"
}
Response:
json
{
  "userId": 1,
  "name": "John Doe Updated",
  "email": "john.doe.updated@example.com"
}
DELETE /v1/users/{userId}
Deletes a user from the platform.

Response: 204 No Content if the user was successfully deleted.
•	Project Structure
The project follows a standard Spring Boot project structure:

bash
Copiar código
/src
  /main
    /java
      /com
        /example
          /users_auth_api
            /controllers
            /dtos
            /repositories
            /services
            /commons
            /config
  /resources
    /application.properties
/controllers: Contains the API controllers that handle HTTP requests.
/dtos: Contains the Data Transfer Objects that define the structure of requests and responses.
/repositories: Contains repository interfaces for database interaction.
/services: Contains the business logic of the API.
/commons: Contains common entities and utilities.
•	Running the Project
Clone this repository:
bash
git clone https://github.com/username/users-auth-api.git
Navigate to the project directory:

bash
cd users-auth-api
Build the project:

bash
./mvnw clean install
Run the application:

bash
./mvnw spring-boot:run
The API will be available at http://localhost:8080.

Contributions
Contributions are welcome! If you find bugs or would like to add improvements, feel free to open an issue or a pull request.
