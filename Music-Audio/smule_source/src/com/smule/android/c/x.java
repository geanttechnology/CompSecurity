// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import java.io.Serializable;

// Referenced classes of package com.smule.android.c:
//            y, w

public class x
    implements Serializable
{

    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    public x(y y1)
    {
        b = y.a(y1);
        c = y.b(y1);
        d = y.c(y1);
        e = y.d(y1);
        f = y.e(y1);
        g = y.f(y1);
        h = y.g(y1);
        i = y.h(y1);
        j = y.i(y1);
        k = y.j(y1);
        l = y.k(y1);
        m = y.l(y1);
        a = w.a(w.a());
    }

    public x(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10)
    {
        this(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, false);
    }

    public x(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, boolean flag)
    {
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = s4;
        g = s5;
        h = s6;
        i = s7;
        j = s8;
        k = s9;
        l = s10;
        m = flag;
        a = w.a(w.a());
    }

    public String toString()
    {
        return (new StringBuilder()).append("[timeStamp=").append(a).append(", eventType=").append(b).append(", target=").append(c).append(", context=").append(d).append(", value=").append(e).append(", k1=").append(f).append(", k2=").append(g).append(", k3=").append(h).append(", k4=").append(i).append(", k5=").append(j).append(", k6=").append(k).append(", k7=").append(l).append(", immediate=").append(m).append("]").toString();
    }
}
