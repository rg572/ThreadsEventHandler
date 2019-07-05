import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReplyHandlerTest {


    @Test
    public void handleTest1(){
        // Arrange
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        String expected = "Carthage must be destroyed";
        EventHandler handler = new ReplyHandler(out, expected);

        // Act
        handler.handle();
        String actual = new String(baos.toByteArray());

        // Assert
        Assert.assertEquals(expected + "\n", actual);
    }

}