package lab01.tdd;

/**
 * This class create SelectStrategy that check only the elements that are multiple of n
 *
 */
public class MultipleOfStrategyFactory implements SelectAbstractFactory {

    private final int n;

    /**
     * Constructor of the class MultipleOfStrategyFactory
     *
     * @param n the number that the elements must be multiple of
     */
    public MultipleOfStrategyFactory(int n) {
        this.n = n;
    }

    /**
     * Create a new SelectStrategy that check only even elements
     *
     * @return a new SelectStrategy
     */
    @Override
    public SelectStrategy createSelectStrategy() {
        return i -> i % n == 0;
    }
}
