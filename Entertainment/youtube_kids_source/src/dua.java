// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dua extends eul
{

    private dzp a;
    private dlb b;
    private dlb c;
    private dre d;
    private dtk e;
    private dtx f[];
    private byte g[];
    private duf h;
    private dpd i[];

    public dua()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = dtx.a;
        g = eup.f;
        h = null;
        i = dpd.a;
    }

    public final int a()
    {
        boolean flag = false;
        int j;
        int k;
        int l;
        if (a != null)
        {
            k = euj.b(1, a) + 0;
        } else
        {
            k = 0;
        }
        j = k;
        if (b != null)
        {
            j = k + euj.b(2, b);
        }
        k = j;
        if (c != null)
        {
            k = j + euj.b(3, c);
        }
        l = k;
        if (d != null)
        {
            l = k + euj.b(4, d);
        }
        j = l;
        if (e != null)
        {
            j = l + euj.b(5, e);
        }
        k = j;
        if (f != null)
        {
            dtx adtx[] = f;
            int i1 = adtx.length;
            l = 0;
            do
            {
                k = j;
                if (l >= i1)
                {
                    break;
                }
                dtx dtx1 = adtx[l];
                k = j;
                if (dtx1 != null)
                {
                    k = j + euj.b(6, dtx1);
                }
                l++;
                j = k;
            } while (true);
        }
        l = k;
        if (!Arrays.equals(g, eup.f))
        {
            l = k + euj.b(8, g);
        }
        j = l;
        if (h != null)
        {
            j = l + euj.b(9, h);
        }
        l = j;
        if (i != null)
        {
            dpd adpd[] = i;
            int j1 = adpd.length;
            k = ((flag) ? 1 : 0);
            do
            {
                l = j;
                if (k >= j1)
                {
                    break;
                }
                dpd dpd1 = adpd[k];
                l = j;
                if (dpd1 != null)
                {
                    l = j + euj.b(10, dpd1);
                }
                k++;
                j = l;
            } while (true);
        }
        j = l + eup.a(O);
        P = j;
        return j;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int j = eui1.a();
            switch (j)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (a == null)
                {
                    a = new dzp();
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

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dtk();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                int i1 = eup.a(eui1, 50);
                dtx adtx[];
                int k;
                if (f == null)
                {
                    k = 0;
                } else
                {
                    k = f.length;
                }
                adtx = new dtx[i1 + k];
                if (f != null)
                {
                    System.arraycopy(f, 0, adtx, 0, k);
                }
                for (f = adtx; k < f.length - 1; k++)
                {
                    f[k] = new dtx();
                    eui1.a(f[k]);
                    eui1.a();
                }

                f[k] = new dtx();
                eui1.a(f[k]);
                break;

            case 66: // 'B'
                g = eui1.g();
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new duf();
                }
                eui1.a(h);
                break;

            case 82: // 'R'
                int j1 = eup.a(eui1, 82);
                dpd adpd[];
                int l;
                if (i == null)
                {
                    l = 0;
                } else
                {
                    l = i.length;
                }
                adpd = new dpd[j1 + l];
                if (i != null)
                {
                    System.arraycopy(i, 0, adpd, 0, l);
                }
                for (i = adpd; l < i.length - 1; l++)
                {
                    i[l] = new dpd();
                    eui1.a(i[l]);
                    eui1.a();
                }

                i[l] = new dpd();
                eui1.a(i[l]);
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
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            dtx adtx[] = f;
            int l = adtx.length;
            for (int j = 0; j < l; j++)
            {
                dtx dtx1 = adtx[j];
                if (dtx1 != null)
                {
                    euj1.a(6, dtx1);
                }
            }

        }
        if (!Arrays.equals(g, eup.f))
        {
            euj1.a(8, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i != null)
        {
            dpd adpd[] = i;
            int i1 = adpd.length;
            for (int k = ((flag) ? 1 : 0); k < i1; k++)
            {
                dpd dpd1 = adpd[k];
                if (dpd1 != null)
                {
                    euj1.a(10, dpd1);
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
            if (!(obj instanceof dua))
            {
                return false;
            }
            obj = (dua)obj;
            if ((a != null ? a.equals(((dua) (obj)).a) : ((dua) (obj)).a == null) && (b != null ? b.equals(((dua) (obj)).b) : ((dua) (obj)).b == null) && (c != null ? c.equals(((dua) (obj)).c) : ((dua) (obj)).c == null) && (d != null ? d.equals(((dua) (obj)).d) : ((dua) (obj)).d == null) && (e != null ? e.equals(((dua) (obj)).e) : ((dua) (obj)).e == null) && (Arrays.equals(f, ((dua) (obj)).f) && Arrays.equals(g, ((dua) (obj)).g)) && (h != null ? h.equals(((dua) (obj)).h) : ((dua) (obj)).h == null) && Arrays.equals(i, ((dua) (obj)).i))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dua) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dua) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int k;
        int l;
        boolean flag = false;
        int k1 = getClass().getName().hashCode();
        int i1;
        int j1;
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
        }
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
        j = j1 + (i1 + (l + (k + (j + (k1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L8:
        if (g != null) goto _L4; else goto _L3
_L3:
        j = k * 31;
_L11:
        if (h == null)
        {
            k = 0;
        } else
        {
            k = h.hashCode();
        }
        j = k + j * 31;
        if (i != null) goto _L6; else goto _L5
_L5:
        l = j * 31;
_L14:
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return l * 31 + j;
_L2:
        l = 0;
_L9:
        k = j;
        if (l >= f.length) goto _L8; else goto _L7
_L7:
        if (f[l] == null)
        {
            k = 0;
        } else
        {
            k = f[l].hashCode();
        }
        j = k + j * 31;
        l++;
          goto _L9
          goto _L8
_L4:
        l = 0;
_L12:
        j = k;
        if (l >= g.length) goto _L11; else goto _L10
_L10:
        k = k * 31 + g[l];
        l++;
          goto _L12
          goto _L11
_L6:
        k = 0;
_L15:
        l = j;
        if (k >= i.length) goto _L14; else goto _L13
_L13:
        if (i[k] == null)
        {
            l = 0;
        } else
        {
            l = i[k].hashCode();
        }
        j = l + j * 31;
        k++;
          goto _L15
    }
}
