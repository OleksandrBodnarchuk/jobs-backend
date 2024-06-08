package pl.alex.jobsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alex.jobsbackend.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
