// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;


public final class g extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    private static final g f[];

    private g(String s, int i)
    {
        super(s, i);
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/appnexus/opensdk/b/g, s);
    }

    public static g[] values()
    {
        return (g[])f.clone();
    }

    static 
    {
        a = new g("CONNECTION_FAILURE", 0);
        b = new g("URI_SYNTAX_ERROR", 1);
        c = new g("NO_HTTP_RESPONSE", 2);
        d = new g("HTTP_PROTOCOL_ERROR", 3);
        e = new g("TRANSPORT_ERROR", 4);
        f = (new g[] {
            a, b, c, d, e
        });
    }
}
