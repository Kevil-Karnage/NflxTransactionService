package nflx.rozhnov.service;

import nflx.rozhnov.repository.TransactionRepository;
import nflx.rozhnov.repository.AccountRepository;
import nflx.rozhnov.dto.enums.TransactionStatus;
import nflx.rozhnov.dto.request.GetAccountTransactionsRq;
import nflx.rozhnov.dto.request.GetTransactionRq;
import nflx.rozhnov.dto.request.NewTransactionRq;
import nflx.rozhnov.dto.response.TransactionResponse;
import nflx.rozhnov.model.Account;
import nflx.rozhnov.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    public TransactionResponse createNewTransaction(NewTransactionRq rq) {
        Account accountFrom = accountRepository.findById(rq.getFromAccount()).get();
        if (accountFrom.getAmount() < rq.getAmount()) {
            // TODO: make custom exception
            throw new RuntimeException();
        }

        // TODO: mapper
        Transaction transaction = new Transaction();
        transaction.setStatus(TransactionStatus.PENDING.name());
        transaction.setMessage(TransactionStatus.PENDING.getMessage());
        transaction.setTimestamp(ZonedDateTime.now());
        transaction.setFromAccount(rq.getFromAccount());
        transaction.setToAccount(rq.getToAccount());
        transactionRepository.save(transaction);
        return null;
    }

    public TransactionResponse getTransactionById(GetTransactionRq rq) {
        return null;
    }

    public List<TransactionResponse> getAccountTransactions(GetAccountTransactionsRq rq) {
        return null;
    }

}
