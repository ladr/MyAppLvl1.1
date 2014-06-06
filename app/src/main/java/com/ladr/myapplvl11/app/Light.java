package com.ladr.myapplvl11.app;

import android.widget.TextView;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by lychak_vv on 06.06.14.
 */
public class Light implements IPrintable {
    private boolean state = false;
    private TextView buf = null;

    //http://wikijava.org.ua/index.php?title=%D0%93%D0%BB%D0%B0%D0%B2%D0%B0_1_Thinking_in_Java_4th_edition
    public Light(TextView buf)
    {
        state = false;
        initStream(buf);
        println("The light created.");
    }

    private void initStream(TextView buf){
        setPrintBuffer(buf);
        PrintStream origOut = System.out;
        PrintStream interceptor = new Interceptor(origOut);
        System.setOut(interceptor);
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
        println("The light is " + toString() + ".");
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

    public void setPrintBuffer(TextView buf)
    {
        this.buf = buf;
        buf.setText("");
    }

    public void println(String text){
        System.out.println(text);
        //buf.setText(buf.getText() + text + "\n");
    }

    public void print(String text){
        //System.out.print(text);
        //buf.setText(buf.getText() + text);
    }

    private class Interceptor extends PrintStream
    {
        public Interceptor(OutputStream out) {
            super(out, true);
        }
        @Override
        public void println(String s)
        {
            //super.print(s);
            buf.setText(buf.getText() + s + "\n");
        }
    }
}
