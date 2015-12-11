// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.support.v7.vt;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.x;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak, r, g, y, 
//            aa

public class ad
{

    private final r a;
    private volatile Boolean b;
    private String c;
    private Set d;

    protected ad(r r1)
    {
        com.google.android.gms.common.internal.x.a(r1);
        a = r1;
    }

    public String A()
    {
        return "google_analytics_v4.db";
    }

    public String B()
    {
        return "google_analytics2_v4.db";
    }

    public long C()
    {
        return 0x5265c00L;
    }

    public int D()
    {
        return ((Integer)ak.E.a()).intValue();
    }

    public int E()
    {
        return ((Integer)ak.F.a()).intValue();
    }

    public long F()
    {
        return ((Long)ak.G.a()).longValue();
    }

    public long G()
    {
        return ((Long)ak.P.a()).longValue();
    }

    public boolean a()
    {
        return f.a;
    }

    public boolean b()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (b != null) goto _L4; else goto _L3
_L3:
        String s1;
        Object obj;
        obj = a.b().getApplicationInfo();
        s1 = vt.a(a.b(), Process.myPid());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((ApplicationInfo) (obj)).processName;
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!((String) (obj)).equals(s1)) goto _L8; else goto _L9
_L9:
        boolean flag = true;
_L11:
        b = Boolean.valueOf(flag);
_L6:
        if ((b == null || !b.booleanValue()) && "com.google.android.gms.analytics".equals(s1))
        {
            b = Boolean.TRUE;
        }
        if (b == null)
        {
            b = Boolean.TRUE;
            a.f().f("My process not in the list of running processes");
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

    public boolean c()
    {
        return ((Boolean)ak.b.a()).booleanValue();
    }

    public int d()
    {
        return ((Integer)ak.u.a()).intValue();
    }

    public int e()
    {
        return ((Integer)ak.y.a()).intValue();
    }

    public int f()
    {
        return ((Integer)ak.z.a()).intValue();
    }

    public int g()
    {
        return ((Integer)ak.A.a()).intValue();
    }

    public long h()
    {
        return ((Long)ak.j.a()).longValue();
    }

    public long i()
    {
        return ((Long)ak.i.a()).longValue();
    }

    public long j()
    {
        return ((Long)ak.m.a()).longValue();
    }

    public long k()
    {
        return ((Long)ak.n.a()).longValue();
    }

    public int l()
    {
        return ((Integer)ak.o.a()).intValue();
    }

    public int m()
    {
        return ((Integer)ak.p.a()).intValue();
    }

    public long n()
    {
        return (long)((Integer)ak.C.a()).intValue();
    }

    public String o()
    {
        return (String)ak.r.a();
    }

    public String p()
    {
        return (String)ak.q.a();
    }

    public String q()
    {
        return (String)ak.s.a();
    }

    public String r()
    {
        return (String)ak.t.a();
    }

    public y s()
    {
        return com.google.android.gms.analytics.internal.y.a((String)ak.v.a());
    }

    public aa t()
    {
        return aa.a((String)ak.w.a());
    }

    public Set u()
    {
        String s1 = (String)ak.B.a();
        if (d == null || c == null || !c.equals(s1))
        {
            String as[] = TextUtils.split(s1, ",");
            HashSet hashset = new HashSet();
            int j1 = as.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                String s2 = as[i1];
                try
                {
                    hashset.add(Integer.valueOf(Integer.parseInt(s2)));
                }
                catch (NumberFormatException numberformatexception) { }
                i1++;
            }
            c = s1;
            d = hashset;
        }
        return d;
    }

    public long v()
    {
        return ((Long)ak.K.a()).longValue();
    }

    public long w()
    {
        return ((Long)ak.L.a()).longValue();
    }

    public long x()
    {
        return ((Long)ak.O.a()).longValue();
    }

    public int y()
    {
        return ((Integer)com.google.android.gms.analytics.internal.ak.f.a()).intValue();
    }

    public int z()
    {
        return ((Integer)ak.h.a()).intValue();
    }
}
