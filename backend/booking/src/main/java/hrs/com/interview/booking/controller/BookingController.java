package hrs.com.interview.booking.controller;

import hrs.com.interview.booking.facade.BookingFacade;
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

    private final BookingFacade bookingFacade;

    @PostMapping("")
    ResponseEntity<String> createBooking() {
        return ResponseEntity.ok(bookingFacade.createBooking());
    }

    @PutMapping(":id")
    ResponseEntity<String> updateBooking() {
        return ResponseEntity.ok(bookingFacade.updateBooking());
    }

    @DeleteMapping("")
    ResponseEntity<String> deleteBooking() {
        return ResponseEntity.ok(bookingFacade.deleteBooking());
    }

    @PatchMapping(":id")
    ResponseEntity<String> patchUpdateBooking() {
        return ResponseEntity.ok(bookingFacade.patchUpdateBooking());
    }

    @GetMapping(":id")
    ResponseEntity<String> getBooking() {
        return ResponseEntity.ok(bookingFacade.getBooking());
    }

}
