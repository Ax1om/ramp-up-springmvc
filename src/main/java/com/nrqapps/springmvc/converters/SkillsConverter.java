package com.nrqapps.springmvc.converters;

import com.nrqapps.springmvc.models.Skill;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
public class SkillsConverter implements Converter<String, List<Skill>> {

    @Override
    public List<Skill> convert(String skillsIds) {
        if(!StringUtils.isEmpty(skillsIds)) {
            String[] skillsIdsArray =   skillsIds.split(",");
            List<Skill> skills = new ArrayList<>();
            for (String skillId : skillsIdsArray) {
                Skill skill = new Skill();
                skill.setSkillId(Integer.parseInt(skillId));
                skills.add(skill);
            }
            if(skills.size() > 0) {
                return skills;
            }
        }
        return null;
    }
}
