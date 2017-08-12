package com.parag.handlers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView textView;
    int counter = 0;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.btn_start);
        btnStop = (Button)findViewById(R.id.btn_stop);
        textView = (TextView)findViewById(R.id.txt_view);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        counter += 1;
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(""+counter);
                            }
                        });
                    }
                };

                timer.schedule(timerTask, 1000L, 1000L);

            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                counter = 0;
                textView.setText("0");
            }
        });


    }
}
