package com.et.expensetracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table
public class Expense {

    @Id
//    @SequenceGenerator(
//            name = "expense_sequence",
//            sequenceName = "expense_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "expense_sequence"
    )
    private Long Id;
    @Column(unique = true)
    private String expenseName;
    private ExpenseCategory expenseCategory;
    private BigDecimal expenseAmount;

    public Expense(Long id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        Id = id;
        this.expenseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
    }

    public Expense() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
