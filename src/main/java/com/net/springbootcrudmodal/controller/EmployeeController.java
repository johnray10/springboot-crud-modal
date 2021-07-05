package com.net.springbootcrudmodal.controller;

import com.net.springbootcrudmodal.model.Employee;
import com.net.springbootcrudmodal.model.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //Get All Employees
    @GetMapping("/employees")
    public String findAll(Model model){
        model.addAttribute("employees",employeeService.getEmployees());
        return "index";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id) {
        return employeeService.findById(id);
    }

    //Add
    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
