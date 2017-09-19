package com.stuq.jacoco.model;

//import Factory;
import com.stuq.jacoco.CarEngine;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by guoqing on 12/7/17.
 */
public class BenzCTest {

    // factory+ioc/di
    CarEngine ce = mock(CarEngine.class);
    BenzC benzc = new BenzC(ce);
//    BenzC benzc = new BenzC();


    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testStartBenzCMock() {
        when(ce.start()).thenReturn("Start BenzEngine!");

        assertEquals("Start BenzEngine!",ce.start());
        assertEquals("Benzc Start BenzEngine!", benzc.start());
    }

    @Test
    public void testStopBenzCMock() {
        when(ce.stop()).thenReturn("Stop BenzEngine!");

        assertEquals("Stop BenzEngine!",ce.stop());
        assertEquals("Benzc Stop BenzEngine!", benzc.stop());
    }

    @Test
    public void testBrakeBenzC() {
        when(ce.stop()).thenReturn("Stop BenzEngine!");
        benzc.stop();
        assertEquals("Benzc not started!",benzc.brake());

        when(ce.start()).thenReturn("Start BenzEngine!");
        benzc.start();
        assertEquals("Benzc braked!",benzc.brake());
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

