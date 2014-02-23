package be.wihtow.enumeration;

/**
 *
 * @author axel
 */
public enum TypeGenre {

    ACTION("genre.action"),
    ADULT("genre.adult"),
    ANIMATION("genre.animation"),
    ADVENTURE("genre.adventure"),
    BIOPIC("genre.biopic"),
    COMEDY("genre.comedy"),
    COMEDY_DRAMA("genre.comedyDrama"),
    COMEDY_MUSIC("genre.comedyMusic"),
    CONCERT("genre.concert"),
    CRIME("genre.crime"),
    CARTOON("genre.cartoon"),
    DOCUMENTARY("genre.documentary"),
    DRAMA("genre.drama"),
    HORROR("genre.horror"),
    FAMILY("genre.family"),
    FANTASTIC("genre.fantastic"),
    HISTORIC("genre.historic"),
    HUMOR("genre.humor"),
    MANGA("genre.manga"),
    MARTIAL_ART("genre.martialArt"),
    MISC("genre.misc"),
    MUSICAL("genre.musical"),
    PEPLUM("genre.peplum"),
    RACE("genre.race"),
    ROMANCE("genre.romance"),
    SCIENCE_FINCTION("genre.scienceFiction"),
    SPORT("genre.sport"),
    SPY("genre.spy"),
    WAR("genre.war");
    private final String bundle;

    private TypeGenre(String bundle) {
        this.bundle = bundle;
    }

    public String getBundle() {
        return bundle;
    }

}
