package lab01.tdd;

/**
 * This class create SelectStrategy that check only the elements that equals to n
 *
 */
public class EqualsStrategyFactory implements SelectAbstractFactory {
    private final int n;

    /**
     * Constructor of the class EqualsStrategyFactory
     *
     * @param n the number that the elements must be equal to
     */
    public EqualsStrategyFactory(int n) {
        this.n = n;
    }

    /**
     * Create a new SelectStrategy that check only equal to n
     *
     * @return a new SelectStrategy
     */
    @Override
    public SelectStrategy createSelectStrategy() {
        return i -> i == n;
    }
}
