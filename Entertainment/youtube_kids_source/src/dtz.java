// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dtz extends eul
{

    private dzp a;
    private dtw b;
    private dlb c;
    private dlb d;
    private dlb e;
    private dre f;
    private dtk g;
    private dtx h[];
    private byte i[];

    public dtz()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = dtx.a;
        i = eup.f;
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
        j = k;
        if (d != null)
        {
            j = k + euj.b(4, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(5, e);
        }
        l = k;
        if (f != null)
        {
            l = k + euj.b(6, f);
        }
        j = l;
        if (g != null)
        {
            j = l + euj.b(7, g);
        }
        k = j;
        if (h != null)
        {
            dtx adtx[] = h;
            int j1 = adtx.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                k = j;
                if (i1 >= j1)
                {
                    break;
                }
                dtx dtx1 = adtx[i1];
                k = j;
                if (dtx1 != null)
                {
                    k = j + euj.b(8, dtx1);
                }
                i1++;
                j = k;
            } while (true);
        }
        j = k;
        if (!Arrays.equals(i, eup.f))
        {
            j = k + euj.b(10, i);
        }
        j += eup.a(O);
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
                    b = new dtw();
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
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dtk();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                int l = eup.a(eui1, 66);
                dtx adtx[];
                int k;
                if (h == null)
                {
                    k = 0;
                } else
                {
                    k = h.length;
                }
                adtx = new dtx[l + k];
                if (h != null)
                {
                    System.arraycopy(h, 0, adtx, 0, k);
                }
                for (h = adtx; k < h.length - 1; k++)
                {
                    h[k] = new dtx();
                    eui1.a(h[k]);
                    eui1.a();
                }

                h[k] = new dtx();
                eui1.a(h[k]);
                break;

            case 82: // 'R'
                i = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
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
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            dtx adtx[] = h;
            int k = adtx.length;
            for (int j = 0; j < k; j++)
            {
                dtx dtx1 = adtx[j];
                if (dtx1 != null)
                {
                    euj1.a(8, dtx1);
                }
            }

        }
        if (!Arrays.equals(i, eup.f))
        {
            euj1.a(10, i);
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
            if (!(obj instanceof dtz))
            {
                return false;
            }
            obj = (dtz)obj;
            if ((a != null ? a.equals(((dtz) (obj)).a) : ((dtz) (obj)).a == null) && (b != null ? b.equals(((dtz) (obj)).b) : ((dtz) (obj)).b == null) && (c != null ? c.equals(((dtz) (obj)).c) : ((dtz) (obj)).c == null) && (d != null ? d.equals(((dtz) (obj)).d) : ((dtz) (obj)).d == null) && (e != null ? e.equals(((dtz) (obj)).e) : ((dtz) (obj)).e == null) && (f != null ? f.equals(((dtz) (obj)).f) : ((dtz) (obj)).f == null) && (g != null ? g.equals(((dtz) (obj)).g) : ((dtz) (obj)).g == null) && (Arrays.equals(h, ((dtz) (obj)).h) && Arrays.equals(i, ((dtz) (obj)).i)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtz) (obj)).O))
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
        boolean flag = false;
        int j2 = getClass().getName().hashCode();
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
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
        j = i2 + (l1 + (k1 + (j1 + (l + (k + (j + (j2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (h != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L6:
        if (i != null) goto _L4; else goto _L3
_L3:
        j = k * 31;
_L9:
        int i1;
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return j * 31 + k;
_L2:
        i1 = 0;
_L7:
        k = j;
        if (i1 >= h.length) goto _L6; else goto _L5
_L5:
        if (h[i1] == null)
        {
            k = 0;
        } else
        {
            k = h[i1].hashCode();
        }
        j = k + j * 31;
        i1++;
          goto _L7
          goto _L6
_L4:
        i1 = 0;
_L10:
        j = k;
        if (i1 >= i.length) goto _L9; else goto _L8
_L8:
        k = k * 31 + i[i1];
        i1++;
          goto _L10
    }
}
