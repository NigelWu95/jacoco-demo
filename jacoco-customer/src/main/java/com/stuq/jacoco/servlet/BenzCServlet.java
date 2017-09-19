package com.stuq.jacoco.servlet;

import com.stuq.jacoco.model.BenzC;
import util.Tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by guoqing on 19/7/17.
 */
public class BenzCServlet extends HttpServlet {
    private BenzC benzc;
    private static final Logger logger = Logger.getLogger(BenzCServlet.class.getName());

    public BenzCServlet(BenzC benzc){
        this.benzc = benzc;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action;
        String reaction;
        logger.log(Level.INFO,"Incoming request: %s",
                request.getRequestURI() + "?"+ request.getQueryString());

        if(!request.getParameterNames().hasMoreElements())
        {
            reaction = "Welcome to BenzC!";
        }
        else
        {
            action = request.getParameter("action");

            if ("music".equalsIgnoreCase(action)) {
                String cmd = request.getParameter("cmd");
                if(cmd==null) {
                    reaction = "Usage: /BenzC?action=start&cmd=on/off";
                }
                else
                    reaction = benzc.music(cmd);
            }
            else if ("fly".equalsIgnoreCase(action)) {
                    reaction = benzc.fly();
            }
            else if ("help".equalsIgnoreCase(action)) {
                reaction = "Welcome to BenzC Service!\n\n";
                reaction += "Usage: http://<ipaddr>:<port>/BenzC?action=<operations>\n\n";
                reaction += "Operations could be one of the following:\n\n";
                reaction += "help, start, stop, brake.\n\n";
            } else if ("start".equalsIgnoreCase(action)) {
                reaction = benzc.start();
            } else if ("stop".equalsIgnoreCase(action)) {
                reaction = benzc.stop();
            } else if ("brake".equalsIgnoreCase(action)) {
                reaction = benzc.brake();
            } else if ("acc".equalsIgnoreCase(action)) {
                reaction = benzc.acc();
            } else
                reaction = "No such an operation designed!";
        }
        sendMyResultResponse(response, reaction);
    }

    private void sendMyResultResponse(HttpServletResponse response,
                                      Object results) {
        Tools.printToJson(results.toString(), response);
        logger.log(Level.INFO, "The response is \"%s\"", results.toString());
    }

}