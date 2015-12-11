// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.i;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;
import com.google.android.gms.d.ja;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            s, g, q, j, 
//            m, n, a, w, 
//            ag, z, ah, f, 
//            x, ak, p, ad

public class r
{

    private static r i;
    final Context a;
    final Context b;
    public final ii c = ij.d();
    final ad d = s.b(this);
    final com.google.android.gms.analytics.internal.g e;
    final ah f;
    final j g;
    public final ag h;
    private final ja j;
    private final n k;
    private final m l;
    private final e m;
    private final z n;
    private final a o;
    private final com.google.android.gms.analytics.internal.w p;

    private r(s s1)
    {
        Object obj = s1.a;
        w.a(obj, "Application context can't be null");
        w.b(obj instanceof Application, "getApplicationContext didn't return the application");
        Object obj1 = s1.b;
        w.a(obj1);
        a = ((Context) (obj));
        b = ((Context) (obj1));
        obj1 = new com.google.android.gms.analytics.internal.g(this);
        ((com.google.android.gms.analytics.internal.g) (obj1)).p();
        e = ((com.google.android.gms.analytics.internal.g) (obj1));
        a a1;
        com.google.android.gms.analytics.internal.w w1;
        ag ag1;
        if (f.a)
        {
            a().d((new StringBuilder("Google Analytics ")).append(q.a).append(" is starting up.").toString());
        } else
        {
            a().d((new StringBuilder("Google Analytics ")).append(q.a).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        }
        obj1 = com.google.android.gms.analytics.internal.s.f(this);
        ((j) (obj1)).p();
        g = ((j) (obj1));
        obj1 = new m(this);
        ((m) (obj1)).p();
        l = ((m) (obj1));
        s1 = new n(this, s1);
        obj1 = s.a(this);
        a1 = new a(this);
        w1 = new com.google.android.gms.analytics.internal.w(this);
        ag1 = new ag(this);
        obj = ja.a(((Context) (obj)));
        obj.c = new Thread.UncaughtExceptionHandler() {

            final r a;

            public final void uncaughtException(Thread thread, Throwable throwable)
            {
                thread = a.e;
                if (thread != null)
                {
                    thread.e("Job execution failed", throwable);
                }
            }

            
            {
                a = r.this;
                super();
            }
        };
        j = ((ja) (obj));
        obj = new e(this);
        ((z) (obj1)).p();
        n = ((z) (obj1));
        a1.p();
        o = a1;
        w1.p();
        p = w1;
        ag1.p();
        h = ag1;
        obj1 = com.google.android.gms.analytics.internal.s.e(this);
        ((ah) (obj1)).p();
        f = ((ah) (obj1));
        s1.p();
        k = s1;
        if (f.a)
        {
            a().b("Device AnalyticsService version", q.a);
        }
        obj1 = ((i) (obj)).f.e();
        if (((m) (obj1)).d())
        {
            com.google.android.gms.analytics.internal.f.a().a(((m) (obj1)).e());
        }
        if (((m) (obj1)).h())
        {
            obj.c = ((m) (obj1)).i();
        }
        if (((m) (obj1)).d())
        {
            g g1 = com.google.android.gms.analytics.internal.f.a();
            if (g1 != null)
            {
                g1.a(((m) (obj1)).e());
            }
        }
        obj.a = true;
        m = ((e) (obj));
        ((n) (s1)).a.b();
    }

    public static r a(Context context)
    {
        w.a(context);
        if (i != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorenter ;
        long l1;
        long l2;
        if (i != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        ii ii1 = ij.d();
        l1 = ii1.b();
        context = new r(new s(context.getApplicationContext()));
        i = context;
        com.google.android.gms.analytics.e.a();
        l1 = ii1.b() - l1;
        l2 = ((Long)ak.Q.a()).longValue();
        if (l1 <= l2)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context.a().c("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorexit ;
_L2:
        return i;
        context;
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(p p1)
    {
        w.a(p1, "Analytics service not created/initialized");
        w.b(p1.n(), "Analytics service not initialized");
    }

    public static void i()
    {
        ja.b();
    }

    public final com.google.android.gms.analytics.internal.g a()
    {
        a(((p) (e)));
        return e;
    }

    public final ja b()
    {
        w.a(j);
        return j;
    }

    public final n c()
    {
        a(k);
        return k;
    }

    public final e d()
    {
        w.a(m);
        e e1 = m;
        boolean flag;
        if (e1.a && !e1.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.b(flag, "Analytics instance not initialized");
        return m;
    }

    public final m e()
    {
        a(l);
        return l;
    }

    public final a f()
    {
        a(o);
        return o;
    }

    public final z g()
    {
        a(n);
        return n;
    }

    public final com.google.android.gms.analytics.internal.w h()
    {
        a(p);
        return p;
    }
}
