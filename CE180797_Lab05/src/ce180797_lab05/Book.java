package ce180797_lab05;

/**
 *
 * @author Nguyen Hoang Dat
 */
public class Book {
    // Attributes
    private String ID;
    private String name;
    private int year;
    private String author;
    private int size;
    
    // Constructor method
    public Book() {
    }
    public Book(String ID, String name, int year, String author, int size) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.author = author;
        this.size = size;
    }

    // Getter, setter
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public void ShowInfo() {
         System.out.printf("| %5s | %-24s | %4d | %-13s |%4dKB |",
            ID, name, year, author, size);
    }
    
}
