package com.example.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBhelper(context:Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS (USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT, PWD TEXT)")
        db?.execSQL("INSERT INTO USERS (UNAME,PWD) VALUES ('CHING','CHINGSIEN12')")
        db?.execSQL("INSERT INTO USERS (UNAME,PWD) VALUES ('CHING12','CHINGSIEN122')")
        db?.execSQL("INSERT INTO USERS (UNAME,PWD) VALUES ('CHING123','CHINGSIEN122')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
