package com.weibaoer.service.impl;

import com.weibaoer.domain.Employee;
import com.weibaoer.mapper.EmployeeMapper;
import com.weibaoer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: chenwei
 * createDate: 18-9-5 下午2:38
 * description:
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Long id) {
        return employeeMapper.selectById(id);
    }
}
