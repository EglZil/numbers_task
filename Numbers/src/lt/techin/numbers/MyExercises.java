package lt.techin.numbers;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyExercises implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().mapToInt(s -> s).min().orElseThrow();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().mapToInt(s -> s).max().orElseThrow();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> numbers = new ArrayList<>();
        while (iterator.hasNext()) {
            numbers.add(iterator.next());
        }
        return numbers;
    }

    @Override
    public int computeSumOfNumbers(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            if (numberFilter.accept(j)) {
                sum += j;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        List<Integer> numbers = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            numbers.add(j);
        }
        return numbers;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> countedOccurrences = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            countedOccurrences.put(key, countedOccurrences.getOrDefault(key, 0) + 1);
        }
        return countedOccurrences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {
        return new MyIntegerGenerator(i, i1);
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return new FilteredGenerator(integerGenerator, numberFilter);
    }
}
