import Web.Server;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Gruppo N
 */
public class ServetTest {
    @Test
    public void ServerIsReady() throws IOException, SQLException {
        Server server = new Server(8080);
        server.startServer();

    }
}
