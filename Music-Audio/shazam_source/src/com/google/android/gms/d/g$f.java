// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            kw, g, lg, kv, 
//            ku, la, lc

public static final class s extends kw
{

    public String a[];
    public String b[];
    public c c[];
    public c d[];
    public c e[];
    public c f[];
    public c g[];
    public c h[];
    public String i;
    public String j;
    public String k;
    public String l;
    public c m;
    public float n;
    public boolean o;
    public String p[];
    public int q;

    protected final int a()
    {
        boolean flag = false;
        int k5 = super.a();
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
                    l4 = k1 + kv.a(s);
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
                    s s1 = c[k1];
                    int i2 = j1;
                    if (s1 != null)
                    {
                        i2 = j1 + kv.b(2, s1);
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
                    s s2 = d[k1];
                    int j2 = j1;
                    if (s2 != null)
                    {
                        j2 = j1 + kv.b(3, s2);
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
                    s s3 = e[k1];
                    int k2 = j1;
                    if (s3 != null)
                    {
                        k2 = j1 + kv.b(4, s3);
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
                    s s4 = f[k1];
                    int l2 = j1;
                    if (s4 != null)
                    {
                        l2 = j1 + kv.b(5, s4);
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
                    s s5 = g[k1];
                    int i3 = j1;
                    if (s5 != null)
                    {
                        i3 = j1 + kv.b(6, s5);
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
                    s s6 = h[k1];
                    int j3 = j1;
                    if (s6 != null)
                    {
                        j3 = j1 + kv.b(7, s6);
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
            j1 = k1 + kv.b(9, i);
        }
        k1 = j1;
        if (!j.equals(""))
        {
            k1 = j1 + kv.b(10, j);
        }
        j1 = k1;
        if (!k.equals("0"))
        {
            j1 = k1 + kv.b(12, k);
        }
        k1 = j1;
        if (!l.equals(""))
        {
            k1 = j1 + kv.b(13, l);
        }
        k3 = k1;
        if (m != null)
        {
            k3 = k1 + kv.b(14, m);
        }
        j1 = k3;
        if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
        {
            j1 = k3 + (kv.c(15) + 4);
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
                    String s7 = p[k1];
                    k5 = k3;
                    i5 = j4;
                    if (s7 != null)
                    {
                        i5 = j4 + 1;
                        k5 = k3 + kv.a(s7);
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
            k3 = k1 + kv.b(17, q);
        }
        j1 = k3;
        if (o)
        {
            j1 = k3 + (kv.c(18) + 1);
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
                    String s8 = a[k1];
                    k5 = l3;
                    int j5 = k4;
                    if (s8 != null)
                    {
                        j5 = k4 + 1;
                        k5 = l3 + kv.a(s8);
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

    public final lc a(ku ku1)
    {
        do
        {
            int i1 = ku1.a();
            switch (i1)
            {
            default:
                if (a(ku1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int k3 = lg.a(ku1, 10);
                String as[];
                int j1;
                if (b == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = b.length;
                }
                as = new String[k3 + j1];
                k3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(b, 0, as, 0, j1);
                    k3 = j1;
                }
                for (; k3 < as.length - 1; k3++)
                {
                    as[k3] = ku1.d();
                    ku1.a();
                }

                as[k3] = ku1.d();
                b = as;
                break;

            case 18: // '\022'
                int l3 = lg.a(ku1, 18);
                 a1[];
                int k1;
                if (c == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = c.length;
                }
                a1 = new c[l3 + k1];
                l3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(c, 0, a1, 0, k1);
                    l3 = k1;
                }
                for (; l3 < a1.length - 1; l3++)
                {
                    a1[l3] = new <init>();
                    ku1.a(a1[l3]);
                    ku1.a();
                }

                a1[l3] = new <init>();
                ku1.a(a1[l3]);
                c = a1;
                break;

            case 26: // '\032'
                int i4 = lg.a(ku1, 26);
                 a2[];
                int l1;
                if (d == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = d.length;
                }
                a2 = new d[i4 + l1];
                i4 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(d, 0, a2, 0, l1);
                    i4 = l1;
                }
                for (; i4 < a2.length - 1; i4++)
                {
                    a2[i4] = new <init>();
                    ku1.a(a2[i4]);
                    ku1.a();
                }

                a2[i4] = new <init>();
                ku1.a(a2[i4]);
                d = a2;
                break;

            case 34: // '"'
                int j4 = lg.a(ku1, 34);
                 a3[];
                int i2;
                if (e == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = e.length;
                }
                a3 = new e[j4 + i2];
                j4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(e, 0, a3, 0, i2);
                    j4 = i2;
                }
                for (; j4 < a3.length - 1; j4++)
                {
                    a3[j4] = new <init>();
                    ku1.a(a3[j4]);
                    ku1.a();
                }

                a3[j4] = new <init>();
                ku1.a(a3[j4]);
                e = a3;
                break;

            case 42: // '*'
                int k4 = lg.a(ku1, 42);
                 a4[];
                int j2;
                if (f == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = f.length;
                }
                a4 = new f[k4 + j2];
                k4 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(f, 0, a4, 0, j2);
                    k4 = j2;
                }
                for (; k4 < a4.length - 1; k4++)
                {
                    a4[k4] = new <init>();
                    ku1.a(a4[k4]);
                    ku1.a();
                }

                a4[k4] = new <init>();
                ku1.a(a4[k4]);
                f = a4;
                break;

            case 50: // '2'
                int l4 = lg.a(ku1, 50);
                 a5[];
                int k2;
                if (g == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = g.length;
                }
                a5 = new g[l4 + k2];
                l4 = k2;
                if (k2 != 0)
                {
                    System.arraycopy(g, 0, a5, 0, k2);
                    l4 = k2;
                }
                for (; l4 < a5.length - 1; l4++)
                {
                    a5[l4] = new <init>();
                    ku1.a(a5[l4]);
                    ku1.a();
                }

                a5[l4] = new <init>();
                ku1.a(a5[l4]);
                g = a5;
                break;

            case 58: // ':'
                int i5 = lg.a(ku1, 58);
                 a6[];
                int l2;
                if (h == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = h.length;
                }
                a6 = new h[i5 + l2];
                i5 = l2;
                if (l2 != 0)
                {
                    System.arraycopy(h, 0, a6, 0, l2);
                    i5 = l2;
                }
                for (; i5 < a6.length - 1; i5++)
                {
                    a6[i5] = new <init>();
                    ku1.a(a6[i5]);
                    ku1.a();
                }

                a6[i5] = new <init>();
                ku1.a(a6[i5]);
                h = a6;
                break;

            case 74: // 'J'
                i = ku1.d();
                break;

            case 82: // 'R'
                j = ku1.d();
                break;

            case 98: // 'b'
                k = ku1.d();
                break;

            case 106: // 'j'
                l = ku1.d();
                break;

            case 114: // 'r'
                if (m == null)
                {
                    m = new <init>();
                }
                ku1.a(m);
                break;

            case 125: // '}'
                n = Float.intBitsToFloat(ku1.f());
                break;

            case 130: 
                int j5 = lg.a(ku1, 130);
                String as1[];
                int i3;
                if (p == null)
                {
                    i3 = 0;
                } else
                {
                    i3 = p.length;
                }
                as1 = new String[j5 + i3];
                j5 = i3;
                if (i3 != 0)
                {
                    System.arraycopy(p, 0, as1, 0, i3);
                    j5 = i3;
                }
                for (; j5 < as1.length - 1; j5++)
                {
                    as1[j5] = ku1.d();
                    ku1.a();
                }

                as1[j5] = ku1.d();
                p = as1;
                break;

            case 136: 
                q = ku1.e();
                break;

            case 144: 
                o = ku1.c();
                break;

            case 154: 
                int k5 = lg.a(ku1, 154);
                String as2[];
                int j3;
                if (a == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = a.length;
                }
                as2 = new String[k5 + j3];
                k5 = j3;
                if (j3 != 0)
                {
                    System.arraycopy(a, 0, as2, 0, j3);
                    k5 = j3;
                }
                for (; k5 < as2.length - 1; k5++)
                {
                    as2[k5] = ku1.d();
                    ku1.a();
                }

                as2[k5] = ku1.d();
                a = as2;
                break;
            }
        } while (true);
    }

    public final void a(kv kv1)
    {
        boolean flag = false;
        if (b != null && b.length > 0)
        {
            for (int i1 = 0; i1 < b.length; i1++)
            {
                String s = b[i1];
                if (s != null)
                {
                    kv1.a(1, s);
                }
            }

        }
        if (c != null && c.length > 0)
        {
            for (int j1 = 0; j1 < c.length; j1++)
            {
                a a1 = c[j1];
                if (a1 != null)
                {
                    kv1.a(2, a1);
                }
            }

        }
        if (d != null && d.length > 0)
        {
            for (int k1 = 0; k1 < d.length; k1++)
            {
                a a2 = d[k1];
                if (a2 != null)
                {
                    kv1.a(3, a2);
                }
            }

        }
        if (e != null && e.length > 0)
        {
            for (int l1 = 0; l1 < e.length; l1++)
            {
                a a3 = e[l1];
                if (a3 != null)
                {
                    kv1.a(4, a3);
                }
            }

        }
        if (f != null && f.length > 0)
        {
            for (int i2 = 0; i2 < f.length; i2++)
            {
                a a4 = f[i2];
                if (a4 != null)
                {
                    kv1.a(5, a4);
                }
            }

        }
        if (g != null && g.length > 0)
        {
            for (int j2 = 0; j2 < g.length; j2++)
            {
                a a5 = g[j2];
                if (a5 != null)
                {
                    kv1.a(6, a5);
                }
            }

        }
        if (h != null && h.length > 0)
        {
            for (int k2 = 0; k2 < h.length; k2++)
            {
                a a6 = h[k2];
                if (a6 != null)
                {
                    kv1.a(7, a6);
                }
            }

        }
        if (!i.equals(""))
        {
            kv1.a(9, i);
        }
        if (!j.equals(""))
        {
            kv1.a(10, j);
        }
        if (!k.equals("0"))
        {
            kv1.a(12, k);
        }
        if (!l.equals(""))
        {
            kv1.a(13, l);
        }
        if (m != null)
        {
            kv1.a(14, m);
        }
        if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
        {
            kv1.a(15, n);
        }
        if (p != null && p.length > 0)
        {
            for (int l2 = 0; l2 < p.length; l2++)
            {
                String s1 = p[l2];
                if (s1 != null)
                {
                    kv1.a(16, s1);
                }
            }

        }
        if (q != 0)
        {
            kv1.a(17, q);
        }
        if (o)
        {
            kv1.a(18, o);
        }
        if (a != null && a.length > 0)
        {
            for (int i3 = ((flag) ? 1 : 0); i3 < a.length; i3++)
            {
                String s2 = a[i3];
                if (s2 != null)
                {
                    kv1.a(19, s2);
                }
            }

        }
        super.a(kv1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof )) goto _L4; else goto _L3
_L3:
        obj = ()obj;
        flag = flag1;
        if (!la.a(a, ((a) (obj)).a)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!la.a(b, ((b) (obj)).b)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!la.a(c, ((c) (obj)).c)) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (!la.a(d, ((d) (obj)).d)) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!la.a(e, ((e) (obj)).e)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!la.a(f, ((f) (obj)).f)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!la.a(g, ((g) (obj)).g)) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!la.a(h, ((h) (obj)).h)) goto _L4; else goto _L12
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
        if (Float.floatToIntBits(n) == Float.floatToIntBits(((s) (obj)).n))
        {
            flag = flag1;
            if (o == ((o) (obj)).o)
            {
                flag = flag1;
                if (la.a(p, ((p) (obj)).p))
                {
                    flag = flag1;
                    if (q == ((q) (obj)).q)
                    {
                        return a(((kw) (obj)));
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

    public final int hashCode()
    {
        int i2 = 0;
        int j2 = la.a(a);
        int k2 = la.a(b);
        int l2 = la.a(c);
        int i3 = la.a(d);
        int j3 = la.a(e);
        int k3 = la.a(f);
        int l3 = la.a(g);
        int i4 = la.a(h);
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
        return (((c1 + (((l1 + (k1 + (j1 + (i1 + ((((((((j2 + 527) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + j4) * 31) * 31 + la.a(p)) * 31 + q) * 31 + c();
    }

    public ()
    {
        a = lg.f;
        b = lg.f;
        c = b();
        d = b();
        e = b();
        f = b();
        g = b();
        h = b();
        i = "";
        j = "";
        k = "0";
        l = "";
        m = null;
        n = 0.0F;
        o = false;
        p = lg.f;
        q = 0;
        r = null;
        s = -1;
    }
}
