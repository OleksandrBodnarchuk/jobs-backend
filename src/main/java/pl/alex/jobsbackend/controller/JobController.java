package pl.alex.jobsbackend.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.alex.jobsbackend.entity.JobDto;
import pl.alex.jobsbackend.service.JobService;

@Slf4j
@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

  private final JobService jobService;

  @GetMapping("/{id}")
  public ResponseEntity<JobDto> getJobById(@PathVariable long id) {
    JobDto jobById = jobService.getJobById(id);
    log.info("Job fetched: {}", jobById.toString());
    return ResponseEntity.ok(jobById);
  }

  @GetMapping
  public ResponseEntity<List<JobDto>> getJobWithLimit(
      @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
    List<JobDto> jobDtos = jobService.getJobsLimited(limit);
    log.info("Fetched: {}", jobDtos.stream().map(JobDto::title).collect(Collectors.joining(", ")));
    return ResponseEntity.ok(jobDtos);
  }

  @PostMapping("/add")
  public ResponseEntity<JobDto> saveJob(@RequestBody JobDto jobDto) {
    log.info("Saving job: {}", jobDto.toString());
    return ResponseEntity.ok(jobService.saveJob(jobDto));
  }
}
