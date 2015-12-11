// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dlo extends eul
{

    public dre a;
    public byte b[];
    public dzo c[];
    private String d;
    private dzp e;
    private dlb f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dlb j;
    private String k;
    private dlb l;
    private eab m;
    private dfq n[];
    private dzp o;
    private dfq p[];
    private dlp q;
    private dxa r[];
    private dlb s;
    private boolean t;
    private dqi u;

    public dlo()
    {
        d = "";
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        a = null;
        k = "";
        l = null;
        m = null;
        n = dfq.a;
        o = null;
        p = dfq.a;
        b = eup.f;
        c = dzo.a;
        q = null;
        r = dxa.a;
        s = null;
        t = false;
        u = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (!d.equals(""))
        {
            j1 = euj.b(1, d) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(2, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(3, f);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(4, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(5, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(6, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(7, j);
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(8, a);
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
            int l2 = adfq.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= l2)
                {
                    break;
                }
                dfq dfq1 = adfq[l1];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(13, dfq1);
                }
                l1++;
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
            int i3 = adfq1.length;
            int i2 = 0;
            do
            {
                j1 = i1;
                if (i2 >= i3)
                {
                    break;
                }
                dfq dfq2 = adfq1[i2];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(15, dfq2);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!Arrays.equals(b, eup.f))
        {
            i1 = j1 + euj.b(17, b);
        }
        j1 = i1;
        if (c != null)
        {
            dzo adzo[] = c;
            int j3 = adzo.length;
            int j2 = 0;
            do
            {
                j1 = i1;
                if (j2 >= j3)
                {
                    break;
                }
                dzo dzo1 = adzo[j2];
                j1 = i1;
                if (dzo1 != null)
                {
                    j1 = i1 + euj.b(18, dzo1);
                }
                j2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(20, q);
        }
        j1 = i1;
        if (r != null)
        {
            dxa adxa[] = r;
            int k3 = adxa.length;
            int k2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (k2 >= k3)
                {
                    break;
                }
                dxa dxa1 = adxa[k2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(21, dxa1);
                }
                k2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(22, s);
        }
        j1 = i1;
        if (t)
        {
            boolean flag1 = t;
            j1 = i1 + (euj.b(23) + 1);
        }
        i1 = j1;
        if (u != null)
        {
            i1 = j1 + euj.b(24, u);
        }
        i1 += eup.a(O);
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
                d = eui1.f();
                break;

            case 18: // '\022'
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 26: // '\032'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 34: // '"'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 42: // '*'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 50: // '2'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 58: // ':'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 66: // 'B'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
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
                b = eui1.g();
                break;

            case 146: 
                int l2 = eup.a(eui1, 146);
                dzo adzo[];
                int l1;
                if (c == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = c.length;
                }
                adzo = new dzo[l2 + l1];
                if (c != null)
                {
                    System.arraycopy(c, 0, adzo, 0, l1);
                }
                for (c = adzo; l1 < c.length - 1; l1++)
                {
                    c[l1] = new dzo();
                    eui1.a(c[l1]);
                    eui1.a();
                }

                c[l1] = new dzo();
                eui1.a(c[l1]);
                break;

            case 162: 
                if (q == null)
                {
                    q = new dlp();
                }
                eui1.a(q);
                break;

            case 170: 
                int i3 = eup.a(eui1, 170);
                dxa adxa[];
                int i2;
                if (r == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = r.length;
                }
                adxa = new dxa[i3 + i2];
                if (r != null)
                {
                    System.arraycopy(r, 0, adxa, 0, i2);
                }
                for (r = adxa; i2 < r.length - 1; i2++)
                {
                    r[i2] = new dxa();
                    eui1.a(r[i2]);
                    eui1.a();
                }

                r[i2] = new dxa();
                eui1.a(r[i2]);
                break;

            case 178: 
                if (s == null)
                {
                    s = new dlb();
                }
                eui1.a(s);
                break;

            case 184: 
                t = eui1.e();
                break;

            case 194: 
                if (u == null)
                {
                    u = new dqi();
                }
                eui1.a(u);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!d.equals(""))
        {
            euj1.a(1, d);
        }
        if (e != null)
        {
            euj1.a(2, e);
        }
        if (f != null)
        {
            euj1.a(3, f);
        }
        if (g != null)
        {
            euj1.a(4, g);
        }
        if (h != null)
        {
            euj1.a(5, h);
        }
        if (i != null)
        {
            euj1.a(6, i);
        }
        if (j != null)
        {
            euj1.a(7, j);
        }
        if (a != null)
        {
            euj1.a(8, a);
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
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(17, b);
        }
        if (c != null)
        {
            dzo adzo[] = c;
            int k2 = adzo.length;
            for (int k1 = 0; k1 < k2; k1++)
            {
                dzo dzo1 = adzo[k1];
                if (dzo1 != null)
                {
                    euj1.a(18, dzo1);
                }
            }

        }
        if (q != null)
        {
            euj1.a(20, q);
        }
        if (r != null)
        {
            dxa adxa[] = r;
            int l2 = adxa.length;
            for (int l1 = ((flag) ? 1 : 0); l1 < l2; l1++)
            {
                dxa dxa1 = adxa[l1];
                if (dxa1 != null)
                {
                    euj1.a(21, dxa1);
                }
            }

        }
        if (s != null)
        {
            euj1.a(22, s);
        }
        if (t)
        {
            euj1.a(23, t);
        }
        if (u != null)
        {
            euj1.a(24, u);
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
            if (!(obj instanceof dlo))
            {
                return false;
            }
            obj = (dlo)obj;
            if ((d != null ? d.equals(((dlo) (obj)).d) : ((dlo) (obj)).d == null) && (e != null ? e.equals(((dlo) (obj)).e) : ((dlo) (obj)).e == null) && (f != null ? f.equals(((dlo) (obj)).f) : ((dlo) (obj)).f == null) && (g != null ? g.equals(((dlo) (obj)).g) : ((dlo) (obj)).g == null) && (h != null ? h.equals(((dlo) (obj)).h) : ((dlo) (obj)).h == null) && (i != null ? i.equals(((dlo) (obj)).i) : ((dlo) (obj)).i == null) && (j != null ? j.equals(((dlo) (obj)).j) : ((dlo) (obj)).j == null) && (a != null ? a.equals(((dlo) (obj)).a) : ((dlo) (obj)).a == null) && (k != null ? k.equals(((dlo) (obj)).k) : ((dlo) (obj)).k == null) && (l != null ? l.equals(((dlo) (obj)).l) : ((dlo) (obj)).l == null) && (m != null ? m.equals(((dlo) (obj)).m) : ((dlo) (obj)).m == null) && Arrays.equals(n, ((dlo) (obj)).n) && (o != null ? o.equals(((dlo) (obj)).o) : ((dlo) (obj)).o == null) && (Arrays.equals(p, ((dlo) (obj)).p) && Arrays.equals(b, ((dlo) (obj)).b) && Arrays.equals(c, ((dlo) (obj)).c)) && (q != null ? q.equals(((dlo) (obj)).q) : ((dlo) (obj)).q == null) && Arrays.equals(r, ((dlo) (obj)).r) && (s != null ? s.equals(((dlo) (obj)).s) : ((dlo) (obj)).s == null) && t == ((dlo) (obj)).t && (u != null ? u.equals(((dlo) (obj)).u) : ((dlo) (obj)).u == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlo) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlo) (obj)).O))
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
        boolean flag = false;
        int l3 = getClass().getName().hashCode();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
        }
        if (f == null)
        {
            k1 = 0;
        } else
        {
            k1 = f.hashCode();
        }
        if (g == null)
        {
            l1 = 0;
        } else
        {
            l1 = g.hashCode();
        }
        if (h == null)
        {
            i2 = 0;
        } else
        {
            i2 = h.hashCode();
        }
        if (i == null)
        {
            j2 = 0;
        } else
        {
            j2 = i.hashCode();
        }
        if (j == null)
        {
            k2 = 0;
        } else
        {
            k2 = j.hashCode();
        }
        if (a == null)
        {
            l2 = 0;
        } else
        {
            l2 = a.hashCode();
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
        j1 = i1 * 31;
_L15:
        if (b != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L18:
        if (c != null) goto _L8; else goto _L7
_L7:
        k1 = i1 * 31;
_L21:
        if (q == null)
        {
            i1 = 0;
        } else
        {
            i1 = q.hashCode();
        }
        i1 += k1 * 31;
        if (r != null) goto _L10; else goto _L9
_L9:
        j1 = i1 * 31;
_L24:
        if (s == null)
        {
            i1 = 0;
        } else
        {
            i1 = s.hashCode();
        }
        if (t)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (u == null)
        {
            l1 = 0;
        } else
        {
            l1 = u.hashCode();
        }
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + i2;
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
        k1 = 0;
_L16:
        j1 = i1;
        if (k1 >= p.length) goto _L15; else goto _L14
_L14:
        if (p[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = p[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L16
          goto _L15
_L6:
        k1 = 0;
_L19:
        i1 = j1;
        if (k1 >= b.length) goto _L18; else goto _L17
_L17:
        j1 = j1 * 31 + b[k1];
        k1++;
          goto _L19
          goto _L18
_L8:
        j1 = 0;
_L22:
        k1 = i1;
        if (j1 >= c.length) goto _L21; else goto _L20
_L20:
        if (c[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = c[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L22
          goto _L21
_L10:
        k1 = 0;
_L25:
        j1 = i1;
        if (k1 >= r.length) goto _L24; else goto _L23
_L23:
        if (r[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = r[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L25
    }
}
