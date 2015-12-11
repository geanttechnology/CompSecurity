// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.f;

import java.util.List;

// Referenced classes of package com.helpshift.f:
//            a

public class b
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private int h;
    private List i;
    private Boolean j;

    public b(String s, String s1, String s2, String s3, String s4, String s5, int k, 
            boolean flag)
    {
        h = 0;
        i = null;
        j = Boolean.valueOf(true);
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = k;
        j = Boolean.valueOf(flag);
    }

    public a a()
    {
        return new a(a, b, c, d, e, f, g, i, h, j.booleanValue());
    }

    public b a(int k)
    {
        h = k;
        return this;
    }

    public b a(List list)
    {
        i = list;
        return this;
    }
}
