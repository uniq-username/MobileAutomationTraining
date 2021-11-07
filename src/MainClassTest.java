import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetLocalNumber(){
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Function getClassString() is expected to contain the substring \"hello\" or \"Нello\"",
                mainClass.getClassString().contains("hello") || mainClass.getClassString().contains("Hello"));
    }
}
