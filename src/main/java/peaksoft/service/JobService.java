package peaksoft.service;

import peaksoft.model.Job;

import java.util.List;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public interface JobService {
    String  createJobTable();
    String addJob(Job job);
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    String deleteDescriptionColumn();
}
