package com.siddharth.ZeroKata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ComputerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design);
    }

    //TODO: Button Click Method..
    public void BtnClick(View view) {

        Button btnSelected = (Button) view;
        int CellID = 0;
        switch ((btnSelected.getId())) {

            case R.id.btn1:
                CellID = 1;
                break;

            case R.id.btn2:
                CellID = 2;
                break;

            case R.id.btn3:
                CellID = 3;
                break;

            case R.id.btn4:
                CellID = 4;
                break;

            case R.id.btn5:
                CellID = 5;
                break;

            case R.id.btn6:
                CellID = 6;
                break;

            case R.id.btn7:
                CellID = 7;
                break;

            case R.id.btn8:
                CellID = 8;
                break;

            case R.id.btn9:
                CellID = 9;
                break;
        }
        PlayGame(CellID, btnSelected);
    }

    int ActivePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<>();// hold player 1 data
    ArrayList<Integer> Player2 = new ArrayList<>();// hold player 2 data

    void PlayGame(int CellID, Button btnSelected) {


        if (ActivePlayer == 1) {
            btnSelected.setText("O");
            btnSelected.setBackgroundColor(Color.RED);
            Player1.add(CellID);
            ActivePlayer = 2;

            AutoPlay();
        } else if (ActivePlayer == 2) {
            btnSelected.setText("X");
            btnSelected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer = 1;

        }

        btnSelected.setEnabled(false);
        CheckWinner();
    }

    //TODO: For Checking Winner..
    void CheckWinner() {
        int Winner = -1;
        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            Winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            Winner = 2;
        }

        //row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            Winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            Winner = 2;
        }

        //row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            Winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            Winner = 2;
        }


        //col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            Winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            Winner = 2;
        }

        //col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            Winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            Winner = 2;
        }


        //col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            Winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            Winner = 2;
        }


        if (Winner != -1) {
            //  That Means We have winner

            if (Winner == 1) {
                new AlertDialog.Builder(ComputerActivity.this)
                        .setTitle("You Win")
                        .setMessage("Do You Want to Play Again??")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(ComputerActivity.this, ComputerActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })

                        .show();
            }

            if (Winner == 2) {
                new AlertDialog.Builder(ComputerActivity.this)
                        .setTitle("You Lose!!")
                        .setMessage("Do You Want to Play Again??")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(ComputerActivity.this, ComputerActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })

                        .show();
            }

        }

    }

    void AutoPlay() {

        ArrayList<Integer> EmptyCells = new ArrayList<>(); // all un selected cells
        //Find empty cells

        for (int cellID = 1; cellID < 10; cellID++) {
            if (!(Player1.contains(cellID) || Player2.contains(cellID))) {
                EmptyCells.add(cellID);
            }
        }

        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size()); // if size =3 , select (0,1,2)
        int CellID = EmptyCells.get(RandIndex);

        Button btnSelected;
        switch (CellID) {

            case 2:
                btnSelected = findViewById(R.id.btn2);
                break;

            case 3:
                btnSelected = findViewById(R.id.btn3);
                break;

            case 4:
                btnSelected = findViewById(R.id.btn4);
                break;

            case 5:
                btnSelected = findViewById(R.id.btn5);
                break;

            case 6:
                btnSelected = findViewById(R.id.btn6);
                break;

            case 7:
                btnSelected = findViewById(R.id.btn7);
                break;

            case 8:
                btnSelected = findViewById(R.id.btn8);
                break;

            case 9:
                btnSelected = findViewById(R.id.btn9);
                break;
            default:
                btnSelected = findViewById(R.id.btn1);
                break;

        }
        PlayGame(CellID, btnSelected);
    }
}


