package com.weibaoer.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.weibaoer.domain.Employee;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee>{

    /**
     * 测试分页
     */
    List<Employee> selectList(Pagination page);

}
