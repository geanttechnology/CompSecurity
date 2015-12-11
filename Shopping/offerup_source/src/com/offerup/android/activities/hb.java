// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;


final class hb extends Enum
{

    public static final hb a;
    public static final hb b;
    public static final hb c;
    private static hb d;
    private static final hb e[];

    private hb(String s, int i)
    {
        super(s, i);
    }

    public static hb valueOf(String s)
    {
        return (hb)Enum.valueOf(com/offerup/android/activities/hb, s);
    }

    public static hb[] values()
    {
        return (hb[])e.clone();
    }

    static 
    {
        a = new hb("UNKNOWN", 0);
        b = new hb("DEFAULT", 1);
        c = new hb("OK_GOOGLE", 2);
        d = new hb("DEEP_LINK", 3);
        e = (new hb[] {
            a, b, c, d
        });
    }
}
