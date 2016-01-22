package net.source_code.thaker;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class Repeater extends Service {


    public Repeater() {
        handler.postDelayed(updateTimerThread, 0);

    }


    Handler handler = new Handler();



    private Runnable updateTimerThread = new Runnable()
    {

        public void run()
        {
            //write here whaterver you want to repeat
            Intent i = new Intent();
            i.setClass(Repeater.this, MSG.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            handler.postDelayed(this, 12000);


        }

    };

    @Override
    public void onCreate()
    {
        super.onCreate();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        handler.removeCallbacks(updateTimerThread);
    }



    @Override
    public IBinder onBind(Intent intent)
    {

        return null;
    }

}
