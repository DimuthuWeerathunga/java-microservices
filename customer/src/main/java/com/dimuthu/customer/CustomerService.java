package com.dimuthu.customer;

import com.dimuthu.clients.fraud.FraudCheckResponse;
import com.dimuthu.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check is email is valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fruadCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fruadCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
    }
}
