// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dev extends eul
{

    public ecn a;
    public ecu b;
    public ecr c[];
    public byte d[];
    private dlb e;
    private dre f;
    private dlb g[];
    private dfq h[];
    private boolean i;
    private dlb j;

    public dev()
    {
        e = null;
        f = null;
        g = dlb.a;
        h = dfq.a;
        a = null;
        b = null;
        c = ecr.a;
        i = false;
        j = null;
        d = eup.f;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        int k1;
        if (e != null)
        {
            k = euj.b(1, e) + 0;
        } else
        {
            k = 0;
        }
        l = k;
        if (f != null)
        {
            l = k + euj.b(2, f);
        }
        k = l;
        if (g != null)
        {
            dlb adlb[] = g;
            int i2 = adlb.length;
            int i1 = 0;
            do
            {
                k = l;
                if (i1 >= i2)
                {
                    break;
                }
                dlb dlb1 = adlb[i1];
                k = l;
                if (dlb1 != null)
                {
                    k = l + euj.b(3, dlb1);
                }
                i1++;
                l = k;
            } while (true);
        }
        l = k;
        if (h != null)
        {
            dfq adfq[] = h;
            int j2 = adfq.length;
            int j1 = 0;
            do
            {
                l = k;
                if (j1 >= j2)
                {
                    break;
                }
                dfq dfq1 = adfq[j1];
                l = k;
                if (dfq1 != null)
                {
                    l = k + euj.b(4, dfq1);
                }
                j1++;
                k = l;
            } while (true);
        }
        k1 = l;
        if (a != null)
        {
            k1 = l + euj.b(5, a);
        }
        k = k1;
        if (b != null)
        {
            k = k1 + euj.b(6, b);
        }
        l = k;
        if (c != null)
        {
            ecr aecr[] = c;
            int k2 = aecr.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                l = k;
                if (l1 >= k2)
                {
                    break;
                }
                ecr ecr1 = aecr[l1];
                l = k;
                if (ecr1 != null)
                {
                    l = k + euj.b(7, ecr1);
                }
                l1++;
                k = l;
            } while (true);
        }
        k = l;
        if (i)
        {
            boolean flag1 = i;
            k = l + (euj.b(8) + 1);
        }
        l = k;
        if (j != null)
        {
            l = k + euj.b(9, j);
        }
        k = l;
        if (!Arrays.equals(d, eup.f))
        {
            k = l + euj.b(11, d);
        }
        k += eup.a(O);
        P = k;
        return k;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int k = eui1.a();
            switch (k)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 18: // '\022'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 26: // '\032'
                int k1 = eup.a(eui1, 26);
                dlb adlb[];
                int l;
                if (g == null)
                {
                    l = 0;
                } else
                {
                    l = g.length;
                }
                adlb = new dlb[k1 + l];
                if (g != null)
                {
                    System.arraycopy(g, 0, adlb, 0, l);
                }
                for (g = adlb; l < g.length - 1; l++)
                {
                    g[l] = new dlb();
                    eui1.a(g[l]);
                    eui1.a();
                }

                g[l] = new dlb();
                eui1.a(g[l]);
                break;

            case 34: // '"'
                int l1 = eup.a(eui1, 34);
                dfq adfq[];
                int i1;
                if (h == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = h.length;
                }
                adfq = new dfq[l1 + i1];
                if (h != null)
                {
                    System.arraycopy(h, 0, adfq, 0, i1);
                }
                for (h = adfq; i1 < h.length - 1; i1++)
                {
                    h[i1] = new dfq();
                    eui1.a(h[i1]);
                    eui1.a();
                }

                h[i1] = new dfq();
                eui1.a(h[i1]);
                break;

            case 42: // '*'
                if (a == null)
                {
                    a = new ecn();
                }
                eui1.a(a);
                break;

            case 50: // '2'
                if (b == null)
                {
                    b = new ecu();
                }
                eui1.a(b);
                break;

            case 58: // ':'
                int i2 = eup.a(eui1, 58);
                ecr aecr[];
                int j1;
                if (c == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = c.length;
                }
                aecr = new ecr[i2 + j1];
                if (c != null)
                {
                    System.arraycopy(c, 0, aecr, 0, j1);
                }
                for (c = aecr; j1 < c.length - 1; j1++)
                {
                    c[j1] = new ecr();
                    eui1.a(c[j1]);
                    eui1.a();
                }

                c[j1] = new ecr();
                eui1.a(c[j1]);
                break;

            case 64: // '@'
                i = eui1.e();
                break;

            case 74: // 'J'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 90: // 'Z'
                d = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (e != null)
        {
            euj1.a(1, e);
        }
        if (f != null)
        {
            euj1.a(2, f);
        }
        if (g != null)
        {
            dlb adlb[] = g;
            int j1 = adlb.length;
            for (int k = 0; k < j1; k++)
            {
                dlb dlb1 = adlb[k];
                if (dlb1 != null)
                {
                    euj1.a(3, dlb1);
                }
            }

        }
        if (h != null)
        {
            dfq adfq[] = h;
            int k1 = adfq.length;
            for (int l = 0; l < k1; l++)
            {
                dfq dfq1 = adfq[l];
                if (dfq1 != null)
                {
                    euj1.a(4, dfq1);
                }
            }

        }
        if (a != null)
        {
            euj1.a(5, a);
        }
        if (b != null)
        {
            euj1.a(6, b);
        }
        if (c != null)
        {
            ecr aecr[] = c;
            int l1 = aecr.length;
            for (int i1 = ((flag) ? 1 : 0); i1 < l1; i1++)
            {
                ecr ecr1 = aecr[i1];
                if (ecr1 != null)
                {
                    euj1.a(7, ecr1);
                }
            }

        }
        if (i)
        {
            euj1.a(8, i);
        }
        if (j != null)
        {
            euj1.a(9, j);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(11, d);
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
            if (!(obj instanceof dev))
            {
                return false;
            }
            obj = (dev)obj;
            if ((e != null ? e.equals(((dev) (obj)).e) : ((dev) (obj)).e == null) && (f != null ? f.equals(((dev) (obj)).f) : ((dev) (obj)).f == null) && (Arrays.equals(g, ((dev) (obj)).g) && Arrays.equals(h, ((dev) (obj)).h)) && (a != null ? a.equals(((dev) (obj)).a) : ((dev) (obj)).a == null) && (b != null ? b.equals(((dev) (obj)).b) : ((dev) (obj)).b == null) && (Arrays.equals(c, ((dev) (obj)).c) && i == ((dev) (obj)).i) && (j != null ? j.equals(((dev) (obj)).j) : ((dev) (obj)).j == null) && Arrays.equals(d, ((dev) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dev) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dev) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k;
        int l;
        int i1;
        boolean flag = false;
        i1 = getClass().getName().hashCode();
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (f == null)
        {
            l = 0;
        } else
        {
            l = f.hashCode();
        }
        k = l + (k + (i1 + 527) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L10:
        if (h != null) goto _L4; else goto _L3
_L3:
        l *= 31;
_L13:
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        k = i1 + (k + l * 31) * 31;
        if (c != null) goto _L6; else goto _L5
_L5:
        l = k * 31;
_L16:
        if (i)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (j == null)
        {
            i1 = 0;
        } else
        {
            i1 = j.hashCode();
        }
        k = i1 + (k + l * 31) * 31;
        if (d != null) goto _L8; else goto _L7
_L7:
        l = k * 31;
_L19:
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return l * 31 + k;
_L2:
        i1 = 0;
_L11:
        l = k;
        if (i1 >= g.length) goto _L10; else goto _L9
_L9:
        if (g[i1] == null)
        {
            l = 0;
        } else
        {
            l = g[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L11
          goto _L10
_L4:
        i1 = 0;
        k = l;
_L14:
        l = k;
        if (i1 >= h.length) goto _L13; else goto _L12
_L12:
        if (h[i1] == null)
        {
            l = 0;
        } else
        {
            l = h[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L14
          goto _L13
_L6:
        i1 = 0;
_L17:
        l = k;
        if (i1 >= c.length) goto _L16; else goto _L15
_L15:
        if (c[i1] == null)
        {
            l = 0;
        } else
        {
            l = c[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L17
          goto _L16
_L8:
        i1 = 0;
_L20:
        l = k;
        if (i1 >= d.length) goto _L19; else goto _L18
_L18:
        k = k * 31 + d[i1];
        i1++;
          goto _L20
    }
}
