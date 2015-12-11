// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.a.k;
import com.smule.android.network.a.n;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.a;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.u;
import java.util.Map;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.android.network.managers:
//            q, s

public class PerformanceManager
{

    protected static PerformanceManager a = null;
    private static final String b = com/smule/android/network/managers/PerformanceManager.getName();

    private PerformanceManager()
    {
    }

    public static PerformanceManager a()
    {
        if (a == null)
        {
            a = new PerformanceManager();
        }
        return a;
    }

    private void a(u u, Object obj)
    {
        com.smule.android.network.core.a.a(u, obj);
    }

    static void a(PerformanceManager performancemanager, u u, Object obj)
    {
        performancemanager.a(u, obj);
    }

    public q a(String s1, float f, float f1)
    {
        return com.smule.android.network.managers.q.a(k.b(s1, f, f1));
    }

    public q a(String s1, String s2, String s3, String s4, Long long1, Boolean boolean1, float f, 
            float f1, String s5, Map map)
    {
        return a(s1, s2, s3, s4, long1, boolean1, f, f1, s5, map, null);
    }

    public q a(String s1, String s2, String s3, String s4, Long long1, Boolean boolean1, float f, 
            float f1, String s5, Map map, Integer integer)
    {
        return com.smule.android.network.managers.q.a(k.a(s1, s2, s3, s4, long1, boolean1, f, f1, s5, map, integer));
    }

    public s a(int i)
    {
        return com.smule.android.network.managers.s.a(k.a(n.b, Integer.valueOf(i), Integer.valueOf(15)));
    }

    public Future a(int i, PerformancesResponseCallback performancesresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(performancesresponsecallback, i) {

            final PerformancesResponseCallback a;
            final int b;
            final PerformanceManager c;

            public void run()
            {
                com.smule.android.network.managers.PerformanceManager.a(c, a, c.a(b));
            }

            
            {
                c = PerformanceManager.this;
                a = performancesresponsecallback;
                b = i;
                super();
            }
        });
    }

    public Future a(String s1, float f, float f1, NetworkResponseCallback networkresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(networkresponsecallback, s1, f, f1) {

            final NetworkResponseCallback a;
            final String b;
            final float c;
            final float d;
            final PerformanceManager e;

            public void run()
            {
                com.smule.android.network.managers.PerformanceManager.a(e, a, e.b(b, c, d));
            }

            
            {
                e = PerformanceManager.this;
                a = networkresponsecallback;
                b = s1;
                c = f;
                d = f1;
                super();
            }
        });
    }

    public Future a(String s1, float f, float f1, PerformanceResponseCallback performanceresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(performanceresponsecallback, s1, f, f1) {

            final PerformanceResponseCallback a;
            final String b;
            final float c;
            final float d;
            final PerformanceManager e;

            public void run()
            {
                com.smule.android.network.managers.PerformanceManager.a(e, a, e.a(b, c, d));
            }

            
            {
                e = PerformanceManager.this;
                a = performanceresponsecallback;
                b = s1;
                c = f;
                d = f1;
                super();
            }
        });
    }

    public Future a(String s1, NetworkResponseCallback networkresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(s1, networkresponsecallback) {

            final String a;
            final NetworkResponseCallback b;
            final PerformanceManager c;

            public void run()
            {
                o o = k.a(a);
                if (b != null)
                {
                    com.smule.android.network.managers.PerformanceManager.a(c, b, o);
                }
            }

            
            {
                c = PerformanceManager.this;
                a = s1;
                b = networkresponsecallback;
                super();
            }
        });
    }

    public o b(String s1, float f, float f1)
    {
        return k.a(s1, f, f1);
    }

}
