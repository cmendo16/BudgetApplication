package createBudget;// we are currently in the createBudget class
//import budget.BudgetManager; 
import budget.Budget; // this will represents someone's budget 

import budget.BudgetApp;

import budget.Expense; // to use the expense class
import budget.Goal;
import budget.Category;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner; // needed for the Scanner class 

/*
 * This class provides methods where user's can add expenses, remove expenses, add goals, and enter their income. 
 * It represents the 'Plan Your Budget' section in the program. 
 */

public class PlanBudget {
	
    Scanner scanner; // Scanner object 
	private Budget budget; // the user's budget 
	private String budgetName;  

	/*
	 * no arg constructor 
	 */
	public PlanBudget() { 
		scanner = new Scanner(System.in); // needed to read user input 
		budgetName = ""; // the name of the budget 
		budget = new Budget(); // a budget object 
	}
	/*
	 * constructor that accepts arguments 
	 * @param budget - a budget object
	 * @param budgetName - the name of the budget 
	 */
	public PlanBudget(Budget budget, String budgetName) {
		scanner = new Scanner(System.in); 
	    this.budget = budget;
	    this.budgetName = budgetName; 
		
	}
	// setter and getter methods for the budget and budget name 
	
	/*
	 * the setBudget method sets a budget object 
	 * @param budget - a budget object 
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
	 * the enterIncome class allows the user to enter their income. 
	 */
	public void enterIncome() { 
		
		double income = 0.0; // variable to hold the income for the user 
		boolean validInput = false; // flag to track valid input
		
		System.out.println("\tWELCOME TO PLAN YOUR BUDGET"); 
		System.out.println("\t--------------------"); 
		
		if(budget.getIncome() == 0.0) { // if the user's income is 0 (meaning, there has been no income entered), then ask the user to enter their income 
			
		while (!validInput) {// using a while loop and a flag for input validation, this ensures that the user enters a numeric value. ß
	        try {
	            System.out.print("\nPlease enter your income: "); 
	            income = scanner.nextDouble();  
	            validInput = true; // Input is valid, exit the loop
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid numeric value.");// displaying error message. 
	            scanner.nextLine(); // Consume newline 
	        }
	    }
		
		} else { 
			System.out.printf("\tYou're current income is: $%.2f", budget.getIncome()); // displaying the user's current income if they have already entered one. 
		}
		
		this.budget.setIncome(income);// passing the income and saving it to the budget
	
		
	} 
	
