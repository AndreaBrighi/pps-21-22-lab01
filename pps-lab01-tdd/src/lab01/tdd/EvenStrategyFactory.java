package lab01.tdd;

/**
 * This class create SelectStrategy that check only even elements
 */
public class EvenStrategyFactory extends MultipleOfStrategyFactory {

    /**
     * Constructor of the class EvenStrategyFactory
     *
     */
    public EvenStrategyFactory() {
        super(2);
    }

    /**
     * Create a new SelectStrategy that check only even elements
     *
     * @return a new SelectStrategy
     */
    @Override
    public SelectStrategy createSelectStrategy() {
        return super.createSelectStrategy();
    }
}
