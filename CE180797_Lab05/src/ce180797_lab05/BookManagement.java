package ce180797_lab05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nguyen Hoang Dat
 */
public class BookManagement {
    
    // Attributes
    private ArrayList<EBook> listEBook = new ArrayList<>();

    // Constructor methods
    public BookManagement() {
        listEBook.add(new EBook("B0001", "HTML", 2022, "Peter, John", 100, "www.google.com"));
        listEBook.add(new EBook("B0002", "C/C++", 2000, "Bobita", 90, "http://c.com.vn"));
        listEBook.add(new EBook("B0003", "JAVA", 1999, "Jerry", 65, "www.google.com"));
        listEBook.add(new EBook("B0004", "Python", 1998, "John", 70, "python.org"));
        listEBook.add(new EBook("B0005", "Javascript", 2000, "Peter", 19, "javacript.com"));
    }
    
    // Add new book to ArrayList (listEBook)
    public void entryData() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("----- Add new ebook -----");
        
        System.out.print("Input ID: ");
        String ID = input.nextLine();

        System.out.print("Input name: ");
        String name = input.nextLine();

        System.out.print("Input year: ");
        int year = input.nextInt();
        input.nextLine(); // remove \n in buffer

        System.out.print("Input authors: ");
        String author = input.nextLine();

        System.out.print("Input size (kilobyte): ");
        int size = input.nextInt();
        input.nextLine(); // remove \n in buffer

        System.out.print("Input url: ");
        String URL = input.nextLine();
        
        // add an EBook with those attributes to listEBook if they are satisfy the conditions
        if(ID.length() == 5 && !name.isEmpty() && year >= 1900 && year <= 2024 
                && !author.isEmpty() && size > 0) 
        {
            System.out.println("Ebook created and added to list of ebooks successful!");
            listEBook.add(new EBook(ID, name, year, author, size, URL));
        }
    }
    
    // Print list of books
    public void printData() {
        System.out.println("-----------------------------------BOOK MANAGEMENT --------------------------------------+");
        System.out.println("| No. | ID    | Name                     | Year | Author        | Size  | URL            |");
        System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
        int count = 0;
        for(int i = 0 ; i < listEBook.size(); i++) {
            System.out.printf("|  %-3d", ++count);
            listEBook.get(i).ShowInfo();
            System.out.println("+-----+-------+--------------------------+------+---------------+-------+----------------+");
        }
    }
    
    // Sort the list of books ascending by size   
    public void sort() {
        Collections.sort(listEBook, (b1, b2) -> Integer.compare(b2.getSize(), b1.getSize()));
        System.out.println("List of books sorted in ascending order by size.");    
    }
    
    // Return the index of the Book found in the list. Return -1 if not found.
    public int searchBookByID(String ID) {
        for(int i = 0; i < listEBook.size(); i++)
            if(listEBook.get(i).getID().equals(ID))
                return i;
        return -1;
    }
    
    // Return the object of the Book found in the list. Return null if not found.
    public EBook searchBookObjectByID(String ID) {
        for(int i = 0; i < listEBook.size(); i++)
            if(listEBook.get(i).getID().equals(ID))
                return listEBook.get(i);
        return null;
    }
    
    // Return a list of books with the largest size 
    public ArrayList<EBook> biggestSize() {
        int max = listEBook.get(0).getSize();
        ArrayList<EBook> listOfBiggest = new ArrayList<>();
        
        for(int i = 0; i < listEBook.size(); i++) 
            if(listEBook.get(i).getSize() > max)
                max = listEBook.get(i).getSize();
    
        for(int i = 0; i < listEBook.size(); i++)
            if(listEBook.get(i).getSize() == max)
                listOfBiggest.add(listEBook.get(i));
        
        return listOfBiggest;
    }
    
    /*
    Delete the book with the ID entered by the user 
    and displays the message 'Delete successfully'. 
    If the book is not found, the message 'Not found' will be displayed.
    */
    public void deleteBookByID(String ID) {
        if(searchBookByID(ID) != -1) {
            listEBook.remove(searchBookByID(ID));
            System.out.println("Delete successfully");
        }
        else
            System.out.println("Not found");
    }
    
}
