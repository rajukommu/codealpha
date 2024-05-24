package hotelReservationSystem;


import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean available;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void bookRoom() {
        available = false;
    }

    public void releaseRoom() {
        available = true;
    }
}

class Reservation {
    private int reservationId;
    private String guestName;
    private Room room;
    private int duration;
    private double totalPrice;

    public Reservation(int reservationId, String guestName, Room room, int duration, double totalPrice) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.room = room;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public int getDuration() {
        return duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private int nextReservationId;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        nextReservationId = 1;
    }

    public void addRoom(int roomNumber, String category) {
        rooms.add(new Room(roomNumber, category));
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Category: " + room.getCategory());
            }
        }
    }

    public Reservation makeReservation(String guestName, int roomNumber, int duration) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                room = r;
                break;
            }
        }
        if (room == null || !room.isAvailable()) {
            System.out.println("Invalid room number or room is not available.");
            return null;
        }

        double totalPrice = calculateTotalPrice(room.getCategory(), duration);
        Reservation reservation = new Reservation(nextReservationId++, guestName, room, duration, totalPrice);
        room.bookRoom();
        reservations.add(reservation);
        return reservation;
    }

    private double calculateTotalPrice(String category, int duration) {
        // Simple calculation for demonstration purposes, actual pricing logic may vary
        double pricePerNight;
        if (category.equals("Standard")) {
            pricePerNight = 100.0;
        } else if (category.equals("Deluxe")) {
            pricePerNight = 150.0;
        } else {
            pricePerNight = 200.0;
        }
        return pricePerNight * duration;
    }

    public void displayBookingDetails(int reservationId) {
        Reservation reservation = null;
        for (Reservation r : reservations) {
            if (r.getReservationId() == reservationId) {
                reservation = r;
                break;
            }
        }
        if (reservation == null) {
            System.out.println("Invalid reservation ID.");
            return;
        }

        System.out.println("Booking Details:");
        System.out.println("Reservation ID: " + reservation.getReservationId());
        System.out.println("Guest Name: " + reservation.getGuestName());
        System.out.println("Room Number: " + reservation.getRoom().getRoomNumber());
        System.out.println("Category: " + reservation.getRoom().getCategory());
        System.out.println("Duration: " + reservation.getDuration() + " nights");
        System.out.println("Total Price: $" + reservation.getTotalPrice());
    }
}


