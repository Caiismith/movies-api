# movies-api
# Senior Developer Interview Assignment

Reads in a JSON file of movies, stores it in a Mongo database and provides Get methods for a web application to interrogate the data.

## Requirements
- Java 8
- Maven
- MongoDB
- Git

## How to run
- With mongodb installed, open a window in your terminal and run `mongod --port 12121`
- Within your IDE - Click Run on the `MoviesApiApplication`
- Alternatively from the command line - go to the `movies-api` repoistory and run `mvn spring-boot:run`
- This will be running on port `8080` - see below for a list of requests

## Requests Available
- `http://localhost:8080/movies` - return all movies
- `http://localhost:8080/movies/most-liked` - return the movie with the highest number of likes
- `http://localhost:8080/movies/{title}` - return a specific movie by title, replacing {title} with movie title
- `http://localhost:8080/movies/id/{movieId}` - return a specific movie by id, replacing {movieId} with movie id
- `http://localhost:8080/comments` - return all comments
- `http://localhost:8080/comments/most-active` - return a list of the most active users comments
