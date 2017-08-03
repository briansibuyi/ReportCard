package com.example.brian.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {

    EditText Name, Pass, myath,myBusiness,myAccounting,myScience,myEnglish;
    DbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Name= (EditText) findViewById(R.id.Old_StudentName);
        Pass= (EditText) findViewById(R.id.New_StudentName);
        myath = (EditText)findViewById(R.id.mathEdit) ;
        myBusiness = (EditText)findViewById(R.id.BusinesEdit) ;
        myAccounting = (EditText)findViewById(R.id.AccoutningEdit) ;
        myScience = (EditText)findViewById(R.id.ScienceEdit) ;
        myEnglish = (EditText)findViewById(R.id.EnglishEdit) ;


        //Database Object
        helper = new DbAdapter(this);
    }

    //Inserting Method
    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        String t3 = myath.getText().toString();
        String t4 = myBusiness.getText().toString();
        String t5 = myAccounting.getText().toString();
        String t6 = myScience.getText().toString();
        String t7 = myEnglish.getText().toString();

        if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty() || t5.isEmpty() || t6.isEmpty() || t7.isEmpty())
        {
            Message.message(getApplicationContext(),"Fill all the field above!");
        }
        else
        {
            long id = helper.insertData(t1,t2,t3,t4,t5,t6,t7);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Record Added Unsuccessful");
                Name.setText("");
                Pass.setText("");
                myath.setText("");
                myBusiness.setText("");
                myAccounting.setText("");
                myScience.setText("");
                myEnglish.setText("");

            } else
            {
                Message.message(getApplicationContext(),"Record Added Successful");
                Name.setText("");
                Pass.setText("");
                myath.setText("");
                myBusiness.setText("");
                myAccounting.setText("");
                myScience.setText("");
                myEnglish.setText("");
            }
        }
         viewdata();


    }


    public void viewdata()
    {

        Intent y = new Intent(this,Main2Activity.class);
        startActivity(y);



    }


    public void Next(View view)
    {

        Intent y = new Intent(this,Main3Activity.class);
        startActivity(y);



    }
    public void Next1(View view)
    {

        Intent y = new Intent(this,Main4Activity.class);
        startActivity(y);



    }


}
