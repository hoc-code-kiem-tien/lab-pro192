package ce180797_lab05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nguyen Hoang Dat
 */
public class CE180797_Lab05 {

    public static void showMenu() {
        System.out.print("----- BOOK MANAGEMENT -----\n" +
                            "1. Adds new book.\n" +
                            "2. Shows all books.\n" +
                            "3. The biggest size book.\n" +
                            "4. Search a book by ID.\n" +
                            "5. Sort the list of books ascending by size.\n" +
                            "6. Delete a book by ID.\n" +
                            "7. Quit.\n" +
                            "Please select a function:");
    }
    
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // Declaring object
        BookManagement book = new BookManagement();
        
        /* 
        Creating a constant loop to show menu and receive the options.
        (The program ends when there is an exiting option or an invalid option).
        */
        do {
            // Using the method to show menu
            showMenu();
            // Receive the option (Remove \n in buffer after that)
            int option = input.nextInt(); input.nextLine();
            
            // Perform function (from menu) according to option
            switch(option) {
                case 1:
                    book.entryData();
                    break;
                case 2:
                    book.printData();
                    break;
                case 3:
                    System.out.println("| No. | ID    | Name                     | Year | Author        | Size  | URL            |");
                    System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
                    
                    // Using count variable to constantly print No.
                    int count = 0;
                    // print all the books in the ArrayList book.biggestSize(), according to format
                    for(int i = 0 ; i < book.biggestSize().size(); i++) {
                        System.out.printf("|  %-3d", ++count);
                        book.biggestSize().get(i).ShowInfo();
                        System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
                    }
                    break;
                case 4:
                    System.out.print(">>> Please enter book's ID to search: ");
                    String ID = input.nextLine();
                    
                    // Using count variable to constantly print No.
                    count = 0;
                    // Consider condition to print found book
                    if(book.searchBookObjectByID(ID) != null){
                        System.out.println("Search Results:");
                        System.out.println("-----------------------------------BOOK MANAGEMENT --------------------------------------+");
                        System.out.println("| No. | ID    | Name                     | Year | Author        | Size  | URL            |");
                        System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
                        System.out.printf("|  %-3d", ++count);
                        book.searchBookObjectByID(ID).ShowInfo();
                            System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
                    }
                    else
                        System.out.println("Search Results: Not Found");
                    break;
                case 5:
                    book.sort();
                    book.printData();
                    break;
                case 6:
                    String deleteID = input.nextLine();
                    book.deleteBookByID(deleteID);
                    break;
                case 7:
                    System.out.println("THANK FOR USING OUR APPLICATION!");
                    System.out.print("SEE YOU AGAIN!");
                    return;
                default:
                    System.out.print("The function of application must be from 1 to 7!");
                    return;
            }
            
        }
        while(true);
        
    }
    
}
