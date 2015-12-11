// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    private static final c i[];
    final boolean h;

    private c(String s, int j, boolean flag)
    {
        super(s, j);
        h = flag;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/facebook/c, s);
    }

    public static c[] values()
    {
        return (c[])i.clone();
    }

    static 
    {
        a = new c("NONE", 0, false);
        b = new c("FACEBOOK_APPLICATION_WEB", 1, true);
        c = new c("FACEBOOK_APPLICATION_NATIVE", 2, true);
        d = new c("FACEBOOK_APPLICATION_SERVICE", 3, true);
        e = new c("WEB_VIEW", 4, false);
        f = new c("TEST_USER", 5, true);
        g = new c("CLIENT_TOKEN", 6, true);
        i = (new c[] {
            a, b, c, d, e, f, g
        });
    }
}
