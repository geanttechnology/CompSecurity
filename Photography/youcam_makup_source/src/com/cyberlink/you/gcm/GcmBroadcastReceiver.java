// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.cyberlink.you.u;

// Referenced classes of package com.cyberlink.you.gcm:
//            GcmIntentService

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver
{

    public GcmBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent == null)
        {
            return;
        } else
        {
            String s = intent.getAction();
            Log.d("GcmBroadcastReceiver", (new StringBuilder()).append("onReceive: ").append(s).toString());
            u.a(context);
            startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), com/cyberlink/you/gcm/GcmIntentService.getName())));
            setResultCode(-1);
            return;
        }
    }
}
