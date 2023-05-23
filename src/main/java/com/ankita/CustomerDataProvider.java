package com.ankita;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


@Component
public class CustomerDataProvider {
    @Autowired
    ProjectApiRoot apiRoot;
    public Customer createcustomer(CustomerDraft customerDraft) {
        return apiRoot.customers().post(customerDraft).executeBlocking().getBody().getCustomer();
    }
    public Customer updatecustomer(CustomerDraft customerDraft) {
        return apiRoot.customers().post(customerDraft).executeBlocking().getBody().getCustomer();
    }
    public Customer getallcustomer(String id) {
        return apiRoot.customers().withId(id).get().executeBlocking().getBody();
    }
}

