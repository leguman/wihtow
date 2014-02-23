package be.wihtow.web.controller;

import be.wihtow.entities.movie.Movie;
import be.wihtow.services.MovieBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author X-L
 */
@ManagedBean
@RequestScoped
public class MovieMBean {

    @EJB
    private transient MovieBean movieBean;
    @ManagedProperty(value = "#{param.id}")
    private Integer id;
    private Movie movie;
    private List<Movie> movies;

    @PostConstruct
    public void load() {
        if (id != null) {
            this.movie = movieBean.find(id);
        } else {
            this.movie = movieBean.create();
        }
    }

    public String save() {
        if (this.movie.getId() != null) {
            movieBean.save(this.movie);
        } else {
            this.movie.setIsDeleted(Boolean.FALSE);
            movieBean.save(this.movie);
        }
        return "movies";
    }

    public String remove() {
        movieBean.remove(this.movie.getId());
        return "movies";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public List<Movie> getMovies() {
        if (movies == null) {
            movies = movieBean.findAll();
        }
        return movies;
    }

    public List<Movie> getLatestMovies() {
        if (movies == null) {
            movies = movieBean.findLatest();
        }
        return movies;
    }
}
