// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dli extends eul
{

    public dre a;
    public byte b[];
    private String c;
    private dzp d;
    private dlb e;
    private dlb f;
    private String g;
    private dlb h;
    private dfq i[];
    private dfq j[];
    private dxa k[];
    private dqi l;

    public dli()
    {
        c = "";
        d = null;
        e = null;
        f = null;
        a = null;
        g = "";
        h = null;
        i = dfq.a;
        j = dfq.a;
        b = eup.f;
        k = dxa.a;
        l = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
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
            j1 = i1 + euj.b(4, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(5, f);
        }
        j1 = i1;
        if (a != null)
        {
            j1 = i1 + euj.b(6, a);
        }
        i1 = j1;
        if (!g.equals(""))
        {
            i1 = j1 + euj.b(7, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(9, h);
        }
        i1 = j1;
        if (i != null)
        {
            dfq adfq[] = i;
            int j2 = adfq.length;
            int k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= j2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                i1 = j1;
                if (dfq1 != null)
                {
                    i1 = j1 + euj.b(12, dfq1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (j != null)
        {
            dfq adfq1[] = j;
            int k2 = adfq1.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                dfq dfq2 = adfq1[l1];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(13, dfq2);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!Arrays.equals(b, eup.f))
        {
            i1 = j1 + euj.b(14, b);
        }
        j1 = i1;
        if (k != null)
        {
            dxa adxa[] = k;
            int l2 = adxa.length;
            int i2 = ((flag) ? 1 : 0);
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
                    j1 = i1 + euj.b(15, dxa1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(16, l);
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

            case 34: // '"'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 58: // ':'
                g = eui1.f();
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 98: // 'b'
                int i2 = eup.a(eui1, 98);
                dfq adfq[];
                int j1;
                if (i == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = i.length;
                }
                adfq = new dfq[i2 + j1];
                if (i != null)
                {
                    System.arraycopy(i, 0, adfq, 0, j1);
                }
                for (i = adfq; j1 < i.length - 1; j1++)
                {
                    i[j1] = new dfq();
                    eui1.a(i[j1]);
                    eui1.a();
                }

                i[j1] = new dfq();
                eui1.a(i[j1]);
                break;

            case 106: // 'j'
                int j2 = eup.a(eui1, 106);
                dfq adfq1[];
                int k1;
                if (j == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = j.length;
                }
                adfq1 = new dfq[j2 + k1];
                if (j != null)
                {
                    System.arraycopy(j, 0, adfq1, 0, k1);
                }
                for (j = adfq1; k1 < j.length - 1; k1++)
                {
                    j[k1] = new dfq();
                    eui1.a(j[k1]);
                    eui1.a();
                }

                j[k1] = new dfq();
                eui1.a(j[k1]);
                break;

            case 114: // 'r'
                b = eui1.g();
                break;

            case 122: // 'z'
                int k2 = eup.a(eui1, 122);
                dxa adxa[];
                int l1;
                if (k == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = k.length;
                }
                adxa = new dxa[k2 + l1];
                if (k != null)
                {
                    System.arraycopy(k, 0, adxa, 0, l1);
                }
                for (k = adxa; l1 < k.length - 1; l1++)
                {
                    k[l1] = new dxa();
                    eui1.a(k[l1]);
                    eui1.a();
                }

                k[l1] = new dxa();
                eui1.a(k[l1]);
                break;

            case 130: 
                if (l == null)
                {
                    l = new dqi();
                }
                eui1.a(l);
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
            euj1.a(4, e);
        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (a != null)
        {
            euj1.a(6, a);
        }
        if (!g.equals(""))
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i != null)
        {
            dfq adfq[] = i;
            int l1 = adfq.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(12, dfq1);
                }
            }

        }
        if (j != null)
        {
            dfq adfq1[] = j;
            int i2 = adfq1.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dfq dfq2 = adfq1[j1];
                if (dfq2 != null)
                {
                    euj1.a(13, dfq2);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(14, b);
        }
        if (k != null)
        {
            dxa adxa[] = k;
            int j2 = adxa.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dxa dxa1 = adxa[k1];
                if (dxa1 != null)
                {
                    euj1.a(15, dxa1);
                }
            }

        }
        if (l != null)
        {
            euj1.a(16, l);
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
            if (!(obj instanceof dli))
            {
                return false;
            }
            obj = (dli)obj;
            if ((c != null ? c.equals(((dli) (obj)).c) : ((dli) (obj)).c == null) && (d != null ? d.equals(((dli) (obj)).d) : ((dli) (obj)).d == null) && (e != null ? e.equals(((dli) (obj)).e) : ((dli) (obj)).e == null) && (f != null ? f.equals(((dli) (obj)).f) : ((dli) (obj)).f == null) && (a != null ? a.equals(((dli) (obj)).a) : ((dli) (obj)).a == null) && (g != null ? g.equals(((dli) (obj)).g) : ((dli) (obj)).g == null) && (h != null ? h.equals(((dli) (obj)).h) : ((dli) (obj)).h == null) && (Arrays.equals(i, ((dli) (obj)).i) && Arrays.equals(j, ((dli) (obj)).j) && Arrays.equals(b, ((dli) (obj)).b) && Arrays.equals(k, ((dli) (obj)).k)) && (l != null ? l.equals(((dli) (obj)).l) : ((dli) (obj)).l == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dli) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dli) (obj)).O))
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
        int l2 = getClass().getName().hashCode();
        int l1;
        int i2;
        int j2;
        int k2;
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
        i1 = k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (i != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        if (j != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L13:
        if (b != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L16:
        if (k != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (l == null)
        {
            i1 = 0;
        } else
        {
            i1 = l.hashCode();
        }
        if (O == null)
        {
            k1 = ((flag) ? 1 : 0);
        } else
        {
            k1 = O.hashCode();
        }
        return (i1 + j1 * 31) * 31 + k1;
_L2:
        k1 = 0;
_L11:
        j1 = i1;
        if (k1 >= i.length) goto _L10; else goto _L9
_L9:
        if (i[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = i[k1].hashCode();
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
        if (k1 >= j.length) goto _L13; else goto _L12
_L12:
        if (j[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = j[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
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
        if (k1 >= k.length) goto _L19; else goto _L18
_L18:
        if (k[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = k[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
