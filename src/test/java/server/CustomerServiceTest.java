package server;

import com.ankita.CustomerDataProvider;
import com.ankita.CustomerService;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerDataProvider cdp;
    //object ban gya like normal  new CustomerDataProvider by @Mock
    @InjectMocks
    CustomerService customerService;
    @Test
    void createcustomertest() {
        Customer customer = CustomerBuilder.of().email("djjh")
                .firstName("cfdgfdhcfhg").buildUnchecked();

        OngoingStubbing<Customer> na = Mockito.when(cdp.createcustomer(any())).thenReturn(customer);

        String aj= cdp.createcustomer(any()).getEmail();
        String hsdj= cdp.createcustomer(any()).getFirstName();
        Assertions.assertEquals("djjh",cdp.createcustomer(any()).getEmail());
        Assertions.assertEquals("cfdgfdhcfhg",cdp.createcustomer(any()).getFirstName());
    }
    @Test
    void getallcustomer() {
    Customer customer=CustomerBuilder.of().id("djjh").buildUnchecked();
        OngoingStubbing<Customer> ap = Mockito.when(cdp.getallcustomer(any())).thenReturn(customer);
        String jhkj= cdp.getallcustomer(any()).getId();
        Assertions.assertEquals("djjh",cdp.getallcustomer(any()).getId());
    }
}


