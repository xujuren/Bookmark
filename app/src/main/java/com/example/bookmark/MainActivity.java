package com.example.bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> myURLs = new ArrayList<>();

        // Declaring button and editText
        Button button = (Button)findViewById(R.id.my_button);
        EditText my_URLs = (EditText)findViewById(R.id.my_URLs);

        //Declaring ListView and its adapter
        ListView myList = (ListView)findViewById(R.id.my_Listview);
        ArrayAdapter myBookmarksAA = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myURLs);
        myList.setAdapter(myBookmarksAA);

        //Declaring Listener

        //button Listener
        View.OnClickListener add_bookmark = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myURLs.add(my_URLs.getText().toString());
                myBookmarksAA.notifyDataSetChanged();
                my_URLs.getText().clear();
            }
        };

        //ListView Listener
        AdapterView.OnItemClickListener openWeb = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (myURLs.get(i) == null || myURLs.get(i).isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "URL is invalid" ,Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), ActivityWeb.class);
                    intent.putExtra("URL", myURLs.get(i).toString());
                    startActivity(intent);
                }
            }
        };

        myList.setOnItemClickListener(openWeb);
        button.setOnClickListener(add_bookmark);
    }
}