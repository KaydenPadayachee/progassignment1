/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentonest10385543;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kpada
 */
public class Student {
    private ArrayList<String> StudentID;
    private ArrayList<String> StudentName;
    private ArrayList<Integer> StudentAge;
    private ArrayList<String> StudentEmail;
    private ArrayList<String> StudentCourse;

    public void setStudentID(ArrayList<String> StudentID) {
        this.StudentID = StudentID;
    }

    public void setStudentName(ArrayList<String> StudentName) {
        this.StudentName = StudentName;
    }

    public void setStudentAge(ArrayList<Integer> StudentAge) {
        this.StudentAge = StudentAge;
    }

    public void setStudentEmail(ArrayList<String> StudentEmail) {
        this.StudentEmail = StudentEmail;
    }

    public void setStudentCourse(ArrayList<String> StudentCourse) {
        this.StudentCourse = StudentCourse;
    }
   
    public Student() {
        this.StudentID = new ArrayList<String>();
        this.StudentName = new ArrayList<String>();
        this.StudentAge = new ArrayList<Integer>();
        this.StudentEmail = new ArrayList<String>();
        this.StudentCourse =new ArrayList<String>();
    }

    public ArrayList<String> getStudentID() {
        return StudentID;
    }

    public ArrayList<String> getStudentName() {
        return StudentName;
    }

    public ArrayList<Integer> getStudentAge() {
        return StudentAge;
    }

    public ArrayList<String> getStudentEmail() {
        return StudentEmail;
    }

    public ArrayList<String> getStudentCourse() {
        return StudentCourse;
    }
   
    public void WelcomeMessage()
    {  
        Scanner kb = new Scanner(System.in);
       
        System.out.println("  Welcome to your Student Management System\n" +
"                           Enter 1 or any other key to exit");
        if (kb.next().equals("1"))
        {
            Option(kb);    
        }else
        {
            System.exit(0);
        }
    }
   
    public void Option(Scanner kb)
    {
        //
       
        System.out.println("Please select one of the following menu items:\n" +
"                           (1) Capture a new student.\n" +
"                           (2) Search for a student.\n" +
"                           (3) Delete a student.\n" +
"                           (4) Print student report.\n" +
"                           (5) Exit Application"
                           );
        
        //switchcase 
        switch (kb.next()) {
            case "1":
           {
                SaveStudent(kb,getStudentID(),getStudentName(),getStudentAge(),getStudentEmail(),getStudentCourse());
                exitchoice(kb);
            }
            case "2" : {
                System.out.println(SearchStudent(kb, getStudentID(),getStudentName(),getStudentAge(),getStudentEmail(),getStudentCourse()));
                exitchoice(kb);
            }
            case "3" : {
                System.out.println(DeletesStudent(kb, getStudentID(),getStudentName(),getStudentAge(),getStudentEmail(),getStudentCourse()));
                exitchoice(kb);
            }
            case "4" : {
                StudentReport(kb, getStudentID(),getStudentName(),getStudentAge(),getStudentEmail(),getStudentCourse());
                exitchoice(kb);
            }
            case "5" : ExitStudentApplication();
            default : setchoice(kb);
        }
    }
   
    public void SaveStudent(Scanner kb, ArrayList<String> ID, ArrayList<String> Name, ArrayList<Integer> Age, ArrayList<String> Email, ArrayList<String> Course) {
   
    String output;
    String EnteredAge;

    System.out.println("   CAPTURE A NEW STUDENT\n" +
"                       ********************\n" +
"                       Enter the student id:");
    ID.add(kb.next());

    System.out.println("Enter the student name: ");
    Name.add(kb.next());

    System.out.println("Enter the student age: ");
    EnteredAge = StudentAgeChecker(kb);

    if (EnteredAge.equals("Incorect")) {
    output = "Invalid age. The student details have not been saved.";
} else {
    Age.add(Integer.valueOf(EnteredAge));

    System.out.println("Enter the student email: ");
    Email.add(kb.next());

    System.out.println("Enter the student course: ");
    Course.add(kb.next());

        setStudentAge(StudentAge);
        setStudentCourse(StudentCourse);
        setStudentEmail(StudentEmail);
        setStudentID(StudentID);
        setStudentName(StudentName);
    output = "The student details have been successfully saved.";
}   
}
     public void StudentReport(Scanner kb, ArrayList<String> ID, ArrayList<String> Name, ArrayList<Integer> Age, ArrayList<String> Email, ArrayList<String> Course) {
    int i = 0;
    
    while (i < ID.size()) {
        System.out.println("student " + (i + 1)
                + "\n-------------------------------------------"
                + "\nSTUDENT ID: " + ID.get(i)
                + "\nSTUDENT NAME: " + Name.get(i)
                + "\nSTUDENT AGE: " + Age.get(i)
                + "\nSTUDENT EMAIL: " + Email.get(i)
                + "\nSTUDENT COURSE: " + Course.get(i)
                + "\n--------------------------------------------");

        i++;
    }
}
    public String StudentAgeChecker(Scanner kb) {
    String AgeToCheck;
    String output;

    while (true) {
        AgeToCheck = kb.next();

        if (AgeToCheck.matches("[0-9]+") && Integer.parseInt(AgeToCheck) >= 16) {
            output = AgeToCheck;
            break; // Exit the loop when a valid age is entered
        } else {
            System.out.println(" You have entered an incorrect student age!!!\n" +
"                    Please re-enter the student age >>"
                    );
        }
    }

    return output;
}
   
