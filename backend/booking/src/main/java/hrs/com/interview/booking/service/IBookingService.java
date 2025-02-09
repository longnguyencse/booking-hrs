package hrs.com.interview.booking.service;

public interface IBookingService {
    public String createBooking(String bookingName, String bookingDate, String bookingTime);
    public String updateBooking(String bookingId, String bookingName, String bookingDate, String bookingTime);
    public String deleteBooking(String bookingId);
    public String getBooking(String bookingId);
    public String getAllBookings();
}
