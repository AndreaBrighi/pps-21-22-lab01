package lab01.tdd;

public class MultipleOfStrategyFactory implements SelectAbstractFactory {

    private final int n;

    public MultipleOfStrategyFactory(int n) {
        this.n = n;
    }

    @Override
    public SelectStrategy createSelectStrategy() {
        return i -> i % n == 0;
    }
}
