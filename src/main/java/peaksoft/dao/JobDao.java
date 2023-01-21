package peaksoft.dao;

import peaksoft.model.Job;

import java.util.List;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public interface JobDao {
    void createJobTable();
    void addJob(Job job);
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    void deleteDescriptionColumn();
}
