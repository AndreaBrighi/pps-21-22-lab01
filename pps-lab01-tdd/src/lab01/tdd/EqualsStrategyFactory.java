package lab01.tdd;

public class EqualsStrategyFactory implements SelectAbstractFactory {
    private final int n;

    public EqualsStrategyFactory(int n) {
        this.n = n;
    }

    @Override
    public SelectStrategy createSelectStrategy() {
        return i -> i == n;
    }
}
