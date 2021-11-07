import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetLocalNumber(){
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Function getClassNumber() is expected to be greater than 45",
                mainClass.getClassNumber() > 45);
    }
}
