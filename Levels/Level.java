package Levels;
import java.util.Random;

public abstract class Level {
    protected int digits;

    public int generateRandomNumber(){
        Random random=new Random();
        int number=random.nextInt(9*(int)Math.pow(10,digits-1))+(int)Math.pow(10,digits-1);
        return number;
    }
}
