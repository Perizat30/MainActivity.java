package com.example.lesson7;

import java.sql.SQLOutput;

public class Example {
    int number;

    public void main(){
        onFiveClick();
        onSixClick();
        onSevenClick();
        onNumberClick(9);
    }

    public void onNumberClick(int newNumber){

        number=newNumber;
        System.out.println(number);
    }

    public void onSevenClick(){
        number=7;
        System.out.println(number);
    }

    public void onSixClick(){
        number=6;
        System.out.println(number);
    }

    public void onFiveClick(){
        number=5;
        System.out.println(number);
    }

    public void onFourClick(){
        number=4;
        System.out.println(number);
    }

}
