package com.ladr.myapplvl11.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private static long lilaTimePrev;
        private static long lilaTimeCur;
        private static long lilaDuration;
        private static long minDuration = Long.MAX_VALUE;
        private static long maxDuration = 1;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Button button = (Button) rootView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateDetail();
                }
            });
            Button button2 = (Button) rootView.findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateDetail();
                }
            });
            lilaTimeCur = System.currentTimeMillis();
            lilaDuration = lilaTimeCur - lilaTimePrev;

            return rootView;
        }

        //example: http://www.vogella.com/tutorials/AndroidFragments/article.html
        public void updateDetail(){
            TextView view = (TextView) getView().findViewById(R.id.lilaTextView);

            String s = "Lila";
            int i = 5;
            int[] a = {2,3};

            lilaTimeCur = System.currentTimeMillis();
            lilaDuration = lilaTimeCur - lilaTimePrev;
            lilaTimePrev = lilaTimeCur;

            if(minDuration > lilaDuration)
                minDuration = lilaDuration;
            if(maxDuration < lilaDuration)
                maxDuration = lilaDuration;

            for (int j = 0; j < a.length; j++) {

            }

            String newTime = String.valueOf(lilaTimeCur);
            String newDuration = String.valueOf(lilaDuration);

            view.setText(s + "#" + newTime + "(min " + minDuration + "ms, max "
                    +  maxDuration + "ms): " + newDuration + "ms");
        }
    }
}
