// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.content.Context;
import android.util.Log;
import com.cyberlink.uma.d;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.uma.a:
//            d, b, j, h, 
//            f

public final class c
{

    public static final d a = new com.cyberlink.uma.a.d();
    private b b;
    private ScheduledExecutorService c;
    private f d;
    private j e;
    private long f;
    private int g;

    private c()
    {
        b = new b();
        c = Executors.newSingleThreadScheduledExecutor();
        c.scheduleWithFixedDelay(new Runnable() {

            final c a;

            public void run()
            {
                a.g();
            }

            
            {
                a = c.this;
                super();
            }
        }, 0x15180L, 0x15180L, TimeUnit.SECONDS);
    }


    private void a(List list)
    {
        b.d(j.a(list));
    }

    static boolean a(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.length() > 0)
            {
                try
                {
                    new URL(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return false;
                }
                flag = true;
            }
        }
        return flag;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        Log.v("Countly", (new StringBuilder()).append("onStart activityCount:").append(g).toString());
        if (e == null)
        {
            throw new IllegalStateException("init must be called before onStart");
        }
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        g = g + 1;
        if (g == 1)
        {
            b();
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void a(Context context, String s, String s1, String s2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("valid context is required");
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        if (!a(s))
        {
            throw new IllegalArgumentException("valid serverURL is required");
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (s1.length() != 0)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        throw new IllegalArgumentException("valid appKey is required");
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (s2.length() != 0)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        throw new IllegalArgumentException("valid deviceID is required");
        if (e != null && (b.b() != context || !b.c().equals(s) || !b.a().equals(s1) || !com.cyberlink.uma.a.h.a().equals(s2)))
        {
            throw new IllegalStateException("Countly cannot be reinitialized with different values");
        }
        if (e == null)
        {
            com.cyberlink.uma.a.h.a(s2);
            d = new f(context);
            b.a(context);
            b.b(s);
            b.a(s1);
            b.a(d);
            b.c(s3);
            e = new j(d);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void a(String s, Map map, int i, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            throw new IllegalStateException("init must be called before recordEvent");
        }
        break MISSING_BLOCK_LABEL_24;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        throw new IllegalArgumentException("valid key is required");
        e.a(s, map, i, d1);
        e();
        this;
        JVM INSTR monitorexit ;
    }

    void b()
    {
        f = System.nanoTime();
        b.e();
        if (e.a() > 0)
        {
            f();
        }
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        Log.v("Countly", (new StringBuilder()).append("onStop activityCount:").append(g).toString());
        if (e == null)
        {
            throw new IllegalStateException("init must be called before onStop");
        }
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (g == 0)
        {
            throw new IllegalStateException("must call onStart before onStop");
        }
        g = g - 1;
        if (g == 0)
        {
            d();
        }
        this;
        JVM INSTR monitorexit ;
    }

    void d()
    {
        b.b(h());
        f = 0L;
        if (e.a() > 0)
        {
            f();
        }
    }

    void e()
    {
        if (e.a() >= 100)
        {
            f();
        }
    }

    public void f()
    {
        List list = d.c();
        int k = list.size();
        for (int i = 0; i < k; i += 10)
        {
            a(list.subList(i, Math.min(i + 10, k)));
        }

    }

    void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (g > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        b.a(h());
        if (e.a() > 0)
        {
            f();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    int h()
    {
        long l = System.nanoTime();
        long l1 = f;
        f = l;
        return (int)Math.round((double)(l - l1) / 1000000000D);
    }

}
