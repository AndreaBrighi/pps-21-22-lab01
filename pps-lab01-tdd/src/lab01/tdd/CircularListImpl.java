package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private int actual = -1;
    private final List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        actual++;
        return actualElement();
    }

    @Override
    public Optional<Integer> previous() {
        actual--;
        return actualElement();
    }

    private Optional<Integer> actualElement() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            if (actual >= size()) {
                actual = 0;
            } else if (actual < 0) {
                actual = size() - 1;
            }
            return Optional.of(list.get(actual));
        }
    }

    @Override
    public void reset() {
        if (!isEmpty()) {
            int tmp = list.get(actual);
            list.remove(actual);
            list.add(0, tmp);
            actual = -1;
        }
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> tmp;
        for (int i = 0; i < size(); i++) {
            tmp = next();
            if (tmp.isEmpty()) {
                return Optional.empty();
            } else {
                if (strategy.apply(tmp.get())) {
                    return tmp;
                }
            }
        }
        return Optional.empty();
    }
}
