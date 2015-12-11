// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ju;

// Referenced classes of package com.google.android.gms.analytics:
//            d

public class c extends BroadcastReceiver
{

    static Object a = new Object();
    static ju b;
    static Boolean c;

    public c()
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
            boolean flag = l.a(context, com/google/android/gms/analytics/c, true);
            c = Boolean.valueOf(flag);
            return flag;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        g g1;
        Intent intent1;
        boolean flag;
        g1 = r.a(context).a();
        String s = intent.getStringExtra("referrer");
        intent = intent.getAction();
        g1.a("CampaignTrackingReceiver received", intent);
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent) || TextUtils.isEmpty(s))
        {
            g1.e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        flag = d.a(context);
        if (!flag)
        {
            g1.e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (f.a)
        {
            g1.f("Received unexpected installation campaign on package side");
            return;
        }
        w.a(com/google/android/gms/analytics/d);
        intent1 = new Intent(context, com/google/android/gms/analytics/d);
        intent1.putExtra("referrer", s);
        intent = ((Intent) (a));
        intent;
        JVM INSTR monitorenter ;
        context.startService(intent1);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        intent;
        JVM INSTR monitorexit ;
        throw context;
        if (b == null)
        {
            context = new ju(context, "Analytics campaign WakeLock", (byte)0);
            b = context;
            context.c();
        }
        b.a();
_L1:
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        g1.e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
          goto _L1
    }

}
