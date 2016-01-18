package net.source_code.thaker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MSG extends Activity {
    Timer timerx ;
    MyTimerTask Ttask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        Button done = (Button) findViewById(R.id.done);
        Button Stop = (Button) findViewById(R.id.stop2);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       timerx = new Timer();
       Ttask = new MyTimerTask();

         timerx.schedule(Ttask, 5000);

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.os.Process.killProcess(android.os.Process.myPid());
                finish();

            }
        });
    }




    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {


                    finish();


                }


            });
        }
    }






}
