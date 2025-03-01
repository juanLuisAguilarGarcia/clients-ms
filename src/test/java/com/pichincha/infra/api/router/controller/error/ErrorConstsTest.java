package com.pichincha.infra.api.router.controller.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 class ErrorConstsTest {

    @Test
    void validValues(){
        assertEquals("404",ErrorConsts.ERROR_CODE_404);
    }

}
