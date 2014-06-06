package com.ladr.myapplvl11.app;

import android.widget.TextView;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by lychak_vv on 06.06.14.
 */
public class Light extends SystemOutView {
    private boolean state = false;

    //http://wikijava.org.ua/index.php?title=%D0%93%D0%BB%D0%B0%D0%B2%D0%B0_1_Thinking_in_Java_4th_edition
    public Light(TextView outTextView)
    {
        super(outTextView);

        state = false;
        println("The light created.");
    }

    public String toString(){
        return state?"on":"off";
    }

    public Light on(){
        state = true;
        println("The light is switched on.");
        return this;
    }

    public Light printState(){
        println("The light is " + this.toString() + ".");
        return this;
    }

    public Light off(){
        state = false;
        println("The light is switched off.");
        return this;
    }

    public void brighten(){

    }

    public void dim(){

    }

    public void println(String text){
        System.out.println(text);
    }

    public void print(String text){
        System.out.print(text);
    }
}
