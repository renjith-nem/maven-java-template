package com.hashedin;

import java.io.IOException;

import com.hashedin.manager.MovieManager;
import com.hashedin.manager.RatingsManager;
import com.hashedin.manager.UserManager;
import com.hashedin.service.MovieWizard;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		MovieManager movieManager = new MovieManager("movie.data");
		UserManager userManager = new UserManager("user.data");
		RatingsManager ratingsManager = new RatingsManager(userManager,
				movieManager, "ratings.data");

		MovieWizard movieWizard = new MovieWizard(movieManager.getMovieMap(),
				movieManager.getGenreMap(), userManager.getUserMap(),
				ratingsManager.getRatingMap());

		System.out.println(movieWizard.getMostActiveUser());

		System.out.println(movieWizard.getMostWatchedMovie());
		
		System.out.println(movieWizard.getTopMovieByGenre(Constants.comedy));
		
		System.out.println(movieWizard.getTopMovieByYear(1994));
		
		System.out.println(movieWizard.getTopMovieByYearAndGenre(1990, Constants.crime));
		
		
		// System.out.println(movieManager.getGenreMap().get(Constants.action)
		// .toString());
		// System.out.println(movieManager.getMovieMap().get(709).getAvgRating());

	}

}
