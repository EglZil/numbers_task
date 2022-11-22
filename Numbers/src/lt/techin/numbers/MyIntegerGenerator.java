package lt.techin.numbers;

import lt.itakademija.exam.IntegerGenerator;

public class MyIntegerGenerator implements IntegerGenerator {
    private int numberFrom;
    private int numberTo;
    private int numberToReturn;

    public MyIntegerGenerator(int from, int to) {
        numberFrom = from;
        numberTo = to;
        numberToReturn = from;
    }

    @Override
    public Integer getNext() {
        if (numberToReturn >= numberFrom && numberToReturn <= numberTo) {
            int returned = numberToReturn;
            numberToReturn++;
            return returned;
        }
        return null;
    }
}
