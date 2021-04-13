package org.simple.mybatis.entity;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private String id;

    private String name;

    private String gender;

    private String email;
}
