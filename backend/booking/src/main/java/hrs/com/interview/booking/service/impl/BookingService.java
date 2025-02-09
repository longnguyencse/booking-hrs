package hrs.com.interview.booking.service.impl;

import hrs.com.interview.booking.service.IBookingService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class BookingService implements IBookingService {
    @Override
    public String createBooking(String bookingName, String bookingDate, String bookingTime) {
        return "";
    }

    @Override
    public String updateBooking(String bookingId, String bookingName, String bookingDate, String bookingTime) {
        return "";
    }

    @Override
    public String deleteBooking(String bookingId) {
        return "";
    }

    @Override
    public String getBooking(String bookingId) {
        return "";
    }

    @Override
    public String getAllBookings() {
        return "";
    }
}
