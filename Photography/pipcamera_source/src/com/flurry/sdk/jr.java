// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kc, kg, lg, lh, 
//            js, kb, lf, ka, 
//            ly, jj

public class jr
{

    private static final String a = com/flurry/sdk/jr.getSimpleName();
    private final kb b = new kb() {

        final jr a;

        public volatile void a(ka ka)
        {
            a((lg)ka);
        }

        public void a(lg lg1)
        {
            if (jr.a(a) != null && lg1.b != jr.a(a).get())
            {
                return;
            }
            class _cls4
            {

                static final int a[];

                static 
                {
                    a = new int[lg.a.values().length];
                    try
                    {
                        a[lg.a.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[lg.a.c.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[lg.a.d.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[lg.a.e.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls4.a[lg1.c.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                a.a(lg1.b, (Context)lg1.a.get());
                return;

            case 2: // '\002'
                a.a((Context)lg1.a.get());
                return;

            case 3: // '\003'
                a.b((Context)lg1.a.get());
                return;

            case 4: // '\004'
                kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", jr.b(a));
                break;
            }
            a.a();
        }

            
            {
                a = jr.this;
                super();
            }
    };
    private WeakReference c;
    private volatile long d;
    private volatile long e;
    private volatile long f;
    private volatile long g;
    private volatile long h;
    private String i;
    private String j;
    private Map k;

    public jr()
    {
        d = 0L;
        e = 0L;
        f = -1L;
        g = 0L;
        h = 0L;
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", b);
        k = new LinkedHashMap() {

            final jr a;

            protected boolean removeEldestEntry(java.util.Map.Entry entry)
            {
                return size() > 10;
            }

            
            {
                a = jr.this;
                super();
            }
        };
    }

    static WeakReference a(jr jr1)
    {
        return jr1.c;
    }

    static kb b(jr jr1)
    {
        return jr1.b;
    }

    private void b(lf lf, Context context)
    {
        if (lf == null || context == null)
        {
            kg.a(3, a, "Flurry session id cannot be created.");
            return;
        } else
        {
            kg.a(3, a, (new StringBuilder()).append("Flurry session id started:").append(d).toString());
            lg lg1 = new lg();
            lg1.a = new WeakReference(context);
            lg1.b = lf;
            lg1.c = lg.a.b;
            lg1.b();
            return;
        }
    }

    public void a()
    {
    }

    public void a(Context context)
    {
        long l = lh.a().c();
        if (l > 0L)
        {
            long l1 = g;
            g = (System.currentTimeMillis() - l) + l1;
        }
    }

    public void a(lf lf, Context context)
    {
        c = new WeakReference(lf);
        d = System.currentTimeMillis();
        e = SystemClock.elapsedRealtime();
        b(lf, context);
        js.a().b(new ly() {

            final jr a;

            public void a()
            {
                jj.a().c();
            }

            
            {
                a = jr.this;
                super();
            }
        });
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        i = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        k.put(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String b()
    {
        return Long.toString(d);
    }

    public void b(Context context)
    {
        f = SystemClock.elapsedRealtime() - e;
    }

    public void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        j = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public long c()
    {
        return d;
    }

    public long d()
    {
        return e;
    }

    public long e()
    {
        return f;
    }

    public long f()
    {
        return g;
    }

    public long g()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        l = SystemClock.elapsedRealtime() - e;
        if (l <= h)
        {
            break MISSING_BLOCK_LABEL_34;
        }
_L1:
        h = l;
        l = h;
        this;
        JVM INSTR monitorexit ;
        return l;
        l = h + 1L;
        h = l;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public String h()
    {
        this;
        JVM INSTR monitorenter ;
        String s = i;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String i()
    {
        this;
        JVM INSTR monitorenter ;
        String s = j;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public Map j()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = k;
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

}
