package hrs.com.interview.booking.service.impl;

import hrs.com.interview.booking.repository.BookingRepository;
import hrs.com.interview.booking.service.IBookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;

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
