// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.internal.ak;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.m;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.z;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            le, la, kz

public final class kx extends le
{

    private static List b = new ArrayList();
    private boolean c;
    private boolean d;
    private Set e;
    private boolean f;
    private volatile boolean g;
    private boolean h;

    public kx(r r1)
    {
        super(r1);
        e = new HashSet();
    }

    public static kx a(Context context)
    {
        return r.a(context).k();
    }

    public static void d()
    {
        android/support/v7/kx;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        android/support/v7/kx;
        JVM INSTR monitorexit ;
        throw exception;
        b = null;
        android/support/v7/kx;
        JVM INSTR monitorexit ;
    }

    private m n()
    {
        return i().l();
    }

    public la a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new la(i(), s, null);
        s.E();
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a()
    {
        b();
        c = true;
    }

    public void a(kz kz1)
    {
        com.google.android.gms.analytics.internal.f.a(kz1);
        if (!h)
        {
            Log.i((String)ak.c.a(), (new StringBuilder()).append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append((String)ak.c.a()).append(" DEBUG").toString());
            h = true;
        }
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    void b()
    {
        m m1 = n();
        if (m1.d())
        {
            g().a(m1.e());
        }
        if (m1.h())
        {
            a(m1.i());
        }
        if (m1.d())
        {
            kz kz1 = com.google.android.gms.analytics.internal.f.a();
            if (kz1 != null)
            {
                kz1.a(m1.e());
            }
        }
    }

    public boolean c()
    {
        return c && !d;
    }

    public boolean e()
    {
        return f;
    }

    public boolean f()
    {
        return g;
    }

    public kz g()
    {
        return com.google.android.gms.analytics.internal.f.a();
    }

    public String h()
    {
        x.c("getClientId can not be called from the main thread");
        return i().p().b();
    }

}
