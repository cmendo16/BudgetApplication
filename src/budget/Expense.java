// the expense class represents an expense
// contains basic information about an expense
package budget;

import java.time.LocalDate;

/*
 * the Expense class represents an expense and extends the abstract Transaction class/ 
 */
public class Expense extends Transaction {
	private Category category; // to specify the specific category the expense is in. 
	private String name; // the name of the expense 
	
	
	// no-arg constructor 
	
	public Expense() { 
		category = new Category(); 
		name = ""; 
	}
	/*
	 * constructor that accepts arguments 
	 * @param name, the name of the expense 
	 */
	public Expense(String name) { 
		this.name = name; 
	}
	
	/* 
	 * Constructor that accepts arguments 
	 * @param name - the name of the transaction 
	 * @param total - the total amount of the total 
	 * @param description - a brief description of the transaction 
	 */
	public Expense(String name, double total, String description, Category category) {
		super(total, LocalDate.now(), description);// inheriting fields from the Transaction class
		this.name = name;
		this.category = category; 
	}
	
	// below are the setters and getters for each field 
	
	/*
	 * the getName method returns the name of the expense 
	 */
	public String getName() { 
 		return name; 
 	}
	/*
	 * the setName method sets the name of the expense 
	 * @param name - the name of the expense 
	 */
	public void setName(String name) { 
 		this.name = name; 
 	}
	
	/*
	 * the getCategory method gets the category that the expense is in. 
	 */
	public Category getCategory() {
		return category; 
	}
	/*
	 * the setCategory method sets the category of the expense 
	 */
	public void setCategory(Category category) { 
		this.category = category; 
	}
	
	/*
	 * toString method displays the current state of the Expense 
	 */
    @Override
    public String toString() {
        return "\nExpense name: " + name + 
               "\nDescription of expense: " + description + 
               "\nExpense total: $" + String.format("%.2f", total) + 
               "\nDate: " + date + 
               "\nCategory: " + category;
    }
	

	
	
	
	

}
