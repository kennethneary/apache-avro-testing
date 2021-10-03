package com.example.avro.made;

import lombok.Data;

@Data
public class EmployeeReal {

    private String name;
    private int id;
    private int salary;
    private int age;
    private String address;
    private Object any;
//    private Sample any;
}
