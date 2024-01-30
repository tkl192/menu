package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        System.out.println("onCreateOptionsMenu ...");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        if(menu.getClass().getSimpleName().equals("MenuBuilder")){
            try{
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        int itemId = item.getItemId();

        if (itemId == R.id.CART) {
            msg = "Коризна";
        } else if (itemId == R.id.CALL) {
            msg = "Звонок";
        } else if (itemId == R.id.CAMERA) {
            item.setChecked(true);
            msg = "Камера";
        } else if (itemId == R.id.VIDEO) {
            item.setChecked(true);
            msg = "Видео-камера";
        } else if (itemId == R.id.EMAIL) {
            msg = "Email";
        } else if (itemId == R.id.ADD) {
            msg = "Добавить выбрано";
        } else if (itemId == R.id.COPY) {
            msg = "Копировать выбрано";
        } else if (itemId == R.id.PASTE) {
            msg = "Вставить выбрано";
        } else {
            return super.onOptionsItemSelected(item);
        }

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }
    public void onHelpClick(MenuItem item)
    {
        Toast.makeText(getApplicationContext(),"Помощь выбрано",Toast.LENGTH_LONG).show();
    }
}