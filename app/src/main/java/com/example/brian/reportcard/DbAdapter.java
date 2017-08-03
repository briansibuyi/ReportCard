package com.example.brian.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * * Created by Brian on 2017/07/18.
 */

public class DbAdapter {


    myDbHelper myhelper;
    public DbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String pass,String math,String busness,String accounting,String science,String english)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        contentValues.put(myDbHelper.Math, math);//added
        contentValues.put(myDbHelper.Business, busness);//added
        contentValues.put(myDbHelper.Accounting, accounting);//added
        contentValues.put(myDbHelper.Science, science);//added
        contentValues.put(myDbHelper.English, english);//added
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    //Displaying Method from Database
    public ArrayList <String> getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.MyPASSWORD, myDbHelper.Math, myDbHelper.Business, myDbHelper.Accounting, myDbHelper.Science, myDbHelper.English};//added
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);


        ArrayList<String> userList= new ArrayList<String>() ;
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            String  math =cursor.getString(cursor.getColumnIndex(myDbHelper.Math));
            String  business =cursor.getString(cursor.getColumnIndex(myDbHelper.Business));
            String  acc =cursor.getString(cursor.getColumnIndex(myDbHelper.Accounting));
            String  sci =cursor.getString(cursor.getColumnIndex(myDbHelper.Science));
            String  eng =cursor.getString(cursor.getColumnIndex(myDbHelper.English));

            //Avarage Calculation
            int total = ((Integer.parseInt(business)+Integer.parseInt(math)+Integer.parseInt(acc)+Integer.parseInt(sci)+Integer.parseInt(eng)));

            //Avarage Calculation
            int Avarage = ((Integer.parseInt(business)+Integer.parseInt(math)+Integer.parseInt(acc)+Integer.parseInt(sci)+Integer.parseInt(eng))/4);

            buffer.append(cid+ "Name : " + name + "Password : " + password +"Math :  " + math +" Business : " + business +" Accounting : " + acc +" Science : " + sci +" English : " + eng +"      \n");
            String display=cid+ "   - Name           : " + password + "\n"+"     - Password    : " +
                    name +"\n"+"     - Math             : " + math +"\n"+"     - Business      : " +
                    business +"\n"+"     - Accounting  : " + acc +"\n"+"     - Science        : " +
                    sci +"\n"+"     - English         : " + eng +"\n" +"     - Avarage        : "+ total + "\n"+"     - Total             : "+ Avarage ;

            userList.add(display);

        }
        //return buffer.toString();
        return  userList;
    }



    //for deleting the name on the database we use
    public  int delete(String uname, String unumber)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();

        String[] whereArgs ={uname, unumber};

        int count =db.delete(myDbHelper.TABLE_NAME , myDbHelper.NAME+" = ? AND " + myDbHelper.MyPASSWORD+" =? ",whereArgs);
        return  count;
    }


    //for updating the name on the database
    public int updateName(String OldName , String NewName,String OldNumber,String NewNumber,String OldMath,String  NewMath,String OldBuz, String NewBuz,String OldAccout,String NewAccount,String OldScie,String NewSci,String OldEngli,String NewEngli)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myDbHelper.NAME,NewName);
        contentValues.put(myDbHelper.MyPASSWORD,NewNumber); //added
        contentValues.put(myDbHelper.Math,NewMath); //added
        contentValues.put(myDbHelper.Business,NewBuz); //added
        contentValues.put(myDbHelper.Accounting,NewAccount); //added
        contentValues.put(myDbHelper.Science,NewSci); //added
        contentValues.put(myDbHelper.English,NewEngli); //added


        String[] whereArgs= {OldName,OldNumber,OldMath,OldBuz,OldAccout,OldScie,OldEngli};//added
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" =? AND "+ myDbHelper.MyPASSWORD+" =? AND "+ myDbHelper.Math+" =? AND "+ myDbHelper.Business+" =? AND "+ myDbHelper.Accounting+" =? AND "+ myDbHelper.Science+" =? AND "+ myDbHelper.English+" =? ",whereArgs );

        return count;
    }




static class myDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dd";    // Database Name
    private static final String TABLE_NAME = "mydd";   // Table Name
    private static final int DATABASE_Version = 8;    // Database Version
    private static final String UID = "_id";     // Column I (Primary Key)
    private static final String NAME = "Name";    //Column II
    private static final String MyPASSWORD = "Password";    // Column III
    private static final String Math = "Math";    // Column III
    private static final String Business = "Business";    // Column III
    private static final String Accounting = "Accounting";    // Column III
    private static final String Science = "Science";    // Column III
    private static final String English = "English";    // Column III


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225)," + Math + " VARCHAR(225)," + Business + " VARCHAR(225)," + Accounting + " VARCHAR(225)," + Science + " VARCHAR(225)," + English + " VARCHAR(225));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private Context context;

    public myDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "OnUpgrade");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }
}
}

