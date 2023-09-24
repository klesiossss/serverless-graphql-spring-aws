package com.serverless.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {
    private Long id;
    private String name;
    private String email;
}
