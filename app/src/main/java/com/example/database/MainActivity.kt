package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper=MyDBhelper(applicationContext)
        var db=helper.readableDatabase
        var rs=db.rawQuery("SELECT * FROM USERS",null)


        Toast.makeText(applicationContext,rs.getString(),Toast.LENGTH_SHORT).show()
    }
}