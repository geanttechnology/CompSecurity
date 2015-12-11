// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;


public final class k extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    private static final k f[];

    private k(String s, int i)
    {
        super(s, i);
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/mopub/b/k, s);
    }

    public static k[] values()
    {
        return (k[])f.clone();
    }

    static 
    {
        a = new k("LOADING", 0);
        b = new k("DEFAULT", 1);
        c = new k("RESIZED", 2);
        d = new k("EXPANDED", 3);
        e = new k("HIDDEN", 4);
        f = (new k[] {
            a, b, c, d, e
        });
    }
}
