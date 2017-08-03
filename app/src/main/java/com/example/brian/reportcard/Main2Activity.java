package com.example.brian.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    DbAdapter helper;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        myList = (ListView) findViewById(R.id.MyDatabaslist);

        //Database Object
        helper = new DbAdapter(this);


        //Data Viewing Method

        ArrayList<String> array;
        array = helper.getData();

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter <>(this,android.R.layout.simple_list_item_activated_1,array);
        myList.setAdapter(arrayAdapter);

        //avarage display

    }


    public void update(){
        Intent myudpate = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(myudpate);
    }

    public void delete(){
        Intent myudpate = new Intent(Main2Activity.this,Main4Activity.class);
        startActivity(myudpate);
    }

    public void Save(){
        Intent myudpate = new Intent(Main2Activity.this,Main5Activity.class);
        startActivity(myudpate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.nav_save:
                Save();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.nav_update:
                // Do nothing for now
                update();
                return true;

            case R.id.nav_Delete:
                // Do nothing for now
                delete();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
