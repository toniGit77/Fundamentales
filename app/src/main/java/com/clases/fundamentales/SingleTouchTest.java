package com.clases.fundamentales;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;


public class SingleTouchTest extends Activity implements OnTouchListener {

    StringBuilder builder = new StringBuilder();
    TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView = new TextView(this);
        testView.setText("Toca y arrastra un dedo ¡(Un dedo solamente)!");
        testView.setOnTouchListener(this);
        setContentView(testView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        builder.setLength(0);
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                builder.append("down, ");
                break;
            case MotionEvent.ACTION_MOVE:
                builder.append("move, ");
                break;
            case MotionEvent.ACTION_CANCEL:
                builder.append("cancel, ");
                break;
            case MotionEvent.ACTION_UP:
                builder.append("up, ");
                break;
        }
        builder.append(motionEvent.getX());
        builder.append(", ");
        builder.append(motionEvent.getY());
        String text = builder.toString();
        Log.d("TouchTest",text);
        testView.setText(text);
        return true;
    }
}
