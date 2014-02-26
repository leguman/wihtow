package be.wihtow.services;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.TheMovieDbApi;
import com.omertron.themoviedbapi.model.MovieDb;
import com.omertron.themoviedbapi.model.TmdbConfiguration;
import com.omertron.themoviedbapi.results.TmdbResultsList;
import javax.ejb.Stateless;

/**
 *
 * @author X-L
 */
@Stateless
public class TheMovieDbBean {

    private static final String API_KEY = "0dd72d5407afdc97062741d732e9a765";

    /**
     * Search movies corresponding to the different parameters
     *
     * @param title
     * @param year Limit the search to the provided year. Zero (0) will get all
     * years
     * @param lang The language to include. Can be blank/null.
     * @param includeAdult
     * @return
     */
    public TmdbResultsList<MovieDb> searchMovies(String title, int year, String lang, boolean includeAdult) {
        TheMovieDbApi tmdb;
        try {
            tmdb = new TheMovieDbApi(API_KEY);
            return tmdb.searchMovie(title, year, lang, includeAdult, 0);
        } catch (MovieDbException ex) {
            return null;
        }
    }

    public TmdbConfiguration getConfiguration() {
        TheMovieDbApi tmdb;
        try {
            tmdb = new TheMovieDbApi(API_KEY);
            return tmdb.getConfiguration();
        } catch (MovieDbException ex) {
            return null;
        }
    }
}
