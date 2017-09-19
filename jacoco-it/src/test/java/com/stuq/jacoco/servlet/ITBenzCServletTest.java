package com.stuq.jacoco.servlet;

import com.stuq.jacoco.CarEngineFactory;
import com.stuq.jacoco.model.BenzC;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.*;
import util.HttpUtil;
import util.ResourceConfig;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Created by guoqing on 20/7/17.
 */
public class ITBenzCServletTest {
    static CloseableHttpClient httpClient;
    static String host;
    static Server server;

    @BeforeClass
    public static void initAll() throws Exception {
        httpClient = HttpClients.createDefault();
        host="localhost:8080";

        Properties systemProperties = new Properties();
        ResourceConfig.initialize();

        CarEngineFactory cef = new CarEngineFactory();
        BenzC benzc = new BenzC(cef.createCarEngine("benz"));

        systemProperties = ResourceConfig.getSystemProperty();
        String port = systemProperties.getProperty("port");
        server = new Server(Integer.parseInt(port));

        ContextHandler hellocontext = new ContextHandler("/");
        hellocontext.setHandler(new HelloHandler("Hello!"));

        ServletContextHandler benzccontext = new ServletContextHandler();
        benzccontext.setContextPath("/BenzC");
        BenzCServlet benzCServlet = new BenzCServlet(benzc);
        ServletHolder benzcHolder = new ServletHolder(benzCServlet);
        benzccontext.addServlet(benzcHolder, "/*");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {benzccontext, hellocontext});
        server.setHandler(contexts);

        server.start();

    }

    @Before
    public void init() {
    }

    @Test
    public void testBenzCRoot() throws ServletException, IOException {
        HttpGet httpGetRequest = new HttpGet("http://"+host+"/BenzC/");
        HttpResponse httpResponse = httpClient.execute(httpGetRequest);

        assertEquals(200,httpResponse.getStatusLine().getStatusCode());
        assertEquals("Welcome to BenzC!", HttpUtil.getChunk(httpResponse.getEntity()));
    }

    @Test
    public void testBenzCStart() throws Exception {
        HttpGet httpGetRequest = new HttpGet("http://"+host+"/BenzC/?action=start");
        HttpResponse httpResponse = httpClient.execute(httpGetRequest);

        assertEquals("Benzc Start BenzEngine!", HttpUtil.getChunk(httpResponse.getEntity()));
    }

    @Test
    public void testBenzCStop() throws Exception {
        HttpGet httpGetRequest = new HttpGet("http://"+host+"/BenzC/?action=stop");

        HttpResponse httpResponse = httpClient.execute(httpGetRequest);

        assertEquals("Benzc Stop BenzEngine!", HttpUtil.getChunk(httpResponse.getEntity()));
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAll() throws Exception {
        server.stop();
        httpClient.close();
    }
}

