package com.example.azphyo.sqlitesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Insert: ", "Inserting....");
        db.addContact(new Contact("Ravi", "90124345"));
        db.addContact(new Contact("Tommy", "9867868"));

        Log.d("Reading: ","Reading all contacts...");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn: contacts){
            String log = "ID: "+cn.get_id()+" ,Name: "+cn.get_name() + " ,Phone: " + cn.get_phone_number();
            Log.d("Name: ", log);
        }
    }
}
