package com.nrqapps.springmvc.controllers;

import com.nrqapps.springmvc.models.Employee;
import com.nrqapps.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mauricio on 8/21/17.
 * NrqApps © 2017
 */
@Controller
public class CrudController {

    private EmployeeService employeeService;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        modelMap.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @RequestMapping(value = "/upsert", method = RequestMethod.GET)
    public String loadUpsertPage(ModelMap modelMap, @RequestParam( required = false) Integer employeeId) {
        Employee employee = new Employee();
        if( employeeId != null ) {
            employee = employeeService.findOne(employeeId);
        }
        modelMap.addAttribute("employee", employee);
        return "upsert";
    }

    @RequestMapping(value = "upsert", method = RequestMethod.POST)
    public String upsertEmployee(@ModelAttribute Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam Integer employeeId) {
        employeeService.delete(employeeId);
        return "redirect:/";
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
