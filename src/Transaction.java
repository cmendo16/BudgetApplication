
public class Transaction {
	private String name; // the name of the transaction 
	private double total; // the total amount of the transaction
	private String description; // a very brief description of the transaction 
	
	// no-arg constructor 
	public Transaction() { 
		name = ""; 
		total = 0.0; 
		description = ""; 
	}
	
	/* 
	 * Constructor that accepts arguments 
	 * @param name - the name of the transaction 
	 * @param total - the total amount of the total 
	 * @param description - a brief description of the transaction 
	 */
	public Transaction(String name, double total, String description) { 
		this.name = name; 
		this.total = total; 
		this.description = description; 
	}
	
	// getters and setters for each field 
	
	/* 
	 * @return name 
	 */
	public String getName() { 
		return name; 
	}

	/* 
	 * @return total 
	 */
	public double getTotal() { 
		return total; 
	}

	/* 
	 * @return description 
	 */
	public String getDescription() { 
		return description; 
	}
	
	/* 
	 * @param name - the name of the transaction 
	 */
	public void setName(String name) { 
		this.name = name; 
	}
	
	/* 
	 * @param total - the total amount of the transaction 
	 */
	public void setTotal(double total) { 
		this.total = total;
	}
	
	/* 
	 * @param description - a brief description of the transaction 
	 */
	public void setDescription(String description) { 
		this.description = description; 
	}
	
	

}
