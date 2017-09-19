package com.stuq.jacoco;

/**
 * Created by guoqing on 13/7/17.
 */
public class CarEngineFactory implements Factory {

    public CarEngine createCarEngine(String brand) {
        CarEngine ce= null;
        if("Benz".equalsIgnoreCase(brand)){
            ce = new BenzEngine();
        }
        else if("Wagen".equalsIgnoreCase(brand)){
            ce = new WagenEngine();
        }
        return ce;
    }
}
