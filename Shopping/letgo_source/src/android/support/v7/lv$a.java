// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lv, xz, xu, 
//            ye

public static final class c extends xv
{

    private static volatile d m[];
    public int a;
    public String b;
    public d c[];
    public d d[];
    public d e[];
    public String f;
    public String g;
    public long h;
    public boolean i;
    public d j[];
    public int k[];
    public boolean l;

    public static c[] a()
    {
        if (m == null)
        {
            synchronized (xz.a)
            {
                if (m == null)
                {
                    m = new m[0];
                }
            }
        }
        return m;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(xu xu1)
        throws IOException
    {
        boolean flag = false;
        xu1.a(1, a);
        if (!b.equals(""))
        {
            xu1.a(2, b);
        }
        if (c != null && c.length > 0)
        {
            for (int i1 = 0; i1 < c.length; i1++)
            {
                m m1 = c[i1];
                if (m1 != null)
                {
                    xu1.a(3, m1);
                }
            }

        }
        if (d != null && d.length > 0)
        {
            for (int j1 = 0; j1 < d.length; j1++)
            {
                m m2 = d[j1];
                if (m2 != null)
                {
                    xu1.a(4, m2);
                }
            }

        }
        if (e != null && e.length > 0)
        {
            for (int k1 = 0; k1 < e.length; k1++)
            {
                m m3 = e[k1];
                if (m3 != null)
                {
                    xu1.a(5, m3);
                }
            }

        }
        if (!f.equals(""))
        {
            xu1.a(6, f);
        }
        if (!g.equals(""))
        {
            xu1.a(7, g);
        }
        if (h != 0L)
        {
            xu1.a(8, h);
        }
        if (l)
        {
            xu1.a(9, l);
        }
        if (k != null && k.length > 0)
        {
            for (int l1 = 0; l1 < k.length; l1++)
            {
                xu1.a(10, k[l1]);
            }

        }
        if (j != null && j.length > 0)
        {
            for (int i2 = ((flag) ? 1 : 0); i2 < j.length; i2++)
            {
                m m4 = j[i2];
                if (m4 != null)
                {
                    xu1.a(11, m4);
                }
            }

        }
        if (i)
        {
            xu1.a(12, i);
        }
        super.a(xu1);
    }

    protected int b()
    {
        boolean flag = false;
        int j2 = super.b() + xu.b(1, a);
        int i2 = j2;
        if (!b.equals(""))
        {
            i2 = j2 + xu.b(2, b);
        }
        j2 = i2;
        if (c != null)
        {
            j2 = i2;
            if (c.length > 0)
            {
                for (j2 = 0; j2 < c.length;)
                {
                    i i1 = c[j2];
                    int k2 = i2;
                    if (i1 != null)
                    {
                        k2 = i2 + xu.c(3, i1);
                    }
                    j2++;
                    i2 = k2;
                }

                j2 = i2;
            }
        }
        i2 = j2;
        if (d != null)
        {
            i2 = j2;
            if (d.length > 0)
            {
                i2 = j2;
                for (j2 = 0; j2 < d.length;)
                {
                    i j1 = d[j2];
                    int l2 = i2;
                    if (j1 != null)
                    {
                        l2 = i2 + xu.c(4, j1);
                    }
                    j2++;
                    i2 = l2;
                }

            }
        }
        j2 = i2;
        if (e != null)
        {
            j2 = i2;
            if (e.length > 0)
            {
                for (j2 = 0; j2 < e.length;)
                {
                    i k1 = e[j2];
                    int i3 = i2;
                    if (k1 != null)
                    {
                        i3 = i2 + xu.c(5, k1);
                    }
                    j2++;
                    i2 = i3;
                }

                j2 = i2;
            }
        }
        i2 = j2;
        if (!f.equals(""))
        {
            i2 = j2 + xu.b(6, f);
        }
        j2 = i2;
        if (!g.equals(""))
        {
            j2 = i2 + xu.b(7, g);
        }
        i2 = j2;
        if (h != 0L)
        {
            i2 = j2 + xu.b(8, h);
        }
        j2 = i2;
        if (l)
        {
            j2 = i2 + xu.b(9, l);
        }
        i2 = j2;
        if (k != null)
        {
            i2 = j2;
            if (k.length > 0)
            {
                i2 = 0;
                int j3 = 0;
                for (; i2 < k.length; i2++)
                {
                    j3 += xu.b(k[i2]);
                }

                i2 = j2 + j3 + k.length * 1;
            }
        }
        j2 = i2;
        if (j != null)
        {
            j2 = i2;
            if (j.length > 0)
            {
                int k3 = ((flag) ? 1 : 0);
                do
                {
                    j2 = i2;
                    if (k3 >= j.length)
                    {
                        break;
                    }
                    i l1 = j[k3];
                    j2 = i2;
                    if (l1 != null)
                    {
                        j2 = i2 + xu.c(11, l1);
                    }
                    k3++;
                    i2 = j2;
                } while (true);
            }
        }
        i2 = j2;
        if (i)
        {
            i2 = j2 + xu.b(12, i);
        }
        return i2;
    }

    public i c()
    {
        a = 1;
        b = "";
        c = a();
        d = a();
        e = a();
        f = "";
        g = "";
        h = 0L;
        i = false;
        j = a();
        k = ye.a;
        l = false;
        r = null;
        s = -1;
        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof s)) goto _L4; else goto _L3
_L3:
        obj = (s)obj;
        flag = flag1;
        if (a != ((a) (obj)).a) goto _L4; else goto _L5
_L5:
        if (b != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((b) (obj)).b != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!xz.a(c, ((c) (obj)).c)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!xz.a(d, ((d) (obj)).d)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!xz.a(e, ((e) (obj)).e)) goto _L4; else goto _L11
_L11:
        if (f != null) goto _L13; else goto _L12
_L12:
        flag = flag1;
        if (((f) (obj)).f != null) goto _L4; else goto _L14
_L14:
        if (g != null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        flag = flag1;
        if (((g) (obj)).g != null) goto _L4; else goto _L15
_L15:
        flag = flag1;
        if (h == ((h) (obj)).h)
        {
            flag = flag1;
            if (i == ((i) (obj)).i)
            {
                flag = flag1;
                if (xz.a(j, ((j) (obj)).j))
                {
                    flag = flag1;
                    if (xz.a(k, ((k) (obj)).k))
                    {
                        flag = flag1;
                        if (l == ((l) (obj)).l)
                        {
                            return a(((xv) (obj)));
                        }
                    }
                }
            }
        }
          goto _L4
_L7:
        if (!b.equals(((b) (obj)).b))
        {
            return false;
        }
          goto _L8
_L13:
        if (!f.equals(((f) (obj)).f))
        {
            return false;
        }
          goto _L14
        if (!g.equals(((g) (obj)).g))
        {
            return false;
        }
          goto _L15
    }

    public int hashCode()
    {
        char c2 = '\u04CF';
        int k1 = 0;
        int l1 = a;
        int i1;
        int j1;
        char c1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        i2 = xz.a(c);
        j2 = xz.a(d);
        k2 = xz.a(e);
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (g != null)
        {
            k1 = g.hashCode();
        }
        l2 = (int)(h ^ h >>> 32);
        if (i)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        i3 = xz.a(j);
        j3 = xz.a(k);
        if (!l)
        {
            c2 = '\u04D5';
        }
        return ((((c1 + (((j1 + ((((i1 + (l1 + 527) * 31) * 31 + i2) * 31 + j2) * 31 + k2) * 31) * 31 + k1) * 31 + l2) * 31) * 31 + i3) * 31 + j3) * 31 + c2) * 31 + d();
    }

    public ()
    {
        c();
    }
}
