package lt.techin.numbers;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class FilteredGenerator implements IntegerGenerator {

    IntegerGenerator integerGenerator;
    NumberFilter numberFilter;

    public FilteredGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        this.integerGenerator = integerGenerator;
        this.numberFilter = numberFilter;
    }

    @Override
    public Integer getNext() {
        int returned = integerGenerator.getNext();
        if (numberFilter.accept(returned)) {
            return returned;
        }
        return null;
    }
}
