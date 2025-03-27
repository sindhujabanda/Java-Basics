package Basics.Scenario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Student {
    String name;
    int age;
    String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, course);
    }

    public static class ChoosingTheOperation{
        static Set<Student> studentDetails = new HashSet<>();
        public static void main(String[] args) throws IOException {
            boolean option = true;
            Scanner scanner = new Scanner(System.in);
            while (option) {

                System.out.println("Choose An Option");
                System.out.println("1. Adding new student Details");
                System.out.println("2. Retrieve a student details");
                System.out.println("3. Exit");
                System.out.println("4. Get all Student Details");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudentDetails();
                        break;
                    case 2:
                        getStudentDetails();
                        break;
                    case 3:
                        System.out.println("Exiting");
                        option = false;
                        break;
                    case 4:
                        getAllStudentDetails();
                        break;
                    default:
                        System.out.println("Invalid Choice. Enter 1 or 2");
                }
            }
            scanner.close();
        }

        public static void addStudentDetails() throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter student Name");
            String name = bufferedReader.readLine();

            System.out.println("Enter age");
            int age = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter course Name");
            String course = bufferedReader.readLine();

            Student student = new Student(name, age, course);
            studentDetails.add(student);
            System.out.println(student);
        }

        public static void getStudentDetails(){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String name = scanner.nextLine();

            for(Student details: studentDetails){
                if(details.name.equals(name)){
                    System.out.println(details);
                }
            }
        }

        public static void getAllStudentDetails(){
            System.out.println(studentDetails);
        }
    }


}
