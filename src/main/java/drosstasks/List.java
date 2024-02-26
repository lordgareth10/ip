package drosstasks;
import drosstasks.Event;
import myexceptions.InvalidTodoException;

public class List {
    private Task[] tasks;
    private int size;

    public List() {
        this.tasks = new Task[100]; // initial capacity
        this.size = 0;
    }

    //Method that returns the size of the current list
    public int getSize(){
        return size;
    }

    //Method to return task object based on index
    public Task getTask(int index){
        for (int i=0; i < size; i++){
            if (i == index){
                return tasks[i];
            }
        }
        return null;
    }

    // Overloaded Method to add a deadline to the list
    public void addTask(String taskDescription, String taskDeadline){
        tasks[size] = new Deadline(taskDescription, taskDeadline);
        size++;
    }

    // Overloaded Method to add an event to the list
    public void addTask(String taskDescription, String taskStart, String taskEnd) {
        tasks[size] = new Event(taskDescription,taskStart, taskEnd);
        size++;
    }

    // Method to add a task to the list
    public void addTask(String taskDescription) throws InvalidTodoException {
        if (taskDescription.isEmpty()){
            throw new InvalidTodoException();
        }
        tasks[size] = new ToDo(taskDescription);
        size++;
    }

    // Method to print the last added task
    public void printLastTask() {
        if (size > 0) {
            System.out.println("Last added task: " + tasks[size - 1]);
        } else {
            System.out.println("The list is empty.");
        }
    }

    //Method to toggle check task as done by index
    public void markDoneByIndex(int index){
        tasks[index-1].completeTask();
    }

    //Method to toggle check task as undone by index
    public void markUndoneByIndex(int index){
        tasks[index-1].uncheckTask();
    }

    // Method to print all tasks
    public void printAllTasks() {
        if (size > 0) {
            System.out.println("All tasks:");
            for (int i = 0; i < size; i++) {
                Task currentTask = tasks[i]; // Assuming tasks[i] is a drosstasks.Task object
                System.out.print((i + 1) + ".");
                System.out.println(currentTask);
            }
        }
        else {
            System.out.println("The list is empty.");
        }
    }
}
