package com.pichincha.domain.service;

import com.pichincha.ClientsApplication;
import com.pichincha.app.ClientsService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientsApplication.class)
public class ClientsServiceTest {

    @Autowired
    private ClientsService clientsService;



    @Before
    public void init(){

    }


}