	/*
	 * displayMenu displays a menu that will allow the user to customize their own budget 
	 */
	public void budgetManagementMenu() { 
		
		// display the menu that the user will user to create a budget 
		System.out.println(); // printing blank line 
		System.out.println("\tPLANNING YOUR BUDGET"); 
		System.out.println("\t--------------------");

		
            System.out.print("\nSelect from the following options to plan your budget!"); // displaying the menu 
            System.out.println(); // printing blank line in-between output 
            System.out.println("\nBudget Management Menu");
            System.out.println("1. Add an Expense");
            System.out.println("2. Remove an Expense");
            System.out.println("3. Add a goal"); 
            System.out.println("4. Save your budget");
            System.out.println("5. Return to Budget Menu. "); 

            try { 
            int choice = scanner.nextInt();
            
            scanner.nextLine(); // Consuming the newline character

            while(choice < 1 || choice > 5) { 
            	System.out.print("\nInvalid input. Please try again and enter a number between 1 and 5: "); 
            	choice = scanner.nextInt();
            	scanner.nextLine(); // consuming the new line 
            }
            System.out.println(); // printing a blank line
            
            switch (choice) {
                case 1:
                	addExpense();  // calling the addExpense method if they user indicates they want to enter an expense 
                    break;
                case 2:
                	 removeExpense(); // calling the removeExpense method if the user wants to remove an expense 
                    break;
                case 3:
               	 	addGoal(); // calling the addGoal method if the user wants to enter a new goal 
               	 	break;
                case 4: 
               	saveBudgetToFile();
                System.out.println("Returning you to the Budget Management Menu.."); // displaying message that we are returning the user to the budget management menu. 
                budgetManagementMenu(); // displaying the options again. 
                	break; 
                case 5: 
                	System.out.print("Are you sure you want to return to the Budget Menu? (Y/N):  ");// making sure that the user wants to return to the previous menu 
                	String response = scanner.nextLine(); 
                	
                	//do-while loop input validation 
                	while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) { 
                		System.out.println("ERROR. Invalid input. Please enter Y or N. ");
                		System.out.print("\nAre you sure you want to return to the Budget Menu? (Y/N):  ");
                		response = scanner.nextLine(); 
                	}
                	
                	// if user's response is yes, return to the previous menu..
                	if(response.equalsIgnoreCase("Y")) { 
                		System.out.println("Returning to the previous menu.."); 
                		BudgetApp budgetApp = BudgetApp.getInstance(); // getting the singleton instance 
						budgetApp.budgetOptions(budget, budgetName); 
                	}
                	else { 
                		System.out.println("Returning to the Budget Management Menu.."); // if no, then return the user to to the budget management menu 
                		budgetManagementMenu(); 
                	}
                	break; 
                    
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer."); 
            scanner.nextLine(); // consuming newline to prevent stackoverflow from recursive call 
            budgetManagementMenu(); // recursive call 
            
        } catch (IOException e) {
			e.printStackTrace();
		} 
        
  
		
	}

