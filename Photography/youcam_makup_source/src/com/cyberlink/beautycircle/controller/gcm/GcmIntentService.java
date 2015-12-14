// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.i;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.gcm:
//            GcmBroadcastReceiver

public class GcmIntentService extends IntentService
{

    private static int a = 0;

    public GcmIntentService()
    {
        super("GcmIntentService");
    }

    private int a()
    {
        int j = a + 1;
        a = j;
        if (j == 0x7fffffff)
        {
            a = 1;
        }
        return a;
    }

    protected void onHandleIntent(Intent intent)
    {
        Bundle bundle;
        String s;
        Globals.c(this);
        e.b(new Object[] {
            "GcmIntentService::onHandleIntent in"
        });
        bundle = intent.getExtras();
        s = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (bundle.isEmpty()) goto _L2; else goto _L1
_L1:
        if (!"send_error".equals(s)) goto _L4; else goto _L3
_L3:
        e.b(new Object[] {
            (new StringBuilder()).append("GcmIntentService::onHandleIntent, type=MESSAGE_TYPE_SEND_ERROR, extras=").append(bundle.toString()).toString()
        });
_L2:
        GcmBroadcastReceiver.completeWakefulIntent(intent);
        e.b(new Object[] {
            "GcmIntentService::onHandleIntent out"
        });
        return;
_L4:
        if ("deleted_messages".equals(s))
        {
            e.b(new Object[] {
                (new StringBuilder()).append("GcmIntentService::onHandleIntent, type=MESSAGE_TYPE_DELETED, extras=").append(bundle.toString()).toString()
            });
        } else
        if ("gcm".equals(s) && !com.cyberlink.beautycircle.a.a(this, intent, a(), i.ic_launcher))
        {
            e.b(new Object[] {
                "Need API side to handle notification"
            });
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

}
