// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class fo extends Enum
{

    public static final fo a;
    public static final fo b;
    public static final fo c;
    private static final fo e[];
    private String d;

    private fo(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static fo a(String s)
    {
        if (b.a().equals(s))
        {
            return b;
        }
        if (c.a().equals(s))
        {
            return c;
        } else
        {
            return a;
        }
    }

    public static fo valueOf(String s)
    {
        return (fo)Enum.valueOf(com/flurry/sdk/fo, s);
    }

    public static fo[] values()
    {
        return (fo[])e.clone();
    }

    public final String a()
    {
        return d;
    }

    static 
    {
        a = new fo("Unknown", 0, "unknown");
        b = new fo("Streaming", 1, "streaming");
        c = new fo("Progressive", 2, "progressive");
        e = (new fo[] {
            a, b, c
        });
    }
}
