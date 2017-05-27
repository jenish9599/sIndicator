package com.example.cbz.mapss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

/**
 * Created by jenishpatel on 27/03/17.
 */


public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Database.db";
    public static final String TABLE_NAME = "SVNIT";
    public static final String COL1 = "ID";
    public static final String COL2 = "DESTINATION";
    public static final String COL3 = "A";
    public static final String COL4 = "B";
    public static final String COL5 = "C";
    public static final String COL6 = "D";
    public static final String COL7 = "PRIZE";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,DESTINATION TEXT NOCASE,A TEXT,B TEXT,C TEXT,D TEXT,COST1 INTEGER,COST2 INTEGER,COST3 INTEGER,COST4 INTEGER,PRIZE TEXT)");
        //insertData1("DAmka","lai le tu en","","reallly","LAile","");
        //insertData1("MORA","lai le tu en","","reallly","LAile","");
        db.insert(TABLE_NAME,null,insertData1("ATHAWA GATE","Take auto SVNIT-ATHAWA","-","-","-","10",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("GAS CIRCLE","Take auto SVNIT-ATHAWA","Take auto ATHAWA-GAS CIRCLE","-","-","10 + 5 = 15",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Gandhi electronics,surat","Take auto SVNIT-ATHAWA","Take auto ATHAWA-GAS CIRCLE","Walking","-","10 + 5 = 15",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("VR Mall","Take BRTS SVNIT-VR MOLE","-","-","-","9",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Parle point","Take Auto SVNIT-Parle point","-","-","-","5",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Vijay sales pipload","Take BRTS SVNIT-Kargil chowk","Walking","-","-","4",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Iscon Mall","Take BRTS SVNIT-lancer's army school","Walking","-","-","4",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Rajhans","Take BRTS SVNIT-RAJHANS","-","-","-","4",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Subway","Take BRTS SVNIT-RAJHANS","Walking","-","-","4",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Valentine Multiplex","Take BRTS SVNIT-Valentine","-","-","-","6",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("INOX","Take BRTS SVNIT-VR Mall","-","-","-","9",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("Mcdonalds","Take BRTS SVNIT-VR Mall","-","-","-","9",0,0,0,0));
        db.insert(TABLE_NAME,null,insertData1("INOX","Take BRTS SVNIT-VR Mall","-","-","-","9",0,0,0,0));
        //db.insert(TABLE_NAME,null,insertData1("Dumms Beach","Take BRTS SVNIT-VR MOLE","","","","9"));
        //db.insert(TABLE_NAME,null,insertData1("Suvali Beach","Take BRTS SVNIT-VR MOLE","","","","9"));
        //db.insert(TABLE_NAME,null,insertData1("Suvali Beach","Take BRTS SVNIT-VR MOLE","","","","9"));
        db.insert(TABLE_NAME,null,insertData1("Saragam shoping center","Take BRTS SVNIT-VR Mall","-","-","-","9",0,0,0,0));


        //db.insert(TABLE_NAME,null,insertData1("","","","","",""));
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public ContentValues insertData1(String destination, String a, String b,String c,String d ,String e,int p,int q,int r,int s) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, destination);
        contentValues.put(COL3, a);
        contentValues.put(COL4, b);
        contentValues.put(COL5, c);
        contentValues.put(COL6, d);
        contentValues.put(COL7, e);
        contentValues.put("COST1", p);
        contentValues.put("COST2", q);
        contentValues.put("COST3", r);
        contentValues.put("COST4", s);
        return contentValues;
        //db.insert(TABLE_NAME, null, contentValues);

    }


    public boolean insertData(String destination, String a, String b,String c,String d ,String e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, destination);
        contentValues.put(COL3, a);
        contentValues.put(COL4, b);
        contentValues.put(COL5, c);
        contentValues.put(COL6, d);
        contentValues.put(COL7, e);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData3(String source,String destination, String a, String b,String c,String d ,String e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, destination);
        contentValues.put(COL3, a);
        contentValues.put(COL4, b);
        contentValues.put(COL5, c);
        contentValues.put(COL6, d);
        contentValues.put(COL7, e);

        //db.execSQL("create table " + source + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,DESTINATION TEXT NOCASE,A TEXT,B TEXT,C TEXT,D TEXT,PRIZE TEXT)");
        //db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + source + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,DESTINATION TEXT NOCASE,A TEXT,B TEXT,C TEXT,D TEXT,PRIZE TEXT)");
        long result = db.insert(source, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }



    public Cursor getalldata(String a,String b) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(a, new String[]{"ID","DESTINATION","A","B","C","D","PRIZE"},"DESTINATION LIKE ?",new String[]{b}, null, null, null,null);
        return cursor;
    }
    public Cursor getalltable(String a,String b) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(null,null,null,null, null, null, null,null);

        return cursor;
    }
}


