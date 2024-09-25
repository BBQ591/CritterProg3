package assignment;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;


public class testCritter {
    @Test
    public void ifgtTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setReg(1, 15);
        myCritter.setReg(2, 10);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifgt", "r1", "r2", "30")));
        indexStep = myInterpreter.ifgt(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(29, indexStep);

        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        indexStep = myInterpreter.ifgt(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);

        myCritter.setReg(1, 15);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifgt", "r1", "r2", "r3")));
        indexStep = myInterpreter.ifgt(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);


        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        indexStep = myInterpreter.ifgt(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }


    @Test
    public void ifeqTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setReg(1, 10);
        myCritter.setReg(2, 10);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifeq", "r1", "r2", "30")));
        indexStep = myInterpreter.ifeq(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(29, indexStep);

        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        indexStep = myInterpreter.ifeq(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);

        myCritter.setReg(1, 10);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("fieq", "r1", "r2", "r3")));
        indexStep = myInterpreter.ifeq(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);

        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("fieq", "r1", "r2", "r3")));
        indexStep = myInterpreter.ifeq(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }


    @Test
    public void ifltTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("iflt", "r1", "r2", "30")));
        indexStep = myInterpreter.iflt(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(29, indexStep);

        myCritter.setReg(1, 15);
        myCritter.setReg(2, 10);
        indexStep = myInterpreter.iflt(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);

        myCritter.setReg(1, 5);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("iflt", "r1", "r2", "r3")));
        indexStep = myInterpreter.iflt(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);

        myCritter.setReg(1, 20);
        myCritter.setReg(2, 10);
        myCritter.setReg(3, 30);
        indexStep = myInterpreter.iflt(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }


    @Test
    public void ifangleTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setBearing(1);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifangle", String.valueOf(myCritter.getBearing()),String.valueOf(1),"40")));
        indexStep = myInterpreter.ifangle(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(39, indexStep);

        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifangle", String.valueOf(myCritter.getBearing()),String.valueOf(5),"40")));
        indexStep = myInterpreter.ifangle(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);

        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifangle", String.valueOf(myCritter.getBearing()),String.valueOf(1),"r3")));
        indexStep = myInterpreter.ifangle(myCritter, myCritter.getBehaviors().get(2), 2);
        Assert.assertEquals(29, indexStep);

        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifangle", String.valueOf(myCritter.getBearing()),String.valueOf(5),"r3")));
        indexStep = myInterpreter.ifangle(myCritter, myCritter.getBehaviors().get(3), 3);
        Assert.assertEquals(4, indexStep);
    }


    @Test
    public void ifwallTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setBearing(1);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifwall", String.valueOf(myCritter.getBearing()),"40")));
        indexStep = myInterpreter.ifwall(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(39, indexStep);

        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifwall", String.valueOf(myCritter.getBearing()),"43")));
        indexStep = myInterpreter.ifwall(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);


        myCritter.setReg(3, 30);
        myCritter.setBearing(1);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifwall", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifwall(myCritter, myCritter.getBehaviors().get(2), 2);
        Assert.assertEquals(29, indexStep);

        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifwall", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifwall(myCritter, myCritter.getBehaviors().get(3), 3);
        Assert.assertEquals(4, indexStep);
    }


    @Test
    public void ifenemyTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifenemy", String.valueOf(myCritter.getBearing()),"40")));
        indexStep = myInterpreter.ifenemy(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(39, indexStep);

        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifenemy", String.valueOf(myCritter.getBearing()),"43")));
        indexStep = myInterpreter.ifenemy(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);

        myCritter.setReg(3, 30);
        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifenemy", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifenemy(myCritter, myCritter.getBehaviors().get(2), 2);
        Assert.assertEquals(29, indexStep);

        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifenemy", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifenemy(myCritter, myCritter.getBehaviors().get(3), 3);
        Assert.assertEquals(4, indexStep);
    }

    @Test
    public void ifallyTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifally", String.valueOf(myCritter.getBearing()),"43")));
        indexStep = myInterpreter.ifally(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(42, indexStep);

        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifally", String.valueOf(myCritter.getBearing()),"43")));
        indexStep = myInterpreter.ifally(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);

        myCritter.setReg(3, 30);
        myCritter.setBearing(3);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifally", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifally(myCritter, myCritter.getBehaviors().get(2), 2);
        Assert.assertEquals(29, indexStep);

        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifally", String.valueOf(myCritter.getBearing()),"r3")));
        indexStep = myInterpreter.ifally(myCritter, myCritter.getBehaviors().get(3), 3);
        Assert.assertEquals(4, indexStep);
    }


    @Test
    public void goTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("go", "17")));
        indexStep = myInterpreter.go(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(16, indexStep);

        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("go", "r3")));
        indexStep = myInterpreter.go(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);
    }

    @Test
    public void ifrandomTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setRandom(true);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifrandom", "20")));
        indexStep = myInterpreter.ifrandom(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(19, indexStep);

        myCritter.setRandom(false);
        indexStep = myInterpreter.ifrandom(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);

        myCritter.setRandom(true);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifrandom", "r3")));
        indexStep = myInterpreter.ifrandom(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);

        myCritter.setRandom(false);
        indexStep = myInterpreter.ifrandom(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }
    @Test
    public void ifstarvingTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();

        myCritter.setStarving(true);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifstarving", "21")));
        indexStep = myInterpreter.ifstarving(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(20, indexStep);

        myCritter.setStarving(false);
        indexStep = myInterpreter.ifhungry(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);

        myCritter.setStarving(true);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifstarving", "r3")));
        indexStep = myInterpreter.ifstarving(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);

        myCritter.setStarving(false);
        indexStep = myInterpreter.ifstarving(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }

    @Test
    public void ifhungryTest() {
        int indexStep;

        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setHungry(true);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifhungry", "21")));
        indexStep = myInterpreter.ifhungry(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(20, indexStep);

        myCritter.setHungry(false);
        indexStep = myInterpreter.ifhungry(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(1, indexStep);


        myCritter.setHungry(true);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifhungry", "r3")));
        indexStep = myInterpreter.ifhungry(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(29, indexStep);

        myCritter.setHungry(false);
        indexStep = myInterpreter.ifhungry(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);
    }



    @Test
    public void ifEmptyTest() {
        int indexStep;


        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new EachCritter();
        myCritter.setBearing(0);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifempty", String.valueOf(myCritter.getBearing()), "23")));
        indexStep = myInterpreter.ifempty(myCritter, myCritter.getBehaviors().get(0), 0);
        Assert.assertEquals(22, indexStep);


        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifempty", String.valueOf(myCritter.getBearing()), "23")));
        indexStep = myInterpreter.ifempty(myCritter, myCritter.getBehaviors().get(1), 1);
        Assert.assertEquals(2, indexStep);


        myCritter.setBearing(0);
        myCritter.setReg(3, 30);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifempty", String.valueOf(myCritter.getBearing()), "r3")));
        indexStep = myInterpreter.ifempty(myCritter, myCritter.getBehaviors().get(2), 2);
        Assert.assertEquals(29, indexStep);

        myCritter.setBearing(2);
        myCritter.addToBehaviors(new ArrayList<>(Arrays.asList("ifempty", String.valueOf(myCritter.getBearing()), "r3")));
        indexStep = myInterpreter.ifempty(myCritter, myCritter.getBehaviors().get(3), 3);
        Assert.assertEquals(4, indexStep);
    }


    @Test
    public void testLoadCritter() {
        String fileName = System.getProperty("user.dir")+"/species/TheGOATCritter.cri";
        Interpreter myInterpreter = new Interpreter();
        assertThrows(IOException.class, () -> {
            // Call the method that should throw the IOException
            myInterpreter.loadSpecies(fileName);
        });
        //should be a directory that works
        String fileName2 = System.getProperty("user.dir")+"/species/Food.cri";
        try {
            CritterSpecies myCritterSpecies = myInterpreter.loadSpecies(fileName2);
            ArrayList<ArrayList<String>> foodBehavior = new ArrayList<>();
            foodBehavior.add(new ArrayList<>(Arrays.asList("right")));
            foodBehavior.add(new ArrayList<>(Arrays.asList("go", "1")));
            for (int i = 0; i < myCritterSpecies.critterBehavior.size(); i++) {
                Assert.assertEquals(foodBehavior.get(i), myCritterSpecies.critterBehavior.get(i));
            }
        } catch (IOException e) {
            System.err.println("Please input a right directory for fileName2");
        }
    }
}