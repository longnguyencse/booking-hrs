package hrs.com.interview.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "room_booking")
public class RoomBookingEntity {
    @Id
    private UUID roomBookingId;
    private String roomType;
    private String RoomNumber;

    @ManyToOne
    private BookingEntity bookingEntity;
}
