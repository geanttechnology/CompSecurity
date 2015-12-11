// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;


public final class m extends Enum
{

    public static final m a;
    public static final m b;
    private static final m c[];

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/smule/android/network/core/m, s);
    }

    public static m[] values()
    {
        return (m[])c.clone();
    }

    static 
    {
        a = new m("HTTP", 0);
        b = new m("HTTPS", 1);
        c = (new m[] {
            a, b
        });
    }
}
