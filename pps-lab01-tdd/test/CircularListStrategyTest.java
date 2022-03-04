import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularListStrategyTest {

    private CircularList list;
    private static final SelectAbstractFactory EVEN_STRATEGY_FACTORY = new EvenStrategyFactory();
    private static final SelectAbstractFactory EQUALS_STRATEGY_FACTORY_4 = new EqualsStrategyFactory(4);

    @BeforeEach
    void beforeEach() {
        list = new CircularListImpl();
    }

    void initListWith(int... elements) {
        for (var elem : elements) {
            list.add(elem);
        }
    }

    @Test
    public void testEvenStrategy() {
        initListWith(1, 2, 3, 4);
        assertEquals(Optional.of(2), list.next(EVEN_STRATEGY_FACTORY.createSelectStrategy()));
        assertEquals(Optional.of(4), list.next(EVEN_STRATEGY_FACTORY.createSelectStrategy()));
    }

    @Test
    public void testEvenStrategyNoElements() {
        initListWith(1, 3);
        assertEquals(Optional.empty(), list.next(i -> i % 2 == 0));
    }

    @Test
    public void testMultipleOfStrategy() {
        final SelectAbstractFactory multipleOf3 = new MultipleOfStrategyFactory(3);
        initListWith(1, 2, 3, 4);
        assertEquals(Optional.of(3), list.next(multipleOf3.createSelectStrategy()));
        assertEquals(Optional.of(3), list.next(multipleOf3.createSelectStrategy()));
    }

    @Test
    public void testMultipleOfStrategyNoElements() {
        final SelectAbstractFactory multipleOf4 = new MultipleOfStrategyFactory(4);
        initListWith(1, 3);
        assertEquals(Optional.empty(), list.next(multipleOf4.createSelectStrategy()));
    }

    @Test
    public void testEqualsStrategy() {
        initListWith(1, 2, 4, 3, 4);
        list.next(EQUALS_STRATEGY_FACTORY_4.createSelectStrategy());
        assertEquals(Optional.of(3), list.next());
        list.next(EQUALS_STRATEGY_FACTORY_4.createSelectStrategy());
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testEqualsStrategyAdvanced() {
        initListWith(1, 2, 3, 4);
        assertEquals(Optional.of(4), list.next(EQUALS_STRATEGY_FACTORY_4.createSelectStrategy()));
    }

    @Test
    public void testEqualStrategyNoElements() {
        initListWith(1, 3);
        assertEquals(Optional.empty(), list.next(EQUALS_STRATEGY_FACTORY_4.createSelectStrategy()));
    }
}
