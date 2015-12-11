// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


public final class q extends Enum
{

    public static final q a;
    public static final q b;
    public static final q c;
    public static final q d;
    public static final q e;
    public static final q f;
    public static final q g;
    public static final q h;
    private static final q i[];

    private q(String s, int j)
    {
        super(s, j);
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/facebook/q, s);
    }

    public static q[] values()
    {
        return (q[])i.clone();
    }

    static 
    {
        a = new q("REQUESTS", 0);
        b = new q("INCLUDE_ACCESS_TOKENS", 1);
        c = new q("INCLUDE_RAW_RESPONSES", 2);
        d = new q("CACHE", 3);
        e = new q("APP_EVENTS", 4);
        f = new q("DEVELOPER_ERRORS", 5);
        g = new q("GRAPH_API_DEBUG_WARNING", 6);
        h = new q("GRAPH_API_DEBUG_INFO", 7);
        i = (new q[] {
            a, b, c, d, e, f, g, h
        });
    }
}
