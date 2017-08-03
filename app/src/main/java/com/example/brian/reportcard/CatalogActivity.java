/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.brian.reportcard;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogActivity extends AppCompatActivity {


    private EditText username=null;
    private EditText passStu=null;

    private EditText userStu=null;
    private EditText password=null;

    private TextView attempts;
    private Button login;
    int counter = 5;

    DbAdapter helper;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.sign_in);

        userStu = (EditText)findViewById(R.id.Username);
        passStu = (EditText)findViewById(R.id.Password);



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(MainActivity.this,CatalogActivity.class);
//                startActivity(i);
//            }
//        });

        //Database Object
        helper = new DbAdapter(this);
    }




    public void login(View view){

        String t1 = userStu.getText().toString();
        String t2 = passStu.getText().toString();

//        if(userStu.getText().toString().equals("") &&  passStu.getText().toString().equals(""))
//        {
//            Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
//            Intent myudpate = new Intent(CatalogActivity.this,Profile.class);
//            startActivity(myudpate);
//
//
//        }

         if(username.getText().toString().equals("admin") &&  password.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent x = new Intent(CatalogActivity.this,Main2Activity.class);
            startActivity(x);
        }


        else
        {
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter--;

            attempts.setText(Integer.toString(counter));
            if (counter == 0) {
                login.setEnabled(false);
            }

        }
    }

}
