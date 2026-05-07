import java.util.Scanner;

public class Pratice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes :");
        int nodes = sc.nextInt();

        for(int i = 0 ; i < nodes ; i++) {
            System.out.println(i + "->");
        }
        System.out.println("0");

        int choice;
        int token = 0;

        do {
            System.out.println("Enter the sender node :");
            int sender = sc.nextInt();
            System.out.println("Enter the receiver node :");
            int receiver = sc.nextInt();
            System.out.println("Enter Data:");
            String data = sc.nextLine();

            while(token != sender) {
                System.out.println("passing token from " + token + "to " + (token + 1)%nodes);
                token = (token + 1)%nodes;
            }

            System.out.println("Token reached to sender " + token);
            System.out.println("Sender to enter critical section");
            System.out.println("sender is ready to read the data " + data );

            int i = sender;
            while(i!=receiver) {
                System.out.println("passing data from " + i + "to " + (i + 1)%nodes);
                i = (i+1)%nodes;
            }
            System.out.println("Receiver to enter critical section");
            System.out.println("receiver is ready to data" + data );
            token = (sender + 1)%1;

            System.out.println("Press 1 to contiue else Press 0 to stop");
            choice = sc.nextInt();
        }
        while(choice == 1);
    }
}
