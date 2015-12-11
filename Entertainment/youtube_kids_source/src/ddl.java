// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ddl extends eul
{

    private dlb a;
    private dlb b;
    private long c[];
    private double d[];
    private dlb e;
    private dre f;
    private dzs g[];
    private int h;
    private dlb i;
    private double j;
    private dlb k;
    private dlb l[];

    public ddl()
    {
        a = null;
        b = null;
        c = eup.b;
        d = eup.c;
        e = null;
        f = null;
        g = dzs.a;
        h = 0;
        i = null;
        j = 0.0D;
        k = null;
        l = dlb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int i2;
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
                long al[] = c;
                int j2 = al.length;
                j1 = 0;
                int k1 = 0;
                for (; j1 < j2; j1++)
                {
                    k1 += euj.a(al[j1]);
                }

                j1 = i1 + k1 + c.length * 1;
            }
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1;
            if (d.length > 0)
            {
                i1 = j1 + d.length * 8 + d.length * 1;
            }
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(6, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(7, f);
        }
        j1 = i1;
        if (g != null)
        {
            dzs adzs[] = g;
            int k2 = adzs.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                dzs dzs1 = adzs[l1];
                j1 = i1;
                if (dzs1 != null)
                {
                    j1 = i1 + euj.b(8, dzs1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (h != 0)
        {
            i1 = j1 + euj.d(9, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(10, i);
        }
        i2 = j1;
        if (j != 0.0D)
        {
            double d1 = j;
            i2 = j1 + (euj.b(11) + 8);
        }
        i1 = i2;
        if (k != null)
        {
            i1 = i2 + euj.b(12, k);
        }
        i2 = i1;
        if (l != null)
        {
            dlb adlb[] = l;
            int l2 = adlb.length;
            j1 = ((flag) ? 1 : 0);
            do
            {
                i2 = i1;
                if (j1 >= l2)
                {
                    break;
                }
                dlb dlb1 = adlb[j1];
                i2 = i1;
                if (dlb1 != null)
                {
                    i2 = i1 + euj.b(13, dlb1);
                }
                j1++;
                i1 = i2;
            } while (true);
        }
        i1 = i2 + eup.a(O);
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

            case 32: // ' '
                int j2 = eup.a(eui1, 32);
                int j1 = c.length;
                long al[] = new long[j2 + j1];
                System.arraycopy(c, 0, al, 0, j1);
                for (c = al; j1 < c.length - 1; j1++)
                {
                    c[j1] = eui1.c();
                    eui1.a();
                }

                c[j1] = eui1.c();
                break;

            case 41: // ')'
                int k2 = eup.a(eui1, 41);
                int k1 = d.length;
                double ad[] = new double[k2 + k1];
                System.arraycopy(d, 0, ad, 0, k1);
                for (d = ad; k1 < d.length - 1; k1++)
                {
                    d[k1] = Double.longBitsToDouble(eui1.j());
                    eui1.a();
                }

                d[k1] = Double.longBitsToDouble(eui1.j());
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                int l2 = eup.a(eui1, 66);
                dzs adzs[];
                int l1;
                if (g == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = g.length;
                }
                adzs = new dzs[l2 + l1];
                if (g != null)
                {
                    System.arraycopy(g, 0, adzs, 0, l1);
                }
                for (g = adzs; l1 < g.length - 1; l1++)
                {
                    g[l1] = new dzs();
                    eui1.a(g[l1]);
                    eui1.a();
                }

                g[l1] = new dzs();
                eui1.a(g[l1]);
                break;

            case 72: // 'H'
                h = eui1.h();
                break;

            case 82: // 'R'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 89: // 'Y'
                j = Double.longBitsToDouble(eui1.j());
                break;

            case 98: // 'b'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 106: // 'j'
                int i3 = eup.a(eui1, 106);
                dlb adlb[];
                int i2;
                if (l == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = l.length;
                }
                adlb = new dlb[i3 + i2];
                if (l != null)
                {
                    System.arraycopy(l, 0, adlb, 0, i2);
                }
                for (l = adlb; i2 < l.length - 1; i2++)
                {
                    l[i2] = new dlb();
                    eui1.a(l[i2]);
                    eui1.a();
                }

                l[i2] = new dlb();
                eui1.a(l[i2]);
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
            long al[] = c;
            int i2 = al.length;
            for (int i1 = 0; i1 < i2; i1++)
            {
                euj1.b(4, al[i1]);
            }

        }
        if (d != null)
        {
            double ad[] = d;
            int j2 = ad.length;
            for (int j1 = 0; j1 < j2; j1++)
            {
                euj1.a(5, ad[j1]);
            }

        }
        if (e != null)
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            dzs adzs[] = g;
            int k2 = adzs.length;
            for (int k1 = 0; k1 < k2; k1++)
            {
                dzs dzs1 = adzs[k1];
                if (dzs1 != null)
                {
                    euj1.a(8, dzs1);
                }
            }

        }
        if (h != 0)
        {
            euj1.b(9, h);
        }
        if (i != null)
        {
            euj1.a(10, i);
        }
        if (j != 0.0D)
        {
            euj1.a(11, j);
        }
        if (k != null)
        {
            euj1.a(12, k);
        }
        if (l != null)
        {
            dlb adlb[] = l;
            int l2 = adlb.length;
            for (int l1 = ((flag) ? 1 : 0); l1 < l2; l1++)
            {
                dlb dlb1 = adlb[l1];
                if (dlb1 != null)
                {
                    euj1.a(13, dlb1);
                }
            }

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
            if (!(obj instanceof ddl))
            {
                return false;
            }
            obj = (ddl)obj;
            if ((a != null ? a.equals(((ddl) (obj)).a) : ((ddl) (obj)).a == null) && (b != null ? b.equals(((ddl) (obj)).b) : ((ddl) (obj)).b == null) && (Arrays.equals(c, ((ddl) (obj)).c) && Arrays.equals(d, ((ddl) (obj)).d)) && (e != null ? e.equals(((ddl) (obj)).e) : ((ddl) (obj)).e == null) && (f != null ? f.equals(((ddl) (obj)).f) : ((ddl) (obj)).f == null) && (Arrays.equals(g, ((ddl) (obj)).g) && h == ((ddl) (obj)).h) && (i != null ? i.equals(((ddl) (obj)).i) : ((ddl) (obj)).i == null) && j == ((ddl) (obj)).j && (k != null ? k.equals(((ddl) (obj)).k) : ((ddl) (obj)).k == null) && Arrays.equals(l, ((ddl) (obj)).l))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddl) (obj)).O))
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
        boolean flag = false;
        k1 = getClass().getName().hashCode();
        int l1;
        int i2;
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
        j1 += (i1 + (k1 + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L10:
        if (d != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            k1 = 0;
        } else
        {
            k1 = f.hashCode();
        }
        i1 = k1 + (i1 + j1 * 31) * 31;
        if (g != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L16:
        l1 = h;
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        i2 = (int)(Double.doubleToLongBits(j) ^ Double.doubleToLongBits(j) >>> 32);
        if (k == null)
        {
            k1 = 0;
        } else
        {
            k1 = k.hashCode();
        }
        i1 = k1 + ((i1 + (j1 * 31 + l1) * 31) * 31 + i2) * 31;
        if (l != null) goto _L8; else goto _L7
_L7:
        k1 = i1 * 31;
_L19:
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return k1 * 31 + i1;
_L2:
        k1 = 0;
_L11:
        i1 = j1;
        if (k1 >= c.length) goto _L10; else goto _L9
_L9:
        j1 = j1 * 31 + (int)(c[k1] ^ c[k1] >>> 32);
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= d.length) goto _L13; else goto _L12
_L12:
        i1 = i1 * 31 + (int)(Double.doubleToLongBits(d[k1]) ^ Double.doubleToLongBits(d[k1]) >>> 32);
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        j1 = i1;
        if (k1 >= g.length) goto _L16; else goto _L15
_L15:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L17
          goto _L16
_L8:
        j1 = 0;
_L20:
        k1 = i1;
        if (j1 >= l.length) goto _L19; else goto _L18
_L18:
        if (l[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = l[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L20
    }
}
