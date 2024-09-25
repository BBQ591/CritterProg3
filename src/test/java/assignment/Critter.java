package assignment;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public interface Critter {
    void addToBehaviors(ArrayList<String> newBehavior);
    ArrayList<ArrayList<String>> getBehaviors();
    void setBearing(int bearing);
    int getBearing();
    int getCellContent(int bearing);
    HungerLevel getHungerLevel();
    public static enum HungerLevel {
        HAPPY,
        HUNGRY,
        STARVING;
//        private HungerLevel() {}
    }
    void setHungry(boolean hungry);
    void setStarving(boolean starving);
    void setRandom(boolean random);
    boolean ifRandom();
    int getOffAngle(int bearing);
//    void setBearing2(int bearing);
//    int getBearing2();
    int getReg(int register);
    void setReg(int index, int value);
}

