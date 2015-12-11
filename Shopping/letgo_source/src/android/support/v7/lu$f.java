// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, ye, xu, 
//            xz

public static final class a extends xv
{

    public String a[];
    public String b[];
    public d c[];
    public d d[];
    public d e[];
    public d f[];
    public d g[];
    public d h[];
    public String i;
    public String j;
    public String k;
    public String l;
    public d m;
    public float n;
    public boolean o;
    public String p[];
    public int q;

    public a a()
    {
        a = ye.f;
        b = ye.f;
        c = a();
        d = a();
        e = a();
        f = a();
        g = a();
        h = a();
        i = "";
        j = "";
        k = "0";
        l = "";
        m = null;
        n = 0.0F;
        o = false;
        p = ye.f;
        q = 0;
        r = null;
        s = -1;
        return this;
    }

    public void a(xu xu1)
        throws IOException
    {
        boolean flag = false;
        if (b != null && b.length > 0)
        {
            for (int i1 = 0; i1 < b.length; i1++)
            {
                String s = b[i1];
                if (s != null)
                {
                    xu1.a(1, s);
                }
            }

        }
        if (c != null && c.length > 0)
        {
            for (int j1 = 0; j1 < c.length; j1++)
            {
                s s1 = c[j1];
                if (s1 != null)
                {
                    xu1.a(2, s1);
                }
            }

        }
        if (d != null && d.length > 0)
        {
            for (int k1 = 0; k1 < d.length; k1++)
            {
                s s2 = d[k1];
                if (s2 != null)
                {
                    xu1.a(3, s2);
                }
            }

        }
        if (e != null && e.length > 0)
        {
            for (int l1 = 0; l1 < e.length; l1++)
            {
                s s3 = e[l1];
                if (s3 != null)
                {
                    xu1.a(4, s3);
                }
            }

        }
        if (f != null && f.length > 0)
        {
            for (int i2 = 0; i2 < f.length; i2++)
            {
                s s4 = f[i2];
                if (s4 != null)
                {
                    xu1.a(5, s4);
                }
            }

        }
        if (g != null && g.length > 0)
        {
            for (int j2 = 0; j2 < g.length; j2++)
            {
                s s5 = g[j2];
                if (s5 != null)
                {
                    xu1.a(6, s5);
                }
            }

        }
        if (h != null && h.length > 0)
        {
            for (int k2 = 0; k2 < h.length; k2++)
            {
                s s6 = h[k2];
                if (s6 != null)
                {
                    xu1.a(7, s6);
                }
            }

        }
        if (!i.equals(""))
        {
            xu1.a(9, i);
        }
        if (!j.equals(""))
        {
            xu1.a(10, j);
        }
        if (!k.equals("0"))
        {
            xu1.a(12, k);
        }
        if (!l.equals(""))
        {
            xu1.a(13, l);
        }
        if (m != null)
        {
            xu1.a(14, m);
        }
        if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
        {
            xu1.a(15, n);
        }
        if (p != null && p.length > 0)
        {
            for (int l2 = 0; l2 < p.length; l2++)
            {
                String s7 = p[l2];
                if (s7 != null)
                {
                    xu1.a(16, s7);
                }
            }

        }
        if (q != 0)
        {
            xu1.a(17, q);
        }
        if (o)
        {
            xu1.a(18, o);
        }
        if (a != null && a.length > 0)
        {
            for (int i3 = ((flag) ? 1 : 0); i3 < a.length; i3++)
            {
                String s8 = a[i3];
                if (s8 != null)
                {
                    xu1.a(19, s8);
                }
            }

        }
        super.a(xu1);
    }

