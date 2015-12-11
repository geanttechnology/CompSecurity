// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.h;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

// Referenced classes of package com.g.b:
//            o, p, d, w

public final class v
{
    public static final class a
    {

        p a;
        String b;
        o.a c;
        w d;
        Object e;

        private a a(p p1)
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

        public final a a(String s)
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

        public final a a(String s, w w)
        {
            if (s == null || s.length() == 0)
            {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (w != null && !com.g.b.a.a.h.c(s))
            {
                throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must not have a request body.").toString());
            }
            if (w == null && com.g.b.a.a.h.b(s))
            {
                throw new IllegalArgumentException((new StringBuilder("method ")).append(s).append(" must have a request body.").toString());
            } else
            {
                b = s;
                d = w;
                return this;
            }
        }

        public final a a(String s, String s1)
        {
            c.b(s, s1);
            return this;
        }

        public final a a(URL url)
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

        public final a b(String s)
        {
            c.b(s);
            return this;
        }

        public final a b(String s, String s1)
        {
            c.a(s, s1);
            return this;
        }

        public a()
        {
            b = "GET";
            c = new o.a();
        }

        private a(v v1)
        {
            a = v1.a;
            b = v1.b;
            d = v1.d;
            e = v1.e;
            c = v1.c.a();
        }

        a(v v1, byte byte0)
        {
            this(v1);
        }
    }


    final p a;
    public final String b;
    public final o c;
    public final w d;
    final Object e;
    private volatile URL f;
    private volatile URI g;
    private volatile d h;

    private v(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c.a();
        d = a1.d;
        if (a1.e != null)
        {
            a1 = ((a) (a1.e));
        } else
        {
            a1 = this;
        }
        e = a1;
    }

    v(a a1, byte byte0)
    {
        this(a1);
    }

    public final String a(String s)
    {
        return c.a(s);
    }

    public final URL a()
    {
        URL url = f;
        if (url != null)
        {
            return url;
        } else
        {
            URL url1 = a.a();
            f = url1;
            return url1;
        }
    }

    public final URI b()
    {
        URI uri;
        try
        {
            uri = g;
        }
        catch (IllegalStateException illegalstateexception)
        {
            throw new IOException(illegalstateexception.getMessage());
        }
        if (uri != null)
        {
            return uri;
        }
        uri = a.b();
        g = uri;
        return uri;
    }

    public final a c()
    {
        return new a(this, (byte)0);
    }

    public final d d()
    {
        d d1 = h;
        if (d1 != null)
        {
            return d1;
        } else
        {
            d d2 = com.g.b.d.a(c);
            h = d2;
            return d2;
        }
    }

    public final boolean e()
    {
        return a.a.equals("https");
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Request{method=")).append(b).append(", url=").append(a).append(", tag=");
        Object obj;
        if (e != this)
        {
            obj = e;
        } else
        {
            obj = null;
        }
        return stringbuilder.append(obj).append('}').toString();
    }
}
