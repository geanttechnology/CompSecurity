// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class de extends Enum
{

    public static final de a;
    public static final de b;
    public static final de c;
    public static final de d;
    public static final de e;
    public static final de f;
    public static final de g;
    public static final de h;
    public static final de i;
    public static final de j;
    public static final de k;
    public static final de l;
    public static final de m;
    public static final de n;
    public static final de o;
    public static final de p;
    public static final de q;
    private static final de s[];
    private String r;

    private de(String s1, int i1, String s2)
    {
        super(s1, i1);
        r = s2;
    }

    public static de a(String s1)
    {
        if (b.a().equals(s1))
        {
            return b;
        }
        if (c.a().equals(s1))
        {
            return c;
        }
        if (d.a().equals(s1))
        {
            return d;
        }
        if (e.a().equals(s1))
        {
            return e;
        }
        if (f.a().equals(s1))
        {
            return f;
        }
        if (g.a().equals(s1))
        {
            return g;
        }
        if (h.a().equals(s1))
        {
            return h;
        }
        if (i.a().equals(s1))
        {
            return i;
        }
        if (j.a().equals(s1))
        {
            return j;
        }
        if (k.a().equals(s1))
        {
            return k;
        }
        if (l.a().equals(s1))
        {
            return l;
        }
        if (m.a().equals(s1))
        {
            return m;
        }
        if (n.a().equals(s1))
        {
            return n;
        }
        if (o.a().equals(s1))
        {
            return o;
        }
        if (p.a().equals(s1))
        {
            return p;
        }
        if (q.a().equals(s1))
        {
            return q;
        } else
        {
            return a;
        }
    }

    public static de valueOf(String s1)
    {
        return (de)Enum.valueOf(com/flurry/sdk/de, s1);
    }

    public static de[] values()
    {
        return (de[])s.clone();
    }

    public String a()
    {
        return r;
    }

    static 
    {
        a = new de("Unknown", 0, "unknown");
        b = new de("CreativeView", 1, "creativeView");
        c = new de("Start", 2, "start");
        d = new de("Midpoint", 3, "midpoint");
        e = new de("FirstQuartile", 4, "firstQuartile");
        f = new de("ThirdQuartile", 5, "thirdQuartile");
        g = new de("Complete", 6, "complete");
        h = new de("Mute", 7, "mute");
        i = new de("UnMute", 8, "unmute");
        j = new de("Pause", 9, "pause");
        k = new de("Rewind", 10, "rewind");
        l = new de("Resume", 11, "resume");
        m = new de("FullScreen", 12, "fullscreen");
        n = new de("Expand", 13, "expand");
        o = new de("Collapse", 14, "collapse");
        p = new de("AcceptInvitation", 15, "acceptInvitation");
        q = new de("Close", 16, "close");
        s = (new de[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q
        });
    }
}
