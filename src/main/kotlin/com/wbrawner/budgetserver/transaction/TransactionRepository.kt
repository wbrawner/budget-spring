package com.wbrawner.budgetserver.transaction

import com.wbrawner.budgetserver.budget.Budget
import com.wbrawner.budgetserver.category.Category
import com.wbrawner.budgetserver.setToFirstOfMonth
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import java.time.Instant
import java.util.*

interface TransactionRepository: PagingAndSortingRepository<Transaction, Long> {
    fun findAllByBudgetInAndCategoryInAndDateGreaterThanAndDateLessThan(
            budgets: List<Budget>,
            categories: List<Category>,
            start: Instant,
            end: Instant,
            pageable: Pageable? = null
    ): List<Transaction>
    fun findAllByBudgetAndCategory(budget: Budget, category: Category): List<Transaction>
    @Query(
            nativeQuery = true,
            value = "SELECT (COALESCE((SELECT SUM(amount) from transaction WHERE Budget_id = :BudgetId AND expense = 0 AND date > :start), 0)) - (COALESCE((SELECT SUM(amount) from transaction WHERE Budget_id = :BudgetId AND expense = 1 AND date > :date), 0));"
    )
    fun sumBalanceByBudgetId(BudgetId: Long, start: Date = GregorianCalendar().setToFirstOfMonth().time): Long

    @Query(
            nativeQuery = true,
            value = "SELECT (COALESCE((SELECT SUM(amount) from transaction WHERE category_id = :categoryId AND expense = 0 AND date > :start), 0)) - (COALESCE((SELECT SUM(amount) from transaction WHERE category_id = :categoryId AND expense = 1 AND date > :start), 0));"
    )
    fun sumBalanceByCategoryId(categoryId: Long, start: Date = GregorianCalendar().setToFirstOfMonth().time): Long
}