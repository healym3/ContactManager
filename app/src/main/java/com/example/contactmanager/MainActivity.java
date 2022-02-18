package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

//        Contact jason = new Contact();
//        jason.setName("Jason");
//        jason.setPhoneNumber("8328556844");
//        db.addContact(jason);
        //Get 1 contact
//        Contact c = db.getContact(2);
//        c.setName("NewJason");
//        c.setPhoneNumber("2342000");
//        int updatedRow = db.updateContact(c);
//
//        Log.d("UpdateRow", "onCreate: " + updatedRow);
//        db.deleteContact(c);
//        db.addContact(new Contact("James","213986"));
//        db.addContact(new Contact("Timmy","5556858"));
//        db.addContact(new Contact("Greg","4095553152"));
//        db.addContact(new Contact("Shiloh","458555"));
//        db.addContact(new Contact("",""));
//        db.addContact(new Contact("Steve","34534534"));
//        db.addContact(new Contact("Jenny","13135"));
//        db.addContact(new Contact("Robert","5552525"));
//        db.addContact(new Contact("Joanne","52525255"));
//        db.addContact(new Contact("Megan","52525222"));
        db.addContact(new Contact("Chris","5551245"));
        db.addContact(new Contact("Phillip","5556532"));
        db.addContact(new Contact("Marc","5557895"));
        db.addContact(new Contact("Tigg","5551111"));


        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList){
            Log.d("ActivityMain", "onCreate: " + contact.getId() + " " + contact.getName() + " " + contact.getPhoneNumber());
            contactArrayList.add(contact.getName());
        }

        //create array adapter
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                contactArrayList);

        //Add to our listView
        listView.setAdapter(arrayAdapter);

        //Attach eventListener to listview
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d("List", "onItemClick: " + i + " " + contactArrayList.get(i));
        });

        Log.d("ActivityMain", "onCreate: count: " + db.getCount());
    }
}