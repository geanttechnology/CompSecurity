// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;
    private static final b y[];
    private String x;

    private b(String s1, int i1, String s2)
    {
        super(s1, i1);
        x = s2;
    }

    public static b valueOf(String s1)
    {
        return (b)Enum.valueOf(com/j/a/g/b, s1);
    }

    public static b[] values()
    {
        return (b[])y.clone();
    }

    public String a()
    {
        return x;
    }

    static 
    {
        a = new b("VIEWTRACKING", 0, "views");
        b = new b("EVENTS", 1, "events");
        c = new b("ANALYTICS", 2, "analytics");
        d = new b("EXTERNAL", 3, "external");
        e = new b("GOOGLE", 4, "google");
        f = new b("MIXPANEL", 5, "mixpanel");
        g = new b("FLURRY", 6, "flurry");
        h = new b("LOCALYTICS", 7, "localytics");
        i = new b("LISTVIEWS", 8, "listviews");
        j = new b("RECYCLERVIEWS", 9, "recyclerviews");
        k = new b("VISUAL", 10, "visual");
        l = new b("ERRORS", 11, "errors");
        m = new b("SOCKETS", 12, "sockets");
        n = new b("VIEWPAGERS", 13, "viewpagers");
        o = new b("SUPPORTFRAGMENTS", 14, "supportfragments");
        p = new b("FRAGMENTS", 15, "fragments");
        q = new b("PUSH", 16, "push");
        r = new b("CODE", 17, "code");
        s = new b("BUTTONS", 18, "buttons");
        t = new b("DYNAMICVARS", 19, "dynamicvars");
        u = new b("DELAYLOAD", 20, "delay");
        v = new b("SHAKEMENU", 21, "shakemenu");
        w = new b("REQUESTERRORS", 22, "requesterrors");
        y = (new b[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w
        });
    }
}
