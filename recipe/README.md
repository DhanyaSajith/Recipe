# Recipe Management REST API
The Recipe Management REST API is a Java-based application built with Spring Boot that allows users to manage their favorite recipes. It provides endpoints for adding, updating, removing, and fetching recipes, along with the ability to filter recipes based on various criteria.

## Features

- Add a new recipe: Create a new recipe by providing the recipe details, including name, instructions, ingredients, servings, and whether it's vegetarian or not.
- Update a recipe: Update the details of an existing recipe by providing the recipe ID and the updated information.
- Remove a recipe: Remove a recipe from the collection based on its ID.
- Fetch a recipe: Retrieve the details of a specific recipe by its ID.
- Filter recipes: Filter the available recipes based on criteria such as vegetarian/non-vegetarian, number of servings, specific ingredients, or text search within instructions.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA (for data persistence)
- H2 database (or any other supported database)
- Maven (for build and dependency management)
- JUnit 5 and Mockito (for unit testing)

## Getting Started

1. Clone the repository:
git clone https://github.com/DhanyaSajith/Recipe

2. Configure the Database:
Update the database connection details in the `application.properties` file located in the `src/main/resources` directory.

3. Build the Application

4. Run the Application

5. Test the API

## Data Models
The API uses the following data model:

### Recipe

•	id (Long)

•	name (String)

•	instructions (String)

•	vegetarian (Boolean)

•	servings (Integer)

•	ingredients (List<String>)

## Repository

•	RecipeRepository

## Service

•	RecipeService

•	RecipeServiceImpl

## Controller

•	RecipeController

## Testing

Note:Here RecipeController uses the RecipeServiceImpl class to handle the business logic and the @RestController and @RequestMapping annotations to define the API endpoints.
Unit tests have been implemented to ensure the correctness of the application.Unit test has been done for service and controller and testing was successful.

## API Endpoints
The API endpoints can be accessed at

http://localhost:8080/recipes

GET /recipes: Retrieves all recipes

GET /recipes/{id}: Retrieves a specific recipe by ID

POST /recipes: Creates a new recipe

PUT /recipes/{id}: Updates an existing recipe

DELETE /recipes/{id}: Deletes a specific recipe by ID

GET /recipes/filter: Filters recipes based on specified criteria

Application is dockerized,but it's not functional due to some configuration issues.
