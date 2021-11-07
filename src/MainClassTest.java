import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetLocalNumber(){
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Function testGetLocalNumber() is expected to be 14",
                mainClass.getLocalNumber() == 14);
    }
}
