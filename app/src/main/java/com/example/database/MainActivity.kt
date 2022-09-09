package com.example.database

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helper=MyDBhelper(applicationContext)
        val db=helper.readableDatabase

        val BtnInsert:Button=findViewById(R.id.BtnInsert)
    val BtnView:Button=findViewById(R.id.BtnView)
        BtnInsert.setOnClickListener {
            name=findViewById(R.id.edName)
            email=findViewById(R.id.edEmail)
            var values=ContentValues()
            values.put("UNAME",name.text.toString())
            values.put("PWD",email.text.toString())
            db.insert("USERS",null,values)

            name.setText("")
            email.setText("")
            name.requestFocus()
        }

        BtnView.setOnClickListener {
            val rs=db.rawQuery("SELECT * FROM USERS",null)
            val Array:ArrayList<Model> =ArrayList()
            if(rs.moveToFirst())
            {
                do {
                    var std=Model(rs.getString(1),rs.getString((2)))
                    Array.add(std)

                }while (rs.moveToNext())
                for (i in Array) {
                    println(i)
                }

            }


        }
    }
}