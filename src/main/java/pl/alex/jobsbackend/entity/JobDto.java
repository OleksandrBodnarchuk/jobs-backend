package pl.alex.jobsbackend.entity;

import lombok.Builder;

@Builder(toBuilder = true)
public record JobDto(String id,
                     String title,
                     String type,
                     String description,
                     String location,
                     String salary,
                     CompanyDto company) {

}
