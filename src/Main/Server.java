package Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client accepted");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over")) {
                line = in.readUTF();
                System.out.println(line);
            }
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
        finally{
            try {
                if(server != null) {
                    server.close();
                }
                if(socket != null) {
                    socket.close();
                }
                if(in != null) {
                    in.close();
                }
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
