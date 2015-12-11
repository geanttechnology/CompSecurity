// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dhy extends eul
{

    public dzp a;
    public dre b;
    public dlb c;
    public byte d[];
    public dzp e;
    private String f;
    private dlb g;
    private dlb h;
    private dlb i;
    private String j;
    private dzg k;
    private dfq l[];
    private dfq m[];
    private dxa n[];

    public dhy()
    {
        f = "";
        a = null;
        g = null;
        h = null;
        i = null;
        b = null;
        j = "";
        k = null;
        c = null;
        l = dfq.a;
        m = dfq.a;
        d = eup.f;
        n = dxa.a;
        e = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!f.equals(""))
        {
            j1 = euj.b(1, f) + 0;
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
        if (g != null)
        {
            j1 = i1 + euj.b(3, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(4, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(5, i);
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(6, b);
        }
        j1 = i1;
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(7, j);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(8, k);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(9, c);
        }
        i1 = j1;
        if (l != null)
        {
            dfq adfq[] = l;
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
        if (m != null)
        {
            dfq adfq1[] = m;
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
        if (!Arrays.equals(d, eup.f))
        {
            i1 = j1 + euj.b(14, d);
        }
        j1 = i1;
        if (n != null)
        {
            dxa adxa[] = n;
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
        if (e != null)
        {
            i1 = j1 + euj.b(16, e);
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
                f = eui1.f();
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 34: // '"'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 42: // '*'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 50: // '2'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 58: // ':'
                j = eui1.f();
                break;

            case 66: // 'B'
                if (k == null)
                {
                    k = new dzg();
                }
                eui1.a(k);
                break;

            case 74: // 'J'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 98: // 'b'
                int i2 = eup.a(eui1, 98);
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

            case 106: // 'j'
                int j2 = eup.a(eui1, 106);
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

            case 114: // 'r'
                d = eui1.g();
                break;

            case 122: // 'z'
                int k2 = eup.a(eui1, 122);
                dxa adxa[];
                int l1;
                if (n == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = n.length;
                }
                adxa = new dxa[k2 + l1];
                if (n != null)
                {
                    System.arraycopy(n, 0, adxa, 0, l1);
                }
                for (n = adxa; l1 < n.length - 1; l1++)
                {
                    n[l1] = new dxa();
                    eui1.a(n[l1]);
                    eui1.a();
                }

                n[l1] = new dxa();
                eui1.a(n[l1]);
                break;

            case 130: 
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!f.equals(""))
        {
            euj1.a(1, f);
        }
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (g != null)
        {
            euj1.a(3, g);
        }
        if (h != null)
        {
            euj1.a(4, h);
        }
        if (i != null)
        {
            euj1.a(5, i);
        }
        if (b != null)
        {
            euj1.a(6, b);
        }
        if (!j.equals(""))
        {
            euj1.a(7, j);
        }
        if (k != null)
        {
            euj1.a(8, k);
        }
        if (c != null)
        {
            euj1.a(9, c);
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
                    euj1.a(12, dfq1);
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
                    euj1.a(13, dfq2);
                }
            }

        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(14, d);
        }
        if (n != null)
        {
            dxa adxa[] = n;
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
        if (e != null)
        {
            euj1.a(16, e);
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
            if (!(obj instanceof dhy))
            {
                return false;
            }
            obj = (dhy)obj;
            if ((f != null ? f.equals(((dhy) (obj)).f) : ((dhy) (obj)).f == null) && (a != null ? a.equals(((dhy) (obj)).a) : ((dhy) (obj)).a == null) && (g != null ? g.equals(((dhy) (obj)).g) : ((dhy) (obj)).g == null) && (h != null ? h.equals(((dhy) (obj)).h) : ((dhy) (obj)).h == null) && (i != null ? i.equals(((dhy) (obj)).i) : ((dhy) (obj)).i == null) && (b != null ? b.equals(((dhy) (obj)).b) : ((dhy) (obj)).b == null) && (j != null ? j.equals(((dhy) (obj)).j) : ((dhy) (obj)).j == null) && (k != null ? k.equals(((dhy) (obj)).k) : ((dhy) (obj)).k == null) && (c != null ? c.equals(((dhy) (obj)).c) : ((dhy) (obj)).c == null) && (Arrays.equals(l, ((dhy) (obj)).l) && Arrays.equals(m, ((dhy) (obj)).m) && Arrays.equals(d, ((dhy) (obj)).d) && Arrays.equals(n, ((dhy) (obj)).n)) && (e != null ? e.equals(((dhy) (obj)).e) : ((dhy) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhy) (obj)).O))
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
        int j3 = getClass().getName().hashCode();
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
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
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        if (i == null)
        {
            i2 = 0;
        } else
        {
            i2 = i.hashCode();
        }
        if (b == null)
        {
            j2 = 0;
        } else
        {
            j2 = b.hashCode();
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
        if (c == null)
        {
            i3 = 0;
        } else
        {
            i3 = c.hashCode();
        }
        i1 = i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (l != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        if (m != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L13:
        if (d != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L16:
        if (n != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
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
        if (k1 >= d.length) goto _L16; else goto _L15
_L15:
        j1 = j1 * 31 + d[k1];
        k1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
_L20:
        j1 = i1;
        if (k1 >= n.length) goto _L19; else goto _L18
_L18:
        if (n[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = n[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
