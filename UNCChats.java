import java.util.Scanner;

public class UNCChats {

    // Global arrays so all methods can use them
    static String[] messages = new String[100];
    static String[] recipients = new String[100];
    static String[] messageIDs = new String[100];
    static int totalMessages = 0;
    static int messageNumber = 1;

    public static void sendMessage(Scanner input) {
        System.out.print("079 162 7147: ");
        String p1 = input.nextLine();

        if (p1.equalsIgnoreCase("exit")) {
            System.out.println("Chat ended.");
            return;
        }

        messages[totalMessages] = "Message " + messageNumber + ": " + p1;
        recipients[totalMessages] = "079 162 7147";
        messageIDs[totalMessages] = "MSG" + messageNumber;
        System.out.println(" SENT\n DELIVERED\n READ (blue)\n");
        totalMessages++;
        messageNumber++;

        System.out.print("067 151 1727: ");
        String p2 = input.nextLine();

        if (p2.equalsIgnoreCase("exit")) {
            System.out.println("Chat ended.");
            return;
        }

        messages[totalMessages] = "Message " + messageNumber + ": " + p2;
        recipients[totalMessages] = "067 151 1727";
        messageIDs[totalMessages] = "MSG" + messageNumber;
        System.out.println(" SENT\n DELIVERED\n READ (blue)\n");
        totalMessages++;
        messageNumber++;

        // CHAT LOG
        System.out.println("---- CHAT LOG ----");
        System.out.println(messages[totalMessages - 2]);
        System.out.println(messages[totalMessages - 1]);
        System.out.println("------------------");
    }

    public static void showMessages() {
        if (totalMessages == 0) {
            System.out.println("No messages yet.");
        } else {
            System.out.println("\n---- ALL MESSAGES ----");
            for (int i = 0; i < totalMessages; i++) {
                System.out.println(messages[i] + " | To: " + recipients[i] + " | ID: " + messageIDs[i]);
            }
        }
    }

    public static void displayLongestMessage() {
        if (totalMessages == 0) {
            System.out.println("No messages to check.");
            return;
        }
        String longest = "";
        for (int i = 0; i < totalMessages; i++) {
            String content = messages[i].split(": ", 2)[1];
            if (content.length() > longest.length()) {
                longest = messages[i];
            }
        }
        System.out.println("Longest message: " + longest);
    }

    public static void searchMessageID(Scanner input) {
        System.out.print("Enter Message ID e.g. MSG3: ");
        String id = input.nextLine();
        boolean found = false;
        for (int i = 0; i < totalMessages; i++) {
            if (messageIDs[i].equalsIgnoreCase(id)) {
                System.out.println("Found: " + messages[i] + " | To: " + recipients[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Message ID not found.");
    }

    public static void searchRecipient(Scanner input) {
        System.out.print("Enter recipient number: ");
        String num = input.nextLine();
        boolean found = false;
        System.out.println("\n---- Messages to " + num + " ----");
        for (int i = 0; i < totalMessages; i++) {
            if (recipients[i].equals(num)) {
                System.out.println(messages[i] + " | ID: " + messageIDs[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for this recipient.");
    }

    public static void displayReport() {
        System.out.println("\n=== UNC CHATS REPORT ===");
        System.out.println("Total messages sent: " + totalMessages);
        System.out.println("Unique recipients: 2");
        if (totalMessages > 0) {
            displayLongestMessage();
        }
        System.out.println("========================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PASSWORD
        String correctPassword = "Fetty1738?";
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (!password.equals(correctPassword)) {
            System.out.println("Incorrect password. Please try again!");
            input.close();
            return;
        }

        System.out.println("\nWelcome! It is great to see you again");
        System.out.println("=== UNC CHATS ===");

        while (true) {
            System.out.println("\n1. Send Message");
            System.out.println("2. Show Messages");
            System.out.println("3. Display Longest Message");
            System.out.println("4. Search Message ID");
            System.out.println("5. Search Recipient");
            System.out.println("6. Display Report");
            System.out.println("7. Quit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> sendMessage(input);
                case 2 -> showMessages();
                case 3 -> displayLongestMessage();
                case 4 -> searchMessageID(input);
                case 5 -> searchRecipient(input);
                case 6 -> displayReport();
                case 7 -> {
                    System.out.println("Total messages sent: " + totalMessages);
                    System.out.println("Goodbye!");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}