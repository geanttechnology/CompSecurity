// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ju;

// Referenced classes of package com.google.android.gms.analytics:
//            b

public final class a extends BroadcastReceiver
{

    static Object a = new Object();
    static ju b;
    static Boolean c;

    public a()
    {
    }

    public static boolean a(Context context)
    {
        w.a(context);
        if (c != null)
        {
            return c.booleanValue();
        } else
        {
            boolean flag = l.a(context, com/google/android/gms/analytics/a, false);
            c = Boolean.valueOf(flag);
            return flag;
        }
    }

    public final void onReceive(Context context, Intent intent)
    {
        g g1;
        g1 = r.a(context).a();
        intent = intent.getAction();
        Intent intent1;
        boolean flag;
        if (f.a)
        {
            g1.a("Device AnalyticsReceiver got", intent);
        } else
        {
            g1.a("Local AnalyticsReceiver got", intent);
        }
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(intent)) goto _L2; else goto _L1
_L1:
        flag = com.google.android.gms.analytics.b.a(context);
        intent1 = new Intent(context, com/google/android/gms/analytics/b);
        intent1.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent = ((Intent) (a));
        intent;
        JVM INSTR monitorenter ;
        context.startService(intent1);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        intent;
        JVM INSTR monitorexit ;
_L2:
        return;
        if (b == null)
        {
            context = new ju(context, "Analytics WakeLock", (byte)0);
            b = context;
            context.c();
        }
        b.a();
_L3:
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        intent;
        JVM INSTR monitorexit ;
        throw context;
        context;
        g1.e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
          goto _L3
    }

}
