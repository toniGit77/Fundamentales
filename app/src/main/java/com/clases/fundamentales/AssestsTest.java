package com.clases.fundamentales;

import android.app.Activity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;

public class AssestsTest extends Activity {
    StringBuilder builder = new StringBuilder();
    TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView = new TextView(this);
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("canciones/endoftheworld.txt");
            String text = cargarArchivoDeTexto(inputStream);
            testView.setText(text);
        } catch (IOException e) {
            testView.setText("No se puede cargar el archivo de texto");

        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    testView.setText("No se puede cerrar el archivo de texto");
                }
        }
    }

    public String cargarArchivoDeTexto(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ((len = inputStream.read(bytes))> 0 )byteStream.write(bytes,0,len);
        String result =new String(byteStream.toByteArray(),"UTF8");
        Log.d("Assets", result);
        return  result;
    }
}