	/*
	 * The removeExpense method removes an item from the expense. This method display a menu that will give the user some choices on what they want to remove 
	 * The user also has to option to return to the Budget Menu or they can exit the program completely 
	 */
	private void removeExpense() { 
		String response = ""; // variable to hold the user's response. 
		int choice = 0; // to hold the user's choice  
		
		do { 
			String name = ""; // to hold the name of the expense the user wants to remove. 
			
			System.out.println("\tREMOVING AN EXPENSE");
			System.out.println("\t-----------------");
			System.out.println("You have indicated that you want to remove an expense."); 
			System.out.println("List of current expenses in your budget: "); 
			
			List<Expense> expenses = budget.getExpenses(); // getting the list of expenses from the budget 
			
			if(expenses.isEmpty()) { 
				System.out.println(); // printing blank line 
				System.out.println("There are no current expenses to display. "); 
				System.out.println(); // printing blank line
				System.out.println("Returning to the Budget Management Menu..."); // if there are no current expenses to display, we return the user back. 
				System.out.println();// printing blank line
				budgetManagementMenu(); // displaying the budget management menu since there no expenses to remove. 
			}
			else { 
				// displaying the user's expenses. 
				for (Expense e : expenses) {
					System.out.println(e.toString()); 
				    System.out.println("------------");
				}// end of for loop 
				
				// the messages displayed below are if the user decides to not remove any expenses at all after viewing them. 
				// another reason I allow the user to return back is if they accidentally hit the option to remove an expense. 
				boolean validInput = false; 

				while (!validInput) {
				    try {
				        System.out.println("\nIf you did not want to continue entering a goal and would like to go back to the previous menu, enter 1."); 
				        System.out.print("If you would like to continue, please enter 2: "); 
				        choice = scanner.nextInt();
				        scanner.nextLine(); // Consuming the newline

				        if (choice >= 1 && choice <= 2) {
				            break; // exiting the loop 
				        } else {
				            System.out.println("Incorrect input. You must enter 1 or 2. Please try again: ");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Invalid input. Please enter a number.");
				        scanner.nextLine(); // consuming the newline 
				    }
				}

				if (choice == 1) { 
					System.out.println("You have indicated that you want to go back. "); 
					System.out.println("\tReturning you to the Budget Management Menu.."); 
					budgetManagementMenu(); // returning the user back to the Budget Management menu 
				} else { 
					System.out.print("\nEnter the name of the expense you want to remove: ");// asking user to enter name of expense they want removed
		            name = scanner.nextLine();
		            
				
		           
		            boolean expenseRemoved = false;// boolean flag to be used with the iterator 
		            
		            // Using the Iterator Interface provided by Java Collections Framework
		            // Using this to help us iterate through the array and remove expense by its name
		            Iterator<Expense> iterator = expenses.iterator();
		            while (iterator.hasNext()) { 
		                Expense e = iterator.next();
		                if (e.getName().equalsIgnoreCase(name)) {
		                    iterator.remove();
		                    expenseRemoved = true;
		                    System.out.println("Expense removed successfully!");
		                    break;
		                }
		          
		            }      

		            if (!expenseRemoved) { 
		                System.out.println("Expense not found. No expense removed.");// printing that the expense was not found and no expenses were removed 
		            }

		            System.out.print("\nWould you like to remove another expense? (Y/N): ");// asking user if they would like to remove another expense 
		            response = scanner.nextLine();
		            
		            // validating user input
				    while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {
				        System.out.println("\nERROR. Invalid input. Please try again. ");
				        System.out.print("\nWould you like to remove another expense? (Y/N): ");
				        response = scanner.nextLine();
				    }
				    
				    // checking what the user's input was 
					if(response.equalsIgnoreCase("N")) { 
						System.out.println(); // printing a blank line between output 
						System.out.println("You have indicated that you do not want to continue.");
						System.out.println("Returning to Budget Management Menu..."); // letting user know that we are returning them back to the menu 
						System.out.println(); // printing a blank line 
						budgetManagementMenu(); // returning to the budget management menu
					}    
				    
				}
			}			
			
		} while(response.equalsIgnoreCase("Y")); // end of the do-while 
		
		
		

	}
	
	/*
	 * the addExpense class displays messages that allows the user to enter information about a specific expense
	 */
	private void addExpense() { 
		String response; 
	
		// do-while loop 
		do { 
		String name = ""; // the name of the expense
		String categoryName = ""; // to hold the name of the category 
		int choice = 0; // the user's menu choice 
		double total = 0.0; // the total of the expense 
		String description = ""; // the description of the expense
		
		
		System.out.println(); // printing a blank line 
		System.out.println("\tADDING AN EXPENSE");// displaying title 
		System.out.println("\t-----------------");
		System.out.println("\nBelow you will be asked to enter information about an expense."); // letting user know they will be entering information about an expense. 
		
		//add while loop validation here
		System.out.print("\nWhat would you like to name this expense? "); // asking for the name of the expense 
		name = scanner.nextLine();
		
		boolean validInput = false;// flag to be used for while loop input validation 

		while (!validInput) {// while loop that uses flag for input validation 
	        try {
	            System.out.print("\nPlease enter the total for the expense: "); 
	             total = scanner.nextDouble();  
	            validInput = true; // Input is valid, exit the loop
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid numeric value.");
	            scanner.nextLine(); // Consume the invalid input
	        }
	    }
		
		scanner.nextLine(); // consuming the new line. 
		
		System.out.print("\nEnter a brief description of the expense: "); 
		description = scanner.nextLine(); 
		
		
		System.out.print("\nWhat category would you like to add your expense to? "); 
		
		 boolean flag = false; // flag for our while loop 
		 while(!flag) { // while loop that uses flag for input validation 
				try { 
					 System.out.print("\n1. Housing \n2. Transportation \n3. Groceries \n4. Utilities \n5. Entertainment \n6. Other \n"); 
					 choice = scanner.nextInt(); 
					 scanner.nextLine(); // consuming the new line: 
						flag = true; 
				} catch (InputMismatchException e) {
	  	            System.out.println("Invalid input. Please enter a valid numeric value.");
	  	            scanner.nextLine(); // Consume the newline 
	  	        }
			 
		 }

		
		// checking user input validation 
		while(choice < 1 || choice > 6) { 
			try { 
				System.out.println("Invalid Input. You must enter a number between 1 and 6. Please try again. "); 
				 System.out.print("\n1. Housing \n2. Transportation \n3. Groceries \n4. Utilities \n5. Entertainment \n6. Other \n"); 
					choice = scanner.nextInt(); 
					scanner.nextLine(); // consuming the new line: 
					flag = true; 
			} catch (InputMismatchException e) { 
 	            scanner.nextLine(); // consuming the newline 
 	        }
			
		}// end of while loop validation 
		
		// using switch to assign the category name based on the user's choice 
		switch(choice) { 
		case 1: 
			categoryName = "Housing"; 
			break; 
		case 2: 
			categoryName = "Transportation"; 
			break; 
		case 3: 
			categoryName = "Groceries"; 
			break; 
		case 4: 
			categoryName = "Utilities"; 
			break; 
		case 5: 
			categoryName = "Entertainment"; 
			break; 
		case 6: 
			categoryName = "Other"; 
			break; 
		}
		
		Category category = new Category(categoryName); // creating a new category object 
		
	
		Expense expense = new Expense(name, total, description, category); //to create a new expense that will be added to the budget 
		
		
		budget.addExpense(expense); // adding the expense to the budget 
		
		System.out.print("\nExpense has been successfully added to your budget!"); // displaying message that expense was added successfully. 
		
		List<Expense> expenses = budget.getExpenses();		
		
		System.out.println("\n\nList of Expenses: ");// displaying list of expenses 
	
		for (Expense e : expenses) {// for loop to iterate through list of expenses
			System.out.println(e.toString()); // using toString to get the information about the expenses. 
		    System.out.println("------------");
		}// end of for loop 
		
//		scanner.nextLine(); // consuming the new line 
		
		// asking the user if they would like to enter another expense
		  System.out.print("\nWould you like to add another expense? (Y/N): ");
		  response = scanner.nextLine();

		    // validating user input
		    while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {
		        System.out.println("\nERROR. Invalid input. Please try again. ");
		        System.out.print("\nWould you like to add another expense? (Y/N): ");
		        response = scanner.nextLine();
		    }
		    
		    if (response.equalsIgnoreCase("N")) {// if no, then the user does not want to continue. 
			System.out.println(); // printing a blank line between output 
			System.out.println("You have indicated that you do not want to continue.");
			System.out.println("Returning to Budget Management Menu..."); 
			budgetManagementMenu(); // returning to the budget management menu
	    }

		
	} while(response.equalsIgnoreCase("Y")); // end of the do-while loop 
		
		
	}
	/*
	 * the addGoal method allows the user to enter a goal. They can enter the amount that they are aiming for and the amount they have saved towards that goal. 
	 */
	public void addGoal() { 
		String response; 
		
		// do-while loop 
		do { 
		String name = ""; // the name of the goal
		int choice = 0; // the user's menu choice 
		double savedAmount = 0.0; // the amount that the user has saved towards the goal. 
		double targetAmount = 0.0; // the amount that the user would like to reach towards this goal.
		
		
		System.out.println(); // printing a blank line 
		System.out.println("\tADDING A NEW GOAL");
		System.out.println("\t-----------------");
		System.out.println("\nYou have indicated that you would like to enter a new goal. "); 
		
		// the messages displayed below are if the user decides to not remove any expenses at all after viewing them. 
		// another reason I allow the user to return back is if they accidentally hit the option to remove an expense. 
		System.out.println(); // printing a blank line in between outputs. 
		
		boolean validInput = false; // flag for the while loop 
		while (!validInput) {// while loop for input validation 
		    try {
		        System.out.println("\nIf you did not want to continue entering a goal and would like to go back to the previous menu, enter 1."); 
		        System.out.print("If you would like to continue, please enter 2: "); 
		        choice = scanner.nextInt();
		        scanner.nextLine(); // consuming the newline

		        if (choice >= 1 && choice <= 2) {
		            break; // exiting the loop s
		        } else {
		            System.out.println("Incorrect input. You must enter 1 or 2. Please try again: ");
		        }
		    } catch (InputMismatchException e) {
		        System.out.println("Invalid input. Please enter a number.");
		        scanner.nextLine(); // consuming the newline 
		    }
		}

		
		if (choice == 1) { 
			System.out.println("You have indicated that you want to go back. "); // displaying message that the user chose to return to budget management menu
			System.out.println("Returning you to the Budget Management Menu.."); 
			System.out.println(); // printing a blank line in between output. 
			budgetManagementMenu(); // returning the user back to the Budget Management menu 
		} else 
		
		//add while loop validation here
		System.out.print("\nWhat would you like to name your goal? "); 
		name = scanner.nextLine();
		
	
		
		// using a while loop for input validation 
		while (!validInput) {
	        try {
	            System.out.print("\nPlease enter your target amount for your goal:  "); 
	             targetAmount = scanner.nextDouble();  
	             scanner.nextLine(); // consuming the newline. 
	             validInput = true; // Input is valid, exit the loop
	  	        } catch (InputMismatchException e) {
	  	            System.out.println("Invalid input. Please enter a valid numeric value.");
	  	            scanner.nextLine(); // consuming the newline 
	  	        }
	  	    }
		
			 validInput = false;//resetting flag to false
		
			while (!validInput) {// using while loop for input validation 
		        try {
		             System.out.print("\nPlease enter the amount you have saved towards your goal: "); 
		             savedAmount = scanner.nextDouble(); 
		             scanner.nextLine(); 
		             validInput = true; // input is valid, exit the loop
		  	        } catch (InputMismatchException e) {
		  	            System.out.println("Invalid input. Please enter a valid numeric value.");
		  	            scanner.nextLine(); // consuming the new line
		  	        }
		  	    }
	  
	
		System.out.println(); // printing a blank line in-between output. 
		
		Goal goal = new Goal(name, targetAmount, savedAmount); // adding the goal to the budget 
		
		
		budget.addGoal(goal); // adding the goal to the budget 
		
		System.out.print("\nYour goal has been successfully added to your budget!"); // displaying message that goal was added successfully 
		
		List<Goal> goals = budget.getGoals(); // getting the list of goals
		
		
		System.out.println("\n\n\tList of Current Goals: ");//displaying the list of current goals 
		
		
		// below we are displaying the name, saved amount, and the target amount. 
		for (Goal g : goals) {// iterating through the list of goals 
			System.out.print(g.toString());// using toString method to display the information of each goal. 
		    System.out.println("\n------------");
		}// end of for loop 
		
		// asking the user if they would like to enter another expense
		  System.out.print("\nWould you like to add another goal? (Y/N): ");
		  response = scanner.nextLine();

		    // validating user input
		    while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {
		        System.out.println("\nERROR. Invalid input. Please try again. ");
		        System.out.print("\nWould you like to add another goal? (Y/N): ");
		        response = scanner.nextLine();
		    }
		    
		    if (response.equalsIgnoreCase("N")) {
			System.out.println(); // printing a blank line between output 
			System.out.println("You have indicated that you do not want to continue.");
			System.out.println("Returning to Budget Management Menu..."); 
			budgetManagementMenu(); // returning to the budget management menu
	       }
		   
		
	    } while(response.equalsIgnoreCase("Y")); // end of the do-while loop 
	 }
	
	
	/*
	 * the saveBudgetToFile method is meant to save the information entered to a text file
	 */
	public void saveBudgetToFile() {
		
		String filename = this.budgetName + ".txt"; // creating the text file name 
		
        BudgetFileHandler fileHandler = new BudgetFileHandler(filename);// passing the filename as a parameter 
        
        fileHandler.writeBudgetToFile(this.budget); // using the fileHandler to call the writeBudgetToFile, which writes the budget to the text file!  
    
        
    }
	
	

}
