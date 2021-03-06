package com.nrqapps.springmvc.service;

import com.nrqapps.springmvc.dao.MaritalStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
@Service("maritalStatusService")
@Transactional
public class MaritalStatusService implements Serializable {
    private MaritalStatusDao maritalStatusDao;

    public List findAll() {
        return maritalStatusDao.findAll();
    }

    @Autowired
    public void setMaritalStatusDao(MaritalStatusDao maritalStatusDao) {
        this.maritalStatusDao = maritalStatusDao;
    }
}
