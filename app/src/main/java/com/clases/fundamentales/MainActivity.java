package com.clases.fundamentales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String pruebas[]= {"LiveCycleTest", "SingleTouchTest","MultiTouchTest","KeyTest","AcelerometerTest","AssestsTest"
            ,"ExternalEstorageTests","SoundPoolTest","MediaPlayerTest","FullScreenTest","RenderViewTest","FontTest","SurfaceViewTest"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, pruebas));
    }
    @Override
    protected  void onListItemClick(ListView list , View view, int position, long id ){
        super.onListItemClick(list, view, position, id);
        String nobblePru = pruebas[position];
        try {
            Class clazz = Class.forName("com.clases.fundamentales."+nobblePru);
            assert clazz!=null;
            Intent intent = new Intent (this,clazz);
            startActivity(intent);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void log(String text, Class clazz) {
       Log.d("LiveCycleTest", text);
    }
}
