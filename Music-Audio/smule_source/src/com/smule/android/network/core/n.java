// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;


public final class n extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    private static final n d[];

    private n(String s, int i)
    {
        super(s, i);
    }

    public static n valueOf(String s)
    {
        return (n)Enum.valueOf(com/smule/android/network/core/n, s);
    }

    public static n[] values()
    {
        return (n[])d.clone();
    }

    static 
    {
        a = new n("V0", 0);
        b = new n("V1", 1);
        c = new n("V2", 2);
        d = (new n[] {
            a, b, c
        });
    }
}
