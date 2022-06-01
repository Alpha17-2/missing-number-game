package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game{


    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuess;
    private boolean isValidRange = true;

    @Override
    public void reset() {
        smallest = 0;
        remainingGuess = guessCount;
        guess = 0;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.info("The number is {}",number);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess=guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuess;
    }

    @Override
    public void check() {
        checkValidRange();
        if(isValidRange){
            if(guess>number){
                biggest=number-1;
            }
            if(guess<number){
                smallest=number+1;
            }
        }
        remainingGuess--;
    }

    @Override
    public boolean isValidNumber() {
        return isValidRange;
    }

    @Override
    public boolean isGameWon() {
        return (number==guess && guessCount>0);
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon();
    }

    // private methods

    private void checkValidRange(){
        isValidRange = (number>=smallest && number<=biggest);
    }
}
