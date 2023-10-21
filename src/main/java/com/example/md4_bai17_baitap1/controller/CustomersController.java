package com.example.md4_bai17_baitap1.controller;

import com.example.md4_bai17_baitap1.model.Customers;
import com.example.md4_bai17_baitap1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public ModelAndView showAll(){
        return new ModelAndView("/list", "customers", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/create");
    }
    @PostMapping("/create")
    public ModelAndView saveCustomer(Customers customers){
        customerService.save(customers);
        return new ModelAndView("/create", "message","New customer created successfully");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Customers> optionalCustomers = customerService.findById(id);
        if(!optionalCustomers.isPresent()){
            return new ModelAndView("/error_404");
        }
            return new ModelAndView("/update", "customer", optionalCustomers);
    }
    @PostMapping("/update")
    public ModelAndView updateCustomer(Customers customers){
        customerService.save(customers);
        return new ModelAndView("redirect:/customers");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
        return new ModelAndView("redirect:/customers");
    }
}
