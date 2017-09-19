package com.stuq.jacoco.service;

import com.stuq.jacoco.CarEngineFactory;
import com.stuq.jacoco.model.BenzC;
import com.stuq.jacoco.servlet.HelloHandler;
import com.stuq.jacoco.servlet.BenzCServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import util.ResourceConfig;

import java.util.Properties;
import java.util.logging.Logger;


public class TestBenzC {
        public static void main(String[] args) throws Exception
        {
            Properties systemProperties;
            ResourceConfig.initialize();
            Logger logger = Logger.getLogger(TestBenzC.class.getName());

            CarEngineFactory cef = new CarEngineFactory();
            BenzC benzc = new BenzC(cef.createCarEngine("benz"));

            systemProperties = ResourceConfig.getSystemProperty();
            String port = systemProperties.getProperty("port");
            Server server = new Server(Integer.parseInt(port));

            // set up hello servlet
            ContextHandler hellocontext = new ContextHandler("/");
            hellocontext.setHandler(new HelloHandler("Hello!"));

            // set up benzc servlet
            ServletContextHandler benzccontext = new ServletContextHandler();
            benzccontext.setContextPath("/BenzC");
            BenzCServlet benzCServlet = new BenzCServlet(benzc);
            ServletHolder benzcHolder = new ServletHolder(benzCServlet);
            benzccontext.addServlet(benzcHolder, "/*");

            ContextHandlerCollection contexts = new ContextHandlerCollection();
            contexts.setHandlers(new Handler[] {benzccontext, hellocontext});
            server.setHandler(contexts);

            server.start();

            logger.info("Server Started!");

//            server.stop();

            server.join();
            logger.info("Server Stopped!");
        }
}
