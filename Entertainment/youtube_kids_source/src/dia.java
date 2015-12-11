// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dia extends eul
{

    public dre a;
    public byte b[];
    private String c;
    private dzp d;
    private dlb e;
    private dlb f;
    private dlb g;
    private dzp h;
    private dlb i;
    private dlb j;
    private dlb k;
    private dfq l[];
    private dfq m[];
    private String n;
    private dxa o[];
    private dlb p;
    private dqi q;

    public dia()
    {
        c = "";
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        a = null;
        l = dfq.a;
        m = dfq.a;
        n = "";
        b = eup.f;
        o = dxa.a;
        p = null;
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
        if (g != null)
        {
            j1 = i1 + euj.b(5, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(6, h);
        }
        j1 = i1;
        if (i != null)
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
        if (a != null)
        {
            j1 = k1 + euj.b(10, a);
        }
        i1 = j1;
        if (l != null)
        {
            dfq adfq[] = l;
            int i2 = adfq.length;
            k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= i2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                i1 = j1;
                if (dfq1 != null)
                {
                    i1 = j1 + euj.b(11, dfq1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (m != null)
        {
            dfq adfq1[] = m;
            int j2 = adfq1.length;
            k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= j2)
                {
                    break;
                }
                dfq dfq2 = adfq1[k1];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(12, dfq2);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        k1 = j1;
        if (!n.equals(""))
        {
            k1 = j1 + euj.b(13, n);
        }
        i1 = k1;
        if (!Arrays.equals(b, eup.f))
        {
            i1 = k1 + euj.b(16, b);
        }
        j1 = i1;
        if (o != null)
        {
            dxa adxa[] = o;
            int k2 = adxa.length;
            int l1 = ((flag) ? 1 : 0);
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
                    j1 = i1 + euj.b(17, dxa1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (p != null)
        {
            i1 = j1 + euj.b(18, p);
        }
        j1 = i1;
        if (q != null)
        {
            j1 = i1 + euj.b(19, q);
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
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                if (h == null)
                {
                    h = new dzp();
                }
                eui1.a(h);
                break;

            case 58: // ':'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
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

            case 82: // 'R'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 90: // 'Z'
                int i2 = eup.a(eui1, 90);
                dfq adfq[];
                int j1;
                if (l == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = l.length;
                }
                adfq = new dfq[i2 + j1];
                if (l != null)
                {
                    System.arraycopy(l, 0, adfq, 0, j1);
                }
                for (l = adfq; j1 < l.length - 1; j1++)
                {
                    l[j1] = new dfq();
                    eui1.a(l[j1]);
                    eui1.a();
                }

                l[j1] = new dfq();
                eui1.a(l[j1]);
                break;

            case 98: // 'b'
                int j2 = eup.a(eui1, 98);
                dfq adfq1[];
                int k1;
                if (m == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = m.length;
                }
                adfq1 = new dfq[j2 + k1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adfq1, 0, k1);
                }
                for (m = adfq1; k1 < m.length - 1; k1++)
                {
                    m[k1] = new dfq();
                    eui1.a(m[k1]);
                    eui1.a();
                }

                m[k1] = new dfq();
                eui1.a(m[k1]);
                break;

            case 106: // 'j'
                n = eui1.f();
                break;

            case 130: 
                b = eui1.g();
                break;

            case 138: 
                int k2 = eup.a(eui1, 138);
                dxa adxa[];
                int l1;
                if (o == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = o.length;
                }
                adxa = new dxa[k2 + l1];
                if (o != null)
                {
                    System.arraycopy(o, 0, adxa, 0, l1);
                }
                for (o = adxa; l1 < o.length - 1; l1++)
                {
                    o[l1] = new dxa();
                    eui1.a(o[l1]);
                    eui1.a();
                }

                o[l1] = new dxa();
                eui1.a(o[l1]);
                break;

            case 146: 
                if (p == null)
                {
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 154: 
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
        boolean flag = false;
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
        if (g != null)
        {
            euj1.a(5, g);
        }
        if (h != null)
        {
            euj1.a(6, h);
        }
        if (i != null)
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
        if (a != null)
        {
            euj1.a(10, a);
        }
        if (l != null)
        {
            dfq adfq[] = l;
            int l1 = adfq.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(11, dfq1);
                }
            }

        }
        if (m != null)
        {
            dfq adfq1[] = m;
            int i2 = adfq1.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dfq dfq2 = adfq1[j1];
                if (dfq2 != null)
                {
                    euj1.a(12, dfq2);
                }
            }

        }
        if (!n.equals(""))
        {
            euj1.a(13, n);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(16, b);
        }
        if (o != null)
        {
            dxa adxa[] = o;
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
        if (p != null)
        {
            euj1.a(18, p);
        }
        if (q != null)
        {
            euj1.a(19, q);
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
            if (!(obj instanceof dia))
            {
                return false;
            }
            obj = (dia)obj;
            if ((c != null ? c.equals(((dia) (obj)).c) : ((dia) (obj)).c == null) && (d != null ? d.equals(((dia) (obj)).d) : ((dia) (obj)).d == null) && (e != null ? e.equals(((dia) (obj)).e) : ((dia) (obj)).e == null) && (f != null ? f.equals(((dia) (obj)).f) : ((dia) (obj)).f == null) && (g != null ? g.equals(((dia) (obj)).g) : ((dia) (obj)).g == null) && (h != null ? h.equals(((dia) (obj)).h) : ((dia) (obj)).h == null) && (i != null ? i.equals(((dia) (obj)).i) : ((dia) (obj)).i == null) && (j != null ? j.equals(((dia) (obj)).j) : ((dia) (obj)).j == null) && (k != null ? k.equals(((dia) (obj)).k) : ((dia) (obj)).k == null) && (a != null ? a.equals(((dia) (obj)).a) : ((dia) (obj)).a == null) && (Arrays.equals(l, ((dia) (obj)).l) && Arrays.equals(m, ((dia) (obj)).m)) && (n != null ? n.equals(((dia) (obj)).n) : ((dia) (obj)).n == null) && (Arrays.equals(b, ((dia) (obj)).b) && Arrays.equals(o, ((dia) (obj)).o)) && (p != null ? p.equals(((dia) (obj)).p) : ((dia) (obj)).p == null) && (q != null ? q.equals(((dia) (obj)).q) : ((dia) (obj)).q == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dia) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dia) (obj)).O))
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
        int k3 = getClass().getName().hashCode();
        int i2;
        int j2;
        int k2;
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
        if (g == null)
        {
            i2 = 0;
        } else
        {
            i2 = g.hashCode();
        }
        if (h == null)
        {
            j2 = 0;
        } else
        {
            j2 = h.hashCode();
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
        if (a == null)
        {
            j3 = 0;
        } else
        {
            j3 = a.hashCode();
        }
        i1 = j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (l != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        if (m != null) goto _L4; else goto _L3
_L3:
        k1 = j1 * 31;
_L13:
        if (n == null)
        {
            i1 = 0;
        } else
        {
            i1 = n.hashCode();
        }
        j1 = i1 + k1 * 31;
        if (b != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L16:
        if (o != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (p == null)
        {
            i1 = 0;
        } else
        {
            i1 = p.hashCode();
        }
        if (q == null)
        {
            k1 = 0;
        } else
        {
            k1 = q.hashCode();
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
        j1 = k1;
_L14:
        k1 = i1;
        if (j1 >= m.length) goto _L13; else goto _L12
_L12:
        if (m[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = m[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        i1 = j1;
        if (k1 >= b.length) goto _L16; else goto _L15
_L15:
        j1 = j1 * 31 + b[k1];
        k1++;
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
