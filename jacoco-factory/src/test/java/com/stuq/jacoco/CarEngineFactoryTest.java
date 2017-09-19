package com.stuq.jacoco;

import com.stuq.jacoco.BenzEngine;
import com.stuq.jacoco.CarEngine;
import com.stuq.jacoco.CarEngineFactory;
import com.stuq.jacoco.WagenEngine;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by guoqing on 12/7/17.
 */
public class CarEngineFactoryTest {
    CarEngineFactory cef = new CarEngineFactory();

    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testCreateBenz() {
        CarEngine ce = cef.createCarEngine("benz");

        assertTrue(ce instanceof BenzEngine);
    }

    @Test
    public void testCreateWagen() {
        CarEngine ce = cef.createCarEngine("wagen");

        assertTrue(ce instanceof WagenEngine);
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

