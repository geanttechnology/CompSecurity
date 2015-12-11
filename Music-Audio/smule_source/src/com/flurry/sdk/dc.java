// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class dc extends Enum
{

    public static final dc a;
    public static final dc b;
    public static final dc c;
    public static final dc d;
    private static final dc f[];
    private int e;

    private dc(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static dc valueOf(String s)
    {
        return (dc)Enum.valueOf(com/flurry/sdk/dc, s);
    }

    public static dc[] values()
    {
        return (dc[])f.clone();
    }

    static 
    {
        a = new dc("Unknown", 0, 0);
        b = new dc("Linear", 1, 1);
        c = new dc("NonLinearAds", 2, 2);
        d = new dc("CompanionAds", 3, 3);
        f = (new dc[] {
            a, b, c, d
        });
    }
}
