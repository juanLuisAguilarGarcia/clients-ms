package com.pichincha.infra.api.router.facade;

import com.pichincha.ClientsApplication;
import com.pichincha.app.ClientsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientsApplication.class)
public class ClientsFacadeTest {

    @Autowired
    private ClientsFacade clientsFacade;

    @MockBean
    private ClientsService clientsService;

}
