// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;


public final class j extends Enum
{

    public static final j a;
    public static final j b;
    private static final j d[];
    private final String c;

    private j(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/j/a/a/a/j, s);
    }

    public static j[] values()
    {
        return (j[])d.clone();
    }

    public String a()
    {
        return c.toUpperCase();
    }

    static 
    {
        a = new j("EVENTS", 0, "events");
        b = new j("PEOPLE", 1, "people");
        d = (new j[] {
            a, b
        });
    }
}
