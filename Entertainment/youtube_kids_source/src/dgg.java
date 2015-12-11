// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dgg extends eul
{

    public static final dgg a[] = new dgg[0];
    private long b;
    private long c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private dre i;
    private dzp j;
    private dtk k;
    private byte l[];
    private duf m;
    private dpd n[];

    public dgg()
    {
        b = 0L;
        c = 0L;
        d = 0L;
        e = "";
        f = "";
        g = "";
        h = "";
        i = null;
        j = null;
        k = null;
        l = eup.f;
        m = null;
        n = dpd.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (b != 0L)
        {
            j1 = euj.d(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c != 0L)
        {
            i1 = j1 + euj.d(2, c);
        }
        j1 = i1;
        if (d != 0L)
        {
            j1 = i1 + euj.d(3, d);
        }
        i1 = j1;
        if (!e.equals(""))
        {
            i1 = j1 + euj.b(4, e);
        }
        j1 = i1;
        if (!f.equals(""))
        {
            j1 = i1 + euj.b(5, f);
        }
        i1 = j1;
        if (!g.equals(""))
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
            i1 = j1 + euj.b(8, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(9, j);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(10, k);
        }
        j1 = i1;
        if (!Arrays.equals(l, eup.f))
        {
            j1 = i1 + euj.b(12, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(13, m);
        }
        k1 = i1;
        if (n != null)
        {
            dpd adpd[] = n;
            int l1 = adpd.length;
            j1 = ((flag) ? 1 : 0);
            do
            {
                k1 = i1;
                if (j1 >= l1)
                {
                    break;
                }
                dpd dpd1 = adpd[j1];
                k1 = i1;
                if (dpd1 != null)
                {
                    k1 = i1 + euj.b(14, dpd1);
                }
                j1++;
                i1 = k1;
            } while (true);
        }
        i1 = k1 + eup.a(O);
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

            case 8: // '\b'
                b = eui1.c();
                break;

            case 16: // '\020'
                c = eui1.c();
                break;

            case 24: // '\030'
                d = eui1.c();
                break;

            case 34: // '"'
                e = eui1.f();
                break;

            case 42: // '*'
                f = eui1.f();
                break;

            case 50: // '2'
                g = eui1.f();
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 66: // 'B'
                if (i == null)
                {
                    i = new dre();
                }
                eui1.a(i);
                break;

            case 74: // 'J'
                if (j == null)
                {
                    j = new dzp();
                }
                eui1.a(j);
                break;

            case 82: // 'R'
                if (k == null)
                {
                    k = new dtk();
                }
                eui1.a(k);
                break;

            case 98: // 'b'
                l = eui1.g();
                break;

            case 106: // 'j'
                if (m == null)
                {
                    m = new duf();
                }
                eui1.a(m);
                break;

            case 114: // 'r'
                int k1 = eup.a(eui1, 114);
                dpd adpd[];
                int j1;
                if (n == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = n.length;
                }
                adpd = new dpd[k1 + j1];
                if (n != null)
                {
                    System.arraycopy(n, 0, adpd, 0, j1);
                }
                for (n = adpd; j1 < n.length - 1; j1++)
                {
                    n[j1] = new dpd();
                    eui1.a(n[j1]);
                    eui1.a();
                }

                n[j1] = new dpd();
                eui1.a(n[j1]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0L)
        {
            euj1.b(1, b);
        }
        if (c != 0L)
        {
            euj1.b(2, c);
        }
        if (d != 0L)
        {
            euj1.b(3, d);
        }
        if (!e.equals(""))
        {
            euj1.a(4, e);
        }
        if (!f.equals(""))
        {
            euj1.a(5, f);
        }
        if (!g.equals(""))
        {
            euj1.a(6, g);
        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(8, i);
        }
        if (j != null)
        {
            euj1.a(9, j);
        }
        if (k != null)
        {
            euj1.a(10, k);
        }
        if (!Arrays.equals(l, eup.f))
        {
            euj1.a(12, l);
        }
        if (m != null)
        {
            euj1.a(13, m);
        }
        if (n != null)
        {
            dpd adpd[] = n;
            int j1 = adpd.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dpd dpd1 = adpd[i1];
                if (dpd1 != null)
                {
                    euj1.a(14, dpd1);
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
            if (!(obj instanceof dgg))
            {
                return false;
            }
            obj = (dgg)obj;
            if (b == ((dgg) (obj)).b && c == ((dgg) (obj)).c && d == ((dgg) (obj)).d && (e != null ? e.equals(((dgg) (obj)).e) : ((dgg) (obj)).e == null) && (f != null ? f.equals(((dgg) (obj)).f) : ((dgg) (obj)).f == null) && (g != null ? g.equals(((dgg) (obj)).g) : ((dgg) (obj)).g == null) && (h != null ? h.equals(((dgg) (obj)).h) : ((dgg) (obj)).h == null) && (i != null ? i.equals(((dgg) (obj)).i) : ((dgg) (obj)).i == null) && (j != null ? j.equals(((dgg) (obj)).j) : ((dgg) (obj)).j == null) && (k != null ? k.equals(((dgg) (obj)).k) : ((dgg) (obj)).k == null) && Arrays.equals(l, ((dgg) (obj)).l) && (m != null ? m.equals(((dgg) (obj)).m) : ((dgg) (obj)).m == null) && Arrays.equals(n, ((dgg) (obj)).n))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgg) (obj)).O))
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
        int i3 = (int)(b ^ b >>> 32);
        int j3 = (int)(c ^ c >>> 32);
        int k3 = (int)(d ^ d >>> 32);
        int l1;
        int i2;
        int j2;
        int k2;
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
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
        if (j == null)
        {
            j2 = 0;
        } else
        {
            j2 = j.hashCode();
        }
        if (k == null)
        {
            k2 = 0;
        } else
        {
            k2 = k.hashCode();
        }
        i1 = k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + ((((l2 + 527) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (l != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (m == null)
        {
            i1 = 0;
        } else
        {
            i1 = m.hashCode();
        }
        i1 += j1 * 31;
        if (n != null) goto _L4; else goto _L3
_L3:
        k1 = i1 * 31;
_L9:
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
_L7:
        j1 = i1;
        if (k1 >= l.length) goto _L6; else goto _L5
_L5:
        i1 = i1 * 31 + l[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        j1 = 0;
_L10:
        k1 = i1;
        if (j1 >= n.length) goto _L9; else goto _L8
_L8:
        if (n[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = n[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L10
    }

}
