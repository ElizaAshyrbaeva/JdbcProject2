package peaksoft;

import peaksoft.model.Employee;
import peaksoft.model.Job;
import peaksoft.service.EmployeeServiceImpl;
import peaksoft.service.JobServiceImpl;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JobServiceImpl js = new JobServiceImpl();
        EmployeeServiceImpl es = new EmployeeServiceImpl();
        while (true) {
            System.out.println("""
                     >>>>>>>>>>Job<<<<<<<<
                     1.Create Table Job->
                     2.Add Job->
                     3.Get Job By Id->
                     4.Sort By Experience->
                     5.Get Job By Employee Id->
                     6.Delete Description Column->
                                       
                    *********************************
                                       
                    >>>>>>>>>Employee<<<<<<<<<<
                    7.Create Table Employee->
                    8.Add Employee->
                    9.Drop table->
                    10.Clean  table->
                    11.Update Employee->
                    12.Get All Employees->
                    13.Find By Email->
                    14.Get Employee By Id->
                    15.Get Employee By Position->
                                      
                     """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> js.createJobTable();
                case 2 -> {
                    System.out.println("Position:");
                    String position = new Scanner(System.in).nextLine();
                    System.out.println("Profession:");
                    String profession = new Scanner(System.in).nextLine();
                    System.out.println("description");
                    String description = new Scanner(System.in).nextLine();
                    System.out.println("Experience");
                    int experience = new Scanner(System.in).nextInt();
                    System.out.println(js.addJob(new Job(position, profession, description, experience)));
                }
                case 3 -> {
                    System.out.print("Enter a Job ID : ");
                    System.out.println(js.getJobById(new Scanner(System.in).nextLong()));
                }
                case 4 -> {
                    System.out.print("Enter a sort order (asc/desc) : ");
                    System.out.println(js.sortByExperience(new Scanner(System.in).nextLine()));
                }
                case 5 -> {
                    System.out.print("Enter a employee id : ");
                    System.out.println(js.getJobByEmployeeId(new Scanner(System.in).nextLong()));
                }
                case 6 -> System.out.println(js.deleteDescriptionColumn());
                case 7 -> System.out.println(es.createEmployee());
                case 8 -> {
                    System.out.print("Enter a first name : ");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.print("Enter a last name : ");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.print("Enter an age : ");
                    int age = new Scanner(System.in).nextInt();
                    System.out.print("Enter an email : ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.print("Enter a job id : ");
                    int jobId = new Scanner(System.in).nextInt();
                    Employee ne = new Employee(firstName, lastName, age, email, jobId);
                    System.out.println(es.addEmployee(ne));
                }
                case 9 -> System.out.println(es.dropTable());
                case 10 -> System.out.println(es.cleanTable());
                case 11 -> {
                    System.out.print("Enter a employee id : ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("Enter new firstName : ");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.print("Enter new lastName : ");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.print("Enter new age : ");
                    int newAge = new Scanner(System.in).nextInt();
                    System.out.print("Enter new email : ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.print("Enter new job id : ");
                    int jobId = new Scanner(System.in).nextInt();
                    Employee ne = new Employee(firstName, lastName, newAge, email, jobId);
                    System.out.println(es.updateEmployee(id, ne));
                }
                case 12 -> System.out.println(es.getAllEmployees());
                case 13 -> {
                    System.err.println("Enter an email :");
                    System.out.println(es.findByEmail(new Scanner(System.in).nextLine()));
                }
                case 14 -> {
                    System.err.println("Enter id :");
                    System.out.println(es.getEmployeeById(new Scanner(System.in).nextLong()));
                }
                case 15 -> {
                    System.err.println("Enter an position :");
                    System.out.println(es.getEmployeeByPosition(new Scanner(System.in).nextLine()));
                }
                default -> System.err.println("Error !!!");

            }
        }

    }
}
