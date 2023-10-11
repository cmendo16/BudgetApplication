// the budget manager class manages a list of budgets
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
	private List<Budget> budgets; // creating a list of budgets
	
	/* 
	 * no arg constructor
	 */
	public BudgetManager() { 
		budgets = new ArrayList<>(); 
	}
	
	public BudgetManager(double income) { 
		Budget budget = new Budget(income); // creating a new budget and passing income to constructor
		budgets.add(budget); // adding budget to the Budget list
	}
	
	// below are the getter and setter methods 
	public List<Budget> getBudgets() { 
		return budgets; // returning the list of budgets
	}
	
	// below are the methods to remove and add budgets
	
	/*
	 * @param budget - the budget object to be removed
	 */
	public void removeBudget(Budget budget) { 
		budgets.remove(budget);
	}
	
	/*
	 * @param budget - the budget object to be added to the list 
	 */
	public void addBudget(Budget budget) { 
		budgets.add(budget); // the budget to added
	}
}
