import java.util.ArrayList;

public class Registration {

    private String studentName;
    private String rollNumber;
    private int eventId;

    private static ArrayList<Registration> registrations =
            new ArrayList<Registration>();

    public Registration(String studentName, String rollNumber, int eventId) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.eventId = eventId;

        registrations.add(this);
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public int getEventId() {
        return eventId;
    }

    public static ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    public void displayRegistration() {
        System.out.println("\n===== REGISTRATION SUCCESSFUL =====");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Event ID: " + eventId);
    }
}