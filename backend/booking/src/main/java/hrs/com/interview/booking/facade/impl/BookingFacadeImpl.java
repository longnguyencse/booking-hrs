package hrs.com.interview.booking.facade.impl;

import hrs.com.interview.booking.facade.BookingFacade;
import hrs.com.interview.booking.service.IBookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingFacadeImpl implements BookingFacade {

    private final IBookingService bookingService;
    @Override
    public String createBooking() {
        return "Booking created successfully";
    }

    @Override
    public String updateBooking() {
        return "Booking updated successfully";
    }

    @Override
    public String deleteBooking() {
        return "Booking deleted successfully";
    }

    @Override
    public String patchUpdateBooking() {
        return "Booking retrieved successfully";
    }

    @Override
    public String getBooking() {
        return "All bookings retrieved successfully";
    }
}
