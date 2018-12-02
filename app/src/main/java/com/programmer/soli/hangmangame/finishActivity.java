package com.programmer.soli.hangmangame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class finishActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        TextView txt_result = (TextView) findViewById(R.id.txt_result);
        ImageView img_result = (ImageView) findViewById(R.id.img_result);
        Button btn_exit = (Button) findViewById(R.id.btn_exit);
        Button btn_restart = (Button) findViewById(R.id.btn_restart);

        Intent intent = getIntent();
        String result = intent.getStringExtra("RESULT");
        if (result.equals("WON"))
        {
            txt_result.setText("! You Win !");
            txt_result.setTextColor(0xff27ae60);
            img_result.setImageResource(R.drawable.face_1);
        } else if (result.equals("LOSS"))
        {
            txt_result.setText("! Game Over !");
            txt_result.setTextColor(0xffcd2121);
            img_result.setImageResource(R.drawable.face_9);
        }

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 finish();
            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(finishActivity.this,MainActivity.class);
                finishActivity.this.startActivity(newGame);
                finish();
            }
        });
    }
}
