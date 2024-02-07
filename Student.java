package ce180797_lab03;

/**
 *
 * @author Nguyen Hoang Dat
 */
public class Student {

    // Attributes
    private String ID;
    private String fullName;
    private double math;
    private double literature;
    
    // method to pass data to attributes variables
    Student(String iID, String iFullName, double iMath, double iLiterature) {
        ID = iID;
        fullName = iFullName;
        math = iMath;
        literature = iLiterature;
    }

    // Setter
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setMath(double math) {
        this.math = math;
    }
    public void setLiterature(double literature) {
        this.literature = literature;
    }
    
    // Getter
    public String getID() {
        return ID;
    }
    public String getFullName() {
        return fullName;
    }
    public double getMath() {
        return math;
    }
    public double getLiterature() {
        return literature;
    }
    
    double getGPA() {
        return (math + literature) / 2;
    }    
    
}
