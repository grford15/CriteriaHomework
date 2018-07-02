import db.DBFootballer;
import db.DBMovies;
import models.Footballer;
import models.Movies;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Footballer footballer1 = new Footballer("Alfredo", "Morelos", "Rangers");
        DBFootballer.save(footballer1);
        Footballer footballer2 = new Footballer("Daneil", "Candieas", "Rangers");
        DBFootballer.save(footballer2);
        Footballer footballer3 = new Footballer("Steven", "Gerrard", "Liverpool");
        DBFootballer.save(footballer3);

        Movies movie1 = new Movies("Goodfellas", 1990, "Gangster");
        DBMovies.save(movie1);
        Movies movie2 = new Movies("Jurrasic Park", 1993, "Sci-Fi");
        DBMovies.save(movie2);
        Movies movie3 = new Movies("The Godfather: Part II", 1974, "Gangster");
        DBMovies.save(movie3);

        List<Movies> movieList = DBMovies.getAll();
        List<Footballer> footballLists = DBFootballer.getAll();

        Movies findmovie = DBMovies.findByTitle("Jurrasic Park");
        Footballer findballer = DBFootballer.findByLastName("Candieas");

        Movies goodfellas = DBMovies.find(movie1.getId());
        Footballer gerrard = DBFootballer.find(footballer3.getId());

        DBFootballer.delete(footballer1);

        List<Footballer> shorterList = DBFootballer.getAll();

        DBMovies.delete(movie2);

        List<Movies> miniMovies = DBMovies.getAll();

        DBFootballer.deleteAll();
        DBMovies.deleteAll();

        List<Movies> noMovies = DBMovies.getAll();
        List<Footballer> noFootballers = DBFootballer.getAll();



    }
}
