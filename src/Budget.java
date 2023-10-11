/*
 * the Budget class represents a budget 
 */
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double income;
    private List<Double> expenses;

    /* 
     * no-arg constructor
     */
    public Budget() { 
    	income = 0.0; 
   
    }
    /*
     * constructor that accepts arguments 
     * @param income - the income that the user enters. 
     */
    public Budget(double income) {
        this.income = income;
        this.expenses = new ArrayList<>(); 
    }

    // below are the getters and the setter methods
    
    public void setIncome(double income) {
        this.income = income;
    }

    public void addExpense(double expense) {
        expenses.add(expense);
    }
    public void removeExpense(double expense) { 
    	expenses.remove(expense);
    }
    
 

    public double calculateRemainingBalance() {
        double totalExpenses = 0.0;// to hold the total amount of the expenses
        for (double expense : expenses) {
            totalExpenses += expense;
        }
        return income - totalExpenses;
    }

    public double getIncome() {
        return income;
    }

    public List<Double> getExpenses() {
        return expenses;
    }
}

