package com.ladr.myapplvl11.app;

import android.widget.TextView;

/**
 * Created by lychak_vv on 06.06.2014.
 */
public interface IPrintable {
    TextView printBuffer = null;
    void setPrintBuffer(TextView buf);
    void println(String text);
    void print(String text);
}
