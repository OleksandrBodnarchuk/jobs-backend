package pl.alex.jobsbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "companies")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String contactEmail;
  private String contactPhone;

  static CompanyDto toDto(Company company) {
    return CompanyDto.builder()
        .id(String.valueOf(company.id))
        .name(company.name)
        .description(company.description)
        .contactEmail(company.contactEmail)
        .contactPhone(company.contactPhone)
        .build();
  }

  static Company toEntity(CompanyDto companyDto) {
    return Company.builder()
        .contactEmail(companyDto.contactEmail())
        .contactPhone(companyDto.contactPhone())
        .name(companyDto.name())
        .description(companyDto.description())
        .build();
  }
}
