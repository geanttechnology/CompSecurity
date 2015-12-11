// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;


public final class n extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;
    private static final n f[];

    private n(String s, int i)
    {
        super(s, i);
    }

    public static n valueOf(String s)
    {
        return (n)Enum.valueOf(com/shazam/android/ae/n, s);
    }

    public static n[] values()
    {
        return (n[])f.clone();
    }

    static 
    {
        a = new n("V", 0);
        b = new n("D", 1);
        c = new n("I", 2);
        d = new n("W", 3);
        e = new n("E", 4);
        f = (new n[] {
            a, b, c, d, e
        });
    }
}
