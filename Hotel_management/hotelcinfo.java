package Hotel_management;
import java.util.ArrayList;
import java.util.Scanner;

public class hotelcinfo {
    static RoomDB roomDB = new RoomDB();
    static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Room Booking System!");
            System.out.println("1. Book a room");
            System.out.println("2. View booked rooms");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    bookRoom(input);
                    break;
                case 2:
                    viewBookedRooms();
                    break;
                case 3:
                    System.out.println("Thank you for using our system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void bookRoom(Scanner input) {
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter your phone number: ");
        String phone = input.next();
        System.out.print("Enter your address: ");
        String address = input.next();

        System.out.println("Available rooms:\n" + getRoomList(roomDB));
        System.out.print("Enter the room ID you want to book (or 'x' to quit): ");
        String roomID = input.next();

        if (roomID.equals("x")) {
            System.out.println("Booking canceled.");
            return;
        }

        Room room = getRoom(roomID);
        if (room == null) {
            System.out.println("Invalid room ID. Please try again.");
        } else if (!room.isBooked()) {
            room.setBooked(true);
            customers.add(new Customer(name, phone, address, roomID));
            System.out.println("Booking successful! Room " + roomID + " assigned.");
        } else {
            System.out.println("Room " + roomID + " is already booked. Please choose another room.");
        }
    }

    public static void viewBookedRooms() {
        System.out.println("Booked rooms:");
        for (Room r : roomDB.getRoom()) {
            if (r.isBooked()) {
                System.out.println(r.getRoomID());
            }
        }
    }

    public static String getRoomList(RoomDB roomDB) {
        StringBuilder roomList = new StringBuilder();
        for (Room r : roomDB.getRoom()) {
            roomList.append(r.getRoomID()).append(r.isBooked() ? " (Booked)" : " (Available)").append("\n");
        }
        return roomList.toString();
    }

    public static Room getRoom(String roomID) {
        for (Room r : roomDB.getRoom()) {
            if (r.getRoomID().equals(roomID)) {
                return r;
            }
        }
        return null;
    }
}

class RoomDB {
    private ArrayList<Room> room;
    private String[] roomID = {"Room1", "Room2"};

    RoomDB() {
        room = new ArrayList<>();
        for (String id : roomID) {
            addRoom(new Room(id));
        }
    }

    public void addRoom(Room addRoom) {
        room.add(addRoom);
    }

    public ArrayList<Room> getRoom() {
        return room;
    }
}

class Room {
    private String roomID;
    private boolean booked;

    Room(String roomID) {
        this.roomID = roomID;
        this.booked = false;
    }

    String getRoomID() {
        return roomID;
    }

    boolean isBooked() {
        return booked;
    }

    void setBooked(boolean booked) {
        this.booked = booked;
    }
}

class Customer {
    private String name;
    private String phone;
    private String address;
    private String roomID;

    Customer(String name, String phone, String address, String roomID) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.roomID = roomID;
    }
}
