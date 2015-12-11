// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dvk extends eul
{

    public dre a;
    public dvj b;
    public byte c[];
    private String d;
    private dzp e;
    private dlb f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dzp j;
    private dlb k;
    private String l[];
    private String m[];
    private dvl n;
    private String o;
    private dxa p[];
    private dre q;
    private dqi r;
    private dlb s;

    public dvk()
    {
        d = "";
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        a = null;
        b = null;
        l = eup.d;
        m = eup.d;
        n = null;
        o = "";
        c = eup.f;
        p = dxa.a;
        q = null;
        r = null;
        s = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int i2;
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
        if (k != null)
        {
            i1 = j1 + euj.b(8, k);
        }
        j1 = i1;
        if (a != null)
        {
            j1 = i1 + euj.b(9, a);
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(10, b);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1;
            if (l.length > 0)
            {
                String as[] = l;
                int k2 = as.length;
                j1 = 0;
                int k1 = 0;
                for (; j1 < k2; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + l.length * 1;
            }
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1;
            if (m.length > 0)
            {
                String as1[] = m;
                int l2 = as1.length;
                i1 = 0;
                int l1 = 0;
                for (; i1 < l2; i1++)
                {
                    l1 += euj.a(as1[i1]);
                }

                i1 = j1 + l1 + m.length * 1;
            }
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(13, n);
        }
        i2 = j1;
        if (!o.equals(""))
        {
            i2 = j1 + euj.b(14, o);
        }
        i1 = i2;
        if (!Arrays.equals(c, eup.f))
        {
            i1 = i2 + euj.b(16, c);
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
                    j = new dzp();
                }
                eui1.a(j);
                break;

            case 66: // 'B'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 74: // 'J'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 82: // 'R'
                if (b == null)
                {
                    b = new dvj();
                }
                eui1.a(b);
                break;

            case 90: // 'Z'
                int i2 = eup.a(eui1, 90);
                int j1 = l.length;
                String as[] = new String[i2 + j1];
                System.arraycopy(l, 0, as, 0, j1);
                for (l = as; j1 < l.length - 1; j1++)
                {
                    l[j1] = eui1.f();
                    eui1.a();
                }

                l[j1] = eui1.f();
                break;

            case 98: // 'b'
                int j2 = eup.a(eui1, 98);
                int k1 = m.length;
                String as1[] = new String[j2 + k1];
                System.arraycopy(m, 0, as1, 0, k1);
                for (m = as1; k1 < m.length - 1; k1++)
                {
                    m[k1] = eui1.f();
                    eui1.a();
                }

                m[k1] = eui1.f();
                break;

            case 106: // 'j'
                if (n == null)
                {
                    n = new dvl();
                }
                eui1.a(n);
                break;

            case 114: // 'r'
                o = eui1.f();
                break;

            case 130: 
                c = eui1.g();
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
                    q = new dre();
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

            case 162: 
                if (s == null)
                {
                    s = new dlb();
                }
                eui1.a(s);
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
        if (k != null)
        {
            euj1.a(8, k);
        }
        if (a != null)
        {
            euj1.a(9, a);
        }
        if (b != null)
        {
            euj1.a(10, b);
        }
        if (l != null)
        {
            String as[] = l;
            int l1 = as.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                euj1.a(11, as[i1]);
            }

        }
        if (m != null)
        {
            String as1[] = m;
            int i2 = as1.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                euj1.a(12, as1[j1]);
            }

        }
        if (n != null)
        {
            euj1.a(13, n);
        }
        if (!o.equals(""))
        {
            euj1.a(14, o);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(16, c);
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
            if (!(obj instanceof dvk))
            {
                return false;
            }
            obj = (dvk)obj;
            if ((d != null ? d.equals(((dvk) (obj)).d) : ((dvk) (obj)).d == null) && (e != null ? e.equals(((dvk) (obj)).e) : ((dvk) (obj)).e == null) && (f != null ? f.equals(((dvk) (obj)).f) : ((dvk) (obj)).f == null) && (g != null ? g.equals(((dvk) (obj)).g) : ((dvk) (obj)).g == null) && (h != null ? h.equals(((dvk) (obj)).h) : ((dvk) (obj)).h == null) && (i != null ? i.equals(((dvk) (obj)).i) : ((dvk) (obj)).i == null) && (j != null ? j.equals(((dvk) (obj)).j) : ((dvk) (obj)).j == null) && (k != null ? k.equals(((dvk) (obj)).k) : ((dvk) (obj)).k == null) && (a != null ? a.equals(((dvk) (obj)).a) : ((dvk) (obj)).a == null) && (b != null ? b.equals(((dvk) (obj)).b) : ((dvk) (obj)).b == null) && (Arrays.equals(l, ((dvk) (obj)).l) && Arrays.equals(m, ((dvk) (obj)).m)) && (n != null ? n.equals(((dvk) (obj)).n) : ((dvk) (obj)).n == null) && (o != null ? o.equals(((dvk) (obj)).o) : ((dvk) (obj)).o == null) && (Arrays.equals(c, ((dvk) (obj)).c) && Arrays.equals(p, ((dvk) (obj)).p)) && (q != null ? q.equals(((dvk) (obj)).q) : ((dvk) (obj)).q == null) && (r != null ? r.equals(((dvk) (obj)).r) : ((dvk) (obj)).r == null) && (s != null ? s.equals(((dvk) (obj)).s) : ((dvk) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvk) (obj)).O))
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
        int k3 = getClass().getName().hashCode();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
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
        if (k == null)
        {
            l2 = 0;
        } else
        {
            l2 = k.hashCode();
        }
        if (a == null)
        {
            i3 = 0;
        } else
        {
            i3 = a.hashCode();
        }
        if (b == null)
        {
            j3 = 0;
        } else
        {
            j3 = b.hashCode();
        }
        i1 = j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (l != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        if (m != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L13:
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
        j1 = k1 + (i1 + j1 * 31) * 31;
        if (c != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L16:
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
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + i2;
_L2:
        k1 = 0;
_L11:
        j1 = i1;
        if (k1 >= l.length) goto _L10; else goto _L9
_L9:
        if (l[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = l[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
        i1 = j1;
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
_L17:
        i1 = j1;
        if (k1 >= c.length) goto _L16; else goto _L15
_L15:
        j1 = j1 * 31 + c[k1];
        k1++;
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
