// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dge extends eul
{

    public String a;
    public dzp b;
    public ecc c;
    public dlb d;
    public byte e[];
    private String f;
    private dre g;
    private dzp h;
    private int i;
    private dfq j[];
    private int k;
    private dgf l;
    private dzp m;
    private dzp n;
    private dre o;
    private dre p;
    private dre q;
    private dre r;
    private dre s;

    public dge()
    {
        f = "";
        a = "";
        g = null;
        b = null;
        h = null;
        i = 0;
        j = dfq.a;
        k = 1;
        l = null;
        c = null;
        d = null;
        m = null;
        n = null;
        e = eup.f;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
        if (!f.equals(""))
        {
            j1 = euj.b(5, f) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (!a.equals(""))
        {
            i1 = j1 + euj.b(6, a);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(7, g);
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(9, b);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(10, h);
        }
        i1 = j1;
        if (i != 0)
        {
            i1 = j1 + euj.c(12, i);
        }
        j1 = i1;
        if (j != null)
        {
            dfq adfq[] = j;
            int l1 = adfq.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
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
        if (k != 1)
        {
            i1 = j1 + euj.c(17, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(18, l);
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(20, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(22, d);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(24, m);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(25, n);
        }
        i1 = j1;
        if (!Arrays.equals(e, eup.f))
        {
            i1 = j1 + euj.b(27, e);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(28, o);
        }
        i1 = j1;
        if (p != null)
        {
            i1 = j1 + euj.b(29, p);
        }
        j1 = i1;
        if (q != null)
        {
            j1 = i1 + euj.b(30, q);
        }
        i1 = j1;
        if (r != null)
        {
            i1 = j1 + euj.b(34, r);
        }
        j1 = i1;
        if (s != null)
        {
            j1 = i1 + euj.b(35, s);
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

            case 42: // '*'
                f = eui1.f();
                break;

            case 50: // '2'
                a = eui1.f();
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;

            case 74: // 'J'
                if (b == null)
                {
                    b = new dzp();
                }
                eui1.a(b);
                break;

            case 82: // 'R'
                if (h == null)
                {
                    h = new dzp();
                }
                eui1.a(h);
                break;

            case 96: // '`'
                i = eui1.d();
                break;

            case 106: // 'j'
                int l1 = eup.a(eui1, 106);
                dfq adfq[];
                int j1;
                if (j == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = j.length;
                }
                adfq = new dfq[l1 + j1];
                if (j != null)
                {
                    System.arraycopy(j, 0, adfq, 0, j1);
                }
                for (j = adfq; j1 < j.length - 1; j1++)
                {
                    j[j1] = new dfq();
                    eui1.a(j[j1]);
                    eui1.a();
                }

                j[j1] = new dfq();
                eui1.a(j[j1]);
                break;

            case 136: 
                int k1 = eui1.d();
                if (k1 == 1 || k1 == 2)
                {
                    k = k1;
                } else
                {
                    k = 1;
                }
                break;

            case 146: 
                if (l == null)
                {
                    l = new dgf();
                }
                eui1.a(l);
                break;

            case 162: 
                if (c == null)
                {
                    c = new ecc();
                }
                eui1.a(c);
                break;

            case 178: 
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 194: 
                if (m == null)
                {
                    m = new dzp();
                }
                eui1.a(m);
                break;

            case 202: 
                if (n == null)
                {
                    n = new dzp();
                }
                eui1.a(n);
                break;

            case 218: 
                e = eui1.g();
                break;

            case 226: 
                if (o == null)
                {
                    o = new dre();
                }
                eui1.a(o);
                break;

            case 234: 
                if (p == null)
                {
                    p = new dre();
                }
                eui1.a(p);
                break;

            case 242: 
                if (q == null)
                {
                    q = new dre();
                }
                eui1.a(q);
                break;

            case 274: 
                if (r == null)
                {
                    r = new dre();
                }
                eui1.a(r);
                break;

            case 282: 
                if (s == null)
                {
                    s = new dre();
                }
                eui1.a(s);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!f.equals(""))
        {
            euj1.a(5, f);
        }
        if (!a.equals(""))
        {
            euj1.a(6, a);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (b != null)
        {
            euj1.a(9, b);
        }
        if (h != null)
        {
            euj1.a(10, h);
        }
        if (i != 0)
        {
            euj1.a(12, i);
        }
        if (j != null)
        {
            dfq adfq[] = j;
            int j1 = adfq.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(13, dfq1);
                }
            }

        }
        if (k != 1)
        {
            euj1.a(17, k);
        }
        if (l != null)
        {
            euj1.a(18, l);
        }
        if (c != null)
        {
            euj1.a(20, c);
        }
        if (d != null)
        {
            euj1.a(22, d);
        }
        if (m != null)
        {
            euj1.a(24, m);
        }
        if (n != null)
        {
            euj1.a(25, n);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(27, e);
        }
        if (o != null)
        {
            euj1.a(28, o);
        }
        if (p != null)
        {
            euj1.a(29, p);
        }
        if (q != null)
        {
            euj1.a(30, q);
        }
        if (r != null)
        {
            euj1.a(34, r);
        }
        if (s != null)
        {
            euj1.a(35, s);
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
            if (!(obj instanceof dge))
            {
                return false;
            }
            obj = (dge)obj;
            if ((f != null ? f.equals(((dge) (obj)).f) : ((dge) (obj)).f == null) && (a != null ? a.equals(((dge) (obj)).a) : ((dge) (obj)).a == null) && (g != null ? g.equals(((dge) (obj)).g) : ((dge) (obj)).g == null) && (b != null ? b.equals(((dge) (obj)).b) : ((dge) (obj)).b == null) && (h != null ? h.equals(((dge) (obj)).h) : ((dge) (obj)).h == null) && (i == ((dge) (obj)).i && Arrays.equals(j, ((dge) (obj)).j) && k == ((dge) (obj)).k) && (l != null ? l.equals(((dge) (obj)).l) : ((dge) (obj)).l == null) && (c != null ? c.equals(((dge) (obj)).c) : ((dge) (obj)).c == null) && (d != null ? d.equals(((dge) (obj)).d) : ((dge) (obj)).d == null) && (m != null ? m.equals(((dge) (obj)).m) : ((dge) (obj)).m == null) && (n != null ? n.equals(((dge) (obj)).n) : ((dge) (obj)).n == null) && Arrays.equals(e, ((dge) (obj)).e) && (o != null ? o.equals(((dge) (obj)).o) : ((dge) (obj)).o == null) && (p != null ? p.equals(((dge) (obj)).p) : ((dge) (obj)).p == null) && (q != null ? q.equals(((dge) (obj)).q) : ((dge) (obj)).q == null) && (r != null ? r.equals(((dge) (obj)).r) : ((dge) (obj)).r == null) && (s != null ? s.equals(((dge) (obj)).s) : ((dge) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dge) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dge) (obj)).O))
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
        k2 = 0;
        j2 = getClass().getName().hashCode();
        int l2;
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (a == null)
        {
            j1 = 0;
        } else
        {
            j1 = a.hashCode();
        }
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.hashCode();
        }
        if (b == null)
        {
            l1 = 0;
        } else
        {
            l1 = b.hashCode();
        }
        if (h == null)
        {
            i2 = 0;
        } else
        {
            i2 = h.hashCode();
        }
        i1 = (i2 + (l1 + (k1 + (j1 + (i1 + (j2 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i;
        if (j != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        l2 = k;
        if (l == null)
        {
            i1 = 0;
        } else
        {
            i1 = l.hashCode();
        }
        if (c == null)
        {
            k1 = 0;
        } else
        {
            k1 = c.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (m == null)
        {
            i2 = 0;
        } else
        {
            i2 = m.hashCode();
        }
        if (n == null)
        {
            j2 = 0;
        } else
        {
            j2 = n.hashCode();
        }
        i1 = j2 + (i2 + (l1 + (k1 + (i1 + (j1 * 31 + l2) * 31) * 31) * 31) * 31) * 31;
        if (e != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
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
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31 + k2;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= j.length) goto _L6; else goto _L5
_L5:
        if (j[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = j[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= e.length) goto _L9; else goto _L8
_L8:
        i1 = i1 * 31 + e[k1];
        k1++;
          goto _L10
    }
}
