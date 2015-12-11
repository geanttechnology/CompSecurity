// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.kahuna.sdk:
//            m, c

class nit>
    implements Runnable
{

    final String a;
    final String b;
    final m c;

    public void run()
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("id", a);
            hashmap.put("status", b);
            hashmap.put("type", "circle");
            c c1 = new c("k_user_location");
            c1.c(hashmap);
            m.a(c, c1);
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackRegionMonitoringEvent(): ").append(exception).toString());
        }
    }

    (m m1, String s, String s1)
    {
        c = m1;
        a = s;
        b = s1;
        super();
    }
}
