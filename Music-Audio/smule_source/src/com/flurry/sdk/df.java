// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class df extends Enum
{

    public static final df a;
    public static final df b;
    public static final df c;
    public static final df d;
    private static final df f[];
    private int e;

    private df(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static df valueOf(String s)
    {
        return (df)Enum.valueOf(com/flurry/sdk/df, s);
    }

    public static df[] values()
    {
        return (df[])f.clone();
    }

    static 
    {
        a = new df("Unknown", 0, 0);
        b = new df("ClickThrough", 1, 1);
        c = new df("ClickTracking", 2, 2);
        d = new df("CustomClick", 3, 3);
        f = (new df[] {
            a, b, c, d
        });
    }
}
