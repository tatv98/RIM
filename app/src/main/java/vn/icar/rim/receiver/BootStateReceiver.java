package vn.icar.rim.receiver;

import vn.icar.rim.service.SerialListenerService_;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootStateReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent)
    {

        SerialListenerService_.intent(context).start();
    }

}
