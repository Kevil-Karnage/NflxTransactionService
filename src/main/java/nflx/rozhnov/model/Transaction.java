package nflx.rozhnov.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Transaction {
    @Id
    private UUID transactionId;
    private String status;
    private String message;
    private ZonedDateTime timestamp;
    private Long fromAccount;
    private Long toAccount;
}
