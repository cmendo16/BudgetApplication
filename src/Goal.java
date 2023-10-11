
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
	    public Goal(String name, double targetAmount) {
	        this.name = name;
	        this.targetAmount = targetAmount;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getTargetAmount() {
	        return targetAmount;
	    }

	    public double getSavedAmount() {
	        return savedAmount;
	    }
	    
	    
	    public void addAmount(double amount) {
	        savedAmount += amount;
	    }

	    @Override
	    public String toString() {
	        return name + " - Target: $" + targetAmount + ", Saved: $" + savedAmount;
	    }


}
