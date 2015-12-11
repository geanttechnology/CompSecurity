// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c f[];
    final boolean d;
    final boolean e;

    private c(String s, int i, boolean flag, boolean flag1)
    {
        super(s, i);
        d = flag;
        e = flag1;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/facebook/login/c, s);
    }

    public static c[] values()
    {
        return (c[])f.clone();
    }

    static 
    {
        a = new c("NATIVE_WITH_FALLBACK", 0, true, true);
        b = new c("NATIVE_ONLY", 1, true, false);
        c = new c("WEB_ONLY", 2, false, true);
        f = (new c[] {
            a, b, c
        });
    }
}
