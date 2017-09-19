package com.stuq.jacoco;

import com.stuq.jacoco.BenzEngine;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by guoqing on 12/7/17.
 */
public class BenzEngineTest {
    BenzEngine benz = new BenzEngine();

    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testStartBenz() {
        assertEquals("Start BenzEngine!", benz.start());
    }

    @Test
    public void testStopBenz() {
        assertEquals("Stop BenzEngine!", benz.stop());
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

