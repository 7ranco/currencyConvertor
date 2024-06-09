package alurachallenge.currencyConver.Models;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private float firstValue;
    private float seconValue;
    private float res;

    public Converter(float firstValue, float seconValue) {
        this.firstValue = firstValue;
        this.seconValue = seconValue;
    }

    public void operation(){
       this.res = this.firstValue * this.seconValue;
    }

    public String drawHistory(String firstName, String secondName){
        return "{" +
                firstName + ":" + this.firstValue + "," +
                secondName + ":" + this.seconValue + "," +
                "resultado("+ secondName +"):" + this.res +
                "}";
    }
}
