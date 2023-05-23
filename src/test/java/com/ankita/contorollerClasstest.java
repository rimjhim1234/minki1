package com.ankita;


import com.commercetools.api.client.*;
import com.commercetools.api.models.customer.*;
import io.vrap.rmf.base.client.ApiHttpClient;
import io.vrap.rmf.base.client.ApiHttpResponse;
import io.vrap.rmf.base.client.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;

@ContextConfiguration(classes = {contorollerClasstest.class})
@ExtendWith(MockitoExtension.class)
public class contorollerClasstest {
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;
    @Mock
    ProjectApiRoot apiRoot;

    @Test
    void CreatecustomerTest() {
        CustomerData customerDat = new CustomerData();
        Customer customer = Customer.builder().email("fmansd@gmial.com")
                .id("mnfdajks").password("aCCDsdnjkg")
                .buildUnchecked();
        Mockito.when(customerService.createcustomer(any())).thenReturn(customer);
        Customer createcustomer = customerController.createcustomer(customerDat);
        Assertions.assertEquals(createcustomer.getEmail(), "fmansd@gmial.com");
    }
    @Test
    void getallcustomer() {
        CustomerPagedQueryResponse response=CustomerPagedQueryResponse.builder()
                .results(
                         CustomerBuilder
                                .of()
                                .id("789")
                                .email("aaki12@gmail.com")
                                .buildUnchecked()
                )
                .buildUnchecked();

        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder= Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
        Mockito.when(apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        ByProjectKeyCustomersGet byProjectKeyCustomersGet=Mockito.mock(ByProjectKeyCustomersGet.class);
        Mockito.when(apiRoot.customers().get()).thenReturn(byProjectKeyCustomersGet);

        ApiHttpResponse<CustomerPagedQueryResponse> apiHttpResponse =Mockito.mock(ApiHttpResponse.class);
        Mockito.when(byProjectKeyCustomersGet.executeBlocking()).thenReturn(apiHttpResponse);

//        CustomerPagedQueryResponse pagedQueryResponse = Mockito.mock(CustomerPagedQueryResponse.class);
        Mockito.when(apiHttpResponse.getBody()).thenReturn(response);

//        CustomerDraft customerDraft = new CustomerDraftImpl();
//        customerDraft.setEmail(response.getEmail());

        CustomerPagedQueryResponse getallcustomer=customerController.getallcustomer();
        Assertions.assertEquals("aaki12@gmail.com",getallcustomer.getResults().get(0).getEmail());
    }
}




