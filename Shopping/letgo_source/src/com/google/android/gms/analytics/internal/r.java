// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import android.support.v7.kx;
import android.support.v7.vn;
import android.support.v7.vo;
import android.support.v7.wf;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            s, g, ad, q, 
//            j, m, z, a, 
//            w, ag, ah, n, 
//            ak, p

public class r
{

    private static r a;
    private final Context b;
    private final Context c;
    private final vn d;
    private final ad e;
    private final g f;
    private final wf g;
    private final n h;
    private final ah i;
    private final m j;
    private final j k;
    private final kx l;
    private final z m;
    private final a n;
    private final w o;
    private final ag p;

    protected r(s s1)
    {
        Object obj = s1.a();
        x.a(obj, "Application context can't be null");
        x.b(obj instanceof Application, "getApplicationContext didn't return the application");
        Object obj1 = s1.b();
        x.a(obj1);
        b = ((Context) (obj));
        c = ((Context) (obj1));
        d = s1.h(this);
        e = s1.g(this);
        obj1 = s1.f(this);
        ((g) (obj1)).E();
        f = ((g) (obj1));
        z z1;
        a a1;
        w w1;
        ag ag1;
        if (e().a())
        {
            f().d((new StringBuilder()).append("Google Analytics ").append(q.a).append(" is starting up.").toString());
        } else
        {
            f().d((new StringBuilder()).append("Google Analytics ").append(q.a).append(" is starting up. ").append("To enable debug logging on a device run:\n").append("  adb shell setprop log.tag.GAv4 DEBUG\n").append("  adb logcat -s GAv4").toString());
        }
        obj1 = s1.q(this);
        ((j) (obj1)).E();
        k = ((j) (obj1));
        obj1 = s1.e(this);
        ((m) (obj1)).E();
        j = ((m) (obj1));
        obj1 = s1.l(this);
        z1 = s1.d(this);
        a1 = s1.c(this);
        w1 = s1.b(this);
        ag1 = s1.a(this);
        obj = s1.a(((Context) (obj)));
        ((wf) (obj)).a(a());
        g = ((wf) (obj));
        obj = s1.i(this);
        z1.E();
        m = z1;
        a1.E();
        n = a1;
        w1.E();
        o = w1;
        ag1.E();
        p = ag1;
        s1 = s1.p(this);
        s1.E();
        i = s1;
        ((n) (obj1)).E();
        h = ((n) (obj1));
        if (e().a())
        {
            f().b("Device AnalyticsService version", q.a);
        }
        ((kx) (obj)).a();
        l = ((kx) (obj));
        ((n) (obj1)).b();
    }

    public static r a(Context context)
    {
        x.a(context);
        if (a != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorenter ;
        long l1;
        long l2;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        vn vn1 = vo.d();
        l1 = vn1.b();
        context = new r(new s(context.getApplicationContext()));
        a = context;
        kx.d();
        l1 = vn1.b() - l1;
        l2 = ((Long)ak.Q.a()).longValue();
        if (l1 <= l2)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context.f().c("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        com/google/android/gms/analytics/internal/r;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(p p1)
    {
        x.a(p1, "Analytics service not created/initialized");
        x.b(p1.C(), "Analytics service not initialized");
    }

    protected Thread.UncaughtExceptionHandler a()
    {
        return new Thread.UncaughtExceptionHandler() {

            final r a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                thread = a.g();
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
    }

    public Context b()
    {
        return b;
    }

    public Context c()
    {
        return c;
    }

    public vn d()
    {
        return d;
    }

    public ad e()
    {
        return e;
    }

    public g f()
    {
        a(f);
        return f;
    }

    public g g()
    {
        return f;
    }

    public wf h()
    {
        x.a(g);
        return g;
    }

    public n i()
    {
        a(h);
        return h;
    }

    public ah j()
    {
        a(i);
        return i;
    }

    public kx k()
    {
        x.a(l);
        x.b(l.c(), "Analytics instance not initialized");
        return l;
    }

    public m l()
    {
        a(j);
        return j;
    }

    public j m()
    {
        a(k);
        return k;
    }

    public j n()
    {
        if (k == null || !k.C())
        {
            return null;
        } else
        {
            return k;
        }
    }

    public a o()
    {
        a(n);
        return n;
    }

    public z p()
    {
        a(m);
        return m;
    }

    public w q()
    {
        a(o);
        return o;
    }

    public ag r()
    {
        return p;
    }

    public void s()
    {
        wf.d();
    }
}
