package org.simple.mybatis.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    private Integer id;

    private String departmentName;

    private List<Employee> employeeList;

}
