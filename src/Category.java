
public class Category {
	private String name; // the name of the category 
	private String description; // a description of the category 
	private double budgetedAmount; // the amount the user wants to put towards the category 
	
	
	// no arg constructor 
	public Category() { 
		name = ""; 
		description = ""; 
		budgetedAmount = 0.0; 
	}
	/*
	 * constructor that accepts argument 
	 * @param name - the name of the category 
	 * @param description - the description of the category 
	 * @param budgetedAmount - the budgeted amount for the category 
	 */
	public Category(String name, String description, double budgetedAmount) { 
		this.name = name; 
		this.description = description; 
		this.budgetedAmount = budgetedAmount; 
	}
	
	// setters and getters for each field are below 
	public String getName() { 
		return name; 
	}
	
	public String getDescription() { 
		return description; 
	}
	
	public double getBudgetedAmount() { 
		return budgetedAmount; 
	}
	
	// below are the setter methods; 
	
	public void setName(String name) { 
		this.name = name; 
	}
	
	public void setDescription(String description) { 
		this.description = description;  
	}
	
	public void setBudgetedAmount(double budgetedAmount) { 
		this.budgetedAmount = budgetedAmount; 
	}
	
	
	@Override
    public String toString() {
        return name + ": $" + budgetedAmount;
    }
	
	
}
