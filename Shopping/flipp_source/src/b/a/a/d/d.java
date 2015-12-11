// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.b;
import b.a.a.f;
import b.a.a.i;
import b.a.a.z;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            u, t, y, x

public final class d
{

    public final x a;
    public final t b;
    public final Locale c;
    public final boolean d;
    public final a e;
    public final i f;
    public final Integer g;
    public final int h;

    public d(x x1, t t1)
    {
        a = x1;
        b = t1;
        c = null;
        d = false;
        e = null;
        f = null;
        g = null;
        h = 2000;
    }

    public d(x x1, t t1, Locale locale, boolean flag, a a1, i j, Integer integer, 
            int k)
    {
        a = x1;
        b = t1;
        c = locale;
        d = flag;
        e = a1;
        f = j;
        g = integer;
        h = k;
    }

    public final a a(a a1)
    {
        a1 = b.a.a.f.a(a1);
        if (e != null)
        {
            a1 = e;
        }
        a a2 = a1;
        if (f != null)
        {
            a2 = a1.a(f);
        }
        return a2;
    }

    public final b a(String s)
    {
        t t1 = b();
        Object obj = a(((a) (null)));
        u u1 = new u(((a) (obj)), c, g, h);
        int j = t1.a(u1, s, 0);
        if (j >= 0)
        {
            if (j >= s.length())
            {
                long l = u1.a(s);
                if (d && u1.c != null)
                {
                    s = ((a) (obj)).a(i.a(u1.c.intValue()));
                } else
                {
                    s = ((String) (obj));
                    if (u1.b != null)
                    {
                        s = ((a) (obj)).a(u1.b);
                    }
                }
                s = new b(l, s);
                if (f != null)
                {
                    obj = f;
                    obj = b.a.a.f.a(((b.a.a.a.d) (s)).b.a(((i) (obj))));
                    if (obj == ((b.a.a.a.d) (s)).b)
                    {
                        return s;
                    } else
                    {
                        return new b(((b.a.a.a.d) (s)).a, ((a) (obj)));
                    }
                } else
                {
                    return s;
                }
            }
        } else
        {
            j = ~j;
        }
        throw new IllegalArgumentException(b.a.a.d.y.b(s, j));
    }

    public final d a(i j)
    {
        if (f == j)
        {
            return this;
        } else
        {
            return new d(a, b, c, false, e, j, g, h);
        }
    }

    public final x a()
    {
        x x1 = a;
        if (x1 == null)
        {
            throw new UnsupportedOperationException("Printing not supported");
        } else
        {
            return x1;
        }
    }

    public final String a(z z)
    {
        StringBuffer stringbuffer = new StringBuffer(a().a());
        long l = b.a.a.f.a(z);
        z = b.a.a.f.b(z);
        x x1 = a();
        a a1 = a(((a) (z)));
        z = a1.a();
        int j = z.b(l);
        long l1 = (long)j + l;
        if ((l ^ l1) < 0L && ((long)j ^ l) >= 0L)
        {
            z = i.a;
            j = 0;
        } else
        {
            l = l1;
        }
        x1.a(stringbuffer, l, a1.b(), j, z, c);
        return stringbuffer.toString();
    }

    public final t b()
    {
        t t1 = b;
        if (t1 == null)
        {
            throw new UnsupportedOperationException("Parsing not supported");
        } else
        {
            return t1;
        }
    }
}
