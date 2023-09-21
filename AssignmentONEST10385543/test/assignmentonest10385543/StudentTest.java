/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentonest10385543;

import java.io.ByteArrayInputStream;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Test;
import java.util.ArrayList;


/**
 *
 * @author ramck
 */
public class StudentTest {
    
    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Welcome to unit testing");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setStudentID method, of class Student.
     */

@Test
    public void testSetStudentID() {
        // Create an instance of the Student class
        Student student = new Student();

        // Create a sample ArrayList for StudentID
        ArrayList<String> studentID = new ArrayList<>();
        studentID.add("123");
        studentID.add("456");

        // Call the setStudentID method
        student.setStudentID(studentID);

        // Use assertions to verify that the StudentID has been set correctly
        assertEquals(studentID, student.getStudentID());
    }


    @Test
    public void testSaveStudent() {
        // Create an instance of the Student class
        Student student = new Student();

        // Create a sample input to simulate user input via Scanner
        String input = "123\nJohn\n20\njohn@example.com\nMath";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Create ArrayLists to store student data
        ArrayList<String> studentID = new ArrayList<>();
        ArrayList<String> studentName = new ArrayList<>();
        ArrayList<Integer> studentAge = new ArrayList<>();
        ArrayList<String> studentEmail = new ArrayList<>();
        ArrayList<String> studentCourse = new ArrayList<>();

        // Call the SaveStudent method with the simulated input
        student.SaveStudent(new Scanner(System.in), studentID, studentName, studentAge, studentEmail, studentCourse);

        // Assertions to verify that data was added correctly
        assertEquals(1, studentID.size());
        assertEquals("123", studentID.get(0));

        assertEquals(1, studentName.size());
        assertEquals("John", studentName.get(0));

        assertEquals(1, studentAge.size());
        assertEquals(Integer.valueOf(20), studentAge.get(0));

        assertEquals(1, studentEmail.size());
        assertEquals("john@example.com", studentEmail.get(0));

        assertEquals(1, studentCourse.size());
        assertEquals("Math", studentCourse.get(0));
    }
     @Test
    public void testDeletesExistingStudent() {
        ArrayList<String> ID = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<Integer> Age = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> Course = new ArrayList<>();

        ID.add("1");
        Name.add("John");
        Age.add(20);
        Email.add("john@example.com");
        Course.add("Math");

        String input = "1\ny\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner kb = new Scanner(inputStream);

        Student sms = new Student();

        String result = sms.DeletesStudent(kb, ID, Name, Age, Email, Course);

        assertEquals("-------------------------------------------------------\nStudent with id 1 WAS deleted!\n-------------------------------------------------------", result);
        assertEquals(0, ID.size());
        assertEquals(0, Name.size());
        assertEquals(0, Age.size());
        assertEquals(0, Email.size());
        assertEquals(0, Course.size());
    }

    @Test
    public void testDeletesNonExistingStudent() {
        ArrayList<String> ID = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<Integer> Age = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> Course = new ArrayList<>();

        ID.add("1");
        Name.add("John");
        Age.add(20);
        Email.add("john@example.com");
        Course.add("Math");

        String input = "2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner kb = new Scanner(inputStream);

        Student sms = new Student();

        String result = sms.DeletesStudent(kb, ID, Name, Age, Email, Course);

        assertEquals("--------------------------------------------------------\nStudent with Student id: 2 was not found!\n--------------------------------------------------------", result);
        assertEquals(1, ID.size());
        assertEquals(1, Name.size());
        assertEquals(1, Age.size());
        assertEquals(1, Email.size());
        assertEquals(1, Course.size());
    }
     @Test
    public void testSearchExistingStudent() {
        ArrayList<String> ID = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<Integer> Age = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> Course = new ArrayList<>();

        ID.add("1");
        Name.add("John");
        Age.add(20);
        Email.add("john@example.com");
        Course.add("Math");

        String input = "1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner kb = new Scanner(inputStream);

        Student sms = new Student();

        String result = sms.SearchStudent(kb, ID, Name, Age, Email, Course);

        assertEquals("-------------------------------------------------------\nSTUDENT ID: 1\nSTUDENT NAME: John\nSTUDENT AGE: 20\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Math\n-------------------------------------------------------", result);
    }

    @Test
    public void testSearchNonExistingStudent() {
        ArrayList<String> ID = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<Integer> Age = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> Course = new ArrayList<>();

        ID.add("1");
        Name.add("John");
        Age.add(20);
        Email.add("john@example.com");
        Course.add("Math");

        String input = "2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner kb = new Scanner(inputStream);

        Student sms = new Student();

        String result = sms.SearchStudent(kb, ID, Name, Age, Email, Course);

        assertEquals("--------------------------------------------------------\nStudent with Student id: 2 was not be found!\n--------------------------------------------------------", result);
    }
}


    
   /*  @Test
    public void testExitChoice() {
        // Create an instance of the Student class
        Student student = new Student();

        // Mock the Scanner input
        Scanner mockScanner = new Scanner(System.in);
         System.out.println("Enter (1) to launch menu or any other key to exit\n");
String actualOutput = mockScanner.nextLine();
      

student.exitchoice(mockScanner);
        // Define the expected output and the actual printed output
        String expectedOutput = "1";

        // Verify the printed output matches the expected output
        assertEquals(expectedOutput, actualOutput);
    }
*/


//2. Junit testing-https://www.youtube.com/watch?v=vZm0lHciFsQ


    

