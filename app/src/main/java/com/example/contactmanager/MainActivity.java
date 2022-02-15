package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        //Contact jason = new Contact();
        //jason.setName("Jason");
        //jason.setPhoneNumber("8328556844");
        //db.addContact(jason);
        //Get 1 contact
//        Contact c = db.getContact(2);
//        c.setName("NewJason");
//        c.setPhoneNumber("2342000");
//        int updatedRow = db.updateContact(c);
//
//        Log.d("UpdateRow", "onCreate: " + updatedRow);
//        db.deleteContact(c);



        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList){
            Log.d("ActivityMain", "onCreate: " + contact.getId() + " " + contact.getName() + " " + contact.getPhoneNumber());
        }
    }
}