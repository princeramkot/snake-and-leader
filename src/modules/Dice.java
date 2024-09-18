package modules;
import java.util.Random;
import java.util.random.*;

public class Dice {
    int startValue;
    int endValue;
    Random rand;
    public Dice(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.rand = new Random();
    }

    public int rollDice(){
       return rand.nextInt(this.startValue, this.endValue);
    }
}
