package lab01.tdd;

/**
 * Interface for SelectStrategy using  the abstract factory
 */
public interface SelectAbstractFactory {

    /**
     * Create a new SelectStrategy based on the type of the factory
     *
     * @return a new SelectStrategy
     */
    SelectStrategy createSelectStrategy();
}
