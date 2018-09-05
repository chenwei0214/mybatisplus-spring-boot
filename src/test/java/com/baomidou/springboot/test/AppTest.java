package com.baomidou.springboot.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.weibaoer.Application;
import com.weibaoer.domain.Employee;
import com.weibaoer.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jobob on 17/5/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class AppTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getByIdTest() {
        Employee employee = employeeMapper.selectById(1l);
        System.out.println(employee.getUsername());
    }

    @Test
    public void updateTest(){
        Employee employee=new Employee();
        employee.setUsername("lisi");
        List<Long> ids=new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
        //批量更新，只更新设置的字段
        employeeMapper.update(employee, new EntityWrapper<Employee>().in("id",ids));
    }

    @Test
    public void createTest(){
        Employee employee=new Employee();
        employee.setUsername("wangwu");
        employee.setPhone("15825923418");
        employee.setEmail("749565238@qq.com");
        //插入后会返回id
        employeeMapper.insert(employee);
        System.out.println(employee.getId());
    }

    @Test
    public void selectPageTest(){

        Page<Employee> page=new Page<>();
        //设置每页最多返回条数默认为10
        page.setSize(2);
        //设置页码默认为0
        page.setCurrent(1);
        //填充数据
        page.setRecords(employeeMapper.selectList(page));
        //获取总记录数
        System.out.println("总记录数："+page.getTotal());
        //获取总页数
        System.out.println("总页数："+page.getPages());
        page.getRecords().forEach(target->{
            System.out.println("==================");
            System.out.println(target.getUsername());
        });
    }

}
