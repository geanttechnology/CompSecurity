// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gh, gq, gg, gi, 
//            dd, gs

public final class gr
{

    private gi a;
    private String b;
    private gh c;
    private gs d;
    private Object e;

    public gr()
    {
        b = "GET";
        c = new gh();
    }

    private gr(gq gq1)
    {
        a = gq.a(gq1);
        b = gq.b(gq1);
        d = gq.c(gq1);
        e = gq.d(gq1);
        c = gq.e(gq1).b();
    }

    gr(gq gq1, byte byte0)
    {
        this(gq1);
    }

    static gi a(gr gr1)
    {
        return gr1.a;
    }

    static String b(gr gr1)
    {
        return gr1.b;
    }

    static gh c(gr gr1)
    {
        return gr1.c;
    }

    static gs d(gr gr1)
    {
        return gr1.d;
    }

    static Object e(gr gr1)
    {
        return gr1.e;
    }

    public final gq a()
    {
        if (a == null)
        {
            throw new IllegalStateException("url == null");
        } else
        {
            return new gq(this, (byte)0);
        }
    }

    public final gr a(gg gg1)
    {
        c = gg1.b();
        return this;
    }

    public final gr a(gi gi1)
    {
        if (gi1 == null)
        {
            throw new IllegalArgumentException("url == null");
        } else
        {
            a = gi1;
            return this;
        }
    }

    public final gr a(Object obj)
    {
        e = obj;
        return this;
    }

    public final gr a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("url == null");
        }
        String s1;
        if (s.regionMatches(true, 0, "ws:", 0, 3))
        {
            s1 = (new StringBuilder("http:")).append(s.substring(3)).toString();
        } else
        {
            s1 = s;
            if (s.regionMatches(true, 0, "wss:", 0, 4))
            {
                s1 = (new StringBuilder("https:")).append(s.substring(4)).toString();
            }
        }
        s = gi.d(s1);
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected url: ")).append(s1).toString());
        } else
        {
            return a(((gi) (s)));
        }
    }

    public final gr a(String s, gs gs)
    {
        if (s.length() == 0)
        {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }
        if (gs != null && !dd.d(s))
        {
            throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must not have a request body.").toString());
        }
        if (gs == null && dd.c(s))
        {
            throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must have a request body.").toString());
        } else
        {
            b = s;
            d = gs;
            return this;
        }
    }

    public final gr a(String s, String s1)
    {
        c.b(s, s1);
        return this;
    }

    public final gr b(String s)
    {
        c.b(s);
        return this;
    }

    public final gr b(String s, String s1)
    {
        c.a(s, s1);
        return this;
    }
}
