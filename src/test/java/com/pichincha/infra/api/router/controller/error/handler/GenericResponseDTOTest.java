package com.pichincha.infra.api.router.controller.error.handler;

import com.pichincha.infra.api.router.controller.dto.GenericResponseDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GenericResponseDTOTest {

    private String code;
    private String message;

    @Before
    public void init(){
        code = "404";
        message = "error";
    }

    @Test
    public void contructorConArgumentos(){
        GenericResponseDTO error = new GenericResponseDTO(code,message);

        assertNotNull(error);
        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }

    @Test
    public void contructorSinArgumentos(){
        GenericResponseDTO error = new GenericResponseDTO();
        error.setCode(code);
        error.setMessage(message);
        assertNotNull(error);
        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }
}