    protected int b()
    {
        boolean flag = false;
        int k5 = super.b();
        int j1;
        int k1;
        int k3;
        if (b != null && b.length > 0)
        {
            int i1 = 0;
            k1 = 0;
            int l1;
            int i4;
            for (l1 = 0; i1 < b.length; l1 = i4)
            {
                String s = b[i1];
                int l4 = k1;
                i4 = l1;
                if (s != null)
                {
                    i4 = l1 + 1;
                    l4 = k1 + xu.b(s);
                }
                i1++;
                k1 = l4;
            }

            k1 = k5 + k1 + l1 * 1;
        } else
        {
            k1 = k5;
        }
        j1 = k1;
        if (c != null)
        {
            j1 = k1;
            if (c.length > 0)
            {
                j1 = k1;
                for (k1 = 0; k1 < c.length;)
                {
                    a a1 = c[k1];
                    int i2 = j1;
                    if (a1 != null)
                    {
                        i2 = j1 + xu.c(2, a1);
                    }
                    k1++;
                    j1 = i2;
                }

            }
        }
        k1 = j1;
        if (d != null)
        {
            k1 = j1;
            if (d.length > 0)
            {
                for (k1 = 0; k1 < d.length;)
                {
                    a a2 = d[k1];
                    int j2 = j1;
                    if (a2 != null)
                    {
                        j2 = j1 + xu.c(3, a2);
                    }
                    k1++;
                    j1 = j2;
                }

                k1 = j1;
            }
        }
        j1 = k1;
        if (e != null)
        {
            j1 = k1;
            if (e.length > 0)
            {
                j1 = k1;
                for (k1 = 0; k1 < e.length;)
                {
                    a a3 = e[k1];
                    int k2 = j1;
                    if (a3 != null)
                    {
                        k2 = j1 + xu.c(4, a3);
                    }
                    k1++;
                    j1 = k2;
                }

            }
        }
        k1 = j1;
        if (f != null)
        {
            k1 = j1;
            if (f.length > 0)
            {
                for (k1 = 0; k1 < f.length;)
                {
                    a a4 = f[k1];
                    int l2 = j1;
                    if (a4 != null)
                    {
                        l2 = j1 + xu.c(5, a4);
                    }
                    k1++;
                    j1 = l2;
                }

                k1 = j1;
            }
        }
        j1 = k1;
        if (g != null)
        {
            j1 = k1;
            if (g.length > 0)
            {
                j1 = k1;
                for (k1 = 0; k1 < g.length;)
                {
                    a a5 = g[k1];
                    int i3 = j1;
                    if (a5 != null)
                    {
                        i3 = j1 + xu.c(6, a5);
                    }
                    k1++;
                    j1 = i3;
                }

            }
        }
        k1 = j1;
        if (h != null)
        {
            k1 = j1;
            if (h.length > 0)
            {
                for (k1 = 0; k1 < h.length;)
                {
                    a a6 = h[k1];
                    int j3 = j1;
                    if (a6 != null)
                    {
                        j3 = j1 + xu.c(7, a6);
                    }
                    k1++;
                    j1 = j3;
                }

                k1 = j1;
            }
        }
        j1 = k1;
        if (!i.equals(""))
        {
            j1 = k1 + xu.b(9, i);
        }
        k1 = j1;
        if (!j.equals(""))
        {
            k1 = j1 + xu.b(10, j);
        }
        j1 = k1;
        if (!k.equals("0"))
        {
            j1 = k1 + xu.b(12, k);
        }
        k1 = j1;
        if (!l.equals(""))
        {
            k1 = j1 + xu.b(13, l);
        }
        k3 = k1;
        if (m != null)
        {
            k3 = k1 + xu.c(14, m);
        }
        j1 = k3;
        if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
        {
            j1 = k3 + xu.b(15, n);
        }
        k1 = j1;
        if (p != null)
        {
            k1 = j1;
            if (p.length > 0)
            {
                k1 = 0;
                k3 = 0;
                int j4;
                int i5;
                for (j4 = 0; k1 < p.length; j4 = i5)
                {
                    String s1 = p[k1];
                    k5 = k3;
                    i5 = j4;
                    if (s1 != null)
                    {
                        i5 = j4 + 1;
                        k5 = k3 + xu.b(s1);
                    }
                    k1++;
                    k3 = k5;
                }

                k1 = j1 + k3 + j4 * 2;
            }
        }
        k3 = k1;
        if (q != 0)
        {
            k3 = k1 + xu.b(17, q);
        }
        j1 = k3;
        if (o)
        {
            j1 = k3 + xu.b(18, o);
        }
        k1 = j1;
        if (a != null)
        {
            k1 = j1;
            if (a.length > 0)
            {
                int l3 = 0;
                int k4 = 0;
                for (k1 = ((flag) ? 1 : 0); k1 < a.length;)
                {
                    String s2 = a[k1];
                    k5 = l3;
                    int j5 = k4;
                    if (s2 != null)
                    {
                        j5 = k4 + 1;
                        k5 = l3 + xu.b(s2);
                    }
                    k1++;
                    l3 = k5;
                    k4 = j5;
                }

                k1 = j1 + l3 + k4 * 2;
            }
        }
        return k1;
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
        if (!(obj instanceof a)) goto _L4; else goto _L3
_L3:
        obj = (a)obj;
        flag = flag1;
        if (!xz.a(a, ((a) (obj)).a)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!xz.a(b, ((b) (obj)).b)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!xz.a(c, ((c) (obj)).c)) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (!xz.a(d, ((d) (obj)).d)) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!xz.a(e, ((e) (obj)).e)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!xz.a(f, ((f) (obj)).f)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!xz.a(g, ((g) (obj)).g)) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!xz.a(h, ((h) (obj)).h)) goto _L4; else goto _L12
