package nflx.rozhnov.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class NewTransactionRq {
    private Long fromAccount;
    private Long toAccount;
    private double amount;
}
