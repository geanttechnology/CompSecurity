// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmi extends eul
{

    public static final dmi a[] = new dmi[0];
    private int b;
    private dyx c;
    private String d;
    private dma e;
    private dkn f[];
    private String g[];
    private String h;
    private dch i;
    private String j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private String q;
    private String r;

    public dmi()
    {
        b = 0;
        c = null;
        d = "";
        e = null;
        f = dkn.a;
        g = eup.d;
        h = "";
        i = null;
        j = "";
        k = 0;
        l = 0;
        m = 0;
        n = 0;
        o = false;
        p = false;
        q = "";
        r = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (b != 0)
        {
            j1 = euj.c(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(2, c);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(3, d);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(4, e);
        }
        j1 = i1;
        if (f != null)
        {
            dkn adkn[] = f;
            int i2 = adkn.length;
            int k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= i2)
                {
                    break;
                }
                dkn dkn1 = adkn[k1];
                j1 = i1;
                if (dkn1 != null)
                {
                    j1 = i1 + euj.b(5, dkn1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1;
            if (g.length > 0)
            {
                String as[] = g;
                int j2 = as.length;
                int l1 = 0;
                for (i1 = ((flag) ? 1 : 0); i1 < j2; i1++)
                {
                    l1 += euj.a(as[i1]);
                }

                i1 = j1 + l1 + g.length * 1;
            }
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
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(9, j);
        }
        i1 = j1;
        if (k != 0)
        {
            i1 = j1 + euj.c(10, k);
        }
        j1 = i1;
        if (l != 0)
        {
            j1 = i1 + euj.c(11, l);
        }
        i1 = j1;
        if (m != 0)
        {
            i1 = j1 + euj.c(12, m);
        }
        j1 = i1;
        if (n != 0)
        {
            j1 = i1 + euj.c(13, n);
        }
        i1 = j1;
        if (o)
        {
            boolean flag1 = o;
            i1 = j1 + (euj.b(14) + 1);
        }
        j1 = i1;
        if (p)
        {
            boolean flag2 = p;
            j1 = i1 + (euj.b(15) + 1);
        }
        i1 = j1;
        if (!q.equals(""))
        {
            i1 = j1 + euj.b(16, q);
        }
        j1 = i1;
        if (!r.equals(""))
        {
            j1 = i1 + euj.b(17, r);
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

            case 8: // '\b'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3)
                {
                    b = j1;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dyx();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dma();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                int i2 = eup.a(eui1, 42);
                dkn adkn[];
                int k1;
                if (f == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = f.length;
                }
                adkn = new dkn[i2 + k1];
                if (f != null)
                {
                    System.arraycopy(f, 0, adkn, 0, k1);
                }
                for (f = adkn; k1 < f.length - 1; k1++)
                {
                    f[k1] = new dkn();
                    eui1.a(f[k1]);
                    eui1.a();
                }

                f[k1] = new dkn();
                eui1.a(f[k1]);
                break;

            case 50: // '2'
                int j2 = eup.a(eui1, 50);
                int l1 = g.length;
                String as[] = new String[j2 + l1];
                System.arraycopy(g, 0, as, 0, l1);
                for (g = as; l1 < g.length - 1; l1++)
                {
                    g[l1] = eui1.f();
                    eui1.a();
                }

                g[l1] = eui1.f();
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 66: // 'B'
                if (i == null)
                {
                    i = new dch();
                }
                eui1.a(i);
                break;

            case 74: // 'J'
                j = eui1.f();
                break;

            case 80: // 'P'
                k = eui1.d();
                break;

            case 88: // 'X'
                l = eui1.d();
                break;

            case 96: // '`'
                m = eui1.d();
                break;

            case 104: // 'h'
                n = eui1.d();
                break;

            case 112: // 'p'
                o = eui1.e();
                break;

            case 120: // 'x'
                p = eui1.e();
                break;

            case 130: 
                q = eui1.f();
                break;

            case 138: 
                r = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            dkn adkn[] = f;
            int k1 = adkn.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dkn dkn1 = adkn[i1];
                if (dkn1 != null)
                {
                    euj1.a(5, dkn1);
                }
            }

        }
        if (g != null)
        {
            String as[] = g;
            int l1 = as.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                euj1.a(6, as[j1]);
            }

        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(8, i);
        }
        if (!j.equals(""))
        {
            euj1.a(9, j);
        }
        if (k != 0)
        {
            euj1.a(10, k);
        }
        if (l != 0)
        {
            euj1.a(11, l);
        }
        if (m != 0)
        {
            euj1.a(12, m);
        }
        if (n != 0)
        {
            euj1.a(13, n);
        }
        if (o)
        {
            euj1.a(14, o);
        }
        if (p)
        {
            euj1.a(15, p);
        }
        if (!q.equals(""))
        {
            euj1.a(16, q);
        }
        if (!r.equals(""))
        {
            euj1.a(17, r);
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
            if (!(obj instanceof dmi))
            {
                return false;
            }
            obj = (dmi)obj;
            if (b == ((dmi) (obj)).b && (c != null ? c.equals(((dmi) (obj)).c) : ((dmi) (obj)).c == null) && (d != null ? d.equals(((dmi) (obj)).d) : ((dmi) (obj)).d == null) && (e != null ? e.equals(((dmi) (obj)).e) : ((dmi) (obj)).e == null) && (Arrays.equals(f, ((dmi) (obj)).f) && Arrays.equals(g, ((dmi) (obj)).g)) && (h != null ? h.equals(((dmi) (obj)).h) : ((dmi) (obj)).h == null) && (i != null ? i.equals(((dmi) (obj)).i) : ((dmi) (obj)).i == null) && (j != null ? j.equals(((dmi) (obj)).j) : ((dmi) (obj)).j == null) && (k == ((dmi) (obj)).k && l == ((dmi) (obj)).l && m == ((dmi) (obj)).m && n == ((dmi) (obj)).n && o == ((dmi) (obj)).o && p == ((dmi) (obj)).p) && (q != null ? q.equals(((dmi) (obj)).q) : ((dmi) (obj)).q == null) && (r != null ? r.equals(((dmi) (obj)).r) : ((dmi) (obj)).r == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmi) (obj)).O))
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
        int l2;
        int k3;
        l2 = 1;
        k3 = 0;
        int l1 = getClass().getName().hashCode();
        int j2 = b;
        int l3;
        int i4;
        int j4;
        int k4;
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
        i1 = k1 + (j1 + (i1 + ((l1 + 527) * 31 + j2) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (g != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L9:
        int i2;
        int k2;
        int i3;
        int j3;
        if (h == null)
        {
            i1 = 0;
        } else
        {
            i1 = h.hashCode();
        }
        if (i == null)
        {
            k1 = 0;
        } else
        {
            k1 = i.hashCode();
        }
        if (j == null)
        {
            i2 = 0;
        } else
        {
            i2 = j.hashCode();
        }
        l3 = k;
        i4 = l;
        j4 = m;
        k4 = n;
        if (o)
        {
            k2 = 1;
        } else
        {
            k2 = 2;
        }
        if (!p)
        {
            l2 = 2;
        }
        if (q == null)
        {
            i3 = 0;
        } else
        {
            i3 = q.hashCode();
        }
        if (r == null)
        {
            j3 = 0;
        } else
        {
            j3 = r.hashCode();
        }
        if (O != null)
        {
            k3 = O.hashCode();
        }
        return (j3 + (i3 + ((k2 + (((((i2 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + l3) * 31 + i4) * 31 + j4) * 31 + k4) * 31) * 31 + l2) * 31) * 31) * 31 + k3;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= f.length) goto _L6; else goto _L5
_L5:
        if (f[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = f[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
        i1 = j1;
_L10:
        j1 = i1;
        if (k1 >= g.length) goto _L9; else goto _L8
_L8:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }

}
