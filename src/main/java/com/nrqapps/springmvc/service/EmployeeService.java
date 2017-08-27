package com.nrqapps.springmvc.service;

import com.nrqapps.springmvc.dao.EmployeeDao;
import com.nrqapps.springmvc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mauricio on 8/21/17.
 * NrqApps © 2017
 */
@Service("employeeService")
@Transactional
public class EmployeeService implements Serializable {
    private EmployeeDao employeeDao;

    public Employee findOne(Integer employeeId) {
        return employeeDao.findOne(employeeId);
    }

    public List findAll() {
        return employeeDao.findAll();
    }

    public void saveOrUpdate (Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    public void delete (Integer employeeId) {
        employeeDao.delete(findOne(employeeId));
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
