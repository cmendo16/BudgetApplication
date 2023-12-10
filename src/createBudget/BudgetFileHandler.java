package createBudget;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import budget.Budget;
import budget.BudgetApp;
import budget.Category;
import budget.Expense;
import budget.Goal;

/*
 * The BudgetFileHandler class handles the files related to the budget
 * This class writes data to a text file, can allow changes to income, and provides a method to remove expenses from the text file, and provides a method to remove a goal from text file. 
 */

   /*
    * no-arg constructor
    */
	public class BudgetFileHandler {
    private String filename;// the name of the file 
    
    /*
     * constructor that accepts arguments 
     * @param filename - the name of the file 
     */
    public BudgetFileHandler(String filename) {
        this.filename = filename;
    }
    
    /*
     * The writeBudgetToFile method takes the information of a budget and writes it to a text file. 
     * @param budget - a budget object that will have its information saved to a file
     */
    public void writeBudgetToFile(Budget budget) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        	
        	// maybe use a sorting algorithm to store the expenses and the goals in alphabetical order. (look into Sort()) 
        	
            // Below is code that writes information of the budget to a text file (income, expenses, categories and current goals) 
            writer.write("Income: " + budget.getIncome());// writing income 
            writer.newLine();
            writer.write("Expenses: ");
            writer.newLine();
            for (Expense expense : budget.getExpenses()) {// writing expenses to the text file 
                writer.write("  Name: " + expense.getName());
                writer.newLine();
                writer.write("  Amount: " + expense.getTotal());
                writer.newLine();
                writer.write("  Category: " + expense.getCategory().getName());
                writer.newLine();
                writer.write(" Date: " + expense.getDate());
                writer.newLine(); 
                writer.newLine(); 
            }
           
            writer.write("Current Categories");// writing categories 
            writer.newLine();
            for (Category category: budget.getCategories()) {
                writer.write("  Name: " + category.getName());
                writer.newLine();
                writer.newLine(); 
            }
            
            writer.write("Current Goals");// writing current goals 
            writer.newLine(); 
            for(Goal goals : budget.getGoals()) { 
            	writer.write(" Name: " + goals.getName());
            	writer.newLine();
            	writer.write(" Target Amount: " + goals.getTargetAmount());
            	writer.newLine(); 
            	writer.write(" Saved Amount: " + goals.getSavedAmount());
            	writer.newLine();
            	writer.newLine(); 
            	
            }
            
            System.out.println("Budget information saved to " + filename);// displaying message that we have saved information to the file. 
            System.out.println(); // printing a blank line
        } catch (IOException e) {
            System.err.println("Error writing budget information to file: " + e.getMessage());// if an error, display message. 
            e.printStackTrace();
        }
    }

}

