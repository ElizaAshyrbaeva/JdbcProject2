package peaksoft.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
@Getter
@Setter
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int jobId;

    public Employee( String firstName, String lastName, int age, String email, int jobId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.jobId = jobId;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "\nEmployee :" +" "+
                "id :" + id +" "+
                "firstName :" + firstName + '\'' +" "+
                "lastName :" + lastName + '\'' +" "+
                "age :" + age +" "+
                "email :" + email + '\'' + " "+
                "jobId :" + jobId ;
    }
}
