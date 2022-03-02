package lab01.tdd;

public class EvenStrategyFactory implements SelectAbstractFactory{
    @Override
    public SelectStrategy createSelectStrategy() {
        return i -> i % 2 == 0;
    }
}
