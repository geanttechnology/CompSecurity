// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.gcm.GcmReceiver;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.push:
//            PushService

public class GCMPushReceiver extends GcmReceiver
{

    public GCMPushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Autopilot.automaticTakeOff(context);
        super.onReceive(context, intent);
_L2:
        Logger.verbose((new StringBuilder("GCMPushReceiver - Received intent: ")).append(intent.getAction()).toString());
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()))
        {
            startWakefulService(context, (new Intent(context, com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE").putExtra("com.urbanairship.push.EXTRA_INTENT", intent));
        }
        return;
        SecurityException securityexception;
        securityexception;
        Logger.error("Received security exception from GcmReceiver: ", securityexception);
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()))
        {
            startWakefulService(context, (new Intent(context, com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION").putExtra("com.urbanairship.push.EXTRA_GCM_TOKEN_REFRESH", true));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
