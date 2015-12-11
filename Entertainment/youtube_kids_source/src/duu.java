// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duu extends eul
{

    public dlb a;
    public dzp b;
    public dlb c;
    public dlb d;
    public boolean e;
    public dre f;
    public String g;
    public dlb h;
    public byte i[];
    public dzo j[];
    private dlb k;
    private dlb l;
    private dlb m;
    private dfq n[];
    private dut o;
    private dxa p[];
    private dlb q;
    private dqi r;

    public duu()
    {
        a = null;
        k = null;
        b = null;
        c = null;
        d = null;
        e = false;
        f = null;
        l = null;
        m = null;
        g = "";
        h = null;
        n = dfq.a;
        o = null;
        i = eup.f;
        j = dzo.a;
        p = dxa.a;
        q = null;
        r = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(2, k);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(3, b);
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(4, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (e)
        {
            boolean flag1 = e;
            i1 = j1 + (euj.b(6) + 1);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(7, f);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(8, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(9, m);
        }
        k1 = j1;
        if (!g.equals(""))
        {
            k1 = j1 + euj.b(10, g);
        }
        i1 = k1;
        if (h != null)
        {
            i1 = k1 + euj.b(12, h);
        }
        j1 = i1;
        if (n != null)
        {
            dfq adfq[] = n;
            int k2 = adfq.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
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
        if (!Arrays.equals(i, eup.f))
        {
            j1 = i1 + euj.b(15, i);
        }
        i1 = j1;
        if (j != null)
        {
            dzo adzo[] = j;
            int l2 = adzo.length;
            int i2 = 0;
            do
            {
                i1 = j1;
                if (i2 >= l2)
                {
                    break;
                }
                dzo dzo1 = adzo[i2];
                i1 = j1;
                if (dzo1 != null)
                {
                    i1 = j1 + euj.b(16, dzo1);
                }
                i2++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (p != null)
        {
            dxa adxa[] = p;
            int i3 = adxa.length;
            int j2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (j2 >= i3)
                {
                    break;
                }
                dxa dxa1 = adxa[j2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(17, dxa1);
                }
                j2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(18, q);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1 + euj.b(19, r);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new dzp();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 48: // '0'
                e = eui1.e();
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 74: // 'J'
                if (m == null)
                {
                    m = new dlb();
                }
                eui1.a(m);
                break;

            case 82: // 'R'
                g = eui1.f();
                break;

            case 98: // 'b'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 106: // 'j'
                int i2 = eup.a(eui1, 106);
                dfq adfq[];
                int j1;
                if (n == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = n.length;
                }
                adfq = new dfq[i2 + j1];
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
                    o = new dut();
                }
                eui1.a(o);
                break;

            case 122: // 'z'
                i = eui1.g();
                break;

            case 130: 
                int j2 = eup.a(eui1, 130);
                dzo adzo[];
                int k1;
                if (j == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = j.length;
                }
                adzo = new dzo[j2 + k1];
                if (j != null)
                {
                    System.arraycopy(j, 0, adzo, 0, k1);
                }
                for (j = adzo; k1 < j.length - 1; k1++)
                {
                    j[k1] = new dzo();
                    eui1.a(j[k1]);
                    eui1.a();
                }

                j[k1] = new dzo();
                eui1.a(j[k1]);
                break;

            case 138: 
                int k2 = eup.a(eui1, 138);
                dxa adxa[];
                int l1;
                if (p == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = p.length;
                }
                adxa = new dxa[k2 + l1];
                if (p != null)
                {
                    System.arraycopy(p, 0, adxa, 0, l1);
                }
                for (p = adxa; l1 < p.length - 1; l1++)
                {
                    p[l1] = new dxa();
                    eui1.a(p[l1]);
                    eui1.a();
                }

                p[l1] = new dxa();
                eui1.a(p[l1]);
                break;

            case 146: 
                if (q == null)
                {
                    q = new dlb();
                }
                eui1.a(q);
                break;

            case 154: 
                if (r == null)
                {
                    r = new dqi();
                }
                eui1.a(r);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (k != null)
        {
            euj1.a(2, k);
        }
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (c != null)
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (e)
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (l != null)
        {
            euj1.a(8, l);
        }
        if (m != null)
        {
            euj1.a(9, m);
        }
        if (!g.equals(""))
        {
            euj1.a(10, g);
        }
        if (h != null)
        {
            euj1.a(12, h);
        }
        if (n != null)
        {
            dfq adfq[] = n;
            int l1 = adfq.length;
            for (int i1 = 0; i1 < l1; i1++)
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
        if (!Arrays.equals(i, eup.f))
        {
            euj1.a(15, i);
        }
        if (j != null)
        {
            dzo adzo[] = j;
            int i2 = adzo.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dzo dzo1 = adzo[j1];
                if (dzo1 != null)
                {
                    euj1.a(16, dzo1);
                }
            }

        }
        if (p != null)
        {
            dxa adxa[] = p;
            int j2 = adxa.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dxa dxa1 = adxa[k1];
                if (dxa1 != null)
                {
                    euj1.a(17, dxa1);
                }
            }

        }
        if (q != null)
        {
            euj1.a(18, q);
        }
        if (r != null)
        {
            euj1.a(19, r);
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
            if (!(obj instanceof duu))
            {
                return false;
            }
            obj = (duu)obj;
            if ((a != null ? a.equals(((duu) (obj)).a) : ((duu) (obj)).a == null) && (k != null ? k.equals(((duu) (obj)).k) : ((duu) (obj)).k == null) && (b != null ? b.equals(((duu) (obj)).b) : ((duu) (obj)).b == null) && (c != null ? c.equals(((duu) (obj)).c) : ((duu) (obj)).c == null) && (d != null ? d.equals(((duu) (obj)).d) : ((duu) (obj)).d == null) && e == ((duu) (obj)).e && (f != null ? f.equals(((duu) (obj)).f) : ((duu) (obj)).f == null) && (l != null ? l.equals(((duu) (obj)).l) : ((duu) (obj)).l == null) && (m != null ? m.equals(((duu) (obj)).m) : ((duu) (obj)).m == null) && (g != null ? g.equals(((duu) (obj)).g) : ((duu) (obj)).g == null) && (h != null ? h.equals(((duu) (obj)).h) : ((duu) (obj)).h == null) && Arrays.equals(n, ((duu) (obj)).n) && (o != null ? o.equals(((duu) (obj)).o) : ((duu) (obj)).o == null) && (Arrays.equals(i, ((duu) (obj)).i) && Arrays.equals(j, ((duu) (obj)).j) && Arrays.equals(p, ((duu) (obj)).p)) && (q != null ? q.equals(((duu) (obj)).q) : ((duu) (obj)).q == null) && (r != null ? r.equals(((duu) (obj)).r) : ((duu) (obj)).r == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duu) (obj)).O))
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
        boolean flag = false;
        int l3 = getClass().getName().hashCode();
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (k == null)
        {
            j1 = 0;
        } else
        {
            j1 = k.hashCode();
        }
        if (b == null)
        {
            k1 = 0;
        } else
        {
            k1 = b.hashCode();
        }
        if (c == null)
        {
            l1 = 0;
        } else
        {
            l1 = c.hashCode();
        }
        if (d == null)
        {
            i2 = 0;
        } else
        {
            i2 = d.hashCode();
        }
        if (e)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        if (f == null)
        {
            k2 = 0;
        } else
        {
            k2 = f.hashCode();
        }
        if (l == null)
        {
            l2 = 0;
        } else
        {
            l2 = l.hashCode();
        }
        if (m == null)
        {
            i3 = 0;
        } else
        {
            i3 = m.hashCode();
        }
        if (g == null)
        {
            j3 = 0;
        } else
        {
            j3 = g.hashCode();
        }
        if (h == null)
        {
            k3 = 0;
        } else
        {
            k3 = h.hashCode();
        }
        i1 = k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (n != null) goto _L2; else goto _L1
_L1:
        k1 = i1 * 31;
_L10:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        j1 = i1 + k1 * 31;
        if (i != null) goto _L4; else goto _L3
_L3:
        i1 = j1 * 31;
_L13:
        if (j != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L16:
        if (p != null) goto _L8; else goto _L7
_L7:
        j1 *= 31;
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
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return (k1 + (i1 + j1 * 31) * 31) * 31 + l1;
_L2:
        j1 = 0;
_L11:
        k1 = i1;
        if (j1 >= n.length) goto _L10; else goto _L9
_L9:
        if (n[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = n[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        i1 = j1;
        if (k1 >= i.length) goto _L13; else goto _L12
_L12:
        j1 = j1 * 31 + i[k1];
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        j1 = i1;
        if (k1 >= j.length) goto _L16; else goto _L15
_L15:
        if (j[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = j[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
        i1 = j1;
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
