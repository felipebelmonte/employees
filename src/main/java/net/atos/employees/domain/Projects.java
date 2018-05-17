package net.atos.employees.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Projects {

    @JsonProperty("name")
    private String name;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("valueOfProject")
    private String valueOfProject;
    @JsonProperty("dtBegin")
    private ZonedDateTime dtBegin;
    @JsonProperty("dtEnd")
    private ZonedDateTime dtEnd;

    public Projects() {
    }
}
