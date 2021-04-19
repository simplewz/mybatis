package org.simple.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.simple.mybatis.entity.Department;

public interface DepartmentMapper {

    public Department selectById(@Param("id") Integer id);

    /**
     * 根据部门id查询部门信息(带关联员工信息)
     * @param id
     * @return
     */
    public Department selectByIdWithEmployeeList(@Param("id") Integer id);

}
