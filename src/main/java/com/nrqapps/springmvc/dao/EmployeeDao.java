package com.nrqapps.springmvc.dao;

import com.nrqapps.springmvc.models.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by mauricio on 8/21/17.
 * NrqApps © 2017
 */
@Repository("employeeDao")
public class EmployeeDao extends AbstractDao<Integer, Employee> {

}
