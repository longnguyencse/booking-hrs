package hrs.com.interview.booking.controller;

import hrs.com.interview.booking.service.IBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/booking")
@AllArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    @PostMapping("")
    ResponseEntity<String> createBooking() {
        return ResponseEntity.ok("Booking created successfully");
    }

    @PutMapping(":id")
    ResponseEntity<String> updateBooking() {
        return ResponseEntity.ok("Booking updated successfully");
    }

    @DeleteMapping("")
    ResponseEntity<String> deleteBooking() {
        return ResponseEntity.ok("Booking deleted successfully");
    }

    @PatchMapping(":id")
    ResponseEntity<String> patchUpdateBooking() {
        return ResponseEntity.ok("Booking retrieved successfully");
    }

    @GetMapping(":id")
    ResponseEntity<String> getBooking() {
        return ResponseEntity.ok("All bookings retrieved successfully");
    }

}
