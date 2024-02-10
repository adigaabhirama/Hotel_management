package Hotel_management;
package Hotel_management.hotelcinfo;

public class Room extends hotelcinfo {
    private String roomNumber;
    private int floorNumber;

    public Room(String roomNumber, int floorNumber) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " on Floor " + floorNumber;
    }

    public static void main(String[] args) {
        Room room101 = new Room("101", 1);
        System.out.println(room101); 
    }
}
