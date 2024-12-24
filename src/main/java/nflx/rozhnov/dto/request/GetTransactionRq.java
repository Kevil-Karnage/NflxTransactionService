package nflx.rozhnov.dto.request;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GetTransactionRq {
    private UUID transactionId;
}
