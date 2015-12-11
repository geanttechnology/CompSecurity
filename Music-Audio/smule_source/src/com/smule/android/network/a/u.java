// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;


public final class u extends Enum
{

    public static final u a;
    public static final u b;
    public static final u c;
    private static final u d[];

    private u(String s, int i)
    {
        super(s, i);
    }

    public static u valueOf(String s)
    {
        return (u)Enum.valueOf(com/smule/android/network/a/u, s);
    }

    public static u[] values()
    {
        return (u[])d.clone();
    }

    static 
    {
        a = new u("KSONG", 0);
        b = new u("SONG", 1);
        c = new u("ARR", 2);
        d = (new u[] {
            a, b, c
        });
    }
}
