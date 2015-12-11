// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;


final class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    private static final f e[];
    final int d;

    private f(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/mopub/b/f, s);
    }

    public static f[] values()
    {
        return (f[])e.clone();
    }

    static 
    {
        a = new f("PORTRAIT", 0, 1);
        b = new f("LANDSCAPE", 1, 0);
        c = new f("NONE", 2, -1);
        e = (new f[] {
            a, b, c
        });
    }
}
