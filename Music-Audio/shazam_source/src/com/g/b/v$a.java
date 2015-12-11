// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.h;
import java.net.URL;

// Referenced classes of package com.g.b:
//            v, o, d, p, 
//            w

public static final class <init>
{

    p a;
    String b;
    ring c;
    w d;
    Object e;

    private ject a(p p1)
    {
        if (p1 == null)
        {
            throw new IllegalArgumentException("url == null");
        } else
        {
            a = p1;
            return this;
        }
    }

    public final a a(d d1)
    {
        d1 = d1.toString();
        if (d1.isEmpty())
        {
            return b("Cache-Control");
        } else
        {
            return a("Cache-Control", ((String) (d1)));
        }
    }

    public final ring a(String s)
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
        s = p.b(s1);
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected url: ")).append(s1).toString());
        } else
        {
            return a(((p) (s)));
        }
    }

    public final ring a(String s, w w)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }
        if (w != null && !h.c(s))
        {
            throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must not have a request body.").toString());
        }
        if (w == null && h.b(s))
        {
            throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must have a request body.").toString());
        } else
        {
            b = s;
            d = w;
            return this;
        }
    }

    public final ring a(String s, String s1)
    {
        c.b(s, s1);
        return this;
    }

    public final  a(URL url)
    {
        if (url == null)
        {
            throw new IllegalArgumentException("url == null");
        }
        p p1 = p.a(url);
        if (p1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected url: ")).append(url).toString());
        } else
        {
            return a(p1);
        }
    }

    public final v a()
    {
        if (a == null)
        {
            throw new IllegalStateException("url == null");
        } else
        {
            return new v(this, (byte)0);
        }
    }

    public final ring b(String s)
    {
        c.b(s);
        return this;
    }

    public final ring b(String s, String s1)
    {
        c.a(s, s1);
        return this;
    }

    public ring()
    {
        b = "GET";
        c = new <init>();
    }

    private <init>(v v1)
    {
        a = v1.a;
        b = v1.b;
        d = v1.d;
        e = v1.e;
        c = v1.c.a();
    }

    c(v v1, byte byte0)
    {
        this(v1);
    }
}
