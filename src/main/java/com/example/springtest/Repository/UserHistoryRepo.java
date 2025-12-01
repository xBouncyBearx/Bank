package com.example.springtest.Repository;

import com.example.springtest.Entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepo extends JpaRepository<UserHistory, Integer> {
}
