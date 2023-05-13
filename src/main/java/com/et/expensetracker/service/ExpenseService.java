package com.et.expensetracker.service;

import com.et.expensetracker.model.Expense;
import com.et.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId()).
                orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense by id %s", expense.getId())
                ));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense() {
       return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).
                orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense by name %s", name)
                ));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
