package com.ankita;


import com.commercetools.api.models.common.BaseAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {

    public String firstname;
    public String lastname;
    public String password;
    public String email;
    public String id;
    public  String key;
    public List<BaseAddress> addresses;
    public String streetName;

    public List<Integer> shippingAddresses;


}