    public String SearchStudent (Scanner kb, ArrayList<String> ID ,ArrayList<String> Name, ArrayList<Integer> Age, ArrayList<String> Email, ArrayList<String> Course)
    {
        //declaration
        String IDToSearchFor;
        boolean notfound=true;
        String output="";        
        System.out.println("Enter the student id to search: ");
        IDToSearchFor=kb.next();
       
        for (int i = 0; i < ID.size(); i++)
        {
            if (ID.get(i).equals(IDToSearchFor))
            {
                output=           ("-------------------------------------------------------"
                                  +"\nSTUDENT ID: "+ID.get(i)
                                  +"\nSTUDENT NAME: "+Name.get(i)
                                  +"\nSTUDENT AGE: "+Age.get(i)
                                  +"\nSTUDENT EMAIL: "+Email.get(i)
                                  +"\nSTUDENT COURSE: "+Course.get(i)
                                  +"\n-------------------------------------------------------");
                notfound=false;
            }
        }
        if (notfound==true)
        {
            output=           ("--------------------------------------------------------"
                              +"\nStudent with Student id: "+IDToSearchFor+" was not be found!"
                              +"\n--------------------------------------------------------");
        }
       
        return output;
    }
   
   public String DeletesStudent(Scanner kb, ArrayList<String> ID, ArrayList<String> Name, ArrayList<Integer> Age, ArrayList<String> Email, ArrayList<String> Course) {
    // Declaration
    String IDToDelete;
    boolean notfound = true;
    String output = "";

    System.out.println("Enter the student id to delete: ");
    IDToDelete = kb.next();

    int i = 0; // Initialize index

    while (i < ID.size()) {
        if (ID.get(i).equals(IDToDelete)) {
            notfound = false;
            System.out.println("-------------------------------------------------------"
                    + "\nSTUDENT ID: " + ID.get(i)
                    + "\nSTUDENT NAME: " + Name.get(i)
                    + "\nSTUDENT AGE: " + Age.get(i)
                    + "\nSTUDENT EMAIL: " + Email.get(i)
                    + "\nSTUDENT COURSE: " + Course.get(i)
                    + "\n-------------------------------------------------------"
                    + "\nAre you sure you want to delete student " + IDToDelete + " from the system? Yes (y) to delete");

            if (kb.next().equals("y")) {
                ID.remove(i);
                Name.remove(i);
                Age.remove(i);
                Email.remove(i);
                Course.remove(i);
              setStudentAge(StudentAge);
        setStudentCourse(StudentCourse);
        setStudentEmail(StudentEmail);
        setStudentID(StudentID);
        setStudentName(StudentName);
                output = ("-------------------------------------------------------"
                        + "\nStudent with id " + IDToDelete + " WAS deleted!"
                        + "\n-------------------------------------------------------");
                break; // Exit the loop once the student is deleted
            }
        } else {
            i++; // Move to the next student if not found
        }
    }

    if (notfound) {
        output = ("--------------------------------------------------------"
                + "\nStudent with Student id: " + IDToDelete + " was not found!"
                + "\n--------------------------------------------------------");
    }

    return output;
}
    public void ExitStudentApplication()
    {
        System.exit(0);
    }
   
    public void setchoice(Scanner kb)
    {
        System.out.println(" That is an invalid choice.\n" +
"                           Select from the options provided"
                          );
        Option(kb);
    }
   
    public void exitchoice (Scanner kb){
        System.out.println("Enter (1) to launch menu or any other key to exit");
        if (kb.next().equals("1")) {
            Option(kb);
        }
    }
   
}


    
  

    

