package net.source_code.thaker;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends Activity {


    private PendingIntent pendingIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Start = (Button)findViewById(R.id.start);

        Button About = (Button)findViewById(R.id.about_2);



        //Start button
        Start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                    startService(new Intent(MainActivity.this, Repeater.class));
                    Toast.makeText(getBaseContext(),"بدأ برنامج ذكّر بالعمل",Toast.LENGTH_SHORT).show();
                    finish();




            }
        });




        About.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, info.class));

            }
        });


    }








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
