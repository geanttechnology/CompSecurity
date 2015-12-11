// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.j.b;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

// Referenced classes of package com.shazam.h:
//            i, m, p, e, 
//            k, s, l, y, 
//            r, x, o, w, 
//            q

public final class h
    implements i
{
    public static final class a
    {

        public e a;
        public s b;
        public com.shazam.h.e.a.b c;
        public x d;
        public q e;

        public final h a()
        {
            if (!com.shazam.h.b.a.a)
            {
                throw new IllegalStateException("Http client gson configuration was not called. Please call HttpClientGsonConfiguration.configure() before using the library");
            } else
            {
                return new h(this, (byte)0);
            }
        }

        public a()
        {
            d = x.a;
            e = new w();
        }
    }


    private final String a;
    private final s b;
    private final com.shazam.h.e.a.b c;
    private final m d;
    private final p e;
    private x f;

    private h(a a1)
    {
        d = new m(a1.a, a1.e);
        e = new p(a1.b);
        a = a1.a.f;
        b = a1.b;
        c = a1.c;
        f = a1.d;
    }

    h(a a1, byte byte0)
    {
        this(a1);
    }

    private o a(URL url, y y1, boolean flag)
    {
        l.a a1 = new l.a();
        a1.a = url;
        a1.c = y1;
        a1.b = flag;
        a1.e = k.a;
        return d.a(f, a1.a());
    }

    private Object a(URL url, y y1, Class class1, boolean flag)
    {
        url = a(url, y1, flag);
        return e.a(url, class1);
    }

    private byte[] a(Object obj, r r1)
    {
        return b.a(r1).a(obj).getBytes(Charset.forName("UTF-8"));
    }

    public final o a(l l1)
    {
        if (l1.e == null)
        {
            throw new IllegalArgumentException("the http method can not be null");
        } else
        {
            return d.a(f, l1);
        }
    }

    public final o a(URL url)
    {
        return a(url, y.a, false);
    }

    public final o a(URL url, y y1)
    {
        m m1 = d;
        k k1 = com.shazam.h.k.b;
        x x = f;
        r r1 = r.e;
        y1 = m.a(y1);
        if (y1 == null)
        {
            y1 = new byte[0];
        } else
        {
            y1 = y1.getBytes(Charset.forName("UTF-8"));
        }
        return m1.a(k1, url, x, y1, r1);
    }

    public final o a(URL url, Object obj, r r1)
    {
        obj = a(obj, r1);
        return d.a(k.c, url, f, ((byte []) (obj)), r1);
    }

    public final x a()
    {
        return f;
    }

    public final Object a(l l1, Class class1)
    {
        return e.a(a(l1), class1);
    }

    public final Object a(URL url, y y1, Class class1)
    {
        return a(url, y1, class1, false);
    }

    public final Object a(URL url, Class class1)
    {
        return a(url, y.a, class1, false);
    }

    public final Object a(URL url, Object obj, r r1, Class class1)
    {
        obj = a(obj, r1);
        url = d.a(com.shazam.h.k.b, url, f, ((byte []) (obj)), r1);
        return e.a(url, class1);
    }

    public final Object a(URL url, List list, Class class1)
    {
        Object obj = new com.shazam.h.a.c.a();
        obj.b = list;
        obj.a = c;
        list = ((com.shazam.h.a.c.a) (obj)).a();
        obj = (new StringBuilder("multipart/form-data;boundary=")).append(a).toString();
        url = d.a(com.shazam.h.k.b, url, f, list, ((String) (obj)));
        return e.a(url, class1);
    }

    public final void a(x x)
    {
        f = x;
    }

    public final o b(URL url)
    {
        return a(url, y.a);
    }

    public final o b(URL url, Object obj, r r1)
    {
        obj = a(obj, r1);
        return d.a(com.shazam.h.k.b, url, f, ((byte []) (obj)), r1);
    }

    public final Object b(URL url, y y1, Class class1)
    {
        url = a(url, y1);
        return e.a(url, class1);
    }

    public final Object b(URL url, Class class1)
    {
        return a(url, y.a, class1, true);
    }

    public final Object c(URL url, Class class1)
    {
        return b(url, y.a, class1);
    }
}
