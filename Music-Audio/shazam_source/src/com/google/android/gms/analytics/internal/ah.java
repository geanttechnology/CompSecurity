// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, o, r, ad

public final class ah extends p
{

    boolean a;
    boolean b;
    private AlarmManager c;

    protected ah(r r1)
    {
        super(r1);
        c = (AlarmManager)super.i.a.getSystemService("alarm");
    }

    private PendingIntent d()
    {
        Intent intent = new Intent(super.i.a, com/google/android/gms/analytics/a);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(super.i.a, 0, intent, 0);
    }

    protected final void a()
    {
        ActivityInfo activityinfo;
        try
        {
            c.cancel(d());
            if (ad.e() <= 0L)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            activityinfo = super.i.a.getPackageManager().getReceiverInfo(new ComponentName(super.i.a, com/google/android/gms/analytics/a), 2);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return;
        }
        if (activityinfo == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (activityinfo.enabled)
        {
            b("Receiver registered. Using alarm for local dispatch.");
            a = true;
        }
    }

    public final void b()
    {
        o();
        w.a(a, "Receiver not registered");
        long l = ad.e();
        if (l > 0L)
        {
            c();
            long l1 = super.i.c.b();
            b = true;
            c.setInexactRepeating(2, l1 + l, 0L, d());
        }
    }

    public final void c()
    {
        o();
        b = false;
        c.cancel(d());
    }
}
