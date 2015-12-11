// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


public final class s extends Enum
{

    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final s e;
    public static final s f;
    public static final s g;
    public static final s h;
    private static final s i[];

    private s(String s1, int j)
    {
        super(s1, j);
    }

    public static s valueOf(String s1)
    {
        return (s)Enum.valueOf(com/facebook/s, s1);
    }

    public static s[] values()
    {
        return (s[])i.clone();
    }

    static 
    {
        a = new s("REQUESTS", 0);
        b = new s("INCLUDE_ACCESS_TOKENS", 1);
        c = new s("INCLUDE_RAW_RESPONSES", 2);
        d = new s("CACHE", 3);
        e = new s("APP_EVENTS", 4);
        f = new s("DEVELOPER_ERRORS", 5);
        g = new s("GRAPH_API_DEBUG_WARNING", 6);
        h = new s("GRAPH_API_DEBUG_INFO", 7);
        i = (new s[] {
            a, b, c, d, e, f, g, h
        });
    }
}
