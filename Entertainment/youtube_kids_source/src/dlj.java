// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dlj extends eul
{

    public dzp a;
    public dre b;
    public byte c[];
    public dux d;
    private String e;
    private dlb f;
    private dlb g;
    private dlb h;
    private String i;
    private dlb j;
    private dlb k;
    private dzp l[];
    private dxa m[];
    private dlb n;
    private dfq o[];
    private dlb p;
    private dqi q;
    private dlk r;
    private doy s;

    public dlj()
    {
        e = "";
        a = null;
        f = null;
        g = null;
        h = null;
        b = null;
        i = "";
        j = null;
        k = null;
        c = eup.f;
        l = dzp.a;
        m = dxa.a;
        n = null;
        o = dfq.a;
        d = null;
        p = null;
        q = null;
        r = null;
        s = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (!e.equals(""))
        {
            j1 = euj.b(1, e) + 0;
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
        if (b != null)
        {
            i1 = j1 + euj.b(6, b);
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
        k1 = i1;
        if (k != null)
        {
            k1 = i1 + euj.b(9, k);
        }
        j1 = k1;
        if (!Arrays.equals(c, eup.f))
        {
            j1 = k1 + euj.b(11, c);
        }
        i1 = j1;
        if (l != null)
        {
            dzp adzp[] = l;
            int k2 = adzp.length;
            int l1 = 0;
            do
            {
                i1 = j1;
                if (l1 >= k2)
                {
                    break;
                }
                dzp dzp1 = adzp[l1];
                i1 = j1;
                if (dzp1 != null)
                {
                    i1 = j1 + euj.b(12, dzp1);
                }
                l1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (m != null)
        {
            dxa adxa[] = m;
            int l2 = adxa.length;
            int i2 = 0;
            do
            {
                j1 = i1;
                if (i2 >= l2)
                {
                    break;
                }
                dxa dxa1 = adxa[i2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(13, dxa1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(14, n);
        }
        j1 = i1;
        if (o != null)
        {
            dfq adfq[] = o;
            int i3 = adfq.length;
            int j2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (j2 >= i3)
                {
                    break;
                }
                dfq dfq1 = adfq[j2];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(15, dfq1);
                }
                j2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(16, d);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(17, p);
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
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(20, s);
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
                e = eui1.f();
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
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
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
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
                c = eui1.g();
                break;

            case 98: // 'b'
                int i2 = eup.a(eui1, 98);
                dzp adzp[];
                int j1;
                if (l == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = l.length;
                }
                adzp = new dzp[i2 + j1];
                if (l != null)
                {
                    System.arraycopy(l, 0, adzp, 0, j1);
                }
                for (l = adzp; j1 < l.length - 1; j1++)
                {
                    l[j1] = new dzp();
                    eui1.a(l[j1]);
                    eui1.a();
                }

                l[j1] = new dzp();
                eui1.a(l[j1]);
                break;

            case 106: // 'j'
                int j2 = eup.a(eui1, 106);
                dxa adxa[];
                int k1;
                if (m == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = m.length;
                }
                adxa = new dxa[j2 + k1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adxa, 0, k1);
                }
                for (m = adxa; k1 < m.length - 1; k1++)
                {
                    m[k1] = new dxa();
                    eui1.a(m[k1]);
                    eui1.a();
                }

                m[k1] = new dxa();
                eui1.a(m[k1]);
                break;

            case 114: // 'r'
                if (n == null)
                {
                    n = new dlb();
                }
                eui1.a(n);
                break;

            case 122: // 'z'
                int k2 = eup.a(eui1, 122);
                dfq adfq[];
                int l1;
                if (o == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = o.length;
                }
                adfq = new dfq[k2 + l1];
                if (o != null)
                {
                    System.arraycopy(o, 0, adfq, 0, l1);
                }
                for (o = adfq; l1 < o.length - 1; l1++)
                {
                    o[l1] = new dfq();
                    eui1.a(o[l1]);
                    eui1.a();
                }

                o[l1] = new dfq();
                eui1.a(o[l1]);
                break;

            case 130: 
                if (d == null)
                {
                    d = new dux();
                }
                eui1.a(d);
                break;

            case 138: 
                if (p == null)
                {
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 146: 
                if (q == null)
                {
                    q = new dqi();
                }
                eui1.a(q);
                break;

            case 154: 
                if (r == null)
                {
                    r = new dlk();
                }
                eui1.a(r);
                break;

            case 162: 
                if (s == null)
                {
                    s = new doy();
                }
                eui1.a(s);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!e.equals(""))
        {
            euj1.a(1, e);
        }
        if (a != null)
        {
            euj1.a(2, a);
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
        if (b != null)
        {
            euj1.a(6, b);
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
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(11, c);
        }
        if (l != null)
        {
            dzp adzp[] = l;
            int l1 = adzp.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dzp dzp1 = adzp[i1];
                if (dzp1 != null)
                {
                    euj1.a(12, dzp1);
                }
            }

        }
        if (m != null)
        {
            dxa adxa[] = m;
            int i2 = adxa.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dxa dxa1 = adxa[j1];
                if (dxa1 != null)
                {
                    euj1.a(13, dxa1);
                }
            }

        }
        if (n != null)
        {
            euj1.a(14, n);
        }
        if (o != null)
        {
            dfq adfq[] = o;
            int j2 = adfq.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dfq dfq1 = adfq[k1];
                if (dfq1 != null)
                {
                    euj1.a(15, dfq1);
                }
            }

        }
        if (d != null)
        {
            euj1.a(16, d);
        }
        if (p != null)
        {
            euj1.a(17, p);
        }
        if (q != null)
        {
            euj1.a(18, q);
        }
        if (r != null)
        {
            euj1.a(19, r);
        }
        if (s != null)
        {
            euj1.a(20, s);
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
            if (!(obj instanceof dlj))
            {
                return false;
            }
            obj = (dlj)obj;
            if ((e != null ? e.equals(((dlj) (obj)).e) : ((dlj) (obj)).e == null) && (a != null ? a.equals(((dlj) (obj)).a) : ((dlj) (obj)).a == null) && (f != null ? f.equals(((dlj) (obj)).f) : ((dlj) (obj)).f == null) && (g != null ? g.equals(((dlj) (obj)).g) : ((dlj) (obj)).g == null) && (h != null ? h.equals(((dlj) (obj)).h) : ((dlj) (obj)).h == null) && (b != null ? b.equals(((dlj) (obj)).b) : ((dlj) (obj)).b == null) && (i != null ? i.equals(((dlj) (obj)).i) : ((dlj) (obj)).i == null) && (j != null ? j.equals(((dlj) (obj)).j) : ((dlj) (obj)).j == null) && (k != null ? k.equals(((dlj) (obj)).k) : ((dlj) (obj)).k == null) && (Arrays.equals(c, ((dlj) (obj)).c) && Arrays.equals(l, ((dlj) (obj)).l) && Arrays.equals(m, ((dlj) (obj)).m)) && (n != null ? n.equals(((dlj) (obj)).n) : ((dlj) (obj)).n == null) && Arrays.equals(o, ((dlj) (obj)).o) && (d != null ? d.equals(((dlj) (obj)).d) : ((dlj) (obj)).d == null) && (p != null ? p.equals(((dlj) (obj)).p) : ((dlj) (obj)).p == null) && (q != null ? q.equals(((dlj) (obj)).q) : ((dlj) (obj)).q == null) && (r != null ? r.equals(((dlj) (obj)).r) : ((dlj) (obj)).r == null) && (s != null ? s.equals(((dlj) (obj)).s) : ((dlj) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlj) (obj)).O))
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
        boolean flag = false;
        int j3 = getClass().getName().hashCode();
        int l2;
        int i3;
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (a == null)
        {
            j1 = 0;
        } else
        {
            j1 = a.hashCode();
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
        if (b == null)
        {
            j2 = 0;
        } else
        {
            j2 = b.hashCode();
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
        j1 = i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L10:
        if (l != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (m != null) goto _L6; else goto _L5
_L5:
        k1 = j1 * 31;
_L16:
        if (n == null)
        {
            i1 = 0;
        } else
        {
            i1 = n.hashCode();
        }
        i1 += k1 * 31;
        if (o != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (p == null)
        {
            k1 = 0;
        } else
        {
            k1 = p.hashCode();
        }
        if (q == null)
        {
            l1 = 0;
        } else
        {
            l1 = q.hashCode();
        }
        if (r == null)
        {
            i2 = 0;
        } else
        {
            i2 = r.hashCode();
        }
        if (s == null)
        {
            j2 = 0;
        } else
        {
            j2 = s.hashCode();
        }
        if (O == null)
        {
            k2 = ((flag) ? 1 : 0);
        } else
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31 + k2;
_L2:
        k1 = 0;
_L11:
        i1 = j1;
        if (k1 >= c.length) goto _L10; else goto _L9
_L9:
        j1 = j1 * 31 + c[k1];
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= l.length) goto _L13; else goto _L12
_L12:
        if (l[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = l[k1].hashCode();
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
        if (j1 >= m.length) goto _L16; else goto _L15
_L15:
        if (m[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = m[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
_L20:
        j1 = i1;
        if (k1 >= o.length) goto _L19; else goto _L18
_L18:
        if (o[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = o[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
