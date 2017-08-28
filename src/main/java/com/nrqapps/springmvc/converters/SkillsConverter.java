package com.nrqapps.springmvc.converters;

import com.nrqapps.springmvc.models.Skill;
import com.nrqapps.springmvc.service.SkillService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mauricio Enriquez on 8/21/17.
 * NrqApps © 2017
 */
public class SkillsConverter implements Converter<String, List<Skill>> {

    private SkillService skillService;

    public SkillsConverter(SkillService skillService) {
        this.skillService = skillService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Skill> convert(String skillsIds) {
        if(!StringUtils.isEmpty(skillsIds)) {
            String[] skillsIdsArray =   skillsIds.split(",");
            List skillsIdList = new ArrayList<>();
            skillsIdList.addAll(Arrays.asList(skillsIdsArray));
            if(skillsIdList.size() > 0) {
                return (List<Skill>) skillService.findAllIn(skillsIdList);
            }
        }
        return null;
    }
}
