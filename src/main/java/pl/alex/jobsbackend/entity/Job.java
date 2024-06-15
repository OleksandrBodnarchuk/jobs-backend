package pl.alex.jobsbackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
        .company(Company.toDto(job.company))
        .build();
  }

  public static Job toEntity(JobDto dto) {
    return Job.builder()
        .type(dto.type())
        .title(dto.title())
        .description(dto.description())
        .location(dto.location())
        .salary(dto.salary())
        .company(Company.toEntity(dto.company()))
        .build();
  }

}
