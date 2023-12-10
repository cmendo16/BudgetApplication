package budget;

public class Goal {
	  private String name; // the name of the goal 
	  private double targetAmount; // the amount the user wants to put towards the goal
	  private double savedAmount; // the amount the user has saved towards that goal
	    
	  /*
	   * no arg constructor
	   */
	  public Goal() { 
		  name = ""; 
	      targetAmount = 0.0; 
	      savedAmount = 0.0; 
	   }

	   /*
	   * Constructor that accepts arguments
	   * @param name - the name of the budget
	   * @param targetAmount - the amount the user has saved towards that goal
	   */
	  public Goal(String name, double targetAmount, double savedAmount) {
	      this.name = name;
	      this.targetAmount = targetAmount;
	      this.savedAmount = savedAmount; 
	  }
	    
	  // below are the setter methods for each field 
	    
	  /*
	   * setName method sets the name of the goal 
	   * @param name - the name of the method 
	   */
	  public void setName(String name) { 
	   	 this.name = name; 
	   }
	  /*
	   * setName method sets the name of the goal 
	   * @param name - the name of the method 
	   */ 
	   public void setTargetAmount(double targetAmount) { 
	   	  this.targetAmount = targetAmount; 
	   }
	   /*
	   * setName method sets the name of the goal 
	   * @param name - the name of the method 
	   */
	   public void setSavedAmount(double savedAmount) { 
	      this.savedAmount = savedAmount; 
	   }

	   // below is the getter methods for each field. 
	    
	  /*
	   * setName method sets the name of the goal 
	   * @param name - the name of the method 
	   */
	    public String getName() { 
	    	return name; 
	    }
	   /*
	    * setName method sets the name of the goal 
	    * @param name - the name of the method 
	    */
	    public double getTargetAmount() {
	       return targetAmount;
	    }
	    /*
	     * setName method sets the name of the goal 
	     * @param name - the name of the method 
	     */
	    public double getSavedAmount() {
	        return savedAmount;
	    }
	    /*
	     * setName method sets the name of the goal 
	     * @param name - the name of the method 
	     */
	    public void addAmount(double amount) {
	        savedAmount += amount;
	    }
	    /*
	     * setName method sets the name of the goal 
	     * @param name - the name of the method 
	     */
	    @Override
	    public String toString() {
	        return "\nGoal Name: " + name + 
	               String.format("\nTarget Amount: $%.2f \nSaved Amount: $%.2f", targetAmount, savedAmount);  
	    }



}
