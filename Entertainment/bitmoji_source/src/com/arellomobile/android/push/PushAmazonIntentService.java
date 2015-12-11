// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Intent;
import android.util.Log;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.amazon.device.messaging.ADMMessageReceiver;
import com.google.android.gcm.GCMRegistrar;

// Referenced classes of package com.arellomobile.android.push:
//            PushServiceHelper, DeviceRegistrar, PushEventsTransmitter

public class PushAmazonIntentService extends ADMMessageHandlerBase
{
    public static class MessageAlertReceiver extends ADMMessageReceiver
    {

        public MessageAlertReceiver()
        {
            super(com/arellomobile/android/push/PushAmazonIntentService);
        }
    }


    private static final String TAG = "AmazonIntentService";

    public PushAmazonIntentService()
    {
        super(com/arellomobile/android/push/PushAmazonIntentService.getName());
    }

    public PushAmazonIntentService(String s)
    {
        super(s);
    }

    protected void onMessage(Intent intent)
    {
        Log.i("AmazonIntentService", "Received message");
        PushServiceHelper.generateNotification(getApplicationContext(), intent);
    }

    protected void onRegistered(String s)
    {
        Log.i("AmazonIntentService", (new StringBuilder()).append("Device registered: regId = ").append(s).toString());
        GCMRegistrar.setRegistrationId(getApplicationContext(), s);
        DeviceRegistrar.registerWithServer(getApplicationContext(), s);
    }

    protected void onRegistrationError(String s)
    {
        Log.e("AmazonIntentService", (new StringBuilder()).append("Messaging registration error: ").append(s).toString());
        PushEventsTransmitter.onRegisterError(getApplicationContext(), s);
    }

    protected void onUnregistered(String s)
    {
        Log.i("AmazonIntentService", "Device unregistered");
        GCMRegistrar.clearRegistrationId(getApplicationContext());
        DeviceRegistrar.unregisterWithServer(getApplicationContext(), s);
    }
}
