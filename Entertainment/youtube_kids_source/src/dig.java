// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dig extends eul
{

    public dre a;
    public byte b[];
    private String c;
    private dzp d;
    private dlb e;
    private dzp f;
    private String g;
    private dlb h;
    private dre i;
    private dlb j;
    private dlb k;
    private dxa l[];
    private dlb m;
    private dlb n;
    private doy o;
    private String p;
    private dqi q;

    public dig()
    {
        c = "";
        d = null;
        e = null;
        f = null;
        a = null;
        g = "";
        h = null;
        i = null;
        j = null;
        k = null;
        b = eup.f;
        l = dxa.a;
        m = null;
        n = null;
        o = null;
        p = "";
        q = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (!c.equals(""))
        {
            j1 = euj.b(1, c) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(2, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(3, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(4, f);
        }
        j1 = i1;
        if (a != null)
        {
            j1 = i1 + euj.b(5, a);
        }
        i1 = j1;
        if (!g.equals(""))
        {
            i1 = j1 + euj.b(6, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(7, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(9, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(10, j);
        }
        k1 = j1;
        if (k != null)
        {
            k1 = j1 + euj.b(11, k);
        }
        i1 = k1;
        if (!Arrays.equals(b, eup.f))
        {
            i1 = k1 + euj.b(12, b);
        }
        j1 = i1;
        if (l != null)
        {
            dxa adxa[] = l;
            int i2 = adxa.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= i2)
                {
                    break;
                }
                dxa dxa1 = adxa[l1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(13, dxa1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(14, m);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(15, n);
        }
        i1 = j1;
        if (o != null)
        {
            i1 = j1 + euj.b(16, o);
        }
        j1 = i1;
        if (!p.equals(""))
        {
            j1 = i1 + euj.b(17, p);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(18, q);
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
                c = eui1.f();
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dzp();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dzp();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 50: // '2'
                g = eui1.f();
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dre();
                }
                eui1.a(i);
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 90: // 'Z'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 98: // 'b'
                b = eui1.g();
                break;

            case 106: // 'j'
                int k1 = eup.a(eui1, 106);
                dxa adxa[];
                int j1;
                if (l == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = l.length;
                }
                adxa = new dxa[k1 + j1];
                if (l != null)
                {
                    System.arraycopy(l, 0, adxa, 0, j1);
                }
                for (l = adxa; j1 < l.length - 1; j1++)
                {
                    l[j1] = new dxa();
                    eui1.a(l[j1]);
                    eui1.a();
                }

                l[j1] = new dxa();
                eui1.a(l[j1]);
                break;

            case 114: // 'r'
                if (m == null)
                {
                    m = new dlb();
                }
                eui1.a(m);
                break;

            case 122: // 'z'
                if (n == null)
                {
                    n = new dlb();
                }
                eui1.a(n);
                break;

            case 130: 
                if (o == null)
                {
                    o = new doy();
                }
                eui1.a(o);
                break;

            case 138: 
                p = eui1.f();
                break;

            case 146: 
                if (q == null)
                {
                    q = new dqi();
                }
                eui1.a(q);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!c.equals(""))
        {
            euj1.a(1, c);
        }
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (a != null)
        {
            euj1.a(5, a);
        }
        if (!g.equals(""))
        {
            euj1.a(6, g);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (k != null)
        {
            euj1.a(11, k);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(12, b);
        }
        if (l != null)
        {
            dxa adxa[] = l;
            int j1 = adxa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(13, dxa1);
                }
            }

        }
        if (m != null)
        {
            euj1.a(14, m);
        }
        if (n != null)
        {
            euj1.a(15, n);
        }
        if (o != null)
        {
            euj1.a(16, o);
        }
        if (!p.equals(""))
        {
            euj1.a(17, p);
        }
        if (q != null)
        {
            euj1.a(18, q);
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
            if (!(obj instanceof dig))
            {
                return false;
            }
            obj = (dig)obj;
            if ((c != null ? c.equals(((dig) (obj)).c) : ((dig) (obj)).c == null) && (d != null ? d.equals(((dig) (obj)).d) : ((dig) (obj)).d == null) && (e != null ? e.equals(((dig) (obj)).e) : ((dig) (obj)).e == null) && (f != null ? f.equals(((dig) (obj)).f) : ((dig) (obj)).f == null) && (a != null ? a.equals(((dig) (obj)).a) : ((dig) (obj)).a == null) && (g != null ? g.equals(((dig) (obj)).g) : ((dig) (obj)).g == null) && (h != null ? h.equals(((dig) (obj)).h) : ((dig) (obj)).h == null) && (i != null ? i.equals(((dig) (obj)).i) : ((dig) (obj)).i == null) && (j != null ? j.equals(((dig) (obj)).j) : ((dig) (obj)).j == null) && (k != null ? k.equals(((dig) (obj)).k) : ((dig) (obj)).k == null) && (Arrays.equals(b, ((dig) (obj)).b) && Arrays.equals(l, ((dig) (obj)).l)) && (m != null ? m.equals(((dig) (obj)).m) : ((dig) (obj)).m == null) && (n != null ? n.equals(((dig) (obj)).n) : ((dig) (obj)).n == null) && (o != null ? o.equals(((dig) (obj)).o) : ((dig) (obj)).o == null) && (p != null ? p.equals(((dig) (obj)).p) : ((dig) (obj)).p == null) && (q != null ? q.equals(((dig) (obj)).q) : ((dig) (obj)).q == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dig) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dig) (obj)).O))
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
        int k3 = getClass().getName().hashCode();
        int l2;
        int i3;
        int j3;
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
        }
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (a == null)
        {
            i2 = 0;
        } else
        {
            i2 = a.hashCode();
        }
        if (g == null)
        {
            j2 = 0;
        } else
        {
            j2 = g.hashCode();
        }
        if (h == null)
        {
            k2 = 0;
        } else
        {
            k2 = h.hashCode();
        }
        if (i == null)
        {
            l2 = 0;
        } else
        {
            l2 = i.hashCode();
        }
        if (j == null)
        {
            i3 = 0;
        } else
        {
            i3 = j.hashCode();
        }
        if (k == null)
        {
            j3 = 0;
        } else
        {
            j3 = k.hashCode();
        }
        j1 = j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L6:
        if (l != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (m == null)
        {
            i1 = 0;
        } else
        {
            i1 = m.hashCode();
        }
        if (n == null)
        {
            k1 = 0;
        } else
        {
            k1 = n.hashCode();
        }
        if (o == null)
        {
            l1 = 0;
        } else
        {
            l1 = o.hashCode();
        }
        if (p == null)
        {
            i2 = 0;
        } else
        {
            i2 = p.hashCode();
        }
        if (q == null)
        {
            j2 = 0;
        } else
        {
            j2 = q.hashCode();
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
_L7:
        i1 = j1;
        if (k1 >= b.length) goto _L6; else goto _L5
_L5:
        j1 = j1 * 31 + b[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= l.length) goto _L9; else goto _L8
_L8:
        if (l[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = l[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }
}
