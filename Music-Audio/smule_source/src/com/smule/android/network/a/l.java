// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;


public final class l extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    private static final l d[];

    private l(String s, int i)
    {
        super(s, i);
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/smule/android/network/a/l, s);
    }

    public static l[] values()
    {
        return (l[])d.clone();
    }

    static 
    {
        a = new l("ACTIVESEED", 0);
        b = new l("SEED", 1);
        c = new l("FILLED", 2);
        d = (new l[] {
            a, b, c
        });
    }
}
