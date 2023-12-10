/*
 * the Budget class represents a budget 
 */
package budget;

import java.util.ArrayList;

import java.util.List;

public class Budget {
	
	
	// below are necessary lists to keep track of expenses, categories, and transactions that are associated with a specific budget. 
	private String name;// the name of the budget 
    private double income;// to hold the user's income 
    private List<Expense> expenses; // to hold expenses
    private List<Category> categories; // to hold categories related to a budget
    private List<Goal> goals; // to hold the goal related to a budget. 
    
    /* 
     * no-arg constructor
     */
    public Budget() { 
    	name = ""; 
	    income = 0.0; 
	    expenses = new ArrayList<>(); 
	    categories = new ArrayList<>();
	    goals = new ArrayList<>(); 
	    predefinedCategories(); //initializing the predefined categories in the constructor 
    }
    
    /*
     * constructor that accepts arguments 
     * @param income - the income that the user enters. 
     * @param name - the name of the budget 
     */
    public Budget(double income, String name) {
        this.income = income;
        this.name = name; 
        predefinedCategories(); 
    }
    
    /*
     * the setName method sets the name of the budget 
     */
    public void setName(String name) { 
    	this.name = name; 
    }
    
    // below are the getters and the setter methods
    
    /*
     * the setIncome method sets the income 
     */
    public void setIncome(double income) {
        this.income = income;
        
    }

    /*
     * the addExpense method adds an expense to the list. 
     * @param expense - an expense object to be added to the list 
     */
    public void addExpense(Expense expense) {  
    	
    	if (this.expenses == null) { // checking first if our expense list is null. 
    	    this.expenses = new ArrayList<Expense>(); // if true, then we create a new array list so we can add the expenses. 
    	}
    	
    	expenses.add(expense); // adding expense to the array 
    }
    /*
     * the addGoal method adds a new goal to the list. 
     * @param goal - a goal object to be added to the list 
     */
    public void addGoal(Goal goal) { 
    	if(this.goals == null) { 
    		this.goals = new ArrayList<Goal>(); 
    	}
    	goals.add(goal); 
    }
    
    /*
     * the removeExpense method removes an expense from the list. 
     * @param expense - the expense object to be removed from the list. 
     */
    public void removeExpense(Expense expense) { // removing the expense from the list. 
    	expenses.remove(expense);
    }
    
    /*
     * the addCategory method adds a category to a list 
     * @param category - the category to be added to the list 
     */
    public void addCategory(Category category) {
    	if (this.categories == null) { // checking first if our expense list is null. 
    	    this.categories = new ArrayList<Category>(); // if true, then we create a new array list so we can add the expenses. 
    	}
    	
    	categories.add(category);
    }
    

    /*
     * A method that retrieves a category by its name 
     * @param categoryName - a string that holds the name of a category 
     * return category
     */
    public Category getCategoryByName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        return null; // Category not found
    }
    
    /*
     * Void method that defines some predefined categories that are already included in the budget. 
     * 
     */
    public void predefinedCategories() {
    	
    	if (this.categories == null) { // checking first if our expense list is null. 
    	    this.categories = new ArrayList<Category>(); // if true, then we create a new array list so we can add the expenses. 
    	}
    	
        Category category1 = new Category("Housing");
        Category category2 = new Category("Transportation");
        Category category3 = new Category("Groceries");
        Category category4 = new Category("Utilities");
        Category category5 = new Category("Entertainment");

        // adding the categories to our category list. 
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
    }
    
    /*
     * the getIncome method returns the income of the user. 
     */
    public double getIncome() {
        return income;
    }
    
    /*
     * the getName method returns the name of the user. 
     * @return name 
     */
    public String getName() { 
    	return name; 
    }
    
    /*
     * the getExpenses method returns a list of expense 
     * @return expenses
     */
    public List<Expense> getExpenses() {
    	if (expenses == null) {
            return new ArrayList<>();
        }
        return expenses;
    }
    public List<Goal> getGoals() { 
    	if(goals == null) { 
    		return new ArrayList<>(); 
    	}
    	
    	return goals;
    }
    /*
     * the getCategories method returns a list of categories 
     * @return categories 
     */
    public List<Category> getCategories() { 
    	return categories; 
    }

    /*
     * calculates the remaining balance after all expenses.
     */
    public double calculateTotalExpenses() {
    	
        double totalExpenses = 0.0;// defining a variable that holds the total expenses 

        if (expenses == null) {
            return totalExpenses; // Return 0 as there are no expenses
        }

        for (Expense expense : expenses) {
            totalExpenses += expense.getTotal();
        }

        return totalExpenses;
    }
    


    
}

