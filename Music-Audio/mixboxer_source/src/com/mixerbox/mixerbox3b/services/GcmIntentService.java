// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.services:
//            GcmBroadcastReceiver

public class GcmIntentService extends IntentService
{

    public static final int NOTIFICATION_ID = 12321;
    android.support.v4.app.NotificationCompat.Builder builder;
    private NotificationManager mNotificationManager;

    public GcmIntentService()
    {
        super("GcmIntentService");
    }

    private static int getAppVersion(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
        }
        return i;
    }

    private int getTab(String s)
    {
        if (s.equals("playlist"))
        {
            return 1;
        }
        if (s.equals("newsfeed"))
        {
            return 2;
        }
        if (s.equals("search"))
        {
            return 3;
        }
        if (s.equals("dj"))
        {
            return 4;
        }
        return !s.equals("setting") ? 0 : 5;
    }

    private void sendNotification(Bundle bundle)
    {
        if (!MixerBoxSharedPreferences.getShouldSendServerNotification(this))
        {
            return;
        }
        mNotificationManager = (NotificationManager)getSystemService("notification");
        Object obj = new Intent(this, com/mixerbox/mixerbox3b/MainPage);
        if (bundle.containsKey("tab"))
        {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("tab", getTab(bundle.getString("tab")));
            bundle1.putString("playlistId", bundle.getString("playlist"));
            ((Intent) (obj)).putExtras(bundle1);
        }
        ((Intent) (obj)).addFlags(0x24000000);
        obj = PendingIntent.getActivity(this, 12345, ((Intent) (obj)), 0x8000000);
        bundle = bundle.getString("message");
        bundle = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f0200df).setContentTitle("MixerBox 3").setContentIntent(((PendingIntent) (obj))).setStyle((new android.support.v4.app.NotificationCompat.BigTextStyle()).bigText(bundle)).setContentText(bundle);
        bundle.setContentIntent(((PendingIntent) (obj)));
        mNotificationManager.notify(12321, bundle.build());
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION"))
        {
            intent = intent.getStringExtra("registration_id");
            MixerBoxUtils.logMsg((new StringBuilder()).append("GCM ").append(intent).toString());
            if (intent != null)
            {
                Context context = getApplicationContext();
                MixerBoxUtils.sendCohortRegister(context, intent);
                MixerBoxSharedPreferences.putGCMId(context, intent);
                MixerBoxSharedPreferences.putPreVersion(context, getAppVersion(context));
            }
            return;
        }
        Bundle bundle = intent.getExtras();
        String s = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (!bundle.isEmpty() && !"send_error".equals(s) && !"deleted_messages".equals(s) && "gcm".equals(s))
        {
            sendNotification(bundle);
            MixerBoxUtils.logMsg((new StringBuilder()).append("Received: ").append(bundle.toString()).toString());
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }
}
