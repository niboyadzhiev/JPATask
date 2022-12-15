package com.homework.controllers;
import com.homework.model.Employee;
import com.homework.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller

public class EmpController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/viewemp")
    public String viewemp (Model m) {
        List<Employee> list = employeeService.listEmployees();
        m.addAttribute("list",list);
        return "viewemp";
    }


    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/viewemp";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView findContacts(@RequestParam("searchTerm") String searchTerm, ModelAndView model) throws IOException {
        List<Employee> list = employeeService.searchEmployees(searchTerm);
        model.addObject("list", list);
        model.addObject("searchTerm", searchTerm);
        model.setViewName("viewemp");
        return model;
    }

    @RequestMapping(value = "/editemp", method = RequestMethod.GET)
    public ModelAndView editEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("employee", employee);

        return model;
    }


    @RequestMapping(value = "/saveemp", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Employee employee) {
        ModelAndView model = new ModelAndView("redirect:/viewemp");
        employeeService.editEmployee(employee);
        return model;
    }












}






