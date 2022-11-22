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
    public int computeSumOfNumbers(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (numberFilter.accept(i)) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> countedOccurrences = new TreeMap<>();
        for (int key : list) {
            countedOccurrences.put(key, countedOccurrences.getOrDefault(key, 0) + 1);
        }
        return countedOccurrences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int numberFrom, int numberTo) {
        return new MyIntegerGenerator(numberFrom, numberTo);
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return new FilteredGenerator(integerGenerator, numberFilter);
    }
}
