package hotelReservationSystem;

import java.util.Scanner;

public class HotelReservationSystem {
	  public static void main(String[] args) {
	        Hotel hotel = new Hotel();
	        hotel.addRoom(101, "Standard");
	        hotel.addRoom(102, "Deluxe");
	        hotel.addRoom(103, "Suite");

	        Scanner scanner = new Scanner(System.in);

	        boolean quit = false;
	        while (!quit) {
	            System.out.println("\nHotel Reservation System Menu:");
	            System.out.println("1. Display available rooms");
	            System.out.println("2. Make reservation");
	            System.out.println("3. View booking details");
	            System.out.println("4. Quit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    hotel.displayAvailableRooms();
	                    break;
	                case 2:
	                    System.out.print("Enter guest name: ");
	                    scanner.nextLine(); // Consume newline character
	                    String guestName = scanner.nextLine();
	                    System.out.print("Enter room number: ");
	                    int roomNumber = scanner.nextInt();
	                    System.out.print("Enter duration of stay (in nights): ");
	                    int duration = scanner.nextInt();
	                    Reservation reservation = hotel.makeReservation(guestName, roomNumber, duration);
	                    if (reservation != null) {
	                        System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
	                    }
	                    break;
	                case 3:
	                    System.out.print("Enter reservation ID: ");
	                    int reservationId = scanner.nextInt();
	                    hotel.displayBookingDetails(reservationId);
	                    break;
	                case 4:
	                    quit = true;
	                    System.out.println("Exiting program. Thank you!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
	            }
	        }

	        scanner.close();
	    }
}
