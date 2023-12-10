package budget;
import java.time.LocalDate;

/*
 * Transaction is an abstract class that represents a transaction
 */
public abstract class Transaction {
	
    protected double total;// the total of the transaction 
    protected LocalDate date;// the date of the transaction 
    protected String description;// a description of the transaction 
    
	/*
	 * no-arg constructor
	 */
    public Transaction() { 
    	total = 0.0; 
    	date = LocalDate.now();  
    	description = ""; 
    }
    
	/*Constructor that accepts arguments 
	 * @param total - the total of the transaction 
	 * @param date - the current date
	 * @param description - the description of the transaction 
	 */
    public Transaction(double total, LocalDate date, String description) {
        this.total = total;
        this.date = date;
        this.description = description;
    }
    
    // getters and setters for each field 
	
 	/* 
 	 * the getTotal method gets the total of the transaction 
 	 * return total of transaction 
 	 */
 	public double getTotal() { 
 		return total; 
 		
 	}

 	/* The getDescription method gets a description of the Transaction 
 	 * return description of transaction 
 	 */
 	public String getDescription() { 
 		return description; 
 	}
 	/*
 	 * the getDate method gets the date 
 	 * @return the date 
 	 */
 	public LocalDate getDate() { 
 		return date; 
 	}
 	
 	/* The setTotal method sets the total of the transaction 
 	 * @param total - the total amount of the transaction 
 	 */
 	public void setTotal(double total) { 
 		this.total = total;
 	}
 	
 	/* the setDescription method sets the description of the transaction 
 	 * @param description - a brief description of the transaction 
 	 */
 	public void setDescription(String description) { 
 		this.description = description; 
 	}
 	
  /*
   * the setDate method sets the date the transaction is added to the budget 
   * @param date - the current data 
   */
 	public void setDate(LocalDate date) { 
 		this.date = date;
 	}
    
}

