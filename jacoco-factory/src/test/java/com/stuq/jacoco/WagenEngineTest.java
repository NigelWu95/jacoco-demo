package com.stuq.jacoco;

import com.stuq.jacoco.WagenEngine;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by guoqing on 12/7/17.
 */
public class WagenEngineTest {
    WagenEngine wagen = new WagenEngine();

    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testStartWagen() {
        assertEquals("Start WagenEngine!", wagen.start());
    }

    @Test
    public void testStopWagen() {
        assertEquals("Stop WagenEngine!", wagen.stop());
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

