// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class t extends Enum
{

    public static final t a;
    public static final t b;
    private static final t d[];
    final String c;

    private t(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static t valueOf(String s)
    {
        return (t)Enum.valueOf(com/wishabi/flipp/b/t, s);
    }

    public static t[] values()
    {
        return (t[])d.clone();
    }

    static 
    {
        a = new t("LISTINGS", 0, "Listings");
        b = new t("SEARCH", 1, "Search");
        d = (new t[] {
            a, b
        });
    }
}
