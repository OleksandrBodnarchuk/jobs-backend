package pl.alex.jobsbackend.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.alex.jobsbackend.entity.Job;
import pl.alex.jobsbackend.entity.JobDto;
import pl.alex.jobsbackend.repository.JobRepository;

@Service
@RequiredArgsConstructor
public class JobService {

  private final JobRepository jobRepository;

  public JobDto getJobById(Long id) {
    return jobRepository.findById(id).map(Job::toDto)
        .orElseThrow(() -> new RuntimeException("Job not found"));
  }

  public List<JobDto> getJobsLimited(int limit) {
    Pageable pageable = PageRequest.of(0, limit);
    return jobRepository.findAll(pageable).stream().map(Job::toDto).collect(Collectors.toList());
  }

  public JobDto saveJob(JobDto jobDto) {
    Job saved = jobRepository.save(Job.toEntity(jobDto));
    return Job.toDto(saved);
  }

  public void deleteJobById(long id) {
    jobRepository.deleteById(id);
  }
}
