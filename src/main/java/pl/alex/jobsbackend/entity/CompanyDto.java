package pl.alex.jobsbackend.entity;

import lombok.Builder;

@Builder
public record CompanyDto(String id,
                         String name,
                         String description,
                         String contactEmail,
                         String contactPhone) {

}
