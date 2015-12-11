// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ip;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak, r, g

public final class ad
{

    private final r a;
    private volatile Boolean b;
    private String c;
    private Set d;

    protected ad(r r1)
    {
        w.a(r1);
        a = r1;
    }

    public static boolean b()
    {
        return ((Boolean)ak.b.a()).booleanValue();
    }

    public static int c()
    {
        return ((Integer)ak.y.a()).intValue();
    }

    public static long d()
    {
        return ((Long)ak.j.a()).longValue();
    }

    public static long e()
    {
        return ((Long)ak.m.a()).longValue();
    }

    public static int f()
    {
        return ((Integer)ak.o.a()).intValue();
    }

    public static int g()
    {
        return ((Integer)ak.p.a()).intValue();
    }

    public static String h()
    {
        return (String)ak.r.a();
    }

    public static String i()
    {
        return (String)ak.q.a();
    }

    public static String j()
    {
        return (String)ak.s.a();
    }

    public static long l()
    {
        return ((Long)ak.G.a()).longValue();
    }

    public final boolean a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (b != null) goto _L4; else goto _L3
_L3:
        String s;
        Object obj;
        obj = a.a.getApplicationInfo();
        s = ip.a(a.a, Process.myPid());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((ApplicationInfo) (obj)).processName;
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!((String) (obj)).equals(s)) goto _L8; else goto _L9
_L9:
        boolean flag = true;
_L11:
        b = Boolean.valueOf(flag);
_L6:
        if ((b == null || !b.booleanValue()) && "com.google.android.gms.analytics".equals(s))
        {
            b = Boolean.TRUE;
        }
        if (b == null)
        {
            b = Boolean.TRUE;
            a.a().f("My process not in the list of running processes");
        }
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return b.booleanValue();
_L8:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Set k()
    {
        String s = (String)ak.B.a();
        if (d == null || c == null || !c.equals(s))
        {
            String as[] = TextUtils.split(s, ",");
            HashSet hashset = new HashSet();
            int j1 = as.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                String s1 = as[i1];
                try
                {
                    hashset.add(Integer.valueOf(Integer.parseInt(s1)));
                }
                catch (NumberFormatException numberformatexception) { }
                i1++;
            }
            c = s;
            d = hashset;
        }
        return d;
    }
}
