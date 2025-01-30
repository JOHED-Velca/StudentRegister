import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> students = new ArrayList<String>();

    public static void main(String[] args){

        int op;
        do {
            System.out.println("--------MENU--------");
            System.out.println("1. Add new student");
            System.out.println("2. Remove a student");
            System.out.println("3. List of students");
            System.out.println("4. Exit");
//            System.out.println("Enter your choice: ");
            op = getValidInput("Enter your choice: ");
//            op = scanner.nextInt();
//            scanner.nextLine();
            System.out.print("\n");
            switch (op) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    System.out.println("-------DELETE STUDENT-------");
                    removeStudent();
                    System.out.print("\n");
                    break;
                case 3:
                    System.out.println("-------STUDENT LIST-------");
                    listStudents();
                    System.out.print("\n");
                    break;
                case 4:
                    System.out.println("Bye bye!\n");
                    break;
                default:
                    System.out.println("Wrong input! try again.\n");
                    break;
            }
        }while(op!=4);

    }

    public static void addNewStudent() {
        String studentName;
        do {
            System.out.println("Enter the student name: ");
            studentName = scanner.nextLine().trim();
        }while(studentName.isEmpty());

        students.add(studentName);
        System.out.println(studentName+" has been added!\n");

    }

    public static void removeStudent() {
        int remove;
        do{
            listStudents();
            System.out.print("Choose the number of the student to remove: ");
            remove = scanner.nextInt();
            System.out.println("WRONG INPUT!");
        }while (remove < 0 || remove > students.size());
        System.out.print("\n");
        students.remove(remove-1);
    }

    public static void listStudents() {
        if (students.isEmpty()){
            System.out.println("SORRY! no students yet.");
        }
        else{
            for (int i=0;i<students.size();i++){
                System.out.println((i+1)+". " + students.get(i));
            }
        }
    }
    public static int getValidInput(String message){
        int number;
        while(true){
            System.out.println(message);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                return number;
            }
            else{
                System.out.println("INVALID INPUT! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
