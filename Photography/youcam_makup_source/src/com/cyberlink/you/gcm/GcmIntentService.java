// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.cyberlink.you.a.a;
import com.cyberlink.you.g;

// Referenced classes of package com.cyberlink.you.gcm:
//            GcmBroadcastReceiver

public class GcmIntentService extends IntentService
{

    public GcmIntentService()
    {
        super("GcmIntentService");
    }

    protected void onHandleIntent(Intent intent)
    {
        Log.d("GcmIntentService", "GcmIntentService::onHandleIntent in");
        if (g.a().N().equals("v2"))
        {
            a.a();
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
        Log.d("GcmIntentService", "GcmIntentService::onHandleIntent out");
    }
}
