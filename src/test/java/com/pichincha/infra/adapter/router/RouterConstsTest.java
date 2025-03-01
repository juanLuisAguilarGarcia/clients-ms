package com.pichincha.infra.adapter.router;

import com.pichincha.infra.api.router.RouterConsts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouterConstsTest {
    @Test
    void validValues(){
        assertEquals("com.mercadolibre", RouterConsts.COMPONENT_SCAN);
    }

}
