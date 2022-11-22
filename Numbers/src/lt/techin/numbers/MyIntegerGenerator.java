package lt.techin.numbers;

import java.util.Iterator;
import java.util.stream.IntStream;

import lt.itakademija.exam.IntegerGenerator;

public class MyIntegerGenerator implements IntegerGenerator {

    private Iterator<Integer> iterator;

    public MyIntegerGenerator(int from, int to) {
        iterator = IntStream.range(from, to + 1).iterator();
    }

    @Override
    public Integer getNext() {
        while (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}

