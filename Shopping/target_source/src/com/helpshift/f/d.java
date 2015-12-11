// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.f;


// Referenced classes of package com.helpshift.f:
//            c

public class d
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;

    public d(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        i = "";
        j = false;
        k = false;
        l = false;
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = s7;
    }

    public c a()
    {
        return new c(a, b, c, d, e, f, g, h, i, j, k, l);
    }

    public d a(String s)
    {
        i = s;
        return this;
    }

    public d a(boolean flag)
    {
        j = flag;
        return this;
    }

    public d b(boolean flag)
    {
        k = flag;
        return this;
    }

    public d c(boolean flag)
    {
        l = flag;
        return this;
    }
}
