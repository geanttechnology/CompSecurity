// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dcu extends eul
{

    private dlb a;
    private dlb b;
    private double c[];
    private dlb d;
    private dre e;
    private int f;
    private dcv g[];
    private dzs h[];
    private dlb i;
    private dlb j;
    private dlb k;
    private dlb l;
    private dlb m;

    public dcu()
    {
        a = null;
        b = null;
        c = eup.c;
        d = null;
        e = null;
        f = 0;
        g = dcv.a;
        h = dzs.a;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
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
        if (b != null)
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1;
            if (c.length > 0)
            {
                j1 = i1 + c.length * 8 + c.length * 1;
            }
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(4, d);
        }
        k1 = i1;
        if (e != null)
        {
            k1 = i1 + euj.b(5, e);
        }
        j1 = k1;
        if (f != 0)
        {
            j1 = k1 + euj.d(6, f);
        }
        i1 = j1;
        if (g != null)
        {
            dcv adcv[] = g;
            int j2 = adcv.length;
            int l1 = 0;
            do
            {
                i1 = j1;
                if (l1 >= j2)
                {
                    break;
                }
                dcv dcv1 = adcv[l1];
                i1 = j1;
                if (dcv1 != null)
                {
                    i1 = j1 + euj.b(7, dcv1);
                }
                l1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (h != null)
        {
            dzs adzs[] = h;
            int k2 = adzs.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= k2)
                {
                    break;
                }
                dzs dzs1 = adzs[i2];
                j1 = i1;
                if (dzs1 != null)
                {
                    j1 = i1 + euj.b(8, dzs1);
                }
                i2++;
                i1 = j1;
            } while (true);
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
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(11, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(12, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(13, m);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 25: // '\031'
                int i2 = eup.a(eui1, 25);
                int j1 = c.length;
                double ad[] = new double[i2 + j1];
                System.arraycopy(c, 0, ad, 0, j1);
                for (c = ad; j1 < c.length - 1; j1++)
                {
                    c[j1] = Double.longBitsToDouble(eui1.j());
                    eui1.a();
                }

                c[j1] = Double.longBitsToDouble(eui1.j());
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 48: // '0'
                f = eui1.h();
                break;

            case 58: // ':'
                int j2 = eup.a(eui1, 58);
                dcv adcv[];
                int k1;
                if (g == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = g.length;
                }
                adcv = new dcv[j2 + k1];
                if (g != null)
                {
                    System.arraycopy(g, 0, adcv, 0, k1);
                }
                for (g = adcv; k1 < g.length - 1; k1++)
                {
                    g[k1] = new dcv();
                    eui1.a(g[k1]);
                    eui1.a();
                }

                g[k1] = new dcv();
                eui1.a(g[k1]);
                break;

            case 66: // 'B'
                int k2 = eup.a(eui1, 66);
                dzs adzs[];
                int l1;
                if (h == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = h.length;
                }
                adzs = new dzs[k2 + l1];
                if (h != null)
                {
                    System.arraycopy(h, 0, adzs, 0, l1);
                }
                for (h = adzs; l1 < h.length - 1; l1++)
                {
                    h[l1] = new dzs();
                    eui1.a(h[l1]);
                    eui1.a();
                }

                h[l1] = new dzs();
                eui1.a(h[l1]);
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dlb();
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
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 106: // 'j'
                if (m == null)
                {
                    m = new dlb();
                }
                eui1.a(m);
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
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            double ad[] = c;
            int l1 = ad.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                euj1.a(3, ad[i1]);
            }

        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.b(6, f);
        }
        if (g != null)
        {
            dcv adcv[] = g;
            int i2 = adcv.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dcv dcv1 = adcv[j1];
                if (dcv1 != null)
                {
                    euj1.a(7, dcv1);
                }
            }

        }
        if (h != null)
        {
            dzs adzs[] = h;
            int j2 = adzs.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dzs dzs1 = adzs[k1];
                if (dzs1 != null)
                {
                    euj1.a(8, dzs1);
                }
            }

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
        if (l != null)
        {
            euj1.a(12, l);
        }
        if (m != null)
        {
            euj1.a(13, m);
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
            if (!(obj instanceof dcu))
            {
                return false;
            }
            obj = (dcu)obj;
            if ((a != null ? a.equals(((dcu) (obj)).a) : ((dcu) (obj)).a == null) && (b != null ? b.equals(((dcu) (obj)).b) : ((dcu) (obj)).b == null) && Arrays.equals(c, ((dcu) (obj)).c) && (d != null ? d.equals(((dcu) (obj)).d) : ((dcu) (obj)).d == null) && (e != null ? e.equals(((dcu) (obj)).e) : ((dcu) (obj)).e == null) && (f == ((dcu) (obj)).f && Arrays.equals(g, ((dcu) (obj)).g) && Arrays.equals(h, ((dcu) (obj)).h)) && (i != null ? i.equals(((dcu) (obj)).i) : ((dcu) (obj)).i == null) && (j != null ? j.equals(((dcu) (obj)).j) : ((dcu) (obj)).j == null) && (k != null ? k.equals(((dcu) (obj)).k) : ((dcu) (obj)).k == null) && (l != null ? l.equals(((dcu) (obj)).l) : ((dcu) (obj)).l == null) && (m != null ? m.equals(((dcu) (obj)).m) : ((dcu) (obj)).m == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dcu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dcu) (obj)).O))
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
        int k2;
        k2 = 0;
        k1 = getClass().getName().hashCode();
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        i1 = j1 + (i1 + (k1 + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L8:
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
        }
        i1 = (k1 + (i1 + j1 * 31) * 31) * 31 + f;
        if (g != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L11:
        if (h != null) goto _L6; else goto _L5
_L5:
        j1 *= 31;
_L14:
        int l1;
        int i2;
        int j2;
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        if (j == null)
        {
            k1 = 0;
        } else
        {
            k1 = j.hashCode();
        }
        if (k == null)
        {
            l1 = 0;
        } else
        {
            l1 = k.hashCode();
        }
        if (l == null)
        {
            i2 = 0;
        } else
        {
            i2 = l.hashCode();
        }
        if (m == null)
        {
            j2 = 0;
        } else
        {
            j2 = m.hashCode();
        }
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31 + k2;
_L2:
        k1 = 0;
_L9:
        j1 = i1;
        if (k1 >= c.length) goto _L8; else goto _L7
_L7:
        i1 = i1 * 31 + (int)(Double.doubleToLongBits(c[k1]) ^ Double.doubleToLongBits(c[k1]) >>> 32);
        k1++;
          goto _L9
          goto _L8
_L4:
        k1 = 0;
_L12:
        j1 = i1;
        if (k1 >= g.length) goto _L11; else goto _L10
_L10:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
        i1 = j1;
_L15:
        j1 = i1;
        if (k1 >= h.length) goto _L14; else goto _L13
_L13:
        if (h[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = h[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L15
    }
}
