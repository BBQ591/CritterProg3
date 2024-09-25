package assignment;
import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class EachCritter implements Critter {
    public ArrayList<Integer> registers = new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1));

    public ArrayList<ArrayList<String>> behaviors = new ArrayList<>();
    public int bearing;
    public boolean isHungry;
    public boolean isStarving;
    public boolean random;

    public void setReg(int index, int value) {
        registers.set(index-1, value);
    }

    public int getReg(int register) {
        return registers.get(register-1);
    }

    public int getOffAngle(int bearing) {
        return bearing;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }
    public boolean ifRandom() {
        return this.random;
    }
    public HungerLevel getHungerLevel() {
        if (isStarving) {
            return HungerLevel.STARVING;
        }
        else if (isHungry) {
            return HungerLevel.HUNGRY;
        }
        else {
            return HungerLevel.HAPPY;
        }
    }
    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
    public void setStarving(boolean starving) {
        isStarving = starving;
    }
    public ArrayList<ArrayList<String>> getBehaviors() {
        return this.behaviors;
    }
    public void addToBehaviors(ArrayList<String> newBehavior) {
        this.behaviors.add(newBehavior);
    }
    public int getBearing() {
        return this.bearing;
    }
    public void setBearing(int bearing) {
        this.bearing = bearing;
    }
    public int getCellContent (int bearing) {
        //the bearing matched the number of if it is empty, enemy, or friend
        return this.bearing;
    }
}

