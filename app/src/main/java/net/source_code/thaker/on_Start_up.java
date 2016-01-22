package net.source_code.thaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class on_Start_up extends BroadcastReceiver {
    public on_Start_up() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent startServiceIntent = new Intent(context, Repeater.class);
        context.startService(startServiceIntent);


        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
