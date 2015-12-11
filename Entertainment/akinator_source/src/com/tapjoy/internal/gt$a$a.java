// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class g extends g
    implements g
{

    private int b;
    private Object c;
    private int d;
    private Object e;
    private Object f;
    private Object g;

    static g i()
    {
        return new <init>();
    }

    private <init> j()
    {
        return (new <init>()).a(e());
    }

    public final e a()
    {
        return j();
    }

    public final j a(int k)
    {
        b = b | 2;
        d = k;
        return this;
    }

    public final d a(d d1)
    {
        if (d1 == d())
        {
            return this;
        }
        if (d1.d())
        {
            b = b | 1;
            c = c(d1);
        }
        if (d1.c())
        {
            a(d1.a());
        }
        if (d1.a())
        {
            b = b | 4;
            e = e(d1);
        }
        if (d1.e())
        {
            b = b | 8;
            f = f(d1);
        }
        if (d1.f())
        {
            b = b | 0x10;
            g = g(d1);
        }
        super.g = super.g.a(g(d1));
        return this;
    }

    public final g a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 1;
            c = s;
            return this;
        }
    }

    public final c b()
    {
        return j();
    }

    public final j b(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 4;
            e = s;
            return this;
        }
    }

    public final e c(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 8;
            f = s;
            return this;
        }
    }

    public final Object clone()
    {
        return j();
    }

    public final j d(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 0x10;
            g = s;
            return this;
        }
    }

    public final boolean d()
    {
        return true;
    }

    public final g e()
    {
        int l = 1;
        g g1 = new nit>(this, (byte)0);
        int i1 = b;
        int k;
        if ((i1 & 1) != 1)
        {
            l = 0;
        }
        b(g1, c);
        k = l;
        if ((i1 & 2) == 2)
        {
            k = l | 2;
        }
        c(g1, d);
        l = k;
        if ((i1 & 4) == 4)
        {
            l = k | 4;
        }
        d(g1, e);
        k = l;
        if ((i1 & 8) == 8)
        {
            k = l | 8;
        }
        e(g1, f);
        l = k;
        if ((i1 & 0x10) == 16)
        {
            l = k | 0x10;
        }
        f(g1, g);
        g(g1, l);
        return g1;
    }

    public final boolean f()
    {
        return (b & 4) == 4;
    }

    public final String g()
    {
        Object obj = e;
        if (!(obj instanceof String))
        {
            obj = (do)obj;
            String s = ((do) (obj)).f();
            if (((do) (obj)).g())
            {
                e = s;
            }
            return s;
        } else
        {
            return (String)obj;
        }
    }

    public final e h()
    {
        b = b & -5;
        e = e().e();
        return this;
    }

    private ion()
    {
        c = "";
        e = "";
        f = "";
        g = "";
    }
}
