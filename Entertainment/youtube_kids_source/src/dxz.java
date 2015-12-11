// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxz extends eul
{

    public dre a;
    public dya b;
    public byte c[];
    private dlb d;
    private dzp e;
    private dre f;
    private dzb g;
    private String h;
    private dlb i;
    private dlb j;
    private String k;
    private dlb l;
    private dxa m[];
    private dxa n;
    private dxy o;
    private int p;

    public dxz()
    {
        d = null;
        e = null;
        a = null;
        f = null;
        b = null;
        g = null;
        h = "";
        i = null;
        j = null;
        k = "";
        l = null;
        c = eup.f;
        m = dxa.a;
        n = null;
        o = null;
        p = 0;
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
        if (d != null)
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
        if (a != null)
        {
            j1 = i1 + euj.b(3, a);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(4, f);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(5, b);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(6, g);
        }
        j1 = i1;
        if (!h.equals(""))
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
            j1 = i1 + euj.b(12, j);
        }
        i1 = j1;
        if (!k.equals(""))
        {
            i1 = j1 + euj.b(13, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(14, l);
        }
        i1 = j1;
        if (!Arrays.equals(c, eup.f))
        {
            i1 = j1 + euj.b(15, c);
        }
        j1 = i1;
        if (m != null)
        {
            dxa adxa[] = m;
            int l1 = adxa.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[k1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(16, dxa1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(17, n);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(19, o);
        }
        i1 = j1;
        if (p != 0)
        {
            i1 = j1 + euj.c(20, p);
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
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 18: // '\022'
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 26: // '\032'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (b == null)
                {
                    b = new dya();
                }
                eui1.a(b);
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dzb();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 98: // 'b'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 106: // 'j'
                k = eui1.f();
                break;

            case 114: // 'r'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 122: // 'z'
                c = eui1.g();
                break;

            case 130: 
                int l1 = eup.a(eui1, 130);
                dxa adxa[];
                int j1;
                if (m == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = m.length;
                }
                adxa = new dxa[l1 + j1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adxa, 0, j1);
                }
                for (m = adxa; j1 < m.length - 1; j1++)
                {
                    m[j1] = new dxa();
                    eui1.a(m[j1]);
                    eui1.a();
                }

                m[j1] = new dxa();
                eui1.a(m[j1]);
                break;

            case 138: 
                if (n == null)
                {
                    n = new dxa();
                }
                eui1.a(n);
                break;

            case 154: 
                if (o == null)
                {
                    o = new dxy();
                }
                eui1.a(o);
                break;

            case 160: 
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2 || k1 == 3)
                {
                    p = k1;
                } else
                {
                    p = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null)
        {
            euj1.a(1, d);
        }
        if (e != null)
        {
            euj1.a(2, e);
        }
        if (a != null)
        {
            euj1.a(3, a);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (b != null)
        {
            euj1.a(5, b);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(12, j);
        }
        if (!k.equals(""))
        {
            euj1.a(13, k);
        }
        if (l != null)
        {
            euj1.a(14, l);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(15, c);
        }
        if (m != null)
        {
            dxa adxa[] = m;
            int j1 = adxa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(16, dxa1);
                }
            }

        }
        if (n != null)
        {
            euj1.a(17, n);
        }
        if (o != null)
        {
            euj1.a(19, o);
        }
        if (p != 0)
        {
            euj1.a(20, p);
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
            if (!(obj instanceof dxz))
            {
                return false;
            }
            obj = (dxz)obj;
            if ((d != null ? d.equals(((dxz) (obj)).d) : ((dxz) (obj)).d == null) && (e != null ? e.equals(((dxz) (obj)).e) : ((dxz) (obj)).e == null) && (a != null ? a.equals(((dxz) (obj)).a) : ((dxz) (obj)).a == null) && (f != null ? f.equals(((dxz) (obj)).f) : ((dxz) (obj)).f == null) && (b != null ? b.equals(((dxz) (obj)).b) : ((dxz) (obj)).b == null) && (g != null ? g.equals(((dxz) (obj)).g) : ((dxz) (obj)).g == null) && (h != null ? h.equals(((dxz) (obj)).h) : ((dxz) (obj)).h == null) && (i != null ? i.equals(((dxz) (obj)).i) : ((dxz) (obj)).i == null) && (j != null ? j.equals(((dxz) (obj)).j) : ((dxz) (obj)).j == null) && (k != null ? k.equals(((dxz) (obj)).k) : ((dxz) (obj)).k == null) && (l != null ? l.equals(((dxz) (obj)).l) : ((dxz) (obj)).l == null) && (Arrays.equals(c, ((dxz) (obj)).c) && Arrays.equals(m, ((dxz) (obj)).m)) && (n != null ? n.equals(((dxz) (obj)).n) : ((dxz) (obj)).n == null) && (o != null ? o.equals(((dxz) (obj)).o) : ((dxz) (obj)).o == null) && p == ((dxz) (obj)).p)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxz) (obj)).O))
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
        if (a == null)
        {
            k1 = 0;
        } else
        {
            k1 = a.hashCode();
        }
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (b == null)
        {
            i2 = 0;
        } else
        {
            i2 = b.hashCode();
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
        if (l == null)
        {
            k3 = 0;
        } else
        {
            k3 = l.hashCode();
        }
        j1 = k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L6:
        if (m != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (n == null)
        {
            i1 = 0;
        } else
        {
            i1 = n.hashCode();
        }
        if (o == null)
        {
            k1 = 0;
        } else
        {
            k1 = o.hashCode();
        }
        i2 = p;
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return ((k1 + (i1 + j1 * 31) * 31) * 31 + i2) * 31 + l1;
_L2:
        k1 = 0;
_L7:
        i1 = j1;
        if (k1 >= c.length) goto _L6; else goto _L5
_L5:
        j1 = j1 * 31 + c[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= m.length) goto _L9; else goto _L8
_L8:
        if (m[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = m[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }
}
