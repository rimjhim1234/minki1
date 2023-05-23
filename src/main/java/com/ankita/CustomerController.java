package com.ankita;


import com.commercetools.api.client.ApiRoot;
import com.commercetools.api.client.ByProjectKeyInBusinessUnitKeyByBusinessUnitKeyMeRequestBuilder;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CustomerController {
    @Autowired
    ProjectApiRoot apiRoot;
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public Customer createcustomer(CustomerData customerData) {
        return customerService.createcustomer(customerData);
    }
    @GetMapping("/allcustomer")
    public CustomerPagedQueryResponse getallcustomer() {
        return apiRoot
                .customers()
                .get()
                .executeBlocking()
                .getBody();

    }
    @PostMapping("/update")
    public Customer updatecustomer(CustomerData customerData) {
        return customerService.updatecustomer(customerData);
    }
}
