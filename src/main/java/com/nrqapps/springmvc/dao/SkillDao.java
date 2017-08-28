package com.nrqapps.springmvc.dao;

import com.nrqapps.springmvc.models.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
@Repository("skillDao")
public class SkillDao extends AbstractDao<Integer, Skill> {

    public List findAllIn(List skillIdList) {
        getCriteriaQuery()
            .select(getRootEntity());

        Expression<String> expression = getRootEntity().get("skillId");
        Predicate predicate = expression.in(skillIdList);

        getCriteriaQuery()
            .where(predicate);

        return getSession().createQuery(getCriteriaQuery()).getResultList();
    }
}
