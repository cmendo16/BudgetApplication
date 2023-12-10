package overview;
import java.io.IOException;
import java.util.List;

import budget.Category;
import java.util.Scanner;
import budget.Budget;
import budget.Expense;
import budget.Goal;
import budget.BudgetApp; 



// This class will be the overview section in my java class

public class Overview {
		
		Budget budget; // the user's budget 
		Scanner scanner; // to read user input 
		String budgetName; // the name of the budget 
	/*
	 * no-arg constructor
	 */
	public Overview() {
		scanner = new Scanner(System.in); // needed to read input 
		budget = new Budget(); // budget object
		budgetName = ""; // the budgetName 
	}
	/*
	 * Constructor that accepts arguments 
	 */
	public Overview(Budget budget, String budgetName) { 
		scanner = new Scanner(System.in); // needed to read user input 
		this.budget = budget; // a user's object that holds information about a budget 
		this.budgetName = budgetName; // the name of the budget 
	}
	/*
	 * the setBudget method sets the budget 
	 * @param budget - the user's budget object 
	 */
	public void setBudget(Budget budget) { 
		this.budget = budget;
	}
	/*
	 * the setBudgetName method sets the name of the budget 
	 * @param budgetName - the name of the budget 
	 */
	public void setBudgetName(String budgetName) { 
		this.budgetName = budgetName; 
	}
	
	/*
	 * the displayBudgetContents method provides a budget overview. 
	 * It provides a list of expenses, the list of predefined categories, the and user's current goals. 
	 * It also provides insights on their budget such as the total income that the user entered, the total of all expenses that the user has entered, and the remaining calculated balance 
	 */
	public void displayBudgetContents() throws IOException {
        if (budget == null) { // checking if the budget is currently null 
            System.out.println("No budget information to display.");// if the budget is empty, then there is no budget information to display. This should print if the user hasn't planned their budget first. 
        } else {
            System.out.println("\tBUDGET OVERVIEW");// printing the title of the budget overview 
            System.out.println("\t---------------");
            System.out.println(); // printing a blank line
            

            System.out.println("\tEXPENSES:"); // displaying the expenses that the user entered in the budget 
            
            List<Expense> expenses = budget.getExpenses();
            
            if (expenses.isEmpty()) {
            	
                System.out.println("There are currently no expenses to display. ");// if the list is empty, no expenses have been entered and there is no information 
                System.out.println(); // blank line 
                
            } else {
                for (Expense expense : expenses) {// iterating through list of expenses 
                	System.out.println(expense.toString());// using toString to get the expense info 
                    System.out.println("------------"); 
                    
                }
            }

            System.out.println("\tCATEGORIES: ");// displaying the predefined categories in the budget 
            List<Category> categories = budget.getCategories();
            
            if (categories.isEmpty()) {
                System.out.println("No categories in the budget.");// displays if there's not categories
            } else {
                for (Category category : categories) {
                    System.out.println("Name: " + category.getName());// getting the name of the category 
                    System.out.println("------------"); 
                }
            }
            
           System.out.println("\tCURRENT GOALS:  ");//displaying the current goals
           
           List<Goal> goals = budget.getGoals(); // getting the list of the budget goals 
           
           if (goals.isEmpty()) {// checking if the goals list is empty
           		System.out.println(); 
               System.out.println("There are currently no goals to display. ");// displays if the user does not have any goals entered in their budget 
               System.out.println(); 
               
           } else {
               for (Goal g : goals) {
               	System.out.println(g.toString());// using toString to get the expense info 
                   System.out.println("------------"); 
                   
               }
           }
        }
        
        
        
        System.out.println("\n\tBUDGET INSIGHTS"); // below are budget insights 
        System.out.println("---------------"); 
        System.out.printf("\nTotal income entered: $%.2f", getBudgetIncome()); // displaying the total income entered. 
        
        System.out.printf("\nTotal of expenses: $%.2f", getTotalExpenses()); // displaying the total of all the expenses added together
        
       System.out.printf("\nRemaining balance: $%.2f", calculateRemainingBalance());  // displaying the total calculated remaining balance 
       
       
       
       System.out.println(); // printing a blank line between output 
       System.out.println("To return to the Budget Management Menu, please enter 1: ");
       int choice;

       do {
           while (!scanner.hasNextInt()) { // Check if the input is an integer
               System.out.println("Invalid input. Please enter 1 to return to the Budget Management Menu: ");
               scanner.next(); // Consume the non-integer input
           }
           choice = scanner.nextInt(); // reading in the input

           if (choice != 1) {
               System.out.println("Invalid input. Please enter 1 to return to the Budget Management Menu: ");
           }

           scanner.nextLine(); // Consume the newline character

       } while (choice != 1); // Continuing the loop until the user enter's one. 
      
       System.out.println(); // printing a blank line 
       System.out.println("Returning you to the Budget Management Menu..."); 
       
       BudgetApp budgetApp = BudgetApp.getInstance(); // getting the singleton instance
       
       try { // budgetOptions throws an exception, so we surround i've surrounded it with a try-catch 
        budgetApp.budgetOptions(this.budget, this.budgetName);
       } catch (IOException e) { 
    	   System.out.println("Error displaying Budget Options"); 
    	   e.printStackTrace();
       }
   
        
    }
	
	/* the getBudgetIncome method gets the user's income 
	 */
	private double getBudgetIncome() { 
	
		return budget.getIncome(); //returning the income 
	}
	
	/*
	 * the getTotalExpenses method gets the user's total expenses 
	 */
	private double getTotalExpenses() { 
			return budget.calculateTotalExpenses(); // returning the value after calculating the total expenses of the budget. 
	}

	/*
	 * the calculateRemaningBalance method returns the remaining balance after subtracting the user's income and budget.  
	 */
	 private double calculateRemainingBalance() {
		 return getBudgetIncome() - getTotalExpenses(); 
	  }
	 

}
