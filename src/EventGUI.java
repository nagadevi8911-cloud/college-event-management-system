import javax.swing.*;
import java.awt.*;

public class EventGUI {

    static EventManager manager = new EventManager();

    public static void main(String[] args) {

        JFrame frame = new JFrame("College Event Management System");
        frame.setSize(750, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main background
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(new Color(240, 244, 255));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 30, 20, 30)
        );

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setLayout(new GridLayout(2, 1));
        header.setBackground(new Color(55, 70, 180));
        header.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 20, 10)
        );

        JLabel title = new JLabel(
                "COLLEGE EVENT MANAGEMENT SYSTEM",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
                "Plan • Manage • Register • Enjoy",
                SwingConstants.CENTER
        );

        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(subtitle);

        // ================= BUTTON PANEL =================

        JPanel buttonPanel = new JPanel(
                new GridLayout(5, 1, 15, 15)
        );

        buttonPanel.setBackground(
                new Color(240, 244, 255)
        );

        JButton addEvent =
                new JButton("➕   ADD EVENT");

        JButton viewEvents =
                new JButton("📋   VIEW EVENTS");

        JButton register =
                new JButton("📝   REGISTER FOR EVENT");

        JButton viewRegistrations =
                new JButton("👥   VIEW REGISTERED STUDENTS");

        JButton exit =
                new JButton("🚪   EXIT");

        Font buttonFont =
                new Font("Arial", Font.BOLD, 17);

        addEvent.setFont(buttonFont);
        viewEvents.setFont(buttonFont);
        register.setFont(buttonFont);
        viewRegistrations.setFont(buttonFont);
        exit.setFont(buttonFont);

        // Button colors
        addEvent.setBackground(new Color(76, 175, 80));
        viewEvents.setBackground(new Color(33, 150, 243));
        register.setBackground(new Color(255, 152, 0));
        viewRegistrations.setBackground(new Color(156, 39, 176));
        exit.setBackground(new Color(244, 67, 54));

        addEvent.setForeground(Color.WHITE);
        viewEvents.setForeground(Color.WHITE);
        register.setForeground(Color.WHITE);
        viewRegistrations.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);

        addEvent.setFocusPainted(false);
        viewEvents.setFocusPainted(false);
        register.setFocusPainted(false);
        viewRegistrations.setFocusPainted(false);
        exit.setFocusPainted(false);

        buttonPanel.add(addEvent);
        buttonPanel.add(viewEvents);
        buttonPanel.add(register);
        buttonPanel.add(viewRegistrations);
        buttonPanel.add(exit);

        // ================= FOOTER =================

        JLabel footer = new JLabel(
                "🎓  Welcome to your College Event Portal  🎓",
                SwingConstants.CENTER
        );

        footer.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        footer.setForeground(
                new Color(55, 70, 180)
        );

        // Add everything
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        frame.add(mainPanel);

        // ================= ADD EVENT =================

        addEvent.addActionListener(e -> {

            try {

                String idText =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Event ID:"
                        );

                if (idText == null) return;

                int id =
                        Integer.parseInt(idText);

                String name =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Event Name:"
                        );

                if (name == null) return;

                String date =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Event Date:"
                        );

                if (date == null) return;

                String venue =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Venue:"
                        );

                if (venue == null) return;

                String organizer =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Organizer:"
                        );

                if (organizer == null) return;

                Event event =
                        new Event(
                                id,
                                name,
                                date,
                                venue,
                                organizer
                        );

                manager.addEvent(event);

                JOptionPane.showMessageDialog(
                        frame,
                        "✅ Event added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "❌ Please enter a valid Event ID.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // ================= VIEW EVENTS =================

        viewEvents.addActionListener(e -> {

            if (manager.getEvents().isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "❌ No events available."
                );

            } else {

                StringBuilder details =
                        new StringBuilder();

                details.append(
                        "===== 🎓 COLLEGE EVENTS =====\n\n"
                );

                for (Event event :
                        manager.getEvents()) {

                    details.append(
                            event.toString()
                    );

                    details.append(
                            "\n--------------------------\n"
                    );
                }

                JOptionPane.showMessageDialog(
                        frame,
                        details.toString(),
                        "📋 College Events",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ================= REGISTER =================

        register.addActionListener(e -> {

            if (manager.getEvents().isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "❌ No events available.\nPlease add an event first."
                );

                return;
            }

            try {

                String studentName =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Student Name:"
                        );

                if (studentName == null) return;

                String rollNumber =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Roll Number:"
                        );

                if (rollNumber == null) return;

                String eventIdText =
                        JOptionPane.showInputDialog(
                                frame,
                                "Enter Event ID:"
                        );

                if (eventIdText == null) return;

                int eventId =
                        Integer.parseInt(eventIdText);

                boolean found = false;

                for (Event event :
                        manager.getEvents()) {

                    if (event.getId() == eventId) {

                        found = true;
                        break;
                    }
                }

                if (!found) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "❌ Event ID not found.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

                Registration registration =
                        new Registration(
                                studentName,
                                rollNumber,
                                eventId
                        );

                registration.displayRegistration();

                JOptionPane.showMessageDialog(
                        frame,
                        "🎉 REGISTRATION SUCCESSFUL!\n\n"
                        + "Student Name: "
                        + studentName
                        + "\nRoll Number: "
                        + rollNumber
                        + "\nEvent ID: "
                        + eventId,
                        "Registration Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "❌ Please enter a valid Event ID.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // ================= VIEW REGISTRATIONS =================

        viewRegistrations.addActionListener(e -> {

            if (Registration.getRegistrations().isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "❌ No students registered yet."
                );

            } else {

                StringBuilder details =
                        new StringBuilder();

                details.append(
                        "===== 👥 REGISTERED STUDENTS =====\n\n"
                );

                for (Registration r :
                        Registration.getRegistrations()) {

                    details.append(
                            "Student Name: "
                    )
                    .append(r.getStudentName())
                    .append("\n");

                    details.append(
                            "Roll Number: "
                    )
                    .append(r.getRollNumber())
                    .append("\n");

                    details.append(
                            "Event ID: "
                    )
                    .append(r.getEventId())
                    .append("\n");

                    details.append(
                            "--------------------------\n"
                    );
                }

                JOptionPane.showMessageDialog(
                        frame,
                        details.toString(),
                        "👥 Registered Students",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ================= EXIT =================

        exit.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to exit?",
                            "Exit",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}