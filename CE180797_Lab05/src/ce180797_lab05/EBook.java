package ce180797_lab05;

/**
 *
 * @author Nguyen Hoang Dat
 */
public class EBook extends Book{
    // Attributes
    private String URL;

    // Constructor method
    public EBook() {
    }
    public EBook(String ID, String name, int year, String author, int size, String URL) {
        super(ID, name, year, author, size);
        this.URL = URL;
    }
    
    // getter, setter
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    
    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.printf("%-15s |\n",URL);
    }

}
