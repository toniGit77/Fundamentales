package com.clases.fundamentales;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;

import static android.view.MotionEvent.ACTION_POINTER_INDEX_SHIFT;

public class MultiTouchTest extends Activity implements OnTouchListener {

    StringBuilder builder = new StringBuilder();
    TextView testView;
    float[] x = new float[10];
    float[] y = new float[10];
    boolean[] tocado = new boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView = new TextView(this);
        testView.setText("Toca y arrastra ¡(soporta multiples dedos)!");
        testView.setOnTouchListener(this);
        setContentView(testView);
    }

    private void UndateTextView() {
        builder.setLength(0);
        for (int i = 0; i < 10; i++) {
            builder.append(tocado[i]);
            builder.append(", ");
            builder.append(x[i]);
            builder.append(", ");
            builder.append(y[i]);
            builder.append("\n");
        }
        testView.setText(builder.toString());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEvent.ACTION_MASK;
        int pointerIndex = (motionEvent.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> ACTION_POINTER_INDEX_SHIFT;
        int pointerId = motionEvent.getPointerId(pointerIndex);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                tocado[pointerId] = true;
                x[pointerId] = (int) motionEvent.getX(pointerIndex);
                y[pointerId] = (int) motionEvent.getY(pointerIndex);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                tocado[pointerId] = false;
                x[pointerId] = (int) motionEvent.getX(pointerIndex);
                y[pointerId] = (int) motionEvent.getY(pointerIndex);
                break;
            case MotionEvent.ACTION_MOVE:
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    pointerIndex = i;
                    pointerId = motionEvent.getPointerId(pointerIndex);
                    x[pointerId] = (int) motionEvent.getX(pointerIndex);
                    y[pointerId] = (int) motionEvent.getY(pointerIndex);
                }
                break;
        }
        UndateTextView();
        return true;
    }
}
