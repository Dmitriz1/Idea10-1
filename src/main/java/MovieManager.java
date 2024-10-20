public class MovieManager {
    public String[] movies = new String[0];
    public int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String movie) {
        String[] newMovies = new String[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int start = Math.max(movies.length - limit, 0);
        String[] lastMovies = new String[movies.length - start];

        for (int i = 0; i < lastMovies.length; i++) {
            lastMovies[i] = movies[movies.length - 1 - i];
        }
        return lastMovies;
    }
}