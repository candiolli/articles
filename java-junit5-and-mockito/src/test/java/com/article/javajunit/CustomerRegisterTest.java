package com.article.javajunit;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerRegisterTest {

    @Spy
    @InjectMocks
    private CustomerRegister customerRegister;

    @Mock
    private CustomerRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register a new customer with success")
    @Tag("customer-register")
    public void register_success() throws InvalidValueException {
        Customer objectSaved = new Customer("23122100100", "Silas", 123456L);

        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);
        when(repository.save(any(Customer.class))).thenReturn(objectSaved);

        CustomerVO vo = new CustomerVO("23122100100", "Silas", 123456L);

        CustomerVO register = customerRegister.register(vo);
        assertEquals(objectSaved.getId(), register.getId());
        verify(customerRegister).register(vo);
    }

    @DisplayName("Should register a new customer with success")
    @Test
    public void register_success_verify() throws InvalidValueException {
        CustomerRegister customerRegister2 = mock(CustomerRegister.class);

        CustomerVO vo = new CustomerVO("33408777004", "Silas", 123456L);

        customerRegister2.register(vo);

        verify(customerRegister2, times(1)).register(vo);
        verifyNoMoreInteractions(customerRegister2);
    }

    @Test
    public void validate_cpf_success() {
        customerRegister = mock(CustomerRegister.class);
        when(customerRegister.validateRealCpf(anyString())).thenReturn(true);
        Assert.assertTrue(customerRegister.validateRealCpf("8888"));
    }

    @Test
    public void shouldReturnFalseToInvalidateCpf() {
        customerRegister = mock(CustomerRegister.class);
        when(customerRegister.validateRealCpf(anyString())).thenCallRealMethod();
        Assert.assertFalse(customerRegister.validateRealCpf("8888"));
    }
}