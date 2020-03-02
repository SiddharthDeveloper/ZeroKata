package com.siddharth.ZeroKata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button computer;
    Button friend;
    Button online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computer = findViewById(R.id.computer);
        friend = findViewById(R.id.friend);
        online = findViewById(R.id.online);

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComputerActivity.class);
                startActivity(intent);
            }
        });

        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FriendActivity.class);
                startActivity(intent);

            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OnlineActivity.class);
                startActivity(intent);

            }
        });

    }

}
