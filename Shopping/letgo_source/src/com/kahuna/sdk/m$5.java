// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.support.v7.ahg;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.kahuna.sdk:
//            m, c

class nit>
    implements Runnable
{

    final ahg a;
    final String b;
    final m c;

    public void run()
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("id", a.a());
            hashmap.put("status", b);
            hashmap.put("type", "beacon");
            if (a.c() > -1)
            {
                hashmap.put("major", Integer.valueOf(a.c()));
            }
            if (a.d() > -1)
            {
                hashmap.put("minor", Integer.valueOf(a.d()));
            }
            c c1 = new c("k_user_location", System.currentTimeMillis() / 1000L);
            c1.c(hashmap);
            m.a(c, c1);
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackRegionMonitoringEvent(): ").append(exception).toString());
        }
    }

    ahg(m m1, ahg ahg1, String s)
    {
        c = m1;
        a = ahg1;
        b = s;
        super();
    }
}
