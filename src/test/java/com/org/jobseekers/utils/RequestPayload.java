package com.org.jobseekers.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestPayload {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

}
