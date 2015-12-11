// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ax extends Enum
{

    public static final ax a;
    public static final ax b;
    public static final ax c;
    public static final ax d;
    public static final ax e;
    private static final ax g[];
    private final String f;

    private ax(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static ax valueOf(String s)
    {
        return (ax)Enum.valueOf(com/flurry/sdk/ax, s);
    }

    public static ax[] values()
    {
        return (ax[])g.clone();
    }

    public String toString()
    {
        return f;
    }

    static 
    {
        a = new ax("BANNER", 0, "banner");
        b = new ax("TAKEOVER", 1, "takeover");
        c = new ax("STREAM", 2, "stream");
        d = new ax("NATIVE", 3, "native");
        e = new ax("UNKNOWN", 4, "unknown");
        g = (new ax[] {
            a, b, c, d, e
        });
    }
}