_L12:
        if (i != null) goto _L14; else goto _L13
_L13:
        flag = flag1;
        if (((i) (obj)).i != null) goto _L4; else goto _L15
_L15:
        if (j != null) goto _L17; else goto _L16
_L16:
        flag = flag1;
        if (((j) (obj)).j != null) goto _L4; else goto _L18
_L18:
        if (k != null) goto _L20; else goto _L19
_L19:
        flag = flag1;
        if (((k) (obj)).k != null) goto _L4; else goto _L21
_L21:
        if (l != null) goto _L23; else goto _L22
_L22:
        flag = flag1;
        if (((l) (obj)).l != null) goto _L4; else goto _L24
_L24:
        if (m != null)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        flag = flag1;
        if (((m) (obj)).m != null) goto _L4; else goto _L25
_L25:
        flag = flag1;
        if (Float.floatToIntBits(n) == Float.floatToIntBits(((ntBits) (obj)).n))
        {
            flag = flag1;
            if (o == ((o) (obj)).o)
            {
                flag = flag1;
                if (xz.a(p, ((p) (obj)).p))
                {
                    flag = flag1;
                    if (q == ((q) (obj)).q)
                    {
                        return a(((xv) (obj)));
                    }
                }
            }
        }
          goto _L4
_L14:
        if (!i.equals(((i) (obj)).i))
        {
            return false;
        }
          goto _L15
_L17:
        if (!j.equals(((j) (obj)).j))
        {
            return false;
        }
          goto _L18
_L20:
        if (!k.equals(((k) (obj)).k))
        {
            return false;
        }
          goto _L21
_L23:
        if (!l.equals(((l) (obj)).l))
        {
            return false;
        }
          goto _L24
        if (!m.equals(((equals) (obj)).m))
        {
            return false;
        }
          goto _L25
    }

    public int hashCode()
    {
        int i2 = 0;
        int j2 = xz.a(a);
        int k2 = xz.a(b);
        int l2 = xz.a(c);
        int i3 = xz.a(d);
        int j3 = xz.a(e);
        int k3 = xz.a(f);
        int l3 = xz.a(g);
        int i4 = xz.a(h);
        int i1;
        int j1;
        int k1;
        int l1;
        char c1;
        int j4;
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        if (j == null)
        {
            j1 = 0;
        } else
        {
            j1 = j.hashCode();
        }
        if (k == null)
        {
            k1 = 0;
        } else
        {
            k1 = k.hashCode();
        }
        if (l == null)
        {
            l1 = 0;
        } else
        {
            l1 = l.hashCode();
        }
        if (m != null)
        {
            i2 = m.hashCode();
        }
        j4 = Float.floatToIntBits(n);
        if (o)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        return (((c1 + (((l1 + (k1 + (j1 + (i1 + ((((((((j2 + 527) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + j4) * 31) * 31 + xz.a(p)) * 31 + q) * 31 + d();
    }

    public ()
    {
        a();
    }
}
