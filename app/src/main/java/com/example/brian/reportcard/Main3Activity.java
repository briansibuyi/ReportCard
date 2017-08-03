package com.example.brian.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {


    DbAdapter helper;
    EditText updateOldNumber,updateNewNumber,updateOldName,updateNewName,updateOldMath,updatNewMath,updateOldBus,updateNewBus,OldAcc,NewAcc,OldSci,NewScie,OldEng,NewEng;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Database Object
        helper = new DbAdapter(this);

        updateOldNumber= (EditText) findViewById(R.id.Old_studentNumber);
        updateNewNumber= (EditText) findViewById(R.id.New_StudentNumber);

        updateOldName= (EditText) findViewById(R.id.Old_StudentName);
        updateNewName= (EditText) findViewById(R.id.New_StudentName);

        updateOldMath = (EditText) findViewById(R.id.OldMath);
        updatNewMath = (EditText) findViewById(R.id.NewMath);

        updateOldBus = (EditText) findViewById(R.id.oldBusinessMarks);
        updateNewBus = (EditText) findViewById(R.id.NewBusinessMarks);

        OldAcc = (EditText) findViewById(R.id.oldAccountingMarks);
        NewAcc = (EditText) findViewById(R.id.NewAccountingMarks);

        OldSci = (EditText) findViewById(R.id.oldScienceMarks);
        NewScie = (EditText) findViewById(R.id.NewScienceMarks);

        OldEng = (EditText) findViewById(R.id.oldEnglishMarks);
        NewEng = (EditText) findViewById(R.id.NewEnglishMarks);





        ArrayList<String> array;
        array = helper.getData();

        //
        updateOldNumber.setText(array.get(0));


    }



    public void update( View view)
    {


        String u1 = updateOldNumber.getText().toString();
        String u2 = updateNewNumber.getText().toString();



        String u3 = updateOldName.getText().toString();
        String u4 = updateNewName.getText().toString();

        String u5 = updateOldMath.getText().toString();
        String u6 = updatNewMath.getText().toString();

        String u7 = updateOldBus.getText().toString();
        String u8 = updateNewBus.getText().toString();

        String u9 = OldAcc.getText().toString();
        String u10 = NewAcc.getText().toString();

        String u11 = OldSci.getText().toString();
        String u12 = NewScie.getText().toString();

        String u13 = OldEng.getText().toString();
        String u14 = NewEng.getText().toString();

        System.out.println("U1: " +u1 + " U2: " + u2 + "U3: " +u3 + "U4: " + u4+ "U5: " + u5+ "U6: " + u6+ "U7: " + u7+ "U8: " + u8+ "U9: " + u9+ "U10: " + u10+ "U11: " + u11+ "U12: " + u12+ "U13: " + u13+ "U14: " + u14);



        if(u1.isEmpty() || u2.isEmpty() || u3.isEmpty()|| u4.isEmpty()|| u5.isEmpty()|| u6.isEmpty()|| u6.isEmpty()|| u7.isEmpty()|| u8.isEmpty() || u9.isEmpty() || u10.isEmpty()|| u11.isEmpty()|| u12.isEmpty()|| u13.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Data");
        }
        else {
            int a = helper.updateName(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
                //Number field
                updateOldNumber.setText("");
                updateNewNumber.setText("");

                //Name field
                updateOldName.setText("");
                updateNewName.setText("");


                updateOldMath.setText("");
                updatNewMath.setText("");

                updateOldBus.setText("");
                updateNewBus.setText("");

                OldAcc.setText("");
                NewAcc.setText("");

                OldSci.setText("");
                NewScie.setText("");

                OldEng.setText("");
                NewEng.setText("");

            } else {
                Message.message(getApplicationContext(), "Updated");
                //Number field
                updateOldNumber.setText("");
                updateNewNumber.setText("");

                //Name field
                updateOldName.setText("");
                updateNewName.setText("");


                updateOldMath.setText("");
                updatNewMath.setText("");

                updateOldBus.setText("");
                updateNewBus.setText("");

                OldAcc.setText("");
                NewAcc.setText("");

                OldSci.setText("");
                NewScie.setText("");

                OldEng.setText("");
                NewEng.setText("");
            }

        }
        viewdata();

    }

    public void viewdata()
    {

        Intent y = new Intent(this,Main2Activity.class);
        startActivity(y);



    }
}
