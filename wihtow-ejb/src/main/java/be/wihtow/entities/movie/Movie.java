package be.wihtow.entities.movie;

import be.wihtow.domain.Identified;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author X-L
 */
@Entity
@Table(name = "movie")
public class Movie implements Serializable, Identified<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "id_tmdb")
    private Integer idTmdb;
    @Column(name = "id_imdb")
    private Integer idImdb;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",
            joinColumns = {
                @JoinColumn(name = "id_movie")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_genre")})
    private List<Genre> genres;

    public Movie() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdTmdb() {
        return idTmdb;
    }

    public void setIdTmdb(Integer idTmdb) {
        this.idTmdb = idTmdb;
    }

    public Integer getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(Integer idImdb) {
        this.idImdb = idImdb;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Return a String of all genre separeted by ", "
     *
     * @return
     */
    public String getAllGenres() {
        if (this.genres != null) {
            return StringUtils.join(this.genres, ", ");
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
