package be.wihtow.enumeration;

/**
 *
 * @author X-L
 */
public enum GroupType {

    USER(1),
    SUPER_USER(2),
    ADMINISTRATOR(3);

    private final Integer id;

    private GroupType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
