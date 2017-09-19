package com.stuq.jacoco.servlet;

import com.stuq.jacoco.model.BenzC;
import org.junit.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by guoqing on 20/7/17.
 */
public class BenzCServletTest {

    BenzC benzc = mock(BenzC.class);

    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    @BeforeClass
    public static void initAll() throws Exception {
    }

    @Before
    public void init() {
    }

    @Test
    public void testBenzCRoot() throws ServletException, IOException {
        BenzCServlet bs = new BenzCServlet(benzc);
        bs.doGet(request, response);
        assertEquals(200, response.getStatus());
        assertEquals("Welcome to BenzC!", response.getContentAsString());
    }

    @Test
    public void testBenzCStart() throws Exception {
        request.setParameter("action","start");
        when(benzc.start()).thenReturn("Benzc Start BenzEngine!");
        BenzCServlet bs = new BenzCServlet(benzc);

        bs.doGet(request, response);
        assertEquals(200, response.getStatus());
        assertEquals("Benzc Start BenzEngine!", response.getContentAsString());
    }

    @Test
    public void testBenzCStop() throws Exception {
        request.setParameter("action","stop");
        when(benzc.stop()).thenReturn("Benzc Stop BenzEngine!");
        BenzCServlet bs = new BenzCServlet(benzc);

        bs.doGet(request, response);
        assertEquals(200, response.getStatus());
        assertEquals("Benzc Stop BenzEngine!", response.getContentAsString());
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() {
    }
}

