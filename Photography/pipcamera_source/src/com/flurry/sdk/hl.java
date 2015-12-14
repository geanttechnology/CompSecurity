// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kj, js, jb, lf, 
//            lt, kg, lh, iy, 
//            ig, ii, jd

public class hl
    implements kj
{

    private static final String a = com/flurry/sdk/hl.getSimpleName();
    private ig b;
    private iy c;
    private ii d;

    public hl()
    {
    }

    public static hl a()
    {
        com/flurry/sdk/hl;
        JVM INSTR monitorenter ;
        hl hl1 = (hl)js.a().a(com/flurry/sdk/hl);
        com/flurry/sdk/hl;
        JVM INSTR monitorexit ;
        return hl1;
        Exception exception;
        exception;
        throw exception;
    }

    private jb a(lf lf1)
    {
        if (lf1 == null)
        {
            return null;
        } else
        {
            return (jb)lf1.c(com/flurry/sdk/jb);
        }
    }

    private void b(Context context)
    {
        if (!lt.a(context, "android.permission.INTERNET"))
        {
            kg.b(a, "Application must declare permission: android.permission.INTERNET");
        }
        if (!lt.a(context, "android.permission.ACCESS_NETWORK_STATE"))
        {
            kg.e(a, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
        }
    }

    private jb h()
    {
        return a(lh.a().e());
    }

    public FlurryEventRecordStatus a(String s)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, null, false);
        }
        return flurryeventrecordstatus;
    }

    public FlurryEventRecordStatus a(String s, String s1, Map map)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, s1, map, false);
        }
        return flurryeventrecordstatus;
    }

    public FlurryEventRecordStatus a(String s, Map map)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, map, false);
        }
        return flurryeventrecordstatus;
    }

    public FlurryEventRecordStatus a(String s, Map map, boolean flag)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, map, flag);
        }
        return flurryeventrecordstatus;
    }

    public FlurryEventRecordStatus a(String s, boolean flag)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, null, flag);
        }
        return flurryeventrecordstatus;
    }

    public void a(Context context)
    {
        lf.a(com/flurry/sdk/jb);
        c = new iy();
        b = new ig();
        d = new ii();
        b(context);
    }

    public void a(String s, String s1, String s2)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        if (astacktraceelement != null && astacktraceelement.length > 2)
        {
            StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length - 2];
            System.arraycopy(astacktraceelement, 2, astacktraceelement1, 0, astacktraceelement1.length);
            astacktraceelement = astacktraceelement1;
        }
        Throwable throwable = new Throwable(s1);
        throwable.setStackTrace(astacktraceelement);
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, s1, s2, throwable);
        }
    }

    public void a(String s, String s1, Throwable throwable)
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, s1, throwable.getClass().getName(), throwable);
        }
    }

    public FlurryEventRecordStatus b(String s, String s1, Map map)
    {
        jb jb1 = h();
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (jb1 != null)
        {
            flurryeventrecordstatus = jb1.a(s, jd.a(s1), map, false);
        }
        return flurryeventrecordstatus;
    }

    public void b()
    {
        if (d != null)
        {
            d.c();
            d = null;
        }
        if (c != null)
        {
            c.a();
            c = null;
        }
        if (b != null)
        {
            b.a();
            b = null;
        }
        lf.b(com/flurry/sdk/jb);
    }

    public void b(String s)
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, null);
        }
    }

    public void b(String s, Map map)
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, map);
        }
    }

    public ig c()
    {
        return b;
    }

    public void c(String s)
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, null, false);
        }
    }

    public void c(String s, Map map)
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a(s, map, false);
        }
    }

    public iy d()
    {
        return c;
    }

    public ii e()
    {
        return d;
    }

    public void f()
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.a();
        }
    }

    public void g()
    {
        jb jb1 = h();
        if (jb1 != null)
        {
            jb1.b();
        }
    }

}
