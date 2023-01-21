package peaksoft.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
@Getter
@Setter
public class Job {
    private Long id;
    private String position;
    private String profession;
    private String description;
    private int experience;

    public Job( String position, String profession, String description, int experience) {
        this.position = position;
        this.profession = profession;
        this.description = description;
        this.experience = experience;

    }

    public Job(Long id, String position, String profession, String description, int experience) {
        this.id = id;
        this.position = position;
        this.profession = profession;
        this.description = description;
        this.experience = experience;
    }

    public Job() {
    }

    @Override
    public String toString() {
        return "\nJob :" +
                "id :" + id +
                "position :" + position + '\'' +
                "profession :" + profession + '\'' +
                "description :" + description + '\'' +
                "experience :" + experience ;
    }
}
