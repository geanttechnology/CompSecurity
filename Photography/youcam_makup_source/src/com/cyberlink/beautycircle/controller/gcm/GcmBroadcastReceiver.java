// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.gcm:
//            a, GcmIntentService

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver
{

    public GcmBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        String s;
        Bundle bundle;
        long l;
        Globals.c(context);
        obj = a.d(context);
        bundle = intent.getExtras();
        s = bundle.getString("Nid", "");
        l = -1L;
        if (s == null || s.isEmpty()) goto _L2; else goto _L1
_L1:
        long l1 = Long.valueOf(s).longValue();
        l = l1;
_L4:
        long l2 = com.cyberlink.beautycircle.controller.gcm.a.e(context).longValue();
        if (l <= l2)
        {
            e.b(new Object[] {
                (new StringBuilder()).append("Ignore this NId, because the newNId(").append(l).append(") <= curNID(").append(l2).append(")").toString()
            });
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        e.e(new Object[] {
            (new StringBuilder()).append("sNId is not a number! Nid=").append(s).toString()
        });
        if (true) goto _L4; else goto _L3
_L3:
        a.a(context, l);
_L6:
        startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), com/cyberlink/beautycircle/controller/gcm/GcmIntentService.getName())));
        setResultCode(-1);
        return;
_L2:
        String s1 = bundle.getString("HWID", "");
        if (!s1.equals(obj))
        {
            e.b(new Object[] {
                (new StringBuilder()).append("HWID(").append(s1).append(")not equal current deviceID(").append(((String) (obj))).append(") - >ignore!").toString()
            });
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
