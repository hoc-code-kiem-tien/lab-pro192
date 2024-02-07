package ce180797_lab03;

/**
 *
 * @author Nguyen Hoang Dat
 */

import java.util.Scanner;
import java.util.ArrayList;

public class CE180797_Lab03 {
    
    // method để show menu cho người dùng chọn
    public static void menu() {
        System.out.println("----- STUDENT MANAGEMENT V1.0 -----");
        System.out.println();
        System.out.println("1. Adds new student.");
        System.out.println("2. Shows all students.");
        System.out.println("3. Quit.");
        System.out.print("Please select a funtion:");
    }
    
    // method để show thông tin tất cả sinh viên
    public static void showAllStudents(ArrayList<Student> studentArrayList) {
        // in ra khung cho nó đẹp
        System.out.println("----- STUDENT MANAGEMENT V1.0 [List of student] -----");
        System.out.println("| No. | ID    | Student name      | Math | Lit | GPA |");
        System.out.println("+-----+-------+-------------------+------+-----+-----+");
        double max  = studentArrayList.get(0).getGPA();
        for(int i = 0; i < studentArrayList.size(); i++) {
            // Tìm phần tử có thuộc tính .getGPA() lớn nhất gán vô biến max
            if(studentArrayList.get(i).getGPA() > max)
                max = studentArrayList.get(i).getGPA();
            // in ra các thuộc tính theo format
            System.out.printf("|  %-3d| %-5s | %-17s | %-4.1f | %-4.1f| %-4.1f|",
                    i+1, studentArrayList.get(i).getID(), studentArrayList.get(i).getFullName(),
                    studentArrayList.get(i).getMath(),  studentArrayList.get(i).getLiterature(),  studentArrayList.get(i).getGPA());
            System.out.println("\n+-----+-------+-------------------+------+-----+-----+");
        }
        // in ra danh sách người có điểm cao nhất
        System.out.println("The best of this class is/are:");
        int count = 0; // biến đếm này để đếm thứ tự những người đồng hạng nhất
        for(int i = 0; i < studentArrayList.size(); i++)
            if(studentArrayList.get(i).getGPA() == max)        
                System.out.printf("%d. %s (GPA: %.1f))\n", ++count, studentArrayList.get(i).getFullName(), studentArrayList.get(i).getGPA());
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // Khởi tạo một ArrayList để lưu các student theo class Student
        ArrayList<Student> students = new ArrayList<>();
        // Tạo menu
        do {
            menu(); // Gọi method in ra menu
            // lưu lựa chọn nhập vào
            int option = input.nextInt(); 
            input.nextLine();
            switch (option) {
                case 1:
                    String studentInputInfo;
                    // Nếu nhập vào chuỗi trống thì yêu cầu nhập lại đến khi đúng
                    do{
                        System.out.println("----STUDENT MANAGEMENT V1.0 [ADD NEW STUDENT]----");
                        System.out.print("Please enter Student Infomation: ");
                        studentInputInfo = input.nextLine();
                        if(studentInputInfo.equals(""))
                            System.out.println("-->You must enter the data!");
                    }
                    while(studentInputInfo.equals(""));
                    // Khi nhập đúng rồi thì xử lý tách chuỗi thành 4 chuỗi để truyền vào các thuộc tính của mỗi phần tử student
                    String[] infoSplit = new String[4];
                    infoSplit = studentInputInfo.split("@");
                    students.add(new Student(infoSplit[0], infoSplit[1], Double.parseDouble(infoSplit[2]), Double.parseDouble(infoSplit[3])));
                    System.out.println("-->Student created and added to the list of student successful!");
                    break;
                case 2:
                    // option 2 hiển thị tất cả thông tin bằng phương thức showAllStudent();
                    showAllStudents(students);
                    break;
                case 3:
                    // option 3 là thông báo rồi thoát chương trình
                    System.out.print("THANK FOR USING OUR APPLICATION!\n"
                            + "SEE YOU AGAIN!  ");
                    return;
                default: 
                    // Nếu không phải option 1-3 thì in ra thông báo rồi thoát chương trình
                    System.out.print("The function of application must be from 1 to 3!");
                    return;
            }
        }
        while(true);
    }
    
}

