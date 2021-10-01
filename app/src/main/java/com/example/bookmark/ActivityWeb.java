package com.example.bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent intent = getIntent();
        String URL = intent.getStringExtra("URL");

        WebView myWebView = (WebView) findViewById(R.id.my_web);

        myWebView.loadUrl(URL);



    }
}