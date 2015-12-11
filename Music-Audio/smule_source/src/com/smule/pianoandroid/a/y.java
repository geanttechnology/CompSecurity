// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;


public final class y extends Enum
{

    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    private static final y e[];

    private y(String s, int i)
    {
        super(s, i);
    }

    public static y valueOf(String s)
    {
        return (y)Enum.valueOf(com/smule/pianoandroid/a/y, s);
    }

    public static y[] values()
    {
        return (y[])e.clone();
    }

    static 
    {
        a = new y("STATE_UNKNOWN", 0);
        b = new y("STATE_UPDATING", 1);
        c = new y("STATE_PROCESSED", 2);
        d = new y("STATE_NETWORK_ERROR", 3);
        e = (new y[] {
            a, b, c, d
        });
    }
}
