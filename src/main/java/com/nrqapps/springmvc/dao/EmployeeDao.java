package com.nrqapps.springmvc.dao;

import com.nrqapps.springmvc.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mauricio on 8/21/17.
 * NrqApps © 2017
 */
@Repository("employeeDao")
public class EmployeeDao extends AbstractDao<Integer, Employee> {
    public List findByQuery(String query) {

        getCriteriaQuery()
                .select(getRootEntity());

        String param = "%" + query + "%";
        getCriteriaQuery()
                .where(
                        getCriteriaBuilder().or(
                                getCriteriaBuilder().like(getRootEntity().<String>get("name"), param),
                                getCriteriaBuilder().like(getRootEntity().<String>get("surname"), param),
                                getCriteriaBuilder().like(getRootEntity().<String>get("country"), param)
                        )
                );

        return getSession().createQuery(getCriteriaQuery()).getResultList();
    }
}
