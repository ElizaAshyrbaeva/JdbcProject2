package peaksoft.dao;

import com.sun.security.auth.UnixNumericGroupPrincipal;
import peaksoft.config.Util;
import peaksoft.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author
 * Eliza Ashyrbaeva
 * Don't give up!
 **/
public class JobDaoImpl implements JobDao{
    Connection cn;
    public JobDaoImpl (){
        this.cn= Util.getConnection();
    }
    @Override
    public void createJobTable() {
        String sql = "create table  jobs(id serial primary key , position varchar not null ,profession varchar not null ,description  varchar not null ,experience varchar not null )";
        try (Statement st = cn.createStatement()){
                st.execute(sql);
            System.out.println("Successfully!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addJob(Job job) {
        String sql = "insert into jobs (position,profession,description, experience) values (?,?,?,?);";
        try (PreparedStatement pr = cn.prepareStatement(sql)){
            pr.setString(1, job.getPosition());
            pr.setString(2,job.getPosition());
            pr.setString(3,job.getDescription());
            pr.setInt(4,job.getExperience());
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Job getJobById(Long jobId) {
        String sql = "select * from jops where id =?";
        try (PreparedStatement pr = cn.prepareStatement(sql)) {
            pr.setLong(1, jobId);
            pr.executeQuery();
            ResultSet rs = pr.getResultSet();
            Job job = new Job();
            while (rs.next()) ;
            job.setId(rs.getLong("id"));
            return job;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        String sql = "";
        if(ascOrDesc.equals("asc")) sql = "SELECT * FROM jobs ORDER BY experience;";
        else sql = "SELECT * FROM jobs ORDER BY experience DESC;";

        List<Job> results = new ArrayList<>();
        try(Statement statement = cn.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Job job = new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                results.add(job);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return results;
    }
    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        String sql ="select  * from jobs join employee e on jobs.id = e.jobId where e.id= ?";
        try (PreparedStatement pr= cn.prepareStatement(sql)){
            pr.setLong(1,employeeId);
            ResultSet rs  = pr.getResultSet();
            Job job = new Job();
            while (rs.next()){
                job.setId(rs.getLong("id"));
                job.setPosition(rs.getString("position"));
                job.setProfession(rs.getString("profession"));
                job.setDescription(rs.getString("description"));
                job.setExperience(rs.getInt("experience"));
            }
            return job;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteDescriptionColumn()  {
        String sql = "alter table jobs drop column description";
        try (Statement st = cn.createStatement()){
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
