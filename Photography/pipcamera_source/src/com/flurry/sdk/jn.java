// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class jn extends Enum
{

    public static final jn a;
    public static final jn b;
    public static final jn c;
    private static final jn f[];
    public final int d;
    public final boolean e;

    private jn(String s, int i, int j, boolean flag)
    {
        super(s, i);
        d = j;
        e = flag;
    }

    public static jn valueOf(String s)
    {
        return (jn)Enum.valueOf(com/flurry/sdk/jn, s);
    }

    public static jn[] values()
    {
        return (jn[])f.clone();
    }

    static 
    {
        a = new jn("DeviceId", 0, 0, true);
        b = new jn("Sha1Imei", 1, 5, false);
        c = new jn("AndroidAdvertisingId", 2, 13, true);
        f = (new jn[] {
            a, b, c
        });
    }
}
