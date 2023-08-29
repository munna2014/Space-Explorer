package project;

import java.util.Arrays;

public class Randomgenerator {
    private static final long MULTI = 1903565135;
    private static final long INCRE = 1234;
    private static final long MOD = (long) Math.pow(2, 31);

    private long seed;

    public Randomgenerator(long seed) {
        this.seed = seed;
    }

    public int nextInt() {
        seed = (MULTI* seed + INCRE) % MOD;
        return (int) seed;
    }



    public int generateRandomNumber(int max) {
        int range = max + 1;
        int randomNumber = nextInt() % range;
        if(randomNumber<0)randomNumber=randomNumber*-1;
        return randomNumber;
    }
}
