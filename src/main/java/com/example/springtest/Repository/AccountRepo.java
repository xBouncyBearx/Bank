package com.example.springtest.Repository;

import com.example.springtest.Entity.Account;
import com.example.springtest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
    Account findByUser(User user);
    Account findByAID(String AID);
}
