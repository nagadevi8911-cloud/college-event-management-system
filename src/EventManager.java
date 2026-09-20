import java.util.ArrayList;

public class EventManager {

    private ArrayList<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added successfully!");
    }

    public void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\n===== COLLEGE EVENTS =====");

        for (Event event : events) {
            System.out.println(event);
        }
    }

    public ArrayList<Event> 
    getEvents() {
        return events;
    }
}