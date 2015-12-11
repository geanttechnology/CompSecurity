// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gcm.GCMBaseIntentService;

// Referenced classes of package com.arellomobile.android.push:
//            PushEventsTransmitter, PushServiceHelper, DeviceRegistrar

public class PushGCMIntentService extends GCMBaseIntentService
{

    private static final String TAG = "GCMIntentService";

    public PushGCMIntentService()
    {
    }

    protected void onDeletedMessages(Context context, int i)
    {
        Log.i("GCMIntentService", "Received deleted messages notification");
    }

    protected void onError(Context context, String s)
    {
        Log.e("GCMIntentService", (new StringBuilder()).append("Messaging registration error: ").append(s).toString());
        PushEventsTransmitter.onRegisterError(context, s);
    }

    protected void onMessage(Context context, Intent intent)
    {
        Log.i("GCMIntentService", "Received message");
        PushServiceHelper.generateNotification(context, intent);
    }

    protected boolean onRecoverableError(Context context, String s)
    {
        Log.i("GCMIntentService", (new StringBuilder()).append("Received recoverable error: ").append(s).toString());
        return super.onRecoverableError(context, s);
    }

    protected void onRegistered(Context context, String s)
    {
        Log.i("GCMIntentService", (new StringBuilder()).append("Device registered: regId = ").append(s).toString());
        DeviceRegistrar.registerWithServer(context, s);
    }

    protected void onUnregistered(Context context, String s)
    {
        Log.i("GCMIntentService", "Device unregistered");
        DeviceRegistrar.unregisterWithServer(context, s);
    }
}
