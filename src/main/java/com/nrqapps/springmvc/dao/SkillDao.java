package com.nrqapps.springmvc.dao;

import com.nrqapps.springmvc.models.Skill;
import org.springframework.stereotype.Repository;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
@Repository("skillDao")
public class SkillDao extends AbstractDao<Integer, Skill> {

}
