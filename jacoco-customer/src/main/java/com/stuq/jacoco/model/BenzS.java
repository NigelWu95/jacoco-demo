package com.stuq.jacoco.model;

import com.stuq.jacoco.CarEngine;
import com.stuq.jacoco.CarEngineFactory;

/**
 * Created by guoqing on 13/7/17.
 */
public class BenzS {

    //factory
    private CarEngine ce;
    CarEngineFactory cef = new CarEngineFactory();//what if this is not implemented!!!??

    public BenzS(){
        this.ce = cef.createCarEngine("benz");
    }

    public String start(){
        return "Benzs "+ce.start();
    }

    public String stop(){
        return "Benzs "+ce.stop();
    }

}
