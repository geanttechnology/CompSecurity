// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dic extends eul
{

    public dzp a;
    public dlb b;
    public dlb c;
    public dre d;
    public byte e[];
    public dux f;
    private String g;
    private dlb h;
    private String i;
    private dlb j;
    private dlb k;
    private doy l;
    private dzp m[];
    private dxa n[];
    private dlb o;
    private dfq p[];
    private did q;
    private dqi r;
    private String s;
    private dlb t;
    private dnz u;

    public dic()
    {
        g = "";
        a = null;
        b = null;
        h = null;
        c = null;
        d = null;
        i = "";
        j = null;
        k = null;
        l = null;
        e = eup.f;
        m = dzp.a;
        n = dxa.a;
        o = null;
        p = dfq.a;
        q = null;
        r = null;
        s = "";
        f = null;
        t = null;
        u = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
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
        if (c != null)
        {
            j1 = i1 + euj.b(5, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(6, d);
        }
        j1 = i1;
        if (!i.equals(""))
        {
            j1 = i1 + euj.b(7, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(8, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(9, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(11, l);
        }
        j1 = i1;
        if (!Arrays.equals(e, eup.f))
        {
            j1 = i1 + euj.b(12, e);
        }
        i1 = j1;
        if (m != null)
        {
            dzp adzp[] = m;
            int j2 = adzp.length;
            int k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= j2)
                {
                    break;
                }
                dzp dzp1 = adzp[k1];
                i1 = j1;
                if (dzp1 != null)
                {
                    i1 = j1 + euj.b(13, dzp1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (n != null)
        {
            dxa adxa[] = n;
            int k2 = adxa.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                dxa dxa1 = adxa[l1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(14, dxa1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (o != null)
        {
            i1 = j1 + euj.b(15, o);
        }
        j1 = i1;
        if (p != null)
        {
            dfq adfq[] = p;
            int l2 = adfq.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= l2)
                {
                    break;
                }
                dfq dfq1 = adfq[i2];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(16, dfq1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(17, q);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1 + euj.b(18, r);
        }
        i1 = j1;
        if (!s.equals(""))
        {
            i1 = j1 + euj.b(19, s);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(20, f);
        }
        i1 = j1;
        if (t != null)
        {
            i1 = j1 + euj.b(21, t);
        }
        j1 = i1;
        if (u != null)
        {
            j1 = i1 + euj.b(0x39d6d44, u);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 50: // '2'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 58: // ':'
                i = eui1.f();
                break;

            case 66: // 'B'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 74: // 'J'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 90: // 'Z'
                if (l == null)
                {
                    l = new doy();
                }
                eui1.a(l);
                break;

            case 98: // 'b'
                e = eui1.g();
                break;

            case 106: // 'j'
                int i2 = eup.a(eui1, 106);
                dzp adzp[];
                int j1;
                if (m == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = m.length;
                }
                adzp = new dzp[i2 + j1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adzp, 0, j1);
                }
                for (m = adzp; j1 < m.length - 1; j1++)
                {
                    m[j1] = new dzp();
                    eui1.a(m[j1]);
                    eui1.a();
                }

                m[j1] = new dzp();
                eui1.a(m[j1]);
                break;

            case 114: // 'r'
                int j2 = eup.a(eui1, 114);
                dxa adxa[];
                int k1;
                if (n == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = n.length;
                }
                adxa = new dxa[j2 + k1];
                if (n != null)
                {
                    System.arraycopy(n, 0, adxa, 0, k1);
                }
                for (n = adxa; k1 < n.length - 1; k1++)
                {
                    n[k1] = new dxa();
                    eui1.a(n[k1]);
                    eui1.a();
                }

                n[k1] = new dxa();
                eui1.a(n[k1]);
                break;

            case 122: // 'z'
                if (o == null)
                {
                    o = new dlb();
                }
                eui1.a(o);
                break;

            case 130: 
                int k2 = eup.a(eui1, 130);
                dfq adfq[];
                int l1;
                if (p == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = p.length;
                }
                adfq = new dfq[k2 + l1];
                if (p != null)
                {
                    System.arraycopy(p, 0, adfq, 0, l1);
                }
                for (p = adfq; l1 < p.length - 1; l1++)
                {
                    p[l1] = new dfq();
                    eui1.a(p[l1]);
                    eui1.a();
                }

                p[l1] = new dfq();
                eui1.a(p[l1]);
                break;

            case 138: 
                if (q == null)
                {
                    q = new did();
                }
                eui1.a(q);
                break;

            case 146: 
                if (r == null)
                {
                    r = new dqi();
                }
                eui1.a(r);
                break;

            case 154: 
                s = eui1.f();
                break;

            case 162: 
                if (f == null)
                {
                    f = new dux();
                }
                eui1.a(f);
                break;

            case 170: 
                if (t == null)
                {
                    t = new dlb();
                }
                eui1.a(t);
                break;

            case 485190178: 
                if (u == null)
                {
                    u = new dnz();
                }
                eui1.a(u);
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
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (d != null)
        {
            euj1.a(6, d);
        }
        if (!i.equals(""))
        {
            euj1.a(7, i);
        }
        if (j != null)
        {
            euj1.a(8, j);
        }
        if (k != null)
        {
            euj1.a(9, k);
        }
        if (l != null)
        {
            euj1.a(11, l);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(12, e);
        }
        if (m != null)
        {
            dzp adzp[] = m;
            int l1 = adzp.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dzp dzp1 = adzp[i1];
                if (dzp1 != null)
                {
                    euj1.a(13, dzp1);
                }
            }

        }
        if (n != null)
        {
            dxa adxa[] = n;
            int i2 = adxa.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dxa dxa1 = adxa[j1];
                if (dxa1 != null)
                {
                    euj1.a(14, dxa1);
                }
            }

        }
        if (o != null)
        {
            euj1.a(15, o);
        }
        if (p != null)
        {
            dfq adfq[] = p;
            int j2 = adfq.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dfq dfq1 = adfq[k1];
                if (dfq1 != null)
                {
                    euj1.a(16, dfq1);
                }
            }

        }
        if (q != null)
        {
            euj1.a(17, q);
        }
        if (r != null)
        {
            euj1.a(18, r);
        }
        if (!s.equals(""))
        {
            euj1.a(19, s);
        }
        if (f != null)
        {
            euj1.a(20, f);
        }
        if (t != null)
        {
            euj1.a(21, t);
        }
        if (u != null)
        {
            euj1.a(0x39d6d44, u);
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
            if (!(obj instanceof dic))
            {
                return false;
            }
            obj = (dic)obj;
            if ((g != null ? g.equals(((dic) (obj)).g) : ((dic) (obj)).g == null) && (a != null ? a.equals(((dic) (obj)).a) : ((dic) (obj)).a == null) && (b != null ? b.equals(((dic) (obj)).b) : ((dic) (obj)).b == null) && (h != null ? h.equals(((dic) (obj)).h) : ((dic) (obj)).h == null) && (c != null ? c.equals(((dic) (obj)).c) : ((dic) (obj)).c == null) && (d != null ? d.equals(((dic) (obj)).d) : ((dic) (obj)).d == null) && (i != null ? i.equals(((dic) (obj)).i) : ((dic) (obj)).i == null) && (j != null ? j.equals(((dic) (obj)).j) : ((dic) (obj)).j == null) && (k != null ? k.equals(((dic) (obj)).k) : ((dic) (obj)).k == null) && (l != null ? l.equals(((dic) (obj)).l) : ((dic) (obj)).l == null) && (Arrays.equals(e, ((dic) (obj)).e) && Arrays.equals(m, ((dic) (obj)).m) && Arrays.equals(n, ((dic) (obj)).n)) && (o != null ? o.equals(((dic) (obj)).o) : ((dic) (obj)).o == null) && Arrays.equals(p, ((dic) (obj)).p) && (q != null ? q.equals(((dic) (obj)).q) : ((dic) (obj)).q == null) && (r != null ? r.equals(((dic) (obj)).r) : ((dic) (obj)).r == null) && (s != null ? s.equals(((dic) (obj)).s) : ((dic) (obj)).s == null) && (f != null ? f.equals(((dic) (obj)).f) : ((dic) (obj)).f == null) && (t != null ? t.equals(((dic) (obj)).t) : ((dic) (obj)).t == null) && (u != null ? u.equals(((dic) (obj)).u) : ((dic) (obj)).u == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dic) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dic) (obj)).O))
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
        boolean flag = false;
        int k3 = getClass().getName().hashCode();
        int i3;
        int j3;
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
        if (c == null)
        {
            i2 = 0;
        } else
        {
            i2 = c.hashCode();
        }
        if (d == null)
        {
            j2 = 0;
        } else
        {
            j2 = d.hashCode();
        }
        if (i == null)
        {
            k2 = 0;
        } else
        {
            k2 = i.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
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
        j1 = j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L10:
        if (m != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (n != null) goto _L6; else goto _L5
_L5:
        k1 = j1 * 31;
_L16:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        i1 += k1 * 31;
        if (p != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (q == null)
        {
            i1 = 0;
        } else
        {
            i1 = q.hashCode();
        }
        if (r == null)
        {
            k1 = 0;
        } else
        {
            k1 = r.hashCode();
        }
        if (s == null)
        {
            l1 = 0;
        } else
        {
            l1 = s.hashCode();
        }
        if (f == null)
        {
            i2 = 0;
        } else
        {
            i2 = f.hashCode();
        }
        if (t == null)
        {
            j2 = 0;
        } else
        {
            j2 = t.hashCode();
        }
        if (u == null)
        {
            k2 = 0;
        } else
        {
            k2 = u.hashCode();
        }
        if (O == null)
        {
            l2 = ((flag) ? 1 : 0);
        } else
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l2;
_L2:
        k1 = 0;
_L11:
        i1 = j1;
        if (k1 >= e.length) goto _L10; else goto _L9
_L9:
        j1 = j1 * 31 + e[k1];
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= m.length) goto _L13; else goto _L12
_L12:
        if (m[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = m[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
        i1 = j1;
        j1 = k1;
_L17:
        k1 = i1;
        if (j1 >= n.length) goto _L16; else goto _L15
_L15:
        if (n[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = n[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
_L20:
        j1 = i1;
        if (k1 >= p.length) goto _L19; else goto _L18
_L18:
        if (p[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = p[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
