// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.internal.av;

public class abj
{

    private final Object a = new Object();
    private final String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;

    public abj(String s)
    {
        c = 0;
        d = -1L;
        e = -1L;
        f = 0;
        g = -1;
        b = s;
    }

    public static boolean a(Context context)
    {
        ComponentName componentname;
        int i;
        i = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (i == 0)
        {
            acb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        componentname = new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity");
        if (i == context.getPackageManager().getActivityInfo(componentname, 0).theme)
        {
            return true;
        }
        try
        {
            acb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            acb.e("Fail to fetch AdActivity theme");
            acb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        return false;
    }

    public long a()
    {
        return e;
    }

    public Bundle a(Context context, String s)
    {
        Bundle bundle;
        synchronized (a)
        {
            bundle = new Bundle();
            bundle.putString("session_id", b);
            bundle.putLong("basets", e);
            bundle.putLong("currts", d);
            bundle.putString("seq_num", s);
            bundle.putInt("preqs", g);
            bundle.putInt("pclick", c);
            bundle.putInt("pimp", f);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a(av av1, long l)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (e != -1L)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        e = l;
        d = e;
_L2:
        if (av1.c == null || av1.c.getInt("gw", 2) != 1)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        return;
        d = l;
        if (true) goto _L2; else goto _L1
_L1:
        av1;
        obj;
        JVM INSTR monitorexit ;
        throw av1;
        g = g + 1;
        obj;
        JVM INSTR monitorexit ;
    }

    public void b()
    {
        synchronized (a)
        {
            c = c + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        synchronized (a)
        {
            f = f + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
