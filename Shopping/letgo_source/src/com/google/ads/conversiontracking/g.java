// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;


// Referenced classes of package com.google.ads.conversiontracking:
//            j

public class g
{

    public final boolean a;
    public final boolean b;
    public final int c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public long h;

    public g(long l, String s, String s1, boolean flag, boolean flag1, String s2, 
            long l1, int i)
    {
        h = l;
        g = s;
        f = s1;
        b = flag;
        a = flag1;
        e = s2;
        d = l1;
        c = i;
    }

    public g(String s, j.c c1, boolean flag, boolean flag1)
    {
        g = s;
        b = flag1;
        a = flag;
        h = 0L;
        d = j.a();
        c = 0;
        if (!flag1 && flag)
        {
            f = j.b(c1);
            e = j.a(c1);
            return;
        } else
        {
            f = null;
            e = null;
            return;
        }
    }
}
