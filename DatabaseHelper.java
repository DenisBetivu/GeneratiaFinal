package com.example.denis.generatia;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Generatia.db";
    public static final String TABLE_NAME = "Studenti";
    public static final String COL1 = "ID";
    public static final String COL2 = "NUME";
    public static final String COL3 = "PRENUME";
    public static final String COL4 = "CNP";
    public static final String COL5 = "AN_STUDIU";
    public static final String COL6 = "FACULTATE";
    public static final String COL7 = "VARSTA";
    public static final String COL8 = "CREDITE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NUME TEXT, PRENUME TEXT, CNP char(13),AN_STUDIU INT, FACULTATE TEXT char(3), VARSTA INT , CREDITE INT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String Nume, String Prenume, Integer CNP, int An_studiu, String Facultate,
                           Integer Varsta, Integer Credite) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, Nume);
        contentValues.put(COL3, Prenume);
        contentValues.put(COL4, CNP);
        contentValues.put(COL5, An_studiu);
        contentValues.put(COL6, Facultate);
        contentValues.put(COL7, Varsta);
        contentValues.put(COL8, Credite);

        long result = db.insertOrThrow(TABLE_NAME, null, contentValues);

        //idaca inserarea e esuata se va returna -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean updateData (String NumeNou, String PrenumeNou,  int CNP, int An_StudiuNou, String FacultateNoua,
                               int VarstaN, int CrediteN) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); //instante

        contentValues.put("sNume", NumeNou);
        contentValues.put("sPrenume", PrenumeNou);
        contentValues.put("sCNP", CNP);
        contentValues.put("sAn_Studiu", An_StudiuNou);
        contentValues.put("sFacultate", FacultateNoua);
        contentValues.put("sVarsta", VarstaN);
        contentValues.put("sCredite", CrediteN);

        db.update(TABLE_NAME, contentValues,"CNP = '" +CNP+"'", null );

        //this.getWritableDatabase().insertOrThrow("Studenti", "", contentValues);
        return true;
    }


    public void DeleteStud(String Nume, Integer CNP){
     this.getWritableDatabase().delete(TABLE_NAME, "(NUME='"+Nume+"') AND (CNP='"+CNP+"')", null );
     }




/*
    public void updateData(String Nume, String NumeNou);/* cand se marita vreo fata {
        this.getWritableDatabase().execSQL("Update studenti set NUME ='" + NumeNou +"' WHERE NUME ='"+Nume+"'",null);
    }

*/



    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME  , null);
        return data;
    }
}