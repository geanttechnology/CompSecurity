// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xz, xu, 
//            ye

public static final class c extends xv
{

    private static volatile d k[];
    public int a[];
    public int b[];
    public int c[];
    public int d[];
    public int e[];
    public int f[];
    public int g[];
    public int h[];
    public int i[];
    public int j[];

    public static c[] a()
    {
        if (k == null)
        {
            synchronized (xz.a)
            {
                if (k == null)
                {
                    k = new k[0];
                }
            }
        }
        return k;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(xu xu1)
        throws IOException
    {
        boolean flag = false;
        if (a != null && a.length > 0)
        {
            for (int l = 0; l < a.length; l++)
            {
                xu1.a(1, a[l]);
            }

        }
        if (b != null && b.length > 0)
        {
            for (int i1 = 0; i1 < b.length; i1++)
            {
                xu1.a(2, b[i1]);
            }

        }
        if (c != null && c.length > 0)
        {
            for (int j1 = 0; j1 < c.length; j1++)
            {
                xu1.a(3, c[j1]);
            }

        }
        if (d != null && d.length > 0)
        {
            for (int k1 = 0; k1 < d.length; k1++)
            {
                xu1.a(4, d[k1]);
            }

        }
        if (e != null && e.length > 0)
        {
            for (int l1 = 0; l1 < e.length; l1++)
            {
                xu1.a(5, e[l1]);
            }

        }
        if (f != null && f.length > 0)
        {
            for (int i2 = 0; i2 < f.length; i2++)
            {
                xu1.a(6, f[i2]);
            }

        }
        if (g != null && g.length > 0)
        {
            for (int j2 = 0; j2 < g.length; j2++)
            {
                xu1.a(7, g[j2]);
            }

        }
        if (h != null && h.length > 0)
        {
            for (int k2 = 0; k2 < h.length; k2++)
            {
                xu1.a(8, h[k2]);
            }

        }
        if (i != null && i.length > 0)
        {
            for (int l2 = 0; l2 < i.length; l2++)
            {
                xu1.a(9, i[l2]);
            }

        }
        if (j != null && j.length > 0)
        {
            for (int i3 = ((flag) ? 1 : 0); i3 < j.length; i3++)
            {
                xu1.a(10, j[i3]);
            }

        }
        super.a(xu1);
    }

    protected int b()
    {
        boolean flag = false;
        int k1 = super.b();
        int i1;
        int j1;
        if (a != null && a.length > 0)
        {
            int l = 0;
            j1 = 0;
            for (; l < a.length; l++)
            {
                j1 += xu.b(a[l]);
            }

            j1 = k1 + j1 + a.length * 1;
        } else
        {
            j1 = k1;
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1;
            if (b.length > 0)
            {
                i1 = 0;
                k1 = 0;
                for (; i1 < b.length; i1++)
                {
                    k1 += xu.b(b[i1]);
                }

                i1 = j1 + k1 + b.length * 1;
            }
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1;
            if (c.length > 0)
            {
                j1 = 0;
                k1 = 0;
                for (; j1 < c.length; j1++)
                {
                    k1 += xu.b(c[j1]);
                }

                j1 = i1 + k1 + c.length * 1;
            }
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1;
            if (d.length > 0)
            {
                i1 = 0;
                k1 = 0;
                for (; i1 < d.length; i1++)
                {
                    k1 += xu.b(d[i1]);
                }

                i1 = j1 + k1 + d.length * 1;
            }
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1;
            if (e.length > 0)
            {
                j1 = 0;
                k1 = 0;
                for (; j1 < e.length; j1++)
                {
                    k1 += xu.b(e[j1]);
                }

                j1 = i1 + k1 + e.length * 1;
            }
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1;
            if (f.length > 0)
            {
                i1 = 0;
                k1 = 0;
                for (; i1 < f.length; i1++)
                {
                    k1 += xu.b(f[i1]);
                }

                i1 = j1 + k1 + f.length * 1;
            }
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1;
            if (g.length > 0)
            {
                j1 = 0;
                k1 = 0;
                for (; j1 < g.length; j1++)
                {
                    k1 += xu.b(g[j1]);
                }

                j1 = i1 + k1 + g.length * 1;
            }
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1;
            if (h.length > 0)
            {
                i1 = 0;
                k1 = 0;
                for (; i1 < h.length; i1++)
                {
                    k1 += xu.b(h[i1]);
                }

                i1 = j1 + k1 + h.length * 1;
            }
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1;
            if (i.length > 0)
            {
                j1 = 0;
                k1 = 0;
                for (; j1 < i.length; j1++)
                {
                    k1 += xu.b(i[j1]);
                }

                j1 = i1 + k1 + i.length * 1;
            }
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1;
            if (j.length > 0)
            {
                k1 = 0;
                for (i1 = ((flag) ? 1 : 0); i1 < j.length; i1++)
                {
                    k1 += xu.b(j[i1]);
                }

                i1 = j1 + k1 + j.length * 1;
            }
        }
        return i1;
    }

    public j c()
    {
        a = ye.a;
        b = ye.a;
        c = ye.a;
        d = ye.a;
        e = ye.a;
        f = ye.a;
        g = ye.a;
        h = ye.a;
        i = ye.a;
        j = ye.a;
        r = null;
        s = -1;
        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof s)
            {
                obj = (s)obj;
                flag = flag1;
                if (xz.a(a, ((a) (obj)).a))
                {
                    flag = flag1;
                    if (xz.a(b, ((b) (obj)).b))
                    {
                        flag = flag1;
                        if (xz.a(c, ((c) (obj)).c))
                        {
                            flag = flag1;
                            if (xz.a(d, ((d) (obj)).d))
                            {
                                flag = flag1;
                                if (xz.a(e, ((e) (obj)).e))
                                {
                                    flag = flag1;
                                    if (xz.a(f, ((f) (obj)).f))
                                    {
                                        flag = flag1;
                                        if (xz.a(g, ((g) (obj)).g))
                                        {
                                            flag = flag1;
                                            if (xz.a(h, ((h) (obj)).h))
                                            {
                                                flag = flag1;
                                                if (xz.a(i, ((i) (obj)).i))
                                                {
                                                    flag = flag1;
                                                    if (xz.a(j, ((j) (obj)).j))
                                                    {
                                                        return a(((xv) (obj)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ((((((((((xz.a(a) + 527) * 31 + xz.a(b)) * 31 + xz.a(c)) * 31 + xz.a(d)) * 31 + xz.a(e)) * 31 + xz.a(f)) * 31 + xz.a(g)) * 31 + xz.a(h)) * 31 + xz.a(i)) * 31 + xz.a(j)) * 31 + d();
    }

    public ()
    {
        c();
    }
}
