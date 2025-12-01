package com.example.springtest.Service;

import com.example.springtest.DTO.GetTransactionsRequest;
import com.example.springtest.DTO.TransactionRequest;
import com.example.springtest.DTO.TransactionResponse;
import com.example.springtest.Entity.Account;
import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;
import com.example.springtest.Entity.Transaction;
import com.example.springtest.Repository.AccountRepo;
import com.example.springtest.Repository.TransactionRepo;
import com.example.springtest.Service.Specification.TransactionSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;


@Service
public class TransactionService {

    @Value("${X}")
    private Double X;
    @Value("${Y}")
    private Double Y;
    @Value("${Z}")
    private Double Z;
    @Value("${BankAID}")
    private String BankAID;

    TransactionRepo transactionRepo;
    AccountRepo accountRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @Transactional
    public TransactionResponse transactionRequest(TransactionRequest transactionRequest){
        TransactionResponse transactionResponse = new TransactionResponse();
        Account ac1, ac2;
        Transaction transaction;

        if(transactionRequest.getAmount() <= 0.0){
            transactionResponse.setResponse("Amount must be greater than 0");
            return transactionResponse;
        }
        Double Fee = calculateFee(transactionRequest.getAmount());

        switch (transactionRequest.getTransactionType()){
            case DEPOSIT:
                ac1 = accountRepo.findByAID(transactionRequest.getTo());
                if(ac1 == null){
                    transactionResponse.setResponse("Bad Transaction : no account found");
                    return transactionResponse;
                }
                if(!ac1.getAccountStatus().equals(AccountStatus.ACTIVE)){
                    transactionResponse.setResponse("Bad Transaction : Account is Not Active");
                    return transactionResponse;
                }
                transaction = new Transaction();
                transaction.setTransactionId(TIDGenerator(transactionRequest.getFrom(), transactionRequest.getTo()));
                transaction.setTransactionType(transactionRequest.getTransactionType());
                transaction.setTransactionStatus(TransactionStatus.DONE);
                transaction.setFrom(transactionRequest.getFrom());
                transaction.setTo(transactionRequest.getTo());
                transaction.setAmount(transactionRequest.getAmount());

                ac1.setBalance(ac1.getBalance() + transactionRequest.getAmount());
                try{
                    transactionRepo.save(transaction);
                    accountRepo.save(ac1);
                }catch(Exception e){
                    transactionResponse.setResponse("Transaction Failed");
                }
                transactionResponse.setResponse("success");
                transactionResponse.setTransactionId(transaction.getTransactionId());
                return transactionResponse;

            case WITHDRAW:
                ac1 = accountRepo.findByAID(transactionRequest.getFrom());
                if(ac1 == null){
                    transactionResponse.setResponse("Bad Transaction : No Account Found");
                    return transactionResponse;
                }
                if(!ac1.getAccountStatus().equals(AccountStatus.ACTIVE)){
                    transactionResponse.setResponse("Bad Transaction : Account is Not Active");
                    return transactionResponse;
                }
                if(ac1.getBalance() < transactionRequest.getAmount()){
                    transactionResponse.setResponse("Bad Transaction : Insufficient Balance");
                    return transactionResponse;
                }
                transaction = new Transaction();
                transaction.setTransactionId(TIDGenerator(transactionRequest.getFrom(), transactionRequest.getTo()));
                transaction.setTransactionType(transactionRequest.getTransactionType());
                transaction.setTransactionStatus(TransactionStatus.DONE);
                transaction.setFrom(transactionRequest.getFrom());
                transaction.setTo(transactionRequest.getTo());
                transaction.setAmount(transactionRequest.getAmount());

                ac1.setBalance(ac1.getBalance() - transactionRequest.getAmount());
                try{
                    transactionRepo.save(transaction);
                    accountRepo.save(ac1);
                }catch(Exception e){
                    transactionResponse.setResponse("Transaction Failed");
                }
                transactionResponse.setResponse("success");
                transactionResponse.setTransactionId(transaction.getTransactionId());
                return transactionResponse;

            case TRANSFER:
                if(transactionRequest.getFrom().equals(transactionRequest.getTo())){
                    transactionResponse.setResponse("Bad Transaction : Same Accounts");
                    return transactionResponse;
                }
                ac1 = accountRepo.findByAID(transactionRequest.getFrom());
                ac2 = accountRepo.findByAID(transactionRequest.getTo());
                if(ac1 == null || ac2 == null){
                    transactionResponse.setResponse("Bad Transaction : No Account Found");
                    return transactionResponse;
                }
                if(!ac1.getAccountStatus().equals(AccountStatus.ACTIVE) || !ac2.getAccountStatus().equals(AccountStatus.ACTIVE)){
                    transactionResponse.setResponse("Bad Transaction : Accounts Are Not Active");
                    return transactionResponse;
                }
                if(ac1.getBalance() < transactionRequest.getAmount() + Fee){
                    transactionResponse.setResponse("Bad Transaction : Insufficient Balance");
                    return transactionResponse;
                }
                transaction = new Transaction();
                transaction.setTransactionId(TIDGenerator(transactionRequest.getFrom(), transactionRequest.getTo()));
                transaction.setTransactionType(transactionRequest.getTransactionType());
                transaction.setTransactionStatus(TransactionStatus.DONE);
                transaction.setFrom(transactionRequest.getFrom());
                transaction.setTo(transactionRequest.getTo());
                transaction.setAmount(transactionRequest.getAmount());

                ac1.setBalance(ac1.getBalance() - transactionRequest.getAmount());
                ac2.setBalance(ac2.getBalance() + transactionRequest.getAmount());

                Transaction bankTransaction = new Transaction();
                transaction.setTransactionId(TIDGenerator(transactionRequest.getFrom(), BankAID));
                bankTransaction.setTransactionType(TransactionType.TRANSFER);
                bankTransaction.setTransactionStatus(TransactionStatus.DONE);
                bankTransaction.setFrom(transactionRequest.getFrom());
                bankTransaction.setTo(BankAID);
                bankTransaction.setAmount(Fee);

                try{
                    transactionRepo.save(transaction);
                    transactionRepo.save(bankTransaction);
                    accountRepo.save(ac1);
                    accountRepo.save(ac2);
                }catch(Exception e){
                    transactionResponse.setResponse("Transaction Failed");
                    return transactionResponse;
                }
                transactionResponse.setResponse("success");
                transactionResponse.setTransactionId(transaction.getTransactionId());
                return transactionResponse;
            default:
                transactionResponse.setResponse("Bad Transaction : Not a Transaction Type");
                return transactionResponse;
        }
    }

