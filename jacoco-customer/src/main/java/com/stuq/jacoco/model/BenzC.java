package com.stuq.jacoco.model;

import com.stuq.jacoco.CarEngine;

/**
 * Created by guoqing on 13/7/17.
 */
public class BenzC {

    //ioc/di
    private CarEngine ce;

    boolean isStarted=false;

    public BenzC(CarEngine ce){
        this.ce = ce;
    }

    public String start(){
        this.setStarted(true);
        return "Benzc "+ce.start();
    }

    public String stop(){
        this.setStarted(false);
        return "Benzc "+ce.stop();
    }

    public String brake(){
        if(!isStarted)
            return "Benzc not started!";
        else
            return "Benzc braked!";
    }

    private void setStarted(boolean isStarted){
        this.isStarted = isStarted;
    }

    public String music(String cmd) {
        if("on".equalsIgnoreCase(cmd))
            return "Benzc music on!";
        else if("off".equalsIgnoreCase(cmd))
            return "Benzc music off!";
        else
            return "Invalid command for music!";
    }

    public String acc() {
        if(!isStarted)
            return "Benzc not started!";
        else
            return "Benzc accelerated!";
    }

    public String fly() {
        String response = "Are U Insane?! Anyway, cars donot fly!!";
        return response;
    }

    public String random() {
        String response = "You are selected! Lucky Dog! Go and eat your food!";
        return response;
    }

    public String dance(String region) {
        String response = "Come and dance, baby from "+region+"!";
        return response;
    }
}
