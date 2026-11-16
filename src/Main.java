import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int correctPin = 1234;
        int attempts = 3;
        boolean isAuthenticated = false;


        while (attempts > 0) {
            System.out.println("Enter your 4-digit PIN: ");
            int enter_pass = scan.nextInt();

            if (enter_pass == correctPin) {
                isAuthenticated = true;
                break;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Wrong PIN! Try Again. Attempts left: " + attempts + "\n");
                }
            }
        }

        double initialBalance = 2500.75;

        if (isAuthenticated) {
            int choice;
            //double initialBalance = 2500.75;    (available too if it is initialized & declared here most importantly outside the menu loop because the balance must persist while the user performs multiple transactions.)

            int total_number_of_transiction = 0;
            do {
                System.out.println("\n===== ATM MAIN MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Account Status");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");

                choice = scan.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("\nYour initial balance is: " + initialBalance);
                        break;

                    case 2:
                        System.out.println("\nPlease insert the cash you wish to deposit:");
                        double depositAmount = scan.nextDouble();

                        if(depositAmount < 0){
                            System.out.println("\nError!\nDeposit amount shouldn't be in negative value.");
                        }

                        else if(depositAmount == 0){
                            System.out.println("\nTransaction is cancelled.");
                        }

                        else{
                            initialBalance += depositAmount;
                            System.out.println("\nYour deposit has been completed successfully.");
                            System.out.println("Your initial balance is " + initialBalance);
                            total_number_of_transiction++;
                        }

                        break;

                    case 3:
                        System.out.println("\nPlease insert the cash you wish to withdraw:");
                        double withdrawAmount = scan.nextDouble();

                        if(withdrawAmount < 0){
                            System.out.println("\nError!\nWithdraw amount shouldn't be in negative value.");
                        }

                        else if(withdrawAmount == 0){
                            System.out.println("\nTransaction is cancelled.");
                        }

                        else if (withdrawAmount > initialBalance){
                            System.out.println("\nInsufficient balance error!\nWithdraw amount is bigger than your initial balance.");
                        }

                        else{
                            initialBalance -= withdrawAmount;

                            System.out.println("\nYour withdraw has been completed successfully.\nPlease check your money.");

                            if(initialBalance == 0){
                                System.out.println("\nWarning: Your account is now " + "empty.");
                            }

                            else{
                                System.out.println("\nYour initial balance is " + initialBalance);
                            }

                            total_number_of_transiction++;
                        }

                        break;

                    case 4:
                        System.out.println("\nAccount Status");

                        if(initialBalance >= 5000){
                            System.out.println("You are a VIP Customer.");
                        }

                        else if(initialBalance <= 4999.99 && initialBalance >= 1000) {
                            System.out.println("Your are a Regular Customer.");
                        }

                        else{
                            System.out.println("Low Balance");
                        }

                        break;

                    case 5:
                        System.out.println("\nThank you for using our ATM.");
                        System.out.println("Total number of transactions is: " + total_number_of_transiction);
                        break;

                    default:
                        System.out.println("\nError!\nInvalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5);
        } else {
            System.out.println("\nToo many incorrect attempts. Your card has been blocked.");
        }

        scan.close();
    }
}