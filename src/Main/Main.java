package Main;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter port number to use: ");
        int port = scanner.nextInt();
        Server server = new Server(50123);
    }
}
