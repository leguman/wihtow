package be.wihtow.domain;

/**
 * To be implemented by entity classes.<br />Thanks to Hildeberto Mendonca/fishe
 * project on GitHub
 *
 * @author axel
 * @param <T>
 */
public interface Identified<T extends Number> {

    public T getId();

    public void setId(T id);
}
