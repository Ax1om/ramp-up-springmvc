package com.nrqapps.springmvc.service;

import com.nrqapps.springmvc.dao.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
@Service("skillService")
@Transactional
public class SkillService implements Serializable {
    private SkillDao skillDao;

    public List findAll() {
        return skillDao.findAll();
    }

    public List findAllIn(List skillIdList) {
        return skillDao.findAllIn(skillIdList);
    }

    @Autowired
    public void setSkillDao(SkillDao skillDao) {
        this.skillDao = skillDao;
    }
}
