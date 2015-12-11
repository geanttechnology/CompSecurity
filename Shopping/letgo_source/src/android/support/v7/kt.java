// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.ad;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.x;

// Referenced classes of package android.support.v7:
//            ku, ww

public final class kt extends BroadcastReceiver
{

    static Object a = new Object();
    static ww b;
    static Boolean c;

    public kt()
    {
    }

    public static boolean a(Context context)
    {
        x.a(context);
        if (c != null)
        {
            return c.booleanValue();
        } else
        {
            boolean flag = l.a(context, android/support/v7/kt, false);
            c = Boolean.valueOf(flag);
            return flag;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        g g1;
        Object obj = r.a(context);
        g1 = ((r) (obj)).f();
        intent = intent.getAction();
        boolean flag;
        if (((r) (obj)).e().a())
        {
            g1.a("Device AnalyticsReceiver got", intent);
        } else
        {
            g1.a("Local AnalyticsReceiver got", intent);
        }
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(intent)) goto _L2; else goto _L1
_L1:
        flag = ku.a(context);
        obj = new Intent(context, android/support/v7/ku);
        ((Intent) (obj)).setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent = ((Intent) (a));
        intent;
        JVM INSTR monitorenter ;
        context.startService(((Intent) (obj)));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        intent;
        JVM INSTR monitorexit ;
_L2:
        return;
        if (b == null)
        {
            b = new ww(context, 1, "Analytics WakeLock");
            b.a(false);
        }
        b.a(1000L);
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
