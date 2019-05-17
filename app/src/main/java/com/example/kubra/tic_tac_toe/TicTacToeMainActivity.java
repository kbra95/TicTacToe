package com.example.kubra.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToeMainActivity extends AppCompatActivity {

    private boolean player1=true;
    private int number=0;
    private Button buttons[][]=new  Button[3][3];
    private Button button1 ;
    private Button button2 ;
    private Button button3 ;
    private Button button4 ;
    private Button button5 ;
    private Button button6 ;
    private Button button7 ;
    private Button button8 ;
    private Button button9 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_main);



        /*for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String buttonID="button_" +i+j;
                int resID=getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }*/
    }
    private Void increment() {
        number++;
        return null;
    }

    public void onClick(View view) {
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
         button4 = (Button) findViewById(R.id.button4);
         button5 = (Button) findViewById(R.id.button5);
         button6 = (Button) findViewById(R.id.button6);
         button7 = (Button) findViewById(R.id.button7);
         button8 = (Button) findViewById(R.id.button8);
         button9 = (Button) findViewById(R.id.button9);

        if(!((Button) view).getText().toString().equals(""))
            return;
        increment();
        switch (view.getId()) {

            case R.id.button1:
                settingButtonText(button1);

                break;

            case R.id.button2:
                settingButtonText(button2);
                break;

            case R.id.button3:
                settingButtonText(button3);
                break;

            case R.id.button4:
                settingButtonText(button4);
                break;

            case R.id.button5:
                settingButtonText(button5);
                break;

            case R.id.button6:
                settingButtonText(button6);
                break;

            case R.id.button7:
                settingButtonText(button7);
                break;

            case R.id.button8:
                settingButtonText(button8);
                break;

            case R.id.button9:
                settingButtonText(button9);
                break;
        }
    }
    private boolean checkForWin(){
        String field[][]={{button1.getText().toString(),button2.getText().toString(),button3.getText().toString()},
                {button4.getText().toString(),button5.getText().toString(),button6.getText().toString()},
                {button7.getText().toString(),button8.getText().toString(),button9.getText().toString()}};


        for(int i=0;i<3;i++){
            if(field[i][0].equals(field[i][1])
                    &&field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){
                return true;
            }
        }
        for(int i=0;i<3;i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        return false;

    }
    public void settingButtonText(Button butt){
            if(number%2==0) {
                //çift ise player 2 O
                butt.setText("O");
                isFullBoard();
                player1=false;
            }
            else {
                butt.setText("X");
                isFullBoard();
                player1 = true;
            }
            if(checkForWin()){
                if(player1){
                   Toast.makeText(this, "PLAYER1 WINS !!" ,Toast.LENGTH_SHORT).show();
                   resetBoard();
                }
                else {
                    Toast.makeText(this, "PLAYER2 WINS !!" ,Toast.LENGTH_SHORT).show();
                    resetBoard();
                }
            }
            if(isFullBoard()){
                Toast.makeText(this,"No one Wins ORR Everybody win :D ",Toast.LENGTH_LONG).show();
                resetBoard();
            }
    }

    private void resetBoard() {
        button9.setText("");
        button8.setText("");
        button7.setText("");
        button6.setText("");
        button5.setText("");
        button4.setText("");
        button3.setText("");
        button2.setText("");
        button1.setText("");

    }

    public boolean isFullBoard(){
        String field[][]={{button1.getText().toString(),button2.getText().toString(),button3.getText().toString()},
                {button4.getText().toString(),button5.getText().toString(),button6.getText().toString()},
                {button7.getText().toString(),button8.getText().toString(),button9.getText().toString()}};
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(field[i][j].equals("")){
                    return false;
                }
            } }
            return true;
    }
    public void newGame(View view) {
        resetBoard();
    }

   /* private void player1Wins() {
    }
    private void player2Wins() {
    }*/
}