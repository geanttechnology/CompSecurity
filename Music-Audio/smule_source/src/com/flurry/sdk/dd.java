// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class dd extends Enum
{

    public static final dd a;
    public static final dd b;
    public static final dd c;
    private static final dd e[];
    private String d;

    private dd(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static dd a(String s)
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

    public static dd valueOf(String s)
    {
        return (dd)Enum.valueOf(com/flurry/sdk/dd, s);
    }

    public static dd[] values()
    {
        return (dd[])e.clone();
    }

    public String a()
    {
        return d;
    }

    static 
    {
        a = new dd("Unknown", 0, "unknown");
        b = new dd("Streaming", 1, "streaming");
        c = new dd("Progressive", 2, "progressive");
        e = (new dd[] {
            a, b, c
        });
    }
}
