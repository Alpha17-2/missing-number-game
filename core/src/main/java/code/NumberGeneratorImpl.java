package code;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    private static final int maxNumber = 100;
    Random random = new Random();
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
