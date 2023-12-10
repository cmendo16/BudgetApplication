/*
 * This is a very SIMPLE budgeting application. This is a console based program and there are very specific instructions throughout the program to allow for user to have an easier experience
 * There is no way for the user to login or create a new account. However, the user can create a new file and edit this file that will hold save information about their budget. 
 */
package budget;
import java.util.Scanner;
import overview.Overview;
import createBudget.*; 
import createBudget.BudgetFileHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/*
 * the BudgetApp class will act as a Singleton with access to the Overview class and the PlanBudget class. 
 * This class provides method and it acts as an entry point of the program. 
 */

public class BudgetApp {

	  private static BudgetApp instance; // singleton instance of BudgetApp
	 
	    private Overview overview; // instance variable for Overview
	    private PlanBudget plan; // instance variable for PlanBudget
	    
		/*
		 * private constructor
		 */
	    private BudgetApp() {
	        // Initializing Overview and PlanBudget classes 
	        overview = new Overview();
	        plan = new PlanBudget();
	       
	    }

	    // Public static method to get the instance
	    public static BudgetApp getInstance() {
	        if (instance == null) {
	            instance = new BudgetApp();
	        }
	        return instance;
	    }
 
    /*
     * the MainMenu() displays options that the user can choose from at the beginning of the program. It allows the user to either create a new budget, edit an existing budget, or exit program. 
     */
    public void mainMenu() {
     
		Scanner scanner = new Scanner(System.in);// needed to read user input 

        int choice;
        try {
              	// displaying the main menu option 
            	System.out.println(); //printing a blank line. 
                System.out.println("\tMAIN MENU");
                System.out.println("\t---------");
                System.out.println("Please select from the following options:");
                System.out.println("1. Create a new budget.");
                System.out.println("2. View an existing budget.");
                System.out.println("3. Exit the program");
                
                // Read the user's choice as an integer
                choice = scanner.nextInt();
                scanner.nextLine();  // consuming the newline 
                while(choice < 1 || choice > 3) { // while loop input valiadation, user must enter a number between 1 and 3
                	System.out.print("\nInvalid input. Please try again and enter a number between 1 and 3: "); 
                	choice = scanner.nextInt();
                	scanner.nextLine(); // consuming the new line 
                }

                switch (choice) {
                    case 1:
                        // creating a new budget
                        System.out.println(); // printing a blank line
                        System.out.println("Creating a new budget...");
                        System.out.println(); // printing a blank line
                        createBudget();
                        break;
                    case 2:
                        // editing an existing budget
                        System.out.println(); // printing a blank line
                        System.out.println("Editing an existing budget...");
                        viewBudget(); // calling the editBudget method    
                        break;
                    case 3:
                        System.out.print("Are you sure you want to exit? (Y/N): ");// making sure that the user wants to exit 
                        String response = scanner.next();
                        
                        while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) { // while loop input validation 
                        	System.out.print("Invalid input. Please try again. "); 
                        	System.out.println(); // printing a blank line in between output 
                            System.out.print("Are you sure you want to exit? (Y/N): ");
                            response = scanner.next();
                        }
                        if (response.equalsIgnoreCase("Y")) {// if the user entered yes, then exit the program and display message 
                            System.out.println("Exiting the program. Goodbye!");
                            System.exit(0);     
                        } else { 
                        	System.out.println("You have indicated that you do not want to exit."); // if the user decides not to exit, then return them to the Main Menu options 
                        	System.out.println("returning you to the Main Menu options..."); 
                        	mainMenu(); 
                        }
                        break;
                }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid Input. Please enter a valid integer choice (1, 2, or 3).");
            scanner.nextLine(); // consuming new line 
            mainMenu(); // calling the main menu again so that the user can try agaun 
        } 

    }
    	
    /*
     * the createBudget method allows the user to create their budget. 
     * This method allows the user to enter the name of the budget and creates a new budget object. 
     */
    	public void createBudget() { 
    		Scanner scanner = new Scanner(System.in); // needed to read user input 
    		Budget budget;  // the user's budget 
    		String response = ""; // to hold the user's response 
    		String budgetName = ""; // to hold the name for the budget. 
    		String filename = ""; // the filename 
    	 
    	
    		System.out.print("\nPlease enter a name for your new budget: ");// prompting the user to enter the name of the budget. 
    		budgetName = scanner.nextLine();
    		
    		filename = budgetName + ".txt";// creating a text filename
    		
    		try {
              File file = new File(filename);// creating a new file 
              
              if (file.exists()) { // checking if the file exists, if it does, let the user know. 
                  System.out.println("A budget witsh the name '" + budgetName + "' already exists.");
                  System.out.println("Would you like to try again? (Y/N): ");// asking user if they would like to try again, if file already exists 
                  response = scanner.nextLine(); 
              	 while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) { //while-loop input validation 
                  	System.out.println("ERROR. You must enter 'Y' or N'. Please try again."); 
                  	System.out.println(); // blank space in between output 
                  	System.out.print("\nWould you like to try again? (Y/N): "); 
                    response = scanner.nextLine();
              	} 
              	 
              	 
              	if(response.equalsIgnoreCase("Y")) { // if yes, recursively call the cretaeBudget method 
              		 createBudget(); // calling the create Budget method again so that the user can try again. 
              		 System.exit(0); 	
              	} else {
              		System.out.print("Returning to menu..."); // if not, we automatically return to the Main Menu options 
              		System.out.println();// printing a blank line 
              		mainMenu();  // using the budget app instance to call the MainMenu
              	}  
                      
              } else {
                  try (FileWriter writer = new FileWriter(file)) {
                  	
                	 // creating a Budget object with the same name as the file. 
                	  budget = new Budget(0.0, budgetName); 
                	  
                	 // creating a new file with the name of the users budget 
                  	 BudgetFileHandler budgetFile = new BudgetFileHandler(budgetName); // creating a new budget file if one has not been creating already s
                  	 
                      // creating the new budget 
                      System.out.println("New budget '" + budgetName + "' created!");
                      System.out.println("To continue with your new budget, please select from the following options!");
                      budgetOptions(budget, budgetName);    
                      
                  }
              }
          } catch (IOException e) {
              System.err.println("An error occurred while creating the budget: " + e.getMessage());// displaying that an error occurred in the budget 
          }
  		
    		
    		scanner.close(); // closing scanner 
    	} 
    	
    	/*
    	 * the viewBudget option allows the user to view and edit a specific details of the budget. 
    	 */
    	public void viewBudget() { 
    		Scanner scanner = new Scanner(System.in);
    		boolean again = false; 
    		
      		 System.out.print("Enter the name of the existing budget: ");
      		 String budgetName = scanner.nextLine();
      		 
               String filename = budgetName + ".txt"; 
       
                  File file = new File(filename);
                  if (file.exists()) {
                      try (FileReader reader = new FileReader(file)) {
                          // Add code here to read and edit the existing budget file
                          // For example, you can use reader.read() to read the existing budget data.
                          System.out.println("Contents of '" + budgetName + "' budget:");
                          // Display the existing budget content here.
                          String line;
                          BufferedReader bufferedReader = new BufferedReader(reader);
   					while ((line = bufferedReader.readLine()) != null) {
                              System.out.println(line);
                          }
                   
                      } catch (FileNotFoundException e) { 			
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (java.util.InputMismatchException e) { 
						System.out.println("Please enter a valid number. "); 
						scanner.nextLine();
					}
                      
                   } else {
                    	 
               	     // printing message that the budget the user entered does not exist and allowing the user to try again. 
                      System.out.println("A budget with the name '" + budgetName + "' does not exist.");
                      System.out.print("Would you like to try again? (Y/N): ");
                      String response = scanner.nextLine();
                      
                      while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {//while-loop input validation 
                          System.out.println("ERROR. You must enter 'Y' or N'.");
                          System.out.println(); // blank space in between output
                          System.out.print("\nWould you like to try again? (Y/N): ");
                          response = scanner.nextLine();
                      }
                      
                      if (response.equalsIgnoreCase("N")) {
                   	   System.out.println(); 
                   	   System.out.println("Returning to Main Menu..."); 
                   	   System.out.println(); // printing a blank line in-between output 
                   	   mainMenu();
                   	   
                      }
                      else { 
                    	again = false; // setting to false so that we can iterate through the loop again.  
                    	  
                      }
                     
                  }
                      
    		}
    	
    	/*
    	 * displays some options user that will allow the user to navigate to other parts of the program 
    	 */
    	public void budgetOptions(Budget budget, String budgetName) throws IOException { 
    		
    		BudgetApp app = getInstance(); 
  
    		String response = ""; // to hold the user's response. 
    		
    		
    		Scanner scanner = new Scanner(System.in); 
        		
    			try {
                    int choice;
                    	System.out.print("\nBUDGET MENU");
                    	System.out.println(); // printing a blank line to separate output 
                    	System.out.println("\n1. Plan Your Budget"); 
                		System.out.println("\n---------------");
                		System.out.println("\n2. Budget Overview");
                		System.out.println("\n--------------");
                		System.out.println("\n3. Return to Main Menu");
                		System.out.println("\n--------------"); 

                        // Read the user's choice as an integer
                        choice = scanner.nextInt();
                        while(choice < 1 || choice > 3) { 
                        	System.out.print("\nInvalid input. Please try again and enter a number between 1 and 3: "); 
                        	choice = scanner.nextInt();
                        	scanner.nextLine(); // consuming the new line 
                        }

                        switch (choice) {
                            case 1:
                            // using singleton instance to access Plan Budget methods 
                            app.plan.setBudget(budget);  // setting the budget 
                            app.plan.setBudgetName(budgetName);// setting the budget name 
                            app.plan.enterIncome();// prompting user to enter their income. 
                            app.plan.budgetManagementMenu();// displaying the Budget Management Menu
                            break;
                            case 2:
                            app.overview.setBudget(budget);// setting the budget for the Overview object 
                            app.overview.setBudgetName(budgetName);// setting the budgetName 
                            app.overview.displayBudgetContents();// calling displayBudgetContents method to display insights and budget content 
                            break;
                            case 3: 
                            	scanner.nextLine(); // consuming the new line
                            	
                            	System.out.print("\nAre you sure you want to return to the Main Menu? (Y/N): "); // making sure that the user does actually want to return to the main menu 
                            	response = scanner.nextLine(); // taking in the user's input s
                            	while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) { // input validation 
                                	System.out.println("ERROR. You must enter 'Y' or N'. Please try again."); 
                                	 System.out.print("\nAre you sure you want to return to the Main Menu? (Y/N)"); 
                                      response = scanner.nextLine();
                            	} 
                            	if(response.equalsIgnoreCase("Y")) { // if the user enters 'Y', then return them to the main menu 
                            		System.out.print("Returning to the Main Menu..."); 
                            		mainMenu(); // calling the mainMenu() method to display the main menu 
                            	} else { 
                            		// displaying the menu again 
                            		System.out.println("Displaying the Budget Options.."); // if anything else, display the budget options again 
                            		System.out.println(); // printing a blank line between output
                            		budgetOptions(budget, budgetName); // displaying the budget options again. 
                        
                            	}
                            break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                                scanner.nextLine(); 
                        }
                        
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid integer choice.");
                    System.out.println(); 
                    budgetOptions(budget, budgetName); // displaying the budget options again 
                }
    			
    			scanner.close(); // closing the scanner. 
    		
    	}   	 
    		
    /*
     * The main Program. 
     * Here, we are using the BudgetApp instance to begin the program. 
     */
     public static void main(String[] args) {
     
     BudgetApp app = BudgetApp.getInstance(); 
	 
    System.out.println("Welcome to the Budgeting Application!");
    
    app.mainMenu();  // The program begins here. Using the budget instance to call 

    
  }
    
    	
}

    	     

    	
           

  
    


