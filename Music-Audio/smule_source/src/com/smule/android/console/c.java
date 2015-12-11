// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    private static final c s[];

    private c(String s1, int i1)
    {
        super(s1, i1);
    }

    public static c valueOf(String s1)
    {
        return (c)Enum.valueOf(com/smule/android/console/c, s1);
    }

    public static c[] values()
    {
        return (c[])s.clone();
    }

    static 
    {
        a = new c("_unknown_", 0);
        b = new c("_ui_exit_", 1);
        c = new c("_history_cmd_", 2);
        d = new c("history", 3);
        e = new c("help", 4);
        f = new c("env", 5);
        g = new c("ach", 6);
        h = new c("crash", 7);
        i = new c("cls", 8);
        j = new c("req", 9);
        k = new c("expire", 10);
        l = new c("settings", 11);
        m = new c("days", 12);
        n = new c("ver", 13);
        o = new c("sres", 14);
        p = new c("netinfo", 15);
        q = new c("fontsize", 16);
        r = new c("exit", 17);
        s = (new c[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r
        });
    }
}
