package com.stuq.jacoco.model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by guoqing on 12/7/17.
 */
public class BenzSTest {

    // factory+ioc/di
//    Factory cef = mock(Factory.class);
//    CarEngine ce = mock(CarEngine.class);
//    BenzC benzc = new BenzC(cef);
    BenzS bens = new BenzS();


    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testStartBenzS() {
        assertEquals("Benzs Start BenzEngine!",bens.start());
    }

    @Test
    public void testStopBenzS() {
        assertEquals("Benzs Stop BenzEngine!",bens.stop());
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