    public TransactionStatus getTransactionStatus(String TID){
        Transaction transaction = transactionRepo.findByTransactionId(TID);
        if(transaction == null){
            return null;
        }
        return transaction.getTransactionStatus();
    }

    public Page<Transaction> getTransactions(GetTransactionsRequest getTransactionsRequest) {

        Long tid = getTransactionsRequest.getTid();
        String fromAccount = getTransactionsRequest.getFromAccount();
        String toAccount =  getTransactionsRequest.getToAccount();
        TransactionType type = getTransactionsRequest.getType();
        TransactionStatus status = getTransactionsRequest.getStatus();
        Double minAmount = getTransactionsRequest.getMinAmount();
        Double maxAmount = getTransactionsRequest.getMaxAmount();
        LocalDateTime startDate = getTransactionsRequest.getStartDate();
        LocalDateTime endDate = getTransactionsRequest.getEndDate();
        Pageable pageable = PageRequest.of(0, 10);

        Specification<Transaction> spec = (root, query, cb) -> cb.conjunction();

        if (tid != null)
            spec = spec.and(TransactionSpecs.tid(tid));

        if (fromAccount != null)
            spec = spec.and(TransactionSpecs.fromAccount(fromAccount));

        if (toAccount != null)
            spec = spec.and(TransactionSpecs.toAccount(toAccount));

        if (type != null)
            spec = spec.and(TransactionSpecs.type(type));

        if (status != null)
            spec = spec.and(TransactionSpecs.status(status));

        if (minAmount != null && maxAmount != null)
            spec = spec.and(TransactionSpecs.amountBetween(minAmount, maxAmount));

        if (startDate != null && endDate != null)
            spec = spec.and(TransactionSpecs.createdBetween(startDate, endDate));

        return transactionRepo.findAll(spec, pageable);
    }

    public Double getBalance(String AID){
        Account account = accountRepo.findByAID(AID);
        if(account == null){
            return null;
        }
        return account.getBalance();
    }

    private Double calculateFee(Double amount){
        if(X*amount < Y){
            return Y;
        }
        if(X*amount > Z){
            return Z;
        }
        return X*amount;
    }

    private String TIDGenerator(String From, String To){
        String TID = "";
        if(From != null){
            TID += From;
        }
        if(To != null){
            TID += To;
        }
        return TID + System.currentTimeMillis();
    }
}
