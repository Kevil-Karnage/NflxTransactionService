package nflx.rozhnov.controller;

import nflx.rozhnov.dto.request.GetAccountTransactionsRq;
import nflx.rozhnov.dto.request.GetTransactionRq;
import nflx.rozhnov.dto.request.NewTransactionRq;
import nflx.rozhnov.dto.response.TransactionResponse;
import nflx.rozhnov.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/transactions")

public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public TransactionResponse request(NewTransactionRq request) {
        return new TransactionResponse();
    }

    @GetMapping("/check")
    public TransactionResponse check() {
        return new TransactionResponse(
                "transactionExample",
                "200",
                "OK",
                ZonedDateTime.now()
        );
    }

    @PostMapping("/new")
    public TransactionResponse createNew(@RequestBody NewTransactionRq rq) {
        return service.createNewTransaction(rq);
    }

    @PostMapping("/get")
    public TransactionResponse getById(@RequestBody GetTransactionRq rq) {
        return service.getTransactionById(rq);
    }

    @PostMapping("/account")
    public List<TransactionResponse> getAccountTransactions(@RequestBody GetAccountTransactionsRq rq) {
        return service.getAccountTransactions(rq);
    }
}
