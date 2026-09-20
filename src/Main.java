import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static EventManager manager = new EventManager();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" COLLEGE EVENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    manager.viewEvents();
                    break;

                case 3:
                    registerStudent();
                    break;

                case 4:
                    System.out.println("Thank you for using the system! 😊");
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    static void addEvent() {

        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        System.out.print("Enter Organizer: ");
        String organizer = sc.nextLine();

        Event event = new Event(id, name, date, venue, organizer);

        manager.addEvent(event);
    }
        static void registerStudent() {

    System.out.print("Enter Student Name: ");
    String studentName = sc.nextLine();

    System.out.print("Enter Roll Number: ");
    String rollNumber = sc.nextLine();

    System.out.print("Enter Event ID: ");
    int eventId = sc.nextInt();
    sc.nextLine();

    Registration registration =
            new Registration(studentName, rollNumber, eventId);

    registration.displayRegistration();
}
    
}