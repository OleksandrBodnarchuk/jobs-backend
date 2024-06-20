package pl.alex.jobsbackend.entity;

import lombok.Builder;

@Builder(toBuilder = true)
public record CompanyDto(String id,
                         String name,
                         String description,
                         String contactEmail,
                         String contactPhone) {

}
