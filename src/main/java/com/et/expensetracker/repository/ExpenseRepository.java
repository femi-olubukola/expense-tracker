package com.et.expensetracker.repository;

import com.et.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {

//    @Query("{'name': ?0 }")
    Optional<Expense> findByName(String name);
}
