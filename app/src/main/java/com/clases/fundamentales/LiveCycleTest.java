package com.clases.fundamentales;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LiveCycleTest extends Activity {

    StringBuilder builder = new StringBuilder();
    TextView testView;

    private void log(String text){
        Log.d("LiveCycleTest",text);
        builder.append(text);
        builder.append('\n');
        testView.setText(builder.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView= new TextView(this);
        testView.setText(builder.toString());
        setContentView(testView);
        log("created");
    }
    @Override
    protected void onResume(){
        super.onResume();
        log("Resumed");
    }
    @Override
    protected void onPause(){
        super.onPause();
        log("Paused");
        if(isFinishing()){
            log("Finishing");
        }
    }
}
