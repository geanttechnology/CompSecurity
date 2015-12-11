// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;


public final class t extends Enum
{

    public static final t a;
    public static final t b;
    public static final t c;
    public static final t d;
    private static final t e[];

    private t(String s, int i)
    {
        super(s, i);
    }

    public static t valueOf(String s)
    {
        return (t)Enum.valueOf(com/j/a/g/t, s);
    }

    public static t[] values()
    {
        return (t[])e.clone();
    }

    static 
    {
        a = new t("EXPERIMENT", 0);
        b = new t("TAP", 1);
        c = new t("ACTIVITY", 2);
        d = new t("BUTTON", 3);
        e = (new t[] {
            a, b, c, d
        });
    }
}
