// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ih extends Enum
{

    public static final ih a;
    public static final ih b;
    public static final ih c;
    public static final ih d;
    public static final ih e;
    public static final ih f;
    public static final ih g;
    private static final ih i[];
    private final int h;

    private ih(String s, int j, int k)
    {
        super(s, j);
        h = k;
    }

    public static ih valueOf(String s)
    {
        return (ih)Enum.valueOf(com/flurry/sdk/ih, s);
    }

    public static ih[] values()
    {
        return (ih[])i.clone();
    }

    public int a()
    {
        return h;
    }

    static 
    {
        a = new ih("HW_MACHINE", 0, 0);
        b = new ih("MODEL", 1, 1);
        c = new ih("BRAND", 2, 2);
        d = new ih("ID", 3, 3);
        e = new ih("DEVICE", 4, 4);
        f = new ih("PRODUCT", 5, 5);
        g = new ih("VERSION_RELEASE", 6, 6);
        i = (new ih[] {
            a, b, c, d, e, f, g
        });
    }
}
