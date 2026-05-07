import java.util.Scanner;

public class Bully {
    static Boolean[] alive;
    static int n;


    static void election(int x) {
        System.out.println("Election is Conduct by" + x);
        for(int index = x + 1 ; index < n ; index++) {
            if(alive[index]) {
                System.out.println("Passing control of election from:" + x +" to:" + index);
                election(index);
                return;
            }
        }
        System.out.println("The new Leader:" + x);
        // inform all the process who is newleader

        for(int i = 0 ; i < n ; i++) {
            if(alive[i] && i!=x) {
                System.out.println(x + "->" + i);
            }
        }
    }

    static void showStaus() {
        for(int index = 0 ; index < n ; index++) {
            System.out.println(index + (alive[index] == true ? "UP" : "Down"));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the process");
        n = sc.nextInt();

        alive = new Boolean[n];
        for(int index = 0 ; index < n; index++) alive[index] = true;
        
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1.Active the deactived the process");
            System.out.println("2.Deactive the activated Process");
            System.out.println("3.Show Status of Process");
            System.out.println("4.Eleect the leader");
            System.out.println("5.Exit");
            System.out.println("\n");
            System.out.println("Enter the choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the process to deactivate");
                    alive[sc.nextInt()] = false;
                    break;
                
                case 2:
                    System.out.println("Enter the process to activate");
                    alive[sc.nextInt()] = true;
                    break;

                case 3:
                    showStaus();
                    break;
                
                case 4:
                    System.out.println("Give candiate to start the election");
                    int c = sc.nextInt();
                    if(alive[c]) {
                        election(c);
                    }
                    else {
                        System.out.println("this candiate the already deactivated can not conduct the election");
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    break;
            }
        }
        while(choice!=5);
    }
}
