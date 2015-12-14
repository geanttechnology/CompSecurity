// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

// Referenced classes of package com.facebook:
//            AppEventsLogger

public class BoltsMeasurementEventListener extends BroadcastReceiver
{

    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context)
    {
        applicationContext = context.getApplicationContext();
    }

    private void close()
    {
        LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this);
    }

    static BoltsMeasurementEventListener getInstance(Context context)
    {
        if (_instance != null)
        {
            return _instance;
        } else
        {
            _instance = new BoltsMeasurementEventListener(context);
            _instance.open();
            return _instance;
        }
    }

    private void open()
    {
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    protected void finalize()
    {
        close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onReceive(Context context, Intent intent)
    {
        AppEventsLogger.newLogger(context).logEvent((new StringBuilder()).append("bf_").append(intent.getStringExtra("event_name")).toString(), intent.getBundleExtra("event_args"));
    }
}
