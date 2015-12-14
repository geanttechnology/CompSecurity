// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.gcm:
//            GcmIntentService

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
        obj = z.b(context);
        bundle = intent.getExtras();
        s = bundle.getString("Nid", "");
        l = -1L;
        if (s == null || s.isEmpty()) goto _L2; else goto _L1
_L1:
        long l1 = Long.valueOf(s).longValue();
        l = l1;
_L4:
        long l2 = z.b(context, 0L);
        if (l <= l2)
        {
            m.b("WakefulBroadcastReceiver", (new StringBuilder()).append("Ignore this NId, because the newNId(").append(l).append(") <= curNID(").append(l2).append(")").toString());
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        m.e("WakefulBroadcastReceiver", (new StringBuilder()).append("sNId is not a number! Nid=").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
        z.a(context, l);
        Globals.d().a(0L, null);
_L6:
        startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), com/cyberlink/youcammakeup/gcm/GcmIntentService.getName())));
        setResultCode(-1);
        return;
_L2:
        String s1 = bundle.getString("HWID", "");
        if (!s1.equals(obj))
        {
            m.b("WakefulBroadcastReceiver", (new StringBuilder()).append("HWID(").append(s1).append(")not equal current deviceID(").append(((String) (obj))).append(") - >ignore!").toString());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
