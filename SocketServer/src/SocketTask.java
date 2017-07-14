import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTask implements Runnable {
    private Socket socket;

    public SocketTask(Socket socket) {
        this.socket = socket; // TODO Auto-generated constructor stub
    }

    public void run() {
        System.out.println("accepted");

        String message = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                message = br.readLine();
                if (null == message || "bye".equalsIgnoreCase(message)) {
                    System.out.println("bye");
                    break;

                }
                System.out.println("readed:" + message);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            System.out.println("close");

            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                }

            }
        }
    }

}
