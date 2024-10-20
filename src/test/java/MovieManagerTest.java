import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager movieManager = new MovieManager();

    @Test
    void addMovieCorrect() {
        movieManager.addMovie("Movie 1");
        movieManager.addMovie("Movie 2");

        String[] expected = {"Movie 1", "Movie 2"};
        Assertions.assertArrayEquals(expected, movieManager.findAll());
    }

    @Test
    void findAllMovies() {
        movieManager.addMovie("Movie 1");
        movieManager.addMovie("Movie 2");
        movieManager.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        Assertions.assertArrayEquals(expected, movieManager.findAll());
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        movieManager.addMovie("Movie 1");
        movieManager.addMovie("Movie 2");
        movieManager.addMovie("Movie 3");
        movieManager.addMovie("Movie 4");
        movieManager.addMovie("Movie 5");
        movieManager.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        Assertions.assertArrayEquals(expected, movieManager.findLast());
    }

    @Test
    public void testFindLastWithCustomLimit() {
        movieManager = new MovieManager(3);
        movieManager.addMovie("Movie 1");
        movieManager.addMovie("Movie 2");
        movieManager.addMovie("Movie 3");
        movieManager.addMovie("Movie 4");
        movieManager.addMovie("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3"};
        Assertions.assertArrayEquals(expected, movieManager.findLast());
    }

    @Test
    public void testFindLastWhenNoMovies() {
        String[] expected = {};
        Assertions.assertArrayEquals(expected, movieManager.findLast());
    }

    @Test
    public void testFindLastLessThanLimit() {
        movieManager.addMovie("Movie 1");
        movieManager.addMovie("Movie 2");

        String[] expected = {"Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, movieManager.findLast());
    }
}
