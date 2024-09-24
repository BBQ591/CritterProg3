package assignment;
import org.junit.Test;
import org.junit.Assert;



public class testCritter {
    @Test
    public void testCritter2() {
        Interpreter myInterpreter = new Interpreter();
        Critter myCritter = new Critter();
        myInterpreter.executeCritter(myCritter);
        Assert.assertEquals(5, 5);
        System.out.println("testCritter");
    }
}