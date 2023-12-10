package budget;

public class Category {
	private String name; // the name of the category	
	
	// no arg constructor 
	public Category() { 
		name = "";  
	}
	/*
	 * constructor that accepts argument 
	 * @param name - the name of the category 
	 * @param description - the description of the category 
	 * @param budgetedAmount - the budgeted amount for the category 
	 */
	public Category(String name) { 
		this.name = name; 
	}
	
	// setters and getters for each field are below 
	public String getName() { 
		return name; 
	}
	
	// below are the setter methods; 
	
	public void setName(String name) { 
		this.name = name; 
	}

	/*
	 * method that will add a transaction associated with a category 
	 */
	@Override
    public String toString() {
        return name; 
        
    }
	
	
	
}
