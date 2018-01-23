package com.example.munaj.sqlite;

/**
 * Created by Munaj on 1/9/2016.
 * Class specifically for dataBase
 * Anything to do related to a dataBase
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lists.db"; //Files name...
    public static final String TABLE_PRODUCTS = "lists"; //Name of table
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    //What to do when you create the table
    @Override
    public void  onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_PRODUCTNAME + " TEXT " + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS );
        onCreate(db);
    }
    //Add a new row to the database
    public void addProduct(List list){
        //Allows you to set different values to different coloums and allows you to print it right away
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, list.get_productName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
        db.close();
    }

    //Print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM '" + TABLE_PRODUCTS + "' WHERE 1";

        //Cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst(); //Move to first row in your result;
        //Loop through each row
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("productname")) != null){
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
