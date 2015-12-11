// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.b.l;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.push:
//            PushService

public class ADMPushReceiver extends l
{

    public ADMPushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Autopilot.automaticTakeOff(context);
        if (intent != null && intent.getAction() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        Logger.verbose((new StringBuilder("ADMPushReceiver - Received intent: ")).append(intent.getAction()).toString());
        if (android.os.Build.VERSION.SDK_INT < 15)
        {
            Logger.error("ADMPushReceiver - Received intent from ADM transport on an unsupported API version.");
            return;
        }
        s = intent.getAction();
        s.hashCode();
        JVM INSTR lookupswitch 2: default 88
    //                   -743092218: 144
    //                   1060266838: 129;
           goto _L3 _L4 _L5
_L3:
        byte byte0 = -1;
_L11:
        byte0;
        JVM INSTR tableswitch 0 1: default 116
    //                   0 159
    //                   1 188;
           goto _L6 _L7 _L8
_L6:
        if (!isOrderedBroadcast()) goto _L1; else goto _L9
_L9:
        setResultCode(-1);
        return;
_L5:
        if (!s.equals("com.amazon.device.messaging.intent.RECEIVE")) goto _L3; else goto _L10
_L10:
        byte0 = 0;
          goto _L11
_L4:
        if (!s.equals("com.amazon.device.messaging.intent.REGISTRATION")) goto _L3; else goto _L12
_L12:
        byte0 = 1;
          goto _L11
_L7:
        startWakefulService(context, (new Intent(context, com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE").putExtra("com.urbanairship.push.EXTRA_INTENT", intent));
          goto _L6
_L8:
        startWakefulService(context, (new Intent(context, com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED").putExtra("com.urbanairship.push.EXTRA_INTENT", intent));
          goto _L6
    }
}
