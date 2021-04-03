package com.clases.fundamentales;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnKeyListener;
import android.os.Bundle;

public class KeyTest extends Activity implements OnKeyListener {
    StringBuilder builder = new StringBuilder();
    TextView testView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView = new TextView(this);
        testView.setText("Pulsa teclas y observa el resultado en la pantalla");
        testView.setOnKeyListener(this);
        testView.setFocusableInTouchMode(true);
        testView.requestFocus();
        setContentView(testView);
    }
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        builder.setLength(0);
        switch (keyEvent.getAction()) {
            case KeyEvent.ACTION_DOWN:
                builder.append("down, ");
                break;

            case KeyEvent.ACTION_UP:
                builder.append("up, ");
                break;
        }
        builder.append(keyEvent.getKeyCode());
        builder.append(", ");
        builder.append((char)keyEvent.getUnicodeChar());
        String text = builder.toString();
        Log.d("KeyTest",text);
        testView.setText(text);
        if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_BACK)
            return false;
            else
            return true;
    }
}
