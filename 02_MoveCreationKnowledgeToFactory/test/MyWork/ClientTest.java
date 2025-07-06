package MyWork;

import com.surkoffv.MyWork.Node;
import com.surkoffv.MyWork.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test
    public void parse_respectsFactoryConfiguration() {
        Parser parser = new Parser();

        // клиент настраивает ПАРСЕР, а тот перенаправляет опции фабрике
        parser.setDecodeStringNodes(true);
        parser.setRemoveEscapeCharacters(true);

        Node node = parser.parse("http://example.com");

        String expected = "Hello, & world\n from http://example.com";
        Assert.assertEquals(expected, node.getText());
    }
}
