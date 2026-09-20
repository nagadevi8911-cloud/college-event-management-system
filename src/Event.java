public class Event {

    private int id;
    private String name;
    private String date;
    private String venue;
    private String organizer;

    public Event(int id, String name, String date, String venue, String organizer) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.organizer = organizer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getOrganizer() {
        return organizer;
    }

    @Override
    public String toString() {
        return "\nEvent ID: " + id
                + "\nEvent Name: " + name
                + "\nDate: " + date
                + "\nVenue: " + venue
                + "\nOrganizer: " + organizer;
    }
}