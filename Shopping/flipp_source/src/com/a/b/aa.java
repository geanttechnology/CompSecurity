// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;


final class aa extends Enum
{

    public static final aa a;
    public static final aa b;
    public static final aa c;
    private static final aa g[];
    final int d;
    final int e;
    final int f;

    private aa(String s, int i, int j, int k, int l)
    {
        super(s, i);
        d = j;
        e = k;
        f = l;
    }

    public static aa valueOf(String s)
    {
        return (aa)Enum.valueOf(com/a/b/aa, s);
    }

    public static aa[] values()
    {
        return (aa[])g.clone();
    }

    static 
    {
        a = new aa("MICRO", 0, 3, 96, 96);
        b = new aa("MINI", 1, 1, 512, 384);
        c = new aa("FULL", 2, 2, -1, -1);
        g = (new aa[] {
            a, b, c
        });
    }
}
