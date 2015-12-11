// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dii extends eul
{

    public dzp a;
    public dlb b;
    public dlb c;
    public dre d;
    public byte e[];
    public dzo f[];
    private String g;
    private dlb h;
    private dlb i;
    private dlb j;
    private String k;
    private dlb l;
    private eab m;
    private dfq n[];
    private dzp o;
    private dfq p[];
    private dij q;
    private boolean r;
    private dxa s[];
    private dlb t;
    private dre u;
    private dqi v;
    private dih w;
    private boolean x;
    private dnz y;

    public dii()
    {
        g = "";
        a = null;
        b = null;
        h = null;
        i = null;
        j = null;
        c = null;
        d = null;
        k = "";
        l = null;
        m = null;
        n = dfq.a;
        o = null;
        p = dfq.a;
        q = null;
        e = eup.f;
        f = dzo.a;
        r = false;
        s = dxa.a;
        t = null;
        u = null;
        v = null;
        w = null;
        x = false;
        y = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (!g.equals(""))
        {
            j1 = euj.b(1, g) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(2, a);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(3, b);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(4, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(5, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(6, j);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(7, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(8, d);
        }
        j1 = i1;
        if (!k.equals(""))
        {
            j1 = i1 + euj.b(9, k);
        }
        k1 = j1;
        if (l != null)
        {
            k1 = j1 + euj.b(10, l);
        }
        i1 = k1;
        if (m != null)
        {
            i1 = k1 + euj.b(12, m);
        }
        j1 = i1;
        if (n != null)
        {
            dfq adfq[] = n;
            int j2 = adfq.length;
            k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= j2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(13, dfq1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (o != null)
        {
            i1 = j1 + euj.b(14, o);
        }
        j1 = i1;
        if (p != null)
        {
            dfq adfq1[] = p;
            int k2 = adfq1.length;
            k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= k2)
                {
                    break;
                }
                dfq dfq2 = adfq1[k1];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(15, dfq2);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        k1 = j1;
        if (q != null)
        {
            k1 = j1 + euj.b(17, q);
        }
        i1 = k1;
        if (!Arrays.equals(e, eup.f))
        {
            i1 = k1 + euj.b(18, e);
        }
        j1 = i1;
        if (f != null)
        {
            dzo adzo[] = f;
            int l2 = adzo.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= l2)
                {
                    break;
                }
                dzo dzo1 = adzo[l1];
                j1 = i1;
                if (dzo1 != null)
                {
                    j1 = i1 + euj.b(20, dzo1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (r)
        {
            boolean flag1 = r;
            i1 = j1 + (euj.b(21) + 1);
        }
        j1 = i1;
        if (s != null)
        {
            dxa adxa[] = s;
            int i3 = adxa.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= i3)
                {
                    break;
                }
                dxa dxa1 = adxa[i2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(22, dxa1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (t != null)
        {
            i1 = j1 + euj.b(23, t);
        }
        j1 = i1;
        if (u != null)
        {
            j1 = i1 + euj.b(24, u);
        }
        i1 = j1;
        if (v != null)
        {
            i1 = j1 + euj.b(25, v);
        }
        j1 = i1;
        if (w != null)
        {
            j1 = i1 + euj.b(26, w);
        }
        i1 = j1;
        if (x)
        {
            boolean flag2 = x;
            i1 = j1 + (euj.b(27) + 1);
        }
        j1 = i1;
        if (y != null)
        {
            j1 = i1 + euj.b(0x39d6d44, y);
        }
        i1 = j1 + eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                g = eui1.f();
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 42: // '*'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 50: // '2'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 58: // ':'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 66: // 'B'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 74: // 'J'
                k = eui1.f();
                break;

            case 82: // 'R'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 98: // 'b'
                if (m == null)
                {
                    m = new eab();
                }
                eui1.a(m);
                break;

            case 106: // 'j'
                int j2 = eup.a(eui1, 106);
                dfq adfq[];
                int j1;
                if (n == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = n.length;
                }
                adfq = new dfq[j2 + j1];
                if (n != null)
                {
                    System.arraycopy(n, 0, adfq, 0, j1);
                }
                for (n = adfq; j1 < n.length - 1; j1++)
                {
                    n[j1] = new dfq();
                    eui1.a(n[j1]);
                    eui1.a();
                }

                n[j1] = new dfq();
                eui1.a(n[j1]);
                break;

            case 114: // 'r'
                if (o == null)
                {
                    o = new dzp();
                }
                eui1.a(o);
                break;

            case 122: // 'z'
                int k2 = eup.a(eui1, 122);
                dfq adfq1[];
                int k1;
                if (p == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = p.length;
                }
                adfq1 = new dfq[k2 + k1];
                if (p != null)
                {
                    System.arraycopy(p, 0, adfq1, 0, k1);
                }
                for (p = adfq1; k1 < p.length - 1; k1++)
                {
                    p[k1] = new dfq();
                    eui1.a(p[k1]);
                    eui1.a();
                }

                p[k1] = new dfq();
                eui1.a(p[k1]);
                break;

            case 138: 
                if (q == null)
                {
                    q = new dij();
                }
                eui1.a(q);
                break;

            case 146: 
                e = eui1.g();
                break;

            case 162: 
                int l2 = eup.a(eui1, 162);
                dzo adzo[];
                int l1;
                if (f == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = f.length;
                }
                adzo = new dzo[l2 + l1];
                if (f != null)
                {
                    System.arraycopy(f, 0, adzo, 0, l1);
                }
                for (f = adzo; l1 < f.length - 1; l1++)
                {
                    f[l1] = new dzo();
                    eui1.a(f[l1]);
                    eui1.a();
                }

                f[l1] = new dzo();
                eui1.a(f[l1]);
                break;

            case 168: 
                r = eui1.e();
                break;

            case 178: 
                int i3 = eup.a(eui1, 178);
                dxa adxa[];
                int i2;
                if (s == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = s.length;
                }
                adxa = new dxa[i3 + i2];
                if (s != null)
                {
                    System.arraycopy(s, 0, adxa, 0, i2);
                }
                for (s = adxa; i2 < s.length - 1; i2++)
                {
                    s[i2] = new dxa();
                    eui1.a(s[i2]);
                    eui1.a();
                }

                s[i2] = new dxa();
                eui1.a(s[i2]);
                break;

            case 186: 
                if (t == null)
                {
                    t = new dlb();
                }
                eui1.a(t);
                break;

            case 194: 
                if (u == null)
                {
                    u = new dre();
                }
                eui1.a(u);
                break;

            case 202: 
                if (v == null)
                {
                    v = new dqi();
                }
                eui1.a(v);
                break;

            case 210: 
                if (w == null)
                {
                    w = new dih();
                }
                eui1.a(w);
                break;

            case 216: 
                x = eui1.e();
                break;

            case 485190178: 
                if (y == null)
                {
                    y = new dnz();
                }
                eui1.a(y);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!g.equals(""))
        {
            euj1.a(1, g);
        }
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (h != null)
        {
            euj1.a(4, h);
        }
        if (i != null)
        {
            euj1.a(5, i);
        }
        if (j != null)
        {
            euj1.a(6, j);
        }
        if (c != null)
        {
            euj1.a(7, c);
        }
        if (d != null)
        {
            euj1.a(8, d);
        }
        if (!k.equals(""))
        {
            euj1.a(9, k);
        }
        if (l != null)
        {
            euj1.a(10, l);
        }
        if (m != null)
        {
            euj1.a(12, m);
        }
        if (n != null)
        {
            dfq adfq[] = n;
            int i2 = adfq.length;
            for (int i1 = 0; i1 < i2; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(13, dfq1);
                }
            }

        }
        if (o != null)
        {
            euj1.a(14, o);
        }
        if (p != null)
        {
            dfq adfq1[] = p;
            int j2 = adfq1.length;
            for (int j1 = 0; j1 < j2; j1++)
            {
                dfq dfq2 = adfq1[j1];
                if (dfq2 != null)
                {
                    euj1.a(15, dfq2);
                }
            }

        }
        if (q != null)
        {
            euj1.a(17, q);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(18, e);
        }
        if (f != null)
        {
            dzo adzo[] = f;
            int k2 = adzo.length;
            for (int k1 = 0; k1 < k2; k1++)
            {
                dzo dzo1 = adzo[k1];
                if (dzo1 != null)
                {
                    euj1.a(20, dzo1);
                }
            }

        }
        if (r)
        {
            euj1.a(21, r);
        }
        if (s != null)
        {
            dxa adxa[] = s;
            int l2 = adxa.length;
            for (int l1 = ((flag) ? 1 : 0); l1 < l2; l1++)
            {
                dxa dxa1 = adxa[l1];
                if (dxa1 != null)
                {
                    euj1.a(22, dxa1);
                }
            }

        }
        if (t != null)
        {
            euj1.a(23, t);
        }
        if (u != null)
        {
            euj1.a(24, u);
        }
        if (v != null)
        {
            euj1.a(25, v);
        }
        if (w != null)
        {
            euj1.a(26, w);
        }
        if (x)
        {
            euj1.a(27, x);
        }
        if (y != null)
        {
            euj1.a(0x39d6d44, y);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
label0:
        {
            if (!(obj instanceof dii))
            {
                return false;
            }
            obj = (dii)obj;
            if ((g != null ? g.equals(((dii) (obj)).g) : ((dii) (obj)).g == null) && (a != null ? a.equals(((dii) (obj)).a) : ((dii) (obj)).a == null) && (b != null ? b.equals(((dii) (obj)).b) : ((dii) (obj)).b == null) && (h != null ? h.equals(((dii) (obj)).h) : ((dii) (obj)).h == null) && (i != null ? i.equals(((dii) (obj)).i) : ((dii) (obj)).i == null) && (j != null ? j.equals(((dii) (obj)).j) : ((dii) (obj)).j == null) && (c != null ? c.equals(((dii) (obj)).c) : ((dii) (obj)).c == null) && (d != null ? d.equals(((dii) (obj)).d) : ((dii) (obj)).d == null) && (k != null ? k.equals(((dii) (obj)).k) : ((dii) (obj)).k == null) && (l != null ? l.equals(((dii) (obj)).l) : ((dii) (obj)).l == null) && (m != null ? m.equals(((dii) (obj)).m) : ((dii) (obj)).m == null) && Arrays.equals(n, ((dii) (obj)).n) && (o != null ? o.equals(((dii) (obj)).o) : ((dii) (obj)).o == null) && Arrays.equals(p, ((dii) (obj)).p) && (q != null ? q.equals(((dii) (obj)).q) : ((dii) (obj)).q == null) && (Arrays.equals(e, ((dii) (obj)).e) && Arrays.equals(f, ((dii) (obj)).f) && r == ((dii) (obj)).r && Arrays.equals(s, ((dii) (obj)).s)) && (t != null ? t.equals(((dii) (obj)).t) : ((dii) (obj)).t == null) && (u != null ? u.equals(((dii) (obj)).u) : ((dii) (obj)).u == null) && (v != null ? v.equals(((dii) (obj)).v) : ((dii) (obj)).v == null) && (w != null ? w.equals(((dii) (obj)).w) : ((dii) (obj)).w == null) && x == ((dii) (obj)).x && (y != null ? y.equals(((dii) (obj)).y) : ((dii) (obj)).y == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dii) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dii) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        boolean flag1 = true;
        boolean flag = false;
        int l3 = getClass().getName().hashCode();
        int i3;
        int j3;
        int k3;
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (a == null)
        {
            j1 = 0;
        } else
        {
            j1 = a.hashCode();
        }
        if (b == null)
        {
            k1 = 0;
        } else
        {
            k1 = b.hashCode();
        }
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        if (i == null)
        {
            i2 = 0;
        } else
        {
            i2 = i.hashCode();
        }
        if (j == null)
        {
            j2 = 0;
        } else
        {
            j2 = j.hashCode();
        }
        if (c == null)
        {
            k2 = 0;
        } else
        {
            k2 = c.hashCode();
        }
        if (d == null)
        {
            l2 = 0;
        } else
        {
            l2 = d.hashCode();
        }
        if (k == null)
        {
            i3 = 0;
        } else
        {
            i3 = k.hashCode();
        }
        if (l == null)
        {
            j3 = 0;
        } else
        {
            j3 = l.hashCode();
        }
        if (m == null)
        {
            k3 = 0;
        } else
        {
            k3 = m.hashCode();
        }
        i1 = k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (n != null) goto _L2; else goto _L1
_L1:
        k1 = i1 * 31;
_L12:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        i1 += k1 * 31;
        if (p != null) goto _L4; else goto _L3
_L3:
        k1 = i1 * 31;
_L15:
        if (q == null)
        {
            i1 = 0;
        } else
        {
            i1 = q.hashCode();
        }
        j1 = i1 + k1 * 31;
        if (e != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L18:
        if (f != null) goto _L8; else goto _L7
_L7:
        k1 = i1 * 31;
_L21:
        if (r)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        i1 += k1 * 31;
        if (s != null) goto _L10; else goto _L9
_L9:
        j1 = i1 * 31;
_L24:
        if (t == null)
        {
            i1 = 0;
        } else
        {
            i1 = t.hashCode();
        }
        if (u == null)
        {
            k1 = 0;
        } else
        {
            k1 = u.hashCode();
        }
        if (v == null)
        {
            l1 = 0;
        } else
        {
            l1 = v.hashCode();
        }
        if (w == null)
        {
            i2 = 0;
        } else
        {
            i2 = w.hashCode();
        }
        if (x)
        {
            j2 = ((flag1) ? 1 : 0);
        } else
        {
            j2 = 2;
        }
        if (y == null)
        {
            k2 = 0;
        } else
        {
            k2 = y.hashCode();
        }
        if (O == null)
        {
            l2 = ((flag) ? 1 : 0);
        } else
        {
            l2 = O.hashCode();
        }
        return (k2 + ((i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2) * 31) * 31 + l2;
_L2:
        j1 = 0;
_L13:
        k1 = i1;
        if (j1 >= n.length) goto _L12; else goto _L11
_L11:
        if (n[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = n[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L13
          goto _L12
_L4:
        j1 = 0;
_L16:
        k1 = i1;
        if (j1 >= p.length) goto _L15; else goto _L14
_L14:
        if (p[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = p[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L16
          goto _L15
_L6:
        k1 = 0;
_L19:
        i1 = j1;
        if (k1 >= e.length) goto _L18; else goto _L17
_L17:
        j1 = j1 * 31 + e[k1];
        k1++;
          goto _L19
          goto _L18
_L8:
        j1 = 0;
_L22:
        k1 = i1;
        if (j1 >= f.length) goto _L21; else goto _L20
_L20:
        if (f[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = f[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L22
          goto _L21
_L10:
        k1 = 0;
_L25:
        j1 = i1;
        if (k1 >= s.length) goto _L24; else goto _L23
_L23:
        if (s[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = s[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L25
    }
}
