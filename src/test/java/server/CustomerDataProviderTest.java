package server;

import com.ankita.CustomerData;
import com.ankita.CustomerDataProvider;
import com.ankita.CustomerService;
import com.commercetools.api.client.ApiRoot;
import com.commercetools.api.client.ByProjectKeyCustomersPost;
import com.commercetools.api.client.ByProjectKeyCustomersRequestBuilder;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import io.vrap.rmf.base.client.ApiHttpHeaders;
import io.vrap.rmf.base.client.ApiHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CustomerDataProviderTest.class})
@ExtendWith(MockitoExtension.class)
public class CustomerDataProviderTest {
    @Autowired
    MockMvc mockMvc;
    @Mock
    private ProjectApiRoot apiRoot;
    @InjectMocks
    private CustomerDataProvider customerDataProvider;

    @Test
    void createcustomer() {
        Customer customer= CustomerBuilder
                .of()
                .email("akriti26@gmail.com")
                .firstName("akki")
                .buildUnchecked();

        ByProjectKeyCustomersRequestBuilder byProjectKeyCustomersRequestBuilder= Mockito.mock(ByProjectKeyCustomersRequestBuilder.class);
        Mockito.when(apiRoot.customers()).thenReturn(byProjectKeyCustomersRequestBuilder);

        ByProjectKeyCustomersPost mockPost = Mockito.mock(ByProjectKeyCustomersPost.class);
        Mockito.when(apiRoot.customers().post(any(CustomerDraft.class))).thenReturn(mockPost);

        ApiHttpResponse<CustomerSignInResult> mockResponse =Mockito.mock(ApiHttpResponse.class);
        Mockito.when(mockPost.executeBlocking()).thenReturn(mockResponse);

        CustomerSignInResult mockResult = Mockito.mock(CustomerSignInResult.class);
        Mockito.when(mockResponse.getBody()).thenReturn(mockResult);
        Mockito.when(mockResult.getCustomer()).thenReturn(customer);

        CustomerDraft customerDraft = new CustomerDraftImpl();
        customerDraft.setEmail(customer.getEmail());

        Customer actualCustomer = customerDataProvider.createcustomer(customerDraft);
        Assertions.assertEquals("akriti26@gmail.com",actualCustomer.getEmail());

    }
    @Test
    void getallcustomer() {

    }
}


