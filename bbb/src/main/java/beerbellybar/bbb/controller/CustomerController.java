package beerbellybar.bbb.controller;


import beerbellybar.bbb.business.service.CustomerService;
import beerbellybar.bbb.data.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String getLoginView() {
        return "";
    }

    @GetMapping("/user/register")
    public String getRegisterView() {
        return "sign-up.html";
    }

    @PostMapping("/user/register")
    public ResponseEntity<Void> postRegister(@RequestBody Customer customer) {
        try {
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile")
    public  @ResponseBody Customer getProfile() {
        return customerService.getCurrentCustomer();
    }

    @GetMapping("/profile/edit")
    public String getProfileView() {
        return "cus-edit-profile.html";
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> putProfile(@RequestBody Customer customer) {
        try {
            customer.setId(customerService.getCurrentCustomer().getId());
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}