package com.ladr.myapplvl11.app;

import android.widget.TextView;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by user on 06.06.2014.
 */
public class SystemOutView {
    private TextView buf = null;

    public SystemOutView(TextView buf){
        initStream(buf);
    }

    private void initStream(TextView buf){
        this.buf = buf;
        buf.setText("");

        PrintStream origOut = System.out;
        PrintStream interceptor = new Interceptor(origOut);
        System.setOut(interceptor);
    }

    private class Interceptor extends PrintStream
    {
        public Interceptor(OutputStream out) {
            super(out, true);
        }
        @Override
        public void println(String s)
        {
            buf.setText(buf.getText() + s + "\n");
        }
        public void print(String s)
        {
            buf.setText(buf.getText() + s);
        }
    }

}
