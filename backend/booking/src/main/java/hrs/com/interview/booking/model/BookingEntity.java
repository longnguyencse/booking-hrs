package hrs.com.interview.booking.model;

import hrs.com.interview.booking.constant.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "booking")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor
public class BookingEntity {
    @Id
    private UUID bookingId;
    private String bookingName;
    private UUID hotelId;

    private Date arrivalDate;
    private Date departureDate;
    private Date cancelDate;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfInfants;

    private String confirmationNumber;
    private String ItineraryNumber;
    private String currencyCode;
    private String distributionChannel;
    private String source;
    private String bookingType;


    private int numberOfRooms;
    @OneToMany(mappedBy = "bookingEntity")
    private List<RoomBookingEntity> roomBookingEntities;

    private String paymentStatus;
    private String paymentMethod;
    private Date paymentDueDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private String profileName;
    private String profileEmail;
    private String profilePhone;

    private String ratePlanCodes;
    private String ratePlanNames;

    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;

}
