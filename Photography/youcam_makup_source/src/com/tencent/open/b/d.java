// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.SystemClock;
import com.tencent.open.utils.m;

// Referenced classes of package com.tencent.open.b:
//            g

public class d
{

    protected static d a;

    protected d()
    {
    }

    public static d a()
    {
        com/tencent/open/b/d;
        JVM INSTR monitorenter ;
        d d1;
        if (a == null)
        {
            a = new d();
        }
        d1 = a;
        com/tencent/open/b/d;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(int i, String s, String s1, String s2, String s3, Long long1, int j, 
            int k, String s4)
    {
        long l = SystemClock.elapsedRealtime() - long1.longValue();
        if (long1.longValue() == 0L || l < 0L)
        {
            l = 0L;
        }
        long1 = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
        long1.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(i).append("&code=").append(j).append("&time=").append(l).append("&rate=").append(k).append("&uin=").append(s1).append("&data=");
        s = m.a(String.valueOf(i), String.valueOf(j), String.valueOf(l), String.valueOf(k), s, s1, s2, s3, s4);
        g.a().a(long1.toString(), "GET", s, true);
    }

    public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        s = m.a(s, s3, s4, s2, s1, s5, "", s6, s7, "", "", "");
        g.a().a(s, s1, false);
    }

    public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        s = m.a(s, s3, s4, s2, s1, s5, s6, "", "", s7, s8, s9);
        g.a().a(s, s1, false);
    }
}
