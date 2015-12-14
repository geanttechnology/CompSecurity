// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            at

public class ba extends at
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final boolean f;

    public ba(ba ba1)
    {
        super(ba1);
        a = ba1.a;
        b = ba1.b;
        c = ba1.c;
        d = ba1.d;
        e = ba1.e;
        f = ba1.f;
    }

    public ba(String s, String s1, String s2, String s3, String s4, int i, int j, 
            int k, int l, boolean flag, int ai[])
    {
        super(i, j, s1, k, l, false, 0, ai);
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = flag;
    }

    public Object clone()
    {
        return r();
    }

    public String h()
    {
        return b;
    }

    public at m()
    {
        return r();
    }

    public String n()
    {
        return a;
    }

    public String o()
    {
        return c;
    }

    public String p()
    {
        return d;
    }

    public boolean q()
    {
        return f;
    }

    public ba r()
    {
        return new ba(this);
    }
}
