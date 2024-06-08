package pl.alex.jobsbackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String type;
  private String description;
  private String location;
  private String salary;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

 public static JobDto toDto(Job job) {
   return JobDto.builder()
       .id(String.valueOf(job.id))
       .type(job.type)
       .title(job.title)
       .description(job.description)
       .location(job.location)
       .salary(job.salary)
       .companyDto(Company.toDto(job.company))
       .build();
 }

}
