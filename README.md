# BudgetApplication
A Simple Budgeting Application
The purpose of the program is to provide a simple budgeting tool for anyone looking to manage their expenses and balance after entering their income and expenses. 
This console-based program is designed for simplicity, offering clear instructions for easy navigation, even though it lacks 'clickable' features.
The program comprises several classes, including Budget, Expense, the abstract Transaction class, and Category. It starts in the BudgetApp class, which functions as a singleton with access to other classes like PlanBudget and Overview. 
Upon launching the program, a "Main Menu" is displayed, presenting two options: 
1. Create a new budget or
2. 2. View an existing budget. 
The ZIP file provided contains a sample budget file, which includes Income, a list of expenses, categories, and goals, but excludes any calculations like total remaining balance.

When creating a new budget, there are three options: Plan Budget, Overview, and Exit Program. Starting with Plan Budget, you're guided to a section where you can add expenses, add a goal, or remove a goal (optional). After adding expenses, there's an option to remove an expense,
with a list of entered expenses displayed.

Additionally, you can add a goal to your budget. If you choose not to remove a goal, you can return to the previous menu. **PLEASE NOTE: It's important to save your budget to a file after adjustments, as unsaved changes won't be stored.** 
Once you have saved your budget, you can return to the main menu to exit. However, if you would like to see an overview of your budget beforehand, you must return to the Budget Options menu and navigate into “Overview”.
This overview includes your entered income, total calculated remaining balance, and budget contents. To exit from here, you can return to the main menu, and choose “Exit Program” option. 

When you have a saved budget, you can view the saved file if you would like in the Main Menu. You can do this under "View an existing budget". To view this existing file you can enter the budget name **WITHOUT** the .txt extension. 
If you just enter the budget name, the program should be able to correctly identify the file. 
