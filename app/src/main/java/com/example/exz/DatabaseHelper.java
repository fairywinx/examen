package com.example.exz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "emp_info.db";
    private static final String TABLE_NAME = "employee_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "LastNAME";
    private static final String COL_3 = "FirstName";
    private static final String COL_4 = "MiddleName";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, LASTNAME TEXT, FIRSTNAME TEXT, MIDDLENAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(EditText lastname, EditText firstname, EditText middlename) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, lastname.getText().toString());
        contentValues.put(COL_3, firstname.getText().toString());
        contentValues.put(COL_4, middlename.getText().toString());
        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    }

