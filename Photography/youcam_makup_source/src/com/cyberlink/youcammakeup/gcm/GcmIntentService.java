// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.cyberlink.beautycircle.a;
import com.cyberlink.youcammakeup.activity.NoticeActivity;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.gcm:
//            GcmBroadcastReceiver

public class GcmIntentService extends IntentService
{

    private static int a = 0;
    private NotificationManager b;

    public GcmIntentService()
    {
        super("GcmIntentService");
    }

    private int a()
    {
        int i = a + 1;
        a = i;
        if (i == 0x7fffffff)
        {
            a = 1;
        }
        return a;
    }

    private void a(String s, String s1, String s2)
    {
        b = (NotificationManager)getSystemService("notification");
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(this, com/cyberlink/youcammakeup/activity/NoticeActivity), 0);
        s = (new android.support.v4.app.NotificationCompat.Builder(this)).setSmallIcon(0x7f0206ea).setAutoCancel(true).setLights(0xe63082, 1000, 1000).setContentTitle(s).setStyle((new android.support.v4.app.NotificationCompat.BigTextStyle()).bigText(s1)).setContentText(s1).setTicker(s2);
        s.setContentIntent(pendingintent);
        b.notify(a(), s.build());
    }

    protected void onHandleIntent(Intent intent)
    {
        Bundle bundle;
        String s;
        m.b("GcmIntentService", "GcmIntentService::onHandleIntent in");
        bundle = intent.getExtras();
        s = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (bundle.isEmpty()) goto _L2; else goto _L1
_L1:
        if (!"send_error".equals(s)) goto _L4; else goto _L3
_L3:
        m.b("GcmIntentService", (new StringBuilder()).append("GcmIntentService::onHandleIntent, type=MESSAGE_TYPE_SEND_ERROR, extras=").append(bundle.toString()).toString());
_L2:
        GcmBroadcastReceiver.completeWakefulIntent(intent);
        m.b("GcmIntentService", "GcmIntentService::onHandleIntent out");
        return;
_L4:
        if ("deleted_messages".equals(s))
        {
            m.b("GcmIntentService", (new StringBuilder()).append("GcmIntentService::onHandleIntent, type=MESSAGE_TYPE_DELETED, extras=").append(bundle.toString()).toString());
        } else
        if ("gcm".equals(s))
        {
            if (!com.cyberlink.beautycircle.a.a(this, intent, a(), 0x7f0206ea))
            {
                a(bundle.getString("Title", ""), bundle.getString("Msg", ""), bundle.getString("TickerText", ""));
            }
            m.c("GcmIntentService", (new StringBuilder()).append("Received: ").append(bundle.toString()).toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

}
