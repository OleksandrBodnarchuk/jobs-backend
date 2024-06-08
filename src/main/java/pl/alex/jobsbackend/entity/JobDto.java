package pl.alex.jobsbackend.entity;

import lombok.Builder;

@Builder
public record JobDto(String id,
                     String title,
                     String type,
                     String description,
                     String location,
                     String salary,
                     CompanyDto companyDto) {

}
