package com.wbrawner.budgetserver.category;

public class NewCategoryRequest {
    private final String title;
    private final String description;
    private final CategoryAmountRequest amount;
    private final Long budgetId;
    private final Boolean expense;

    public NewCategoryRequest() {
        this(null, null, null, null, null);
    }

    public NewCategoryRequest(String title,
                              String description,
                              CategoryAmountRequest amount,
                              Long budgetId,
                              Boolean expense) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.budgetId = budgetId;
        this.expense = expense;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public CategoryAmountRequest getAmount() {
        return amount;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public Boolean getExpense() {
        return expense;
    }
}
