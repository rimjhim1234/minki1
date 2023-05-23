package com.ankita;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.client.ProjectScopedApiRoot;
import com.commercetools.api.models.common.AddressDraft;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerBuilder;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class CustomerService {

    @Autowired
    ProjectApiRoot apiRoot;
    @Autowired
    CustomerDataProvider cdp;
    public Customer createcustomer(CustomerData customerData) {
        AddressDraft addressDraft=AddressDraft.builder()
                .streetName(CustomerDraft.builder().getCompanyName())
                .build();
        CustomerDraft customerDraft= CustomerDraft
                .builder()
                .firstName(customerData.getFirstname())
                .lastName(customerData.getLastname())
                .password(customerData.getPassword())
                .email(customerData.getEmail())
                .addresses(addressDraft)
                .custom(customFieldsDraftBuilder -> customFieldsDraftBuilder)
                .key(customerData.getFirstname())
                .build();
      return cdp.createcustomer(customerDraft);//when(cdp.createcustomer(customerDraft)).thenreturn(customer)   Customer customer=new Customer();
    }
    public Customer updatecustomer(CustomerData customerData) {
        CustomerDraft customerDraft=CustomerDraft
                .builder()
                .firstName(customerData.getFirstname())
                .email(customerData.getEmail())
                .build();
        return cdp.updatecustomer(customerDraft);
    }
//  public CustomerPagedQueryResponse getallcustomer() {
//      CustomerPagedQueryResponse response = apiRoot.customers().get().executeBlocking().getBody();
//      return response;
//  }
}
