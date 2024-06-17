import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TodoItem {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private int priority;

    public TodoItem(int id, String title, String description, String dueDate, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }
}

class TodoList {
    private List<TodoItem> items;
    private int nextId; // To generate unique ids for new todo items

    public TodoList() {
        this.items = new ArrayList<>();
        this.nextId = 1; // Start with id 1
    }

    public void addItem(TodoItem item) {
        item.setId(nextId++); // Assign a unique id to the new todo item
        items.add(item);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void displayItems() {
        for (TodoItem item : items) {
            System.out.println(item.getId() + ": " + item.getTitle());
        }
    }
}

public class TodoListApp {
    private static Scanner scanner = new Scanner(System.in);
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // Sample data
        todoList.addItem(new TodoItem(1, "Complete Java project", "Finish the Java project for resume", "2024-04-30", 1));
        todoList.addItem(new TodoItem(2, "Buy groceries", "Milk, eggs, bread", "2024-04-27", 2));
        todoList.addItem(new TodoItem(3, "Call mom", "Wish her happy birthday", "2024-05-01", 3));

        boolean exit = false;
        while (!exit) {
            System.out.println("Todo List Menu:");
            System.out.println("1. Display Todo Items");
            System.out.println("2. Add Todo Item");
            System.out.println("3. Remove Todo Item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Todo Items:");
                    todoList.displayItems();
                    break;
                case 2:
                    addTodoItem();
                    break;
                case 3:
                    removeTodoItem();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addTodoItem() {
        System.out.println("Enter the title of the todo item:");
        String title = scanner.nextLine();

        System.out.println("Enter the description:");
        String description = scanner.nextLine();

        System.out.println("Enter the due date (YYYY-MM-DD):");
        String dueDate = scanner.nextLine();

        System.out.println("Enter the priority (1-High, 2-Medium, 3-Low):");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create and add the todo item to the list
        TodoItem newItem = new TodoItem(0, title, description, dueDate, priority);
        todoList.addItem(newItem);


        System.out.println("Todo item added successfully!");
    }

    private static void removeTodoItem() {
        System.out.println("Enter the ID of the todo item to remove:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        todoList.removeItem(id);
        System.out.println("Todo item removed successfully!");
    }
}
