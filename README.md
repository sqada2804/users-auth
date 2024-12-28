Users Authentication API
This project is a user authentication and management system built using Spring Boot. It allows for user registration, login, and management through a RESTful API. The application implements JWT (JSON Web Tokens) for secure authentication and supports role-based authorization.

Features
User Registration & Login: Allows users to register by providing their email, name, and password. Login authenticates the user and returns a JWT for further requests.
JWT Authentication: After logging in, users receive a JWT token that must be included in the Authorization header for all secured endpoints.
User Management: Users can be retrieved, updated, and deleted via authenticated API endpoints.
Role-Based Access Control: The system allows roles for users (e.g., USER), ensuring proper access control.
Technologies Used
Spring Boot: The core framework used for building the backend.
Spring Security: Provides authentication and authorization features for the API.
JWT: Ensures secure communication and token-based authentication.
MySQL: Used for data persistence, storing user information and roles.
Lombok: To reduce boilerplate code for model objects.
Swagger UI: For API documentation and interactive testing.
Endpoints
Authentication
POST /v1/auth/register: Register a new user. Requires a UserRequest object with name, email, and password.
POST /v1/auth/login: Log in with email and password, and receive a JWT token for authentication.
User Management
GET /v1/users/getUser/{userId}: Retrieve user details by user ID. Requires the JWT token in the Authorization header.
PUT /v1/users/updateUser/{userId}: Update user details such as name, email, and password. Requires the JWT token.
DELETE /v1/users/delete/{userId}: Delete a user by user ID. Requires the JWT token.
Architecture and Design
The project uses the Layered Architecture pattern to separate concerns into different layers:

Controller Layer: Handles HTTP requests and responses. It defines RESTful endpoints that interact with the service layer.
Service Layer: Contains the business logic for handling user-related operations such as registration, login, and user management.
Repository Layer: Interacts with the database using Spring Data JPA to persist user information.
Authentication Flow
User Registration: The user provides email, name, and password. The password is encoded using BCrypt before being stored in the database.
Login: The user logs in with email and password. If valid, the system generates a JWT token for the user.
Secure Endpoints: To access secured endpoints (e.g., retrieving, updating, or deleting users), users must include their JWT token in the Authorization header.
JWT Service
Generate Token: After a successful login, a JWT token is generated with the user’s ID as the subject and a predefined expiration date.
Validate Token: JWT tokens are validated for expiration, and the user’s identity is extracted from the token to perform actions on their behalf.
Design Pattern
The application follows a Layered Architecture (also known as N-Tier Architecture) which divides the code into distinct layers:

Controller Layer: Manages incoming HTTP requests and directs them to the appropriate services.
Service Layer: Contains the core business logic for managing users and generating JWT tokens.
Repository Layer: Interacts with the database, using Spring Data JPA to perform CRUD operations on the UserModel.
Additionally, Spring Security is used for securing the endpoints, and the JWT (JSON Web Token) design pattern is used for user authentication.
