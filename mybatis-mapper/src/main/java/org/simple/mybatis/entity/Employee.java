package org.simple.mybatis.entity;

import lombok.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
public class Employee {

    private String id;

    private String name;

    private String gender;

    private String email;

    private Integer dId;

    private Department department;

    public Employee() {
    }

    public Employee(String id, String name, String gender, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public Employee(@Param("id") String id, @Param("name") String name, @Param("gender") String gender, @Param("email") String email, @Param("dId") Integer dId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dId=dId;
    }

    public Employee(String id, String name, String gender, String email, Integer dId, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
        this.department = department;
    }
}
