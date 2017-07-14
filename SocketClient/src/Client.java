import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost", 50004);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 发送关闭命令
            OutputStream socketOut = socket.getOutputStream();
            while (true) {
                String in = br.readLine();
                if (in.equals("bye")) {
                    break;
                }
                socketOut.write((in + "\n").getBytes());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
