package lt.techin.numbers;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class FilteredGenerator implements IntegerGenerator {

    //	private IntegerGenerator integerGenerator;
//	private NumberFilter numberFilter;
    private Iterator<Integer> iterator;
    private List<Integer> numbers;

    public FilteredGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
//		this.integerGenerator = integerGenerator;
//		this.numberFilter = numberFilter;
        numbers = Stream.generate(integerGenerator::getNext).takeWhile(Objects::nonNull)
                .filter(numberFilter::accept).toList();
        iterator = numbers.iterator();
    }

    @Override
    public Integer getNext() {
        while (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}

