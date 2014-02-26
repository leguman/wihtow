package be.wihtow.enumeration;

/**
 *
 * @author X-L
 */
public enum TypeGenre {

    ACTION("genre.action", 28),
    ADULT("genre.adult", 0),
    ADVENTURE("genre.adventure", 12),
    ANIMATION("genre.animation", 16),
    BIOPIC("genre.biopic", 0),
    COMEDY("genre.comedy", 35),
    COMEDY_DRAMA("genre.comedyDrama", 0),
    COMEDY_MUSIC("genre.comedyMusic", 0),
    CONCERT("genre.concert", 0),
    CRIME("genre.crime", 80),
    CARTOON("genre.cartoon", 0),
    DISASTER("genre.disaster", 105),
    DOCUMENTARY("genre.documentary", 99),
    DRAMA("genre.drama", 18),
    EASTERN("genre.eastern", 82),
    EROTIC("genre.erotic", 2916),
    FAMILY("genre.family", 10751),
    FAN_FILM("genre.fanFilm", 10750),
    FANTASY("genre.fantasy", 14),
    FILM_NOIR("genre.filmNoir", 10753),
    FOREIGN("genre.foreign", 10769),
    HISTORY("genre.history", 36),
    HOLIDAY("genre.holiday", 10595),
    HORROR("genre.horror", 27),
    HUMOR("genre.humor", 0),
    INDIE("genre.indie", 10756),
    MANGA("genre.manga", 0),
    MARTIAL_ART("genre.martialArt", 0),
    MISC("genre.misc", 0),
    MUSIC("genre.music", 10402),
    MUSICAL("genre.musical", 22),
    NEO_NOIR("genre.neoNoir", 10754),
    PEPLUM("genre.peplum", 0),
    RACE("genre.race", 0),
    ROAD_MOVIE("genre_roadMovie", 1115),
    ROMANCE("genre.romance", 10749),
    SCIENCE_FINCTION("genre.scienceFiction", 878),
    SHORT("genre.short", 10755),
    SPORT("genre.sport", 9805),
    SPORTING_EVENT("genre.sportEvent", 10758),
    SPORTS_FILM("genre.sportsFilm", 10757),
    SPY("genre.spy", 0),
    SUSPENSE("genre.suspense", 10748),
    THRILLER("genre.thriller", 53),
    TV_MOVIE("genre.tvMovie", 10770),
    WAR("genre.war", 10752),
    WESTERN("genre.western", 37);
    private final String bundle;
    private final int idTmdb;

    private TypeGenre(String bundle, int idTmdb) {
        this.bundle = bundle;
        this.idTmdb = idTmdb;
    }

    public String getBundle() {
        return bundle;
    }

    public int getIdTmdb() {
        return idTmdb;
    }

}
