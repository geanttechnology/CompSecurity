// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class do extends Enum
{

    public static final do a;
    public static final do b;
    public static final do c;
    private static final do f[];
    public final int d;
    public final boolean e;

    private do(String s, int i, int j, boolean flag)
    {
        super(s, i);
        d = j;
        e = flag;
    }

    public static do valueOf(String s)
    {
        return (do)Enum.valueOf(com/flurry/sdk/do, s);
    }

    public static do[] values()
    {
        return (do[])f.clone();
    }

    static 
    {
        a = new do("PhoneId", 0, 0, true);
        b = new do("Sha1Imei", 1, 5, false);
        c = new do("AndroidAdvertisingId", 2, 13, true);
        f = (new do[] {
            a, b, c
        });
    }
}
