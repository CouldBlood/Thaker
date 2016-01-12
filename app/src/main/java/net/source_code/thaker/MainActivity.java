package net.source_code.thaker;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends Activity {







    Timer timerx ;
    MyTimerTask_2 Ttask;

    private PendingIntent pendingIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Start = (Button)findViewById(R.id.start);
        Button Stop =(Button)findViewById(R.id.Stop);
        Button About = (Button)findViewById(R.id.about_2);



        //Start button
        Start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    timerx = new Timer();
                    Ttask = new MyTimerTask_2();
                    //Method repeat Run() from TimerTask class
                    timerx.schedule(Ttask, 625000, 625000);//625,000 microsecond = about 10 minutes

                    Toast.makeText(getBaseContext(),"بدأ البرنامج بالعمل",Toast.LENGTH_SHORT).show();
                    finish();

                 }


                    catch(Exception e){
                    Toast.makeText(getBaseContext(),"البرنامج يعمل بالفعل",Toast.LENGTH_SHORT).show();
               }
            }
        });



        About.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, info.class));
            }
        });


    }


        //repeating class
    public class MyTimerTask_2 extends TimerTask{

        @Override
        public void run() {
            runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, MSG.class));
                }
            }) ;} }

    //this class makes app run on Phone start_up
    public static class StartMyServiceAtBootReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
                Intent serviceIntent = new Intent(context, MainActivity.class);
                context.startService(serviceIntent);
            }
        }
    }
}
