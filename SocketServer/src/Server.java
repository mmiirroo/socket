import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int PORT = 50004;
    private ServerSocket serverSocket;
    private ExecutorService executorService;
    private int POOL_SIZE = 2;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
        this.executorService = Executors.newFixedThreadPool(POOL_SIZE);
    }

    public void start() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                executorService.execute(new SocketTask(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}
