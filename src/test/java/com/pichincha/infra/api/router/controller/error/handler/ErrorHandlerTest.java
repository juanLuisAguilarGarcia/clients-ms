package com.pichincha.infra.api.router.controller.error.handler;

import com.pichincha.infra.api.router.controller.ClientsController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.Assert.assertNotNull;

public class ErrorHandlerTest {
    private ErrorHandler errorHandler;
    private ClientsController clientsController;
    private DataBinder dataBinder;
    private WebRequest request;

    @Before
    public void init(){
        errorHandler = new ErrorHandler();
        clientsController = new ClientsController();
        dataBinder = new DataBinder(clientsController);
        request = Mockito.mock(WebRequest.class);
    }


}

