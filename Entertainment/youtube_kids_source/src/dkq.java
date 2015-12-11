// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkq extends eul
{

    public dkr a;
    public byte b[];
    private dzp c;
    private dre d;
    private dlb e;
    private dlb f;
    private dlb g;
    private String h;
    private dkr i[];
    private dxa j[];

    public dkq()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = "";
        i = dkr.a;
        a = null;
        j = dxa.a;
        b = eup.f;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        if (c != null)
        {
            l = euj.b(1, c) + 0;
        } else
        {
            l = 0;
        }
        k = l;
        if (d != null)
        {
            k = l + euj.b(2, d);
        }
        l = k;
        if (e != null)
        {
            l = k + euj.b(3, e);
        }
        k = l;
        if (f != null)
        {
            k = l + euj.b(4, f);
        }
        l = k;
        if (g != null)
        {
            l = k + euj.b(5, g);
        }
        k = l;
        if (!h.equals(""))
        {
            k = l + euj.b(6, h);
        }
        l = k;
        if (i != null)
        {
            dkr adkr[] = i;
            int k1 = adkr.length;
            int i1 = 0;
            do
            {
                l = k;
                if (i1 >= k1)
                {
                    break;
                }
                dkr dkr1 = adkr[i1];
                l = k;
                if (dkr1 != null)
                {
                    l = k + euj.b(7, dkr1);
                }
                i1++;
                k = l;
            } while (true);
        }
        k = l;
        if (a != null)
        {
            k = l + euj.b(10, a);
        }
        l = k;
        if (j != null)
        {
            dxa adxa[] = j;
            int l1 = adxa.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                l = k;
                if (j1 >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[j1];
                l = k;
                if (dxa1 != null)
                {
                    l = k + euj.b(11, dxa1);
                }
                j1++;
                k = l;
            } while (true);
        }
        k = l;
        if (!Arrays.equals(b, eup.f))
        {
            k = l + euj.b(12, b);
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
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dre();
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
                h = eui1.f();
                break;

            case 58: // ':'
                int j1 = eup.a(eui1, 58);
                dkr adkr[];
                int l;
                if (i == null)
                {
                    l = 0;
                } else
                {
                    l = i.length;
                }
                adkr = new dkr[j1 + l];
                if (i != null)
                {
                    System.arraycopy(i, 0, adkr, 0, l);
                }
                for (i = adkr; l < i.length - 1; l++)
                {
                    i[l] = new dkr();
                    eui1.a(i[l]);
                    eui1.a();
                }

                i[l] = new dkr();
                eui1.a(i[l]);
                break;

            case 82: // 'R'
                if (a == null)
                {
                    a = new dkr();
                }
                eui1.a(a);
                break;

            case 90: // 'Z'
                int k1 = eup.a(eui1, 90);
                dxa adxa[];
                int i1;
                if (j == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = j.length;
                }
                adxa = new dxa[k1 + i1];
                if (j != null)
                {
                    System.arraycopy(j, 0, adxa, 0, i1);
                }
                for (j = adxa; i1 < j.length - 1; i1++)
                {
                    j[i1] = new dxa();
                    eui1.a(j[i1]);
                    eui1.a();
                }

                j[i1] = new dxa();
                eui1.a(j[i1]);
                break;

            case 98: // 'b'
                b = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (c != null)
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
        if (!h.equals(""))
        {
            euj1.a(6, h);
        }
        if (i != null)
        {
            dkr adkr[] = i;
            int i1 = adkr.length;
            for (int k = 0; k < i1; k++)
            {
                dkr dkr1 = adkr[k];
                if (dkr1 != null)
                {
                    euj1.a(7, dkr1);
                }
            }

        }
        if (a != null)
        {
            euj1.a(10, a);
        }
        if (j != null)
        {
            dxa adxa[] = j;
            int j1 = adxa.length;
            for (int l = ((flag) ? 1 : 0); l < j1; l++)
            {
                dxa dxa1 = adxa[l];
                if (dxa1 != null)
                {
                    euj1.a(11, dxa1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(12, b);
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
            if (!(obj instanceof dkq))
            {
                return false;
            }
            obj = (dkq)obj;
            if ((c != null ? c.equals(((dkq) (obj)).c) : ((dkq) (obj)).c == null) && (d != null ? d.equals(((dkq) (obj)).d) : ((dkq) (obj)).d == null) && (e != null ? e.equals(((dkq) (obj)).e) : ((dkq) (obj)).e == null) && (f != null ? f.equals(((dkq) (obj)).f) : ((dkq) (obj)).f == null) && (g != null ? g.equals(((dkq) (obj)).g) : ((dkq) (obj)).g == null) && (h != null ? h.equals(((dkq) (obj)).h) : ((dkq) (obj)).h == null) && Arrays.equals(i, ((dkq) (obj)).i) && (a != null ? a.equals(((dkq) (obj)).a) : ((dkq) (obj)).a == null) && (Arrays.equals(j, ((dkq) (obj)).j) && Arrays.equals(b, ((dkq) (obj)).b)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkq) (obj)).O))
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
        int i2 = getClass().getName().hashCode();
        int j1;
        int k1;
        int l1;
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
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
        k = l1 + (k1 + (j1 + (i1 + (l + (k + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (i != null) goto _L2; else goto _L1
_L1:
        i1 = k * 31;
_L8:
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        k += i1 * 31;
        if (j != null) goto _L4; else goto _L3
_L3:
        l = k * 31;
_L11:
        if (b != null) goto _L6; else goto _L5
_L5:
        k = l * 31;
_L14:
        if (O == null)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = O.hashCode();
        }
        return k * 31 + l;
_L2:
        l = 0;
_L9:
        i1 = k;
        if (l >= i.length) goto _L8; else goto _L7
_L7:
        if (i[l] == null)
        {
            i1 = 0;
        } else
        {
            i1 = i[l].hashCode();
        }
        k = i1 + k * 31;
        l++;
          goto _L9
          goto _L8
_L4:
        i1 = 0;
_L12:
        l = k;
        if (i1 >= j.length) goto _L11; else goto _L10
_L10:
        if (j[i1] == null)
        {
            l = 0;
        } else
        {
            l = j[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L12
          goto _L11
_L6:
        i1 = 0;
_L15:
        k = l;
        if (i1 >= b.length) goto _L14; else goto _L13
_L13:
        l = l * 31 + b[i1];
        i1++;
          goto _L15
    }
}
