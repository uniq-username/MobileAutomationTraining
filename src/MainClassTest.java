import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainClassTest {
    @Test
    public void testGetClassString(){
        MainClass mainClass = new MainClass();
        Assert.assertTrue("Function getClassString() is expected to contain the substring \"hello\" or \"Нello\"",
                mainClass.getClassString().contains("hello") || mainClass.getClassString().contains("Hello"));
    }
}