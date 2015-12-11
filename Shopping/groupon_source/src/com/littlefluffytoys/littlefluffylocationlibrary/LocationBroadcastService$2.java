// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.app.PendingIntent;
import android.location.LocationManager;
import android.util.Log;
import java.util.TimerTask;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationBroadcastService, LocationLibrary

class val.oneshotReceiver extends TimerTask
{

    final LocationBroadcastService this$0;
    final LocationManager val$locationManager;
    final PendingIntent val$oneshotReceiver;

    public void run()
    {
        try
        {
            if (LocationLibrary.showDebugOutput)
            {
                Log.d("LittleFluffyLocationLibrary", "LocationBroadcastService: remove updates after 30 seconds");
            }
            val$locationManager.removeUpdates(val$oneshotReceiver);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        stopSelf();
    }

    Q()
    {
        this$0 = final_locationbroadcastservice;
        val$locationManager = locationmanager;
        val$oneshotReceiver = PendingIntent.this;
        super();
    }
}
