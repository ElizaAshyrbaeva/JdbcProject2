package peaksoft.service;

import peaksoft.dao.JobDao;
import peaksoft.dao.JobDaoImpl;
import peaksoft.model.Job;

import java.util.List;
import java.util.Scanner;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public class JobServiceImpl implements JobService {
    JobDao jd = new JobDaoImpl();

    @Override
    public String createJobTable() {
        jd.createJobTable();
        return "Successfully!!!";
    }

    @Override
    public String addJob(Job job) {
        jd.addJob(job);
        return "Successfully added !!!";

    }

    @Override
    public Job getJobById(Long jobId) {
        return jd.getJobById(new Scanner(System.in).nextLong());
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jd.sortByExperience(new Scanner(System.in).nextLine());
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return jd.getJobByEmployeeId(new Scanner(System.in).nextLong());
    }

    @Override
    public String deleteDescriptionColumn() {
        jd.deleteDescriptionColumn();
        return "Successfully deleted !!!";
    }
}
